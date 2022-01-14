package com.isaccanedo.jpa.repository;

import com.isaccanedo.jpa.model.Employee;
import com.isaccanedo.jpa.model.EmployeeIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {
    List<Employee> findByEmployeeIdentityCompanyId(String companyId);
}
