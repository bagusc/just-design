package com.example.just_design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PersonViewHolder> {

    private final Context context;
    private final List<Item> itemList;
    private final RvItemClick rvItemClick;

    public Adapter(Context context, List<Item> itemList, RvItemClick rvItemClick) {
        this.context = context;
        this.itemList = itemList;
        this.rvItemClick = rvItemClick;
    }

    @NonNull
    @NotNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_layout, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Adapter.PersonViewHolder holder, int position) {
        holder.bindData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            PopupMenu.OnMenuItemClickListener {

        ImageView ivPicture, ivMenu;
        TextView tvName;

        public PersonViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            ivPicture = itemView.findViewById(R.id.ivPicture);
            tvName = itemView.findViewById(R.id.tvName);
            ivMenu = itemView.findViewById(R.id.ivMenu);
            ivMenu.setOnClickListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rvItemClick.onClickItem(itemList.get(getAdapterPosition()));
                }
            });
        }

        public void bindData(Item item) {
            tvName.setText(item.getName());
            Glide.with(context).load(item.getPicture()).into(ivPicture);
        }

        @Override
        public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
            popupMenu.getMenuInflater().inflate(R.menu.rv_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int position = getAdapterPosition();
            rvItemClick.onRvMenuItem(position, item, itemList.get(position));
            return false;
        }
    }
}
