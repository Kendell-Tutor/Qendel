package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.exception.VideoAlreadyExistsException;
import com.qendel.authenticationservice.exception.VideoNotFoundException;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.model.Video;
import com.qendel.authenticationservice.repository.TutorRepository;
import com.qendel.authenticationservice.repository.VideoRepository;
import com.qendel.authenticationservice.service.TutorService;
import com.qendel.authenticationservice.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Video getVideo(String name) {
        if(!videoRepository.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return videoRepository.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return videoRepository.getAllEntryNames();
    }
    @Override
    public void saveVideo(MultipartFile file, int price, String name) throws IOException {

        if(videoRepository.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }

        /**
         --> todo this will fetch the current login tutor when frontend done
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String userName = auth.getName();
        System.out.println("Current loged In Tutor" + userName);
        Tutor tutor = tutorRepository.getTutorByFirstName(userName);

        Video newVid = new Video(name, price, file.getBytes());
        newVid.setId(tutor.getId());
        newVid.setTutorName(tutor.getFirstName() + " " + tutor.getLastName());
         */
        Video newVid = new Video(name, price, file.getBytes());
        /**
         * fetch the current logedin tutor and atatch his id
         */
        videoRepository.save(newVid);
    }
    @Override
    public List<Video> getAllVideosByTutorName(String name) {
        var allVideos = videoRepository.findVideoByTutorNameContaining(name);
        return allVideos.stream()
                .filter(v -> v.getTutorName().contains(name))
                .collect(Collectors.toList());
    }
}
