package com.kiransinh.ems.controller;

import com.kiransinh.ems.entity.Employee;
import com.kiransinh.ems.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping({"/employees", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> allEmployees = service.findAllEmployees();
        log.info("getAllEmployees :: response {}", allEmployees);
        mav.addObject("employees", allEmployees);
        return mav;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = new Employee();
        mav.addObject("employee", employee);
        return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        Employee employee1 = service.addEmployee(employee);
        log.info("saveEmployee: {}", employee1);
        return "redirect:/employees";

    }

    @GetMapping("/showUpdateForm")
    public ModelAndView updateEmployee(@RequestParam Long empId) {
        ModelAndView mv = new ModelAndView("add-employee-form");
        Employee employee = service.findEmployeeById(empId).get();
        mv.addObject("employee", employee);
        return mv;
    }

    @GetMapping("/deleteForm")
    public String deleteForm(@RequestParam Long empId){
        service.deleteEmployee(empId);
        return "redirect:/employees";
    }

}
