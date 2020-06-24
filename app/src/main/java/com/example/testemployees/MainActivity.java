package com.example.testemployees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testemployees.adapters.EmployeeAdapter;
import com.example.testemployees.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EmployeeAdapter mEmployeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerViewEmployees);
        mEmployeeAdapter = new EmployeeAdapter();
        mRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mEmployeeAdapter);
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setFName("Vasy");
        employee2.setFName("Petya");
        employee1.setLName("Konopatkin");
        employee2.setLName("Petrov");
        employees.add(employee1);
        employees.add(employee2);
        mEmployeeAdapter.setEmployees(employees);

    }
}
