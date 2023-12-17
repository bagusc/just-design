package com.example.just_design;

import android.view.MenuItem;


public interface RvItemClick {
    void onClickItem(Item item);
    void onRvMenuItem(int position, MenuItem menuItem, Item item);
}
