package aptech.t2008m.javaspring.manytomany.usercompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentApi {
    @Autowired
    StudentService studentService;
    @Autowired
    GradeService gradeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(){
        return studentService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(method = RequestMethod.GET, path = "add-grade")
    public ResponseEntity<?> addStudentToGrade(
            @RequestParam String studentRollNumber,
            @RequestParam int gradeId) {
        // check sự tồn tại cùa student
        Optional<Student> optionalStudent = studentService.findById(studentRollNumber) ;
        // check sự tồn tại của grade
        Optional<Grade> optionalGrade = gradeService.findById(gradeId) ;
        // trà về not found nếu một trong 2 trường hợp không tìm thấy
        if (!optionalStudent.isPresent() || !optionalGrade.isPresent()){
            return new ResponseEntity<>( "Not found", HttpStatus.NOT_FOUND) ;
        }

    boolean resutlt = studentService.addStudentToCtass(optionalStudent.get(), optionalGrade.get());
        if (!resutlt) {
            return new ResponseEntity<>("Add student error!", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return new ResponseEntity<>( "Add student success!", HttpStatus.OK);
    }
}
