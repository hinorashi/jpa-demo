package com.hino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hino.model.Department;
import com.hino.service.DepartmentService;

@RestController
@RequestMapping("departments")
public class DepartmentController {

  private final DepartmentService departmentService;

  @Autowired
  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping
  public ResponseEntity<?> list() {
    return ResponseEntity.ok(departmentService.findAll());
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Department department) {
    return ResponseEntity.ok(departmentService.save(department));
  }
}
