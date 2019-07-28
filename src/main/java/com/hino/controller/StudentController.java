package com.hino.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hino.model.Department;
import com.hino.model.Student;
import com.hino.service.DepartmentService;
import com.hino.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

  private final StudentService studentService;

  private final DepartmentService departmentService;

  @Autowired
  public StudentController(StudentService studentService, DepartmentService departmentService) {
    this.studentService = studentService;
    this.departmentService = departmentService;
  }

  @GetMapping
  public ResponseEntity<?> list() {
    return ResponseEntity.ok(studentService.findAll());
  }

  @PostMapping(params = "deptName")
  public ResponseEntity<?> saveStudent(@RequestBody Student student, @RequestParam String deptName) {
    Department department = departmentService.findDepartment(deptName.toUpperCase());

    student.setDepartment(department);

    return ResponseEntity.ok(studentService.save(student));

  }

  @PostMapping("/{deptName}")
  public String saveStudent(@RequestBody List<Student> studentList, @PathVariable String deptName) {
    try {
      Department dept = departmentService.findDepartment(deptName.toUpperCase());

      for (Student student : studentList) {
        student.setDepartment(dept);
      }

      studentService.saveAll(studentList);
      return "Student saved successfully..";
    } catch (Exception ex) {
      ex.printStackTrace();
      return "Error in saving Student ..";
    }
  }

  @GetMapping(params = "deptId")
  public ResponseEntity<?> findAllByDepartmentId(@RequestParam Long deptId) {
    return ResponseEntity.ok(studentService.findAllByDepartmentId(deptId));
  }
}
