package com.neo.sihotel.repository;

import com.neo.sihotel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employee, Integer> {
    @Query("from Employee ")
    public List<Employee> getEmployee();
}
