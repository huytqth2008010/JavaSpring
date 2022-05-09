package aptech.t2008m.javaspring.manytomany.usercompositekey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students_grades")
public class StudentGrade {
    @EmbeddedId
    private StudentGradeId id;

    @ManyToOne
    @MapsId("gradeId")
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToOne
    @MapsId("studentRollNumber")
    @JoinColumn(name = "student_rollnumber")
    private Student student;

    private int status;

}
