package com.hino;

import com.hino.model.Company;
import com.hino.model.Department;
import com.hino.model.Student;
import com.hino.repo.CompanyRepository;
import com.hino.repo.DepartmentRepository;
import com.hino.repo.StudentRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpaOneToManyDemoApplication implements CommandLineRunner {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private StudentRepository studentRepository;

  public static void main(String[] args) {

    SpringApplication.run(SpringbootJpaOneToManyDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {

    //Unidirectional Mapping
/*		Department department = new Department();
		department.setName("COMPUTER");
        departmentRepository.save(department);

		Student student = new Student();
		student.setDepartment(departmentRepository.findDepartmentByName("COMPUTER"));
		student.setName("Anup");
		student.setMobile(989911);
		Student student1 = new Student();
		student1.setDepartment(departmentRepository.findDepartmentByName("IT"));
		student1.setName("John");
		student1.setMobile(89774);
		studentRepository.saveAll(Arrays.asList(student,student1));*/

// init company
    Company company = new Company();
    company.setId(68L);
    company.setName("CMC");
    companyRepository.save(company);

    //Bi-directional mapping
    Department department1 = new Department();
    department1.setCompany(company);
    department1.setName("IT");

    //Students list
    Student student = new Student();
    student.setName("Danny");
    student.setMobile(33333);
    student.setDepartment(department1);
    Student student1 = new Student();
    student1.setName("Mark");
    student1.setMobile(11111);
    student1.setDepartment(department1);

    //department1.setStudentList(Arrays.asList(student,student1));
    department1.getStudentList().add(student);
    department1.getStudentList().add(student1);

    company.setDepartmentList(Collections.singleton(department1));

    companyRepository.save(company);

    //Get the list of students from department
    Department department = departmentRepository.findDepartmentById(1l);

    for (Student s : department.getStudentList()) {
      System.out.println(s);
    }

  }

}

