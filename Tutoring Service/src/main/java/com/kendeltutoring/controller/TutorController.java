package com.kendeltutoring.controller;

import com.kendeltutoring.service.TutoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutor/v1/api")
public class TutorController {

    @Autowired
    private TutoringService tutoringService;

}
