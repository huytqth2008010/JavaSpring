package aptech.t2008m.javaspring.student.api;

import aptech.t2008m.javaspring.student.entity.Student;
import aptech.t2008m.javaspring.student.service.StudentService;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>>getList(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10")int limit){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{rollNumber}")
    public ResponseEntity<Student> getDetail(@PathVariable String rollNumber){
        Optional<Student> optionalStudent = studentService.findById(rollNumber);
        if (optionalStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalStudent.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{rollNumber}")
    public ResponseEntity<Student> update(@PathVariable String rollNumber, @RequestBody Student updateStudent){
        Student existing = studentService.findById(rollNumber).get();
        existing.setFullName(updateStudent.getFullName());
        return ResponseEntity.status(HttpStatus.OK).body(studentService.save(existing));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{rollNumber}")
    public ResponseEntity<?> delete(@PathVariable String rollNumber){
        studentService.deleteById(rollNumber);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
