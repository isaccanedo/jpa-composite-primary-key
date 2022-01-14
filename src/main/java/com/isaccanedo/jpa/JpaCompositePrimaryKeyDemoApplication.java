package com.isaccanedo.jpa;

import com.isaccanedo.jpa.model.Employee;
import com.isaccanedo.jpa.model.EmployeeIdentity;
import com.isaccanedo.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaCompositePrimaryKeyDemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaCompositePrimaryKeyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup employees table
		employeeRepository.deleteAllInBatch();

		// Insert a new Employee in the database
		Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
				"Isac",
				"isac@example.com",
				"+91-9999999999");

		employeeRepository.save(employee);

		// Retrieving an Employee Record with the composite primary key
		employeeRepository.findById(new EmployeeIdentity("E-123", "D-457"));

		// Retrieving all the employees of a particular company
		employeeRepository.findByEmployeeIdentityCompanyId("D-457");
	}
}
