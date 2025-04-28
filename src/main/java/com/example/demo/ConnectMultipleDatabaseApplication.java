package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.mongo.documents.Department;
import com.example.demo.mongo.repository.DepartmentRepository;
import com.example.demo.mysql.entity.User;
import com.example.demo.mysql.repository.UserRepository;
import com.example.demo.postgres.entity.Company;
import com.example.demo.postgres.repository.CompanyRepository;

@SpringBootApplication
public class ConnectMultipleDatabaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConnectMultipleDatabaseApplication.class, args);
	}

	private final UserRepository userrepo;

	private final CompanyRepository comprepo;

	private final DepartmentRepository deptrepo;
	
	public ConnectMultipleDatabaseApplication(UserRepository userrepo, CompanyRepository comprepo,
			DepartmentRepository deptrepo) {
		super();
		this.userrepo = userrepo;
		this.comprepo = comprepo;
		this.deptrepo = deptrepo;
	}

	@Override
	public void run(String... args) throws Exception {
		User user = User.builder().username("admin").password("admin").build();

		userrepo.save(user);
		
		Company company = Company.builder().comp_name("IBM").build();
		comprepo.save(company);
		
		Department dept = Department.builder().name("IT").build();
		deptrepo.save(dept);
	}

}
