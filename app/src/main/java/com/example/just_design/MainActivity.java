package com.example.just_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myClickableText = findViewById(R.id.register);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton(v);
            }
        });
        myClickableText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegClick(v);
            }
        });


    }

    // Metode yang akan dipanggil saat tombol diklik
    public void loginButton(View view) {
        // Navigasi ke activity lain
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    // Metode yang akan dipanggil saat teks diklik
    public void onRegClick(View view) {
        // Tambahkan logika yang ingin Anda lakukan saat teks diklik di sini
        // Misalnya, tampilkan pesan atau navigasi ke aktivitas lain
        Intent intent = new Intent( MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


}