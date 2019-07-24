package com.hino.repo;

import com.hino.model.Department;
import com.hino.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findAllByDepartmentId(Long department);
}
