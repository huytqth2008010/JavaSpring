package aptech.t2008m.javaspring.manytomany.usercompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public Grade save(Grade grade){
        gradeRepository.save(grade);
        return grade;
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> findById(int gradeTd) {
        return gradeRepository.findById(gradeTd);
    }
}
