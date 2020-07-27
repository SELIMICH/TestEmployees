package com.example.testemployees.screens.employees;

import com.example.testemployees.pojo.Employee;

import java.util.List;

public interface EmployeesListView {

    public void showData(List<Employee> employees);
    public void showError();
}
