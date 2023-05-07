package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.model.Video;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name);
    void saveVideo(MultipartFile file, int price, String name) throws IOException;
    List<String> getAllVideoNames();
    List<Video> getAllVideosByTutorName(String name);
}
