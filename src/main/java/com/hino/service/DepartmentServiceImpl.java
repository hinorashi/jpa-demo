package com.hino.service;

import com.hino.model.Department;
import com.hino.repo.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  DepartmentRepository departmentRepository;

  @Override
  public Department getOne(Long id) {
    return departmentRepository.getOne(id);
  }

  @Override
  //@Transactional
  public Department save(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public List<Department> findAll() {
    return departmentRepository.findAll();
  }

  @Override
  public Department findDepartment(String name) {
    //Optional<Department> d = departmentRepository.findDepartmentByName(name);
    Department d = departmentRepository.findDepartmentByName(name);
    //Department department = d.orElseThrow(() -> new NotFoundException("Not found"));
    //Department result = d.get();
    return d;
  }
}
