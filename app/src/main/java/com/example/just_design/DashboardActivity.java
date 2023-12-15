package com.example.just_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void openInputDataActivity(View view) {
        Intent intent = new Intent(this, InputDataActivity.class);
        startActivity(intent);
    }

    public void openDisplayDataActivity(View view) {
        Intent intent = new Intent(this, DisplayDataActivity.class);
        startActivity(intent);
    }

    public void openManipulateDataActivity(View view) {
        Intent intent = new Intent(this, ManipulateDataActivity.class);
        startActivity(intent);
    }
}