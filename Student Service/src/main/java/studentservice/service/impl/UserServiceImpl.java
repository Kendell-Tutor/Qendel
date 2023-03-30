package studentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import studentservice.model.User;
import studentservice.repository.UserRepository;
import studentservice.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllStudents() {
        List<User> user = userRepository.findAll();
        List<User> students = user.stream().filter(u -> u.getRole().getValue()==1).collect(Collectors.toList());
        return  students;
    }

    @Override
    public List<User> getAllInstructors() {
        List<User> user = userRepository.findAll();
        List<User> instructors = user.stream().filter(u -> u.getRole().getValue()==2).collect(Collectors.toList());
        return instructors;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addStudent(User student) {
        return userRepository.save(student);
    }

    @Override
    public User addInstructor(User instructor) {
        return userRepository.save(instructor);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);

    }



    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findStudentById(long id) {
        User user = userRepository.findById(id).orElse(null);
        if(   user.getRole().getValue() == 1){
            return user;
        }
        return  null;
    }

    @Override
    public User getInstructorById(long id) {
        User user = userRepository.findById(id).orElse(null);
        if(   user.getRole().getValue() == 2){
            return user;
        }
        return  null;
    }

    @Override
    public List<User> findUserByName(String name) {
       // return userRepository.findUserByName(name);
        return null;
    }

    @Override
    public List<User> findStudentByName(String name) {

//        List<User> user = userRepository.findUserByName(name);
//        List<User> students = user.stream().filter(u -> u.getRole().getValue()==1).collect(Collectors.toList());
//        return students;
        return null;
    }

    @Override
    public List<User> getInstructorByName(String name) {
//        List<User> user = userRepository.findUserByName(name);
//        List<User> instructors = user.stream().filter(u -> u.getRole().getValue()==2).collect(Collectors.toList());
//        return instructors;
        return null;
    }

    @Override
    public List<User> findUserByCourse(String name) {
      //  return userRepository.findUsersByCourse(name);
        return null;
    }

    @Override
    public List<User> findStudentByCourse(String name) {
//        List<User> users = userRepository.findUsersByCourse(name);
//        List<User> students = users.stream().filter(u -> u.getRole().getValue() == 1).collect(Collectors.toList());
//        return students;
        return null;
    }

    @Override
    public List<User> getInstructorByCourse(String name) {
//        List<User> users = userRepository.findUsersByCourse(name);
//        List<User> instructors = users.stream().filter(u -> u.getRole().getValue() == 2).collect(Collectors.toList());
//        return instructors;
        return null;
    }
}