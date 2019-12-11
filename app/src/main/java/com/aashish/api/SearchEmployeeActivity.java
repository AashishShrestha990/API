package com.aashish.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchEmployeeActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        name = findViewById(R.id.editname);
        btnSearch = findViewById(R.id.butnSearch);

        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
