package aptech.t2008m.javaspring.manytomany.usercompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student){
        studentRepository.save(student);
        return student;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(String studentRollNumber) {
        return studentRepository.findById(studentRollNumber);
    }

    public boolean addStudentToCtass(Student student, Grade grade) {
        try {
            //Lấy thông tin lớp học hiện tại cảu sinh viên
            Set<StudentGrade> studentGrades = student.getStudentGrades();
            if (studentGrades == null){
                //Trường hợp chưa join lớp nào thì mới set.
                studentGrades = new HashSet<>();
            }
            // tạo mới đối tượng Student6rade
            StudentGrade studentGrade = new StudentGrade() ;
            // set khoá chính phức hợp
            studentGrade.setId(new StudentGradeId(grade.getId(), student.getRollNumber()));
            // set quan hệ ngược tại với grade
            studentGrade.setGrade(grade) ;
            // set quan hệ ngược lại với student
            studentGrade.setStudent(student) ;
            // đưa thông tin vào set
            studentGrades.add(studentGrade) ;
            // update trường studentgrades của sinh viên.
            student.setStudentGrades(studentGrades) ;
            // save thông tin student đồng thời Là save thông tin student grade
            studentRepository. save(student);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
