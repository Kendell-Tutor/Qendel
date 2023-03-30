package studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    private Long id;
    private String name;
    private String lastName;

    private int age;

    private char gender;

    private Role role;

    private Address address;

    private List<Course> courses;
}
