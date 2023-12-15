package com.example.just_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView myClickableText = findViewById(R.id.login);
        myClickableText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogClick(v);
            }
        });
    }

    // Metode yang akan dipanggil saat teks diklik
    public void onLogClick(View view) {
        // Tambahkan logika yang ingin Anda lakukan saat teks diklik di sini
        // Misalnya, tampilkan pesan atau navigasi ke aktivitas lain
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}