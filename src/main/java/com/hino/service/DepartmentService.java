package com.hino.service;

import com.hino.exception.NotFoundException;
import com.hino.model.Department;
import java.util.List;

public interface DepartmentService {

  Department saveDepartment(Department department);

  List<Department> getDepartments();

  Department findDepartment(String name) throws NotFoundException;
}
