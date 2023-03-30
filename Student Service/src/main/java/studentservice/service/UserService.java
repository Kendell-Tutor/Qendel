package studentservice.service;

import studentservice.model.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserService {


    public List<User> getAllUsers();


    public List<User> getAllStudents() ;


    public List<User> getAllInstructors();


    public User addUser(User user);


    public User addStudent(User student);


    public User addInstructor(User instructor);


    public void deleteUserById(long id);




    public User findUserById(long id);


    public User findStudentById(long id);


    public User getInstructorById(long id) ;


    public List<User> findUserByName(String name);


    public List<User> findStudentByName(String name) ;


    public List<User> getInstructorByName(String name);


    public List<User> findUserByCourse(String name);


    public List<User> findStudentByCourse(String name) ;


    public List<User> getInstructorByCourse(String name);

}
