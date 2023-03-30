package studentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import studentservice.model.User;

import java.util.List;
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

//    List<User> findUserByName(String name);
//
//    List<User> findUsersByCourse(String courseName);
}