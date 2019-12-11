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

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.EmployeeViewHolder > {
    Context context;
    List<Employee> display_employees;

    public DisplayAdapter(Context context, List<Employee> display_employees) {
        this.context = context;
        this.display_employees = display_employees;
    }

    @NonNull
    @Override
    public DisplayAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_display_adapter, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        final Employee d = display_employees.get(position);
        holder.txtid.append(String.valueOf(d.getId()));
        holder.txtname.append(d.getEmployee_name());
        holder.txtsalary.append(String.valueOf(d.getEmployee_salary()));
        holder.txtage.append(String.valueOf(d.getEmployee_age()));
    }


    @Override
    public int getItemCount() {
        return display_employees.size();
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