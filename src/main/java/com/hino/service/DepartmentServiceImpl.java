package com.hino.service;

import com.hino.exception.NotFoundException;
import com.hino.model.Department;
import com.hino.repo.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  DepartmentRepository departmentRepository;

  @Override
  //@Transactional
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public List<Department> getDepartments() {
    return departmentRepository.findAll();
  }

  @Override
  public Department findDepartment(String name) throws NotFoundException {
    //Optional<Department> d = departmentRepository.findDepartmentByName(name);
    Department d = departmentRepository.findDepartmentByName(name);
    //Department department = d.orElseThrow(() -> new NotFoundException("Not found"));
    //Department result = d.get();
    return d;
  }
}
