package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("price") int price) throws IOException {
        videoService.saveVideo(file, price, name);
        return ResponseEntity.ok("Video saved successfully.");
    }

    @GetMapping("{/name}")
    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name){
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(videoService.getVideo(name).getData()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllVideoNames(){
        return ResponseEntity.ok(videoService.getAllVideoNames());
    }

}
