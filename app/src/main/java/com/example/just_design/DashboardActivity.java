package com.example.just_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView greetingText = findViewById(R.id.greetingText);

        // Mendapatkan waktu saat ini
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        // Menentukan selamat pagi atau selamat malam berdasarkan waktu
        if (hourOfDay >= 0 && hourOfDay < 12) {
            greetingText.setText("Good Morning,");
        } else if (hourOfDay >= 12 && hourOfDay < 18) {
            greetingText.setText("Good Afternoon,");
        } else if (hourOfDay >= 18 && hourOfDay < 0) {
            greetingText.setText("Good Evening,");
        }
    }



//    public void openInputDataActivity(View view) {
//        Intent intent = new Intent(this, InputDataActivity.class);
//        startActivity(intent);
//    }
//
//    public void openDisplayDataActivity(View view) {
//        Intent intent = new Intent(this, DisplayDataActivity.class);
//        startActivity(intent);
//    }

//    public void openManipulateDataActivity(View view) {
//        Intent intent = new Intent(this, ManipulateDataActivity.class);
//        startActivity(intent);
//    }
}