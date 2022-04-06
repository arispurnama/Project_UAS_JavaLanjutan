package com.neo.sihotel.controller;

import com.neo.sihotel.repository.EmployeRepository;
import com.neo.sihotel.service.EmployeeService;
import com.neo.sihotel.dto.EmployeDto;
import com.neo.sihotel.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/admin")
public class EmployeController {

    private EmployeeService employeeService;
    private EmployeRepository employeRepository;

    @Autowired
    public EmployeController(EmployeeService employeeService, EmployeRepository employeRepository) {
        this.employeeService = employeeService;
        this.employeRepository = employeRepository;
    }

    //display liast of employee
    @RequestMapping("/employee")
    public String getEmployee(Model model) throws Exception{

        model.addAttribute("employe", employeeService.getAllEmploye());
        return "employe";
    }

    @GetMapping("/showNewEmployee")
    public String showNewEmploye(Model model){
        //create model attribut to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee",employee);

        return "formEmploye";
    }

    @PostMapping("/saveEmployee")
    public String saveEmploye(@ModelAttribute("employee") Employee employee){
        //save employe to database
        employeeService.saveEmploye(employee);

        return "redirect:/employee";
    }

    @RequestMapping("/saveUpdateEmploye")
    public String saveEmploye(@ModelAttribute("employee") EmployeDto employee){
        //save employe to database
        employeeService.updateEmploye(employee);

        return "redirect:/employee";
    }

    @GetMapping("/updateEmploye/{id}")
    public String UpdateEmploy(@PathVariable(value = "id") int id, Model model){
        // get employe form service
        Employee employee = employeeService.getEmployeById(id);

        //set employe as a model attribut to  pre-populate the form
        model.addAttribute("employee",employee);

        return "updateEmploye";
    }
    @GetMapping("/deleteEmploye/{id}")
    public String deleteEmploye(@PathVariable(value = "id") int id){
        employeeService.deleteEmploye(id);

        return "redirect:/employee";
    }
}
