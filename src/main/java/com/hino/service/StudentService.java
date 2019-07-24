package com.hino.service;

import com.hino.model.Student;
import java.util.List;

public interface StudentService {

  List<Student> saveStudent(List<Student> studentList);

  List<Student> getStudents();

  List<Student> test(Long deptId);
}
