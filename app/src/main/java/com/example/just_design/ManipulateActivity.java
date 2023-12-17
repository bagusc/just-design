package com.example.just_design;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import com.example.just_design.Adapter;
import com.example.just_design.RvItemClick;
import com.example.just_design.Item;
import com.example.just_design.R;
import com.example.just_design.databinding.ActivityManipulateBinding; // Import binding

public class ManipulateActivity extends AppCompatActivity implements RvItemClick {

    private ActivityManipulateBinding binding; // Gunakan binding
    private List<Item> itemList;
    private Adapter adapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityManipulateBinding.inflate(getLayoutInflater()); // Gunakan inflate dari binding
        setContentView(binding.getRoot());

        TextView backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        itemList = new ArrayList<>();
        handler = new Handler();

        itemList.add(new Item("Nike Waffle Debut\n", R.drawable.waffle));
        itemList.add(new Item("Nike Revolution 6\n", R.drawable.img));
        itemList.add(new Item("Air Jordan 1 Elevate Low SE\n", R.drawable.img_1));
        itemList.add(new Item("Nike Air More Uptempo '96\n", R.drawable.img_2));



        binding.rvMain.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rvMain.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(this, itemList, this);
        binding.rvMain.setAdapter(adapter);

        binding.rvMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {

            }

            @Override
            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        }
                    }, 3000);
                } else if (dy < 0) {
                }
            }
        });

    }

    @Override
    public void onClickItem(Item item) {
        Intent intent = new Intent(this, SinglePage.class);
        intent.putExtra("name", item.getName());
        intent.putExtra("picture", item.getPicture());
        startActivity(intent);
    }

    @Override
    public void onRvMenuItem(int position, MenuItem menuItem, Item item) {
        int itemId = menuItem.getItemId();

        if (itemId == R.id.edit) {
            navigateToEditPage();
        } else if (itemId == R.id.delete) {
            Toast.makeText(this, "Berhasil dihapus", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToEditPage() {
        Intent intent = new Intent(ManipulateActivity.this, EditPage.class);
        startActivity(intent);
    }

}