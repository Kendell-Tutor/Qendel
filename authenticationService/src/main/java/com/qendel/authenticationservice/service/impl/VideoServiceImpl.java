package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.exception.VideoAlreadyExistsException;
import com.qendel.authenticationservice.exception.VideoNotFoundException;
import com.qendel.authenticationservice.model.Video;
import com.qendel.authenticationservice.repository.VideoRepository;
import com.qendel.authenticationservice.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository repository;

    @Override
    public Video getVideo(String name) {
        if(!repository.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repository.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repository.getAllEntryNames();
    }
    @Override
    public void saveVideo(MultipartFile file, int price, String name) throws IOException {
        if(repository.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, price, file.getBytes());
        repository.save(newVid);
    }
}
