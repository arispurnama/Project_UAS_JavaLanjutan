package com.neo.sihotel.service;

import com.neo.sihotel.dto.EmployeDto;
import com.neo.sihotel.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmploye();
    public void saveEmploye(Employee employee);
    public Employee getEmployeById(int id);
    public Employee updateEmploye(EmployeDto employeDto);
    public boolean deleteEmploye(int id);
}
