package com.hino.controller;

import com.hino.model.Department;
import com.hino.model.Student;
import com.hino.service.DepartmentService;
import com.hino.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {

  @Autowired
  StudentService studentService;

  @Autowired
  DepartmentService departmentService;

  @GetMapping
  public ResponseEntity<?> getStudents() {
    return ResponseEntity.ok(studentService.getStudents());
  }

  @PostMapping("/{deptName}")
  public String saveStudent(@RequestBody List<Student> studentList, @PathVariable String deptName) {
    try {
      Department dept = departmentService.findDepartment(deptName.toUpperCase());

      for (Student student : studentList) {
        student.setDepartment(dept);
      }

      studentService.saveStudent(studentList);
      return "Student saved successfully..";
    } catch (Exception ex) {
      ex.printStackTrace();
      return "Error in saving Student ..";
    }
  }

  @GetMapping("/{deptId}")
  public ResponseEntity getStudentsByDepartment(@PathVariable Long deptId) {
    return ResponseEntity.ok(studentService.test(deptId));
  }
}
