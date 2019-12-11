package com.aashish.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aashish.api.R;
import com.aashish.api.model.Employee;

import java.util.List;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.EmployeeViewHolder > {
    Context context;
    List<Employee> show_employees;

    public DashAdapter(Context context, List<Employee> show_employees) {
        this.context = context;
        this.show_employees = show_employees;
    }

    @NonNull
    @Override
    public DashAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dash_adapter, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        final Employee se = show_employees.get(position);
        holder.txtid.append(String.valueOf(se.getId()));
        holder.txtname.append(se.getEmployee_name());
        holder.txtsalary.append(String.valueOf(se.getEmployee_salary()));
        holder.txtage.append(String.valueOf(se.getEmployee_age()));
    }


    @Override
    public int getItemCount() {
        return show_employees.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView txtname,txtage,txtid,txtsalary;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid=itemView.findViewById(R.id.tvid);
            txtname=itemView.findViewById(R.id.tvname);
            txtsalary=itemView.findViewById(R.id.tvsalary);
            txtage=itemView.findViewById(R.id.tvage);
        }
    }

}