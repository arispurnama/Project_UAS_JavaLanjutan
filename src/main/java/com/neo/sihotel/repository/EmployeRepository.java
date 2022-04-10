package com.neo.sihotel.repository;

import com.neo.sihotel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employee, Integer> {
    @Query("from Employee ")
    public List<Employee> getEmployee();

    @Query(value = "select * from employee where id like %:keyword% or name like %:keyword% or email like %:keyword% or gender like %:keyword% or address like %:keyword% ", nativeQuery = true)
    List<Employee> findByKeyword(@Param("keyword") String keyword);
}
