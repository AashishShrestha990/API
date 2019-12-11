package com.aashish.api.interfaces;

import com.aashish.api.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {

    //Retriving all employee
    @GET("employees")
    Call<List<Employee>> getAllEmployee();

}
