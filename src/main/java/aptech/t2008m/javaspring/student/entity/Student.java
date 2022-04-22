package aptech.t2008m.javaspring.student.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private String rollNumber;

    private String fullName;
    private String gender;
    private int status;

}
