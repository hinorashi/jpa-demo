package com.hino.service;

import com.hino.model.Student;
import java.util.List;

public interface StudentService {

  Student save(Student student);

  List<Student> saveAll(List<Student> studentList);

  List<Student> findAll();

  List<Student> findAllByDepartmentId(Long deptId);
}
