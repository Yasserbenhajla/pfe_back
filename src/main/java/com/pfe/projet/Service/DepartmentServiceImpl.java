package com.pfe.projet.Service;

import com.pfe.projet.Entity.Department;
import com.pfe.projet.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository ;

    @Override
    public Department ajouterDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }
}
