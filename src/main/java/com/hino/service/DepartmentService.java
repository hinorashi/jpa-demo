package com.hino.service;

import com.hino.model.Department;
import java.util.List;

public interface DepartmentService {

  Department getOne(Long id);

  Department save(Department department);

  List<Department> findAll();

  Department findDepartment(String name);
}
