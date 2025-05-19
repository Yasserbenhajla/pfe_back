package com.pfe.projet.RestController;

import com.pfe.projet.Entity.Department;

import com.pfe.projet.Service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin("*")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department ajouterDepartment(@RequestBody Department department) {
        return departmentService.ajouterDepartment(department);
    }


    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartment();
    }
}


