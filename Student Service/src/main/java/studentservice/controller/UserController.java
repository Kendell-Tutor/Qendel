package studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentservice.model.User;
import studentservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
//    @Autowired
//    private UserService userService;
//
//
//    @GetMapping()
//    List<User> getAllUsers(){
//        return  userService.getAllUsers();
//    }




}
