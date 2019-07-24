package com.hino.service;

import com.hino.model.Department;
import com.hino.model.Student;
import com.hino.repo.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> saveStudent(List<Student> studentList) {
    return studentRepository.saveAll(studentList);
  }

  @Override
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  @Override
  public List<Student> test(Long deptId) {
    Department department = new Department();
    department.setId(deptId);
    return studentRepository.findAllByDepartmentId(deptId);
  }
}
