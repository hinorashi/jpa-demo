package com.hino.service;

import com.hino.model.Department;
import com.hino.model.Student;
import com.hino.repo.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public List<Student> saveAll(List<Student> studentList) {
    return studentRepository.saveAll(studentList);
  }

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  public List<Student> findAllByDepartmentId(Long deptId) {
    Department department = new Department();
    department.setId(deptId);
    return studentRepository.findAllByDepartment_id(deptId);
  }
}
