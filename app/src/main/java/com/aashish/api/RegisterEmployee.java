package com.aashish.api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterEmployee extends AppCompatActivity implements View.OnClickListener {

    EditText etname, etage, etsalary;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);

        etname = findViewById(R.id.etName);
        etage = findViewById(R.id.etAge);
        etsalary = findViewById(R.id.etSalary);
        btnRegister = findViewById(R.id.btnregister);

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
