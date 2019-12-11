package com.aashish.api;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display = findViewById(R.id.display);

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
                    display.setText("Code :" + response.code());
                    return;
                }
                List<Employee> employeeList = response.body();
                for (Employee employee : employeeList) {
                    String content = "";
                    content += "Id: " + employee.getId() + "\n";
                    content += "employee_name : " + employee.getEmployee_name() + "\n";
                    content += "employee_salary : " + employee.getEmployee_salary() + "\n";
                    content += "employee_age : " + employee.getEmployee_age() + "\n";
                    content += "profile_image : " + employee.getProfile_image() + "\n";

                    display.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                display.setText("error" + t.getMessage());
            }
        });
    }
}
