package aptech.t2008m.javaspring.manytomany.usercompositekey;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, String> {
}
