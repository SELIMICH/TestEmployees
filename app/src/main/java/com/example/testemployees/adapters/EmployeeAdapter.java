package com.example.testemployees.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testemployees.R;
import com.example.testemployees.pojo.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    List<Employee> mEmployees;

    public List<Employee> getEmployees() {
        return mEmployees;
    }

    public void setEmployees(List<Employee> employees) {
        mEmployees = employees;
        notifyDataSetChanged(); // чтобы после установки сотрудников обновился список
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = mEmployees.get(position);
        holder.mTextViewName.setText(employee.getFName());
        holder.mTextViewLastName.setText(employee.getLName());
        Glide.with(holder.mImageView.getContext())
                .load(employee.getAvatrUrl())
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mEmployees.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewName;
        private TextView mTextViewLastName;
        private ImageView mImageView;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewLastName = itemView.findViewById(R.id.text_view_last_name);
            mImageView = itemView.findViewById(R.id.object_image);

        }

    }
}
