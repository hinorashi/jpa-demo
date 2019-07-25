package com.hino;

import com.hino.model.Company;
import com.hino.model.Department;
import com.hino.model.Student;
import com.hino.repo.CompanyRepository;
import com.hino.repo.DepartmentRepository;
import com.hino.repo.StudentRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private StudentRepository studentRepository;

  public static void main(String[] args) {

    SpringApplication.run(JpaDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {

    //Unidirectional Mapping
//    Department department = new Department();
//    department.setName("COMPUTER");
//    departmentRepository.save(department);
//
//    Student student = new Student();
//    student.setDepartment(departmentRepository.findDepartmentByName("COMPUTER"));
//    student.setName("Anup");
//    student.setMobile(989911);
//    Student student1 = new Student();
//    student1.setDepartment(departmentRepository.findDepartmentByName("IT"));
//    student1.setName("John");
//    student1.setMobile(89774);
//    studentRepository.saveAll(Arrays.asList(student, student1));

    //Bi-directional mapping
    Company company = Company.builder().id(68L).name("CMC").build();

    // create department
    Department department = Department.builder().name("DevOps").company(company).build();

    // create student
    Student student = Student.builder().name("Zed").mobile(696969).department(department).build();
    Student otherStudent = Student.builder().name("Ekko").mobile(777777).department(department).build();

    department.setStudentList(new HashSet<>(Arrays.asList(student, otherStudent)));

    company.setDepartmentList(Collections.singleton(department));

    // save them all
    companyRepository.save(company);

    companyRepository.findAll().forEach(comp -> log.info(comp.toString()));

    departmentRepository.findAll().forEach(dept -> log.info(dept.toString()));

    studentRepository.findAll().forEach(stud -> log.info(stud.toString()));

  }

}

