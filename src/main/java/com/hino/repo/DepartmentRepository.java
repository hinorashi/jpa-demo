package com.hino.repo;

import com.hino.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Department findDepartmentById(Long id);

  Department findDepartmentByName(String name);

}
