package com.aashish.api;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aashish.api.adapter.DisplayAdapter;
import com.aashish.api.interfaces.EmployeeAPI;
import com.aashish.api.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayActivity extends AppCompatActivity {

    private static String base_url = "http://dummy.restapiexample.com/api/v1/";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerView = findViewById(R.id.display);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<List<Employee>> listCall = employeeAPI.getAllEmployee();

        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (!response.isSuccessful()) {
//                    display.setText("Code :" + response.code());
//                    return;
                    Toast.makeText(DisplayActivity.this, "error"+response.code(), Toast.LENGTH_LONG).show();
                    Log.d("error","error" +response.code() );
                    return;
                }
                List<Employee> employeeList = response.body();
//                for (Employee employee : employeeList) {
//                    String content = "";
//                    content += "Id: " + employee.getId() + "\n";
//                    content += "employee_name : " + employee.getEmployee_name() + "\n";
//                    content += "employee_salary : " + employee.getEmployee_salary() + "\n";
//                    content += "employee_age : " + employee.getEmployee_age() + "\n";
//                    content += "profile_image : " + employee.getProfile_image() + "\n";
//
//                    display.append(content);
//                }
                    DisplayAdapter adapterRecycleView = new DisplayAdapter(DisplayActivity.this,employeeList);
                    recyclerView.setAdapter(adapterRecycleView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DisplayActivity.this));

            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
//                display.setText("error" + t.getMessage());

                Toast.makeText(DisplayActivity.this, "error"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.d("error","error   "+t.getLocalizedMessage() );            }
        });
    }
}

//    private static String base_url = "http://dummy.restapiexample.com/api/v1/";
//    private TextView display;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display);
//
//        display = findViewById(R.id.display);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(base_url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
//
//        Call<List<Employee>> listCall = employeeAPI.getAllEmployee();
//
//        listCall.enqueue(new Callback<List<Employee>>() {
//            @Override
//            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
//                if (!response.isSuccessful()) {
//                    display.setText("Code :" + response.code());
//                    return;
//                }
//                List<Employee> employeeList = response.body();
//                for (Employee employee : employeeList) {
//                    String content = "";
//                    content += "Id: " + employee.getId() + "\n";
//                    content += "employee_name : " + employee.getEmployee_name() + "\n";
//                    content += "employee_salary : " + employee.getEmployee_salary() + "\n";
//                    content += "employee_age : " + employee.getEmployee_age() + "\n";
//                    content += "profile_image : " + employee.getProfile_image() + "\n";
//
//                    display.append(content);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Employee>> call, Throwable t) {
//                display.setText("error" + t.getMessage());
//            }
//        });
//    }
//}
