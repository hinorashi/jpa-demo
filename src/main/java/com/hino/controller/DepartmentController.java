package com.hino.controller;

import com.hino.model.Department;
import com.hino.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("departments")
public class DepartmentController {

  private final DepartmentService departmentService;

  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @PostMapping
  public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
    Department result = departmentService.saveDepartment(department);
    log.info("Saved successfully...");
    return ResponseEntity.ok(result);
  }

  @GetMapping
  public ResponseEntity<?> getDepartments() {
    return ResponseEntity.ok(departmentService.getDepartments());
  }

}
