package com.pfe.projet.Service;

import com.pfe.projet.Entity.Department;
import com.pfe.projet.Entity.Specialite;

import java.util.List;

public interface DepartmentService {
    Department ajouterDepartment(Department department);
    List<Department> getDepartment();
}


