package aptech.t2008m.javaspring.manytomany.usercompositekey;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    private String rollNumber;
    private String fullName;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentGrade> studentGrades;
}
