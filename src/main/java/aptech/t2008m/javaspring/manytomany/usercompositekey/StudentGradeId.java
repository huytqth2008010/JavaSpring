package aptech.t2008m.javaspring.manytomany.usercompositekey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class StudentGradeId implements Serializable {
    @Column(name = "grade_id")
    private int gradeId;

    @Column(name = "student_rollnumber")
    private String studentRollNumber;

}
