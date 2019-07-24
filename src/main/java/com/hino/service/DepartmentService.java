package com.hino.service;

import com.hino.exception.NotFoundException;
import com.hino.model.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> getDepartments();
    public Department findDepartment(String name) throws NotFoundException;
}
