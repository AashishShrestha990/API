package com.aashish.api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateOrDeleteEmployee extends AppCompatActivity {

    EditText etEmployee, etsalary, etage;
    Button btnupdate, btndelete, btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_delete_employee);

        etEmployee = findViewById(R.id.etEmployee);
        etsalary = findViewById(R.id.etEmployee);
        etage = findViewById(R.id.etEmployee);
        btnupdate = findViewById(R.id.btnUpdate);
        btndelete = findViewById(R.id.btnDelete);
        btnsearch = findViewById(R.id.btnSearch);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
