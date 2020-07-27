package com.example.testemployees.screens.employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testemployees.R;
import com.example.testemployees.adapters.EmployeeAdapter;
import com.example.testemployees.api.ApiFactory;
import com.example.testemployees.api.ApiService;
import com.example.testemployees.pojo.Employee;
import com.example.testemployees.pojo.EmployeeResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EmployeeListActivity extends AppCompatActivity implements EmployeesListView {

    private RecyclerView mRecyclerView;
    private EmployeeAdapter mEmployeeAdapter;
    private EmployeeListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new EmployeeListPresenter(this);
        mRecyclerView = findViewById(R.id.recyclerViewEmployees);
        mEmployeeAdapter = new EmployeeAdapter();
        mEmployeeAdapter.setEmployees(new ArrayList<Employee>());
        mRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mEmployeeAdapter);
        mPresenter.loadData();
    }

    public void showData(List<Employee> employees) {
        mEmployeeAdapter.setEmployees(employees);
    }

    public void showError() {
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mPresenter.disposeDisposable();
        super.onDestroy();
    }
}
