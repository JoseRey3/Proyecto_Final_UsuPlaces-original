package com.example.usuplace.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.usuplace.Domain.DepartmentDomain;
import com.example.usuplace.Domain.ItemDomain;
import com.example.usuplace.R;
import com.example.usuplace.activites.ItemDetail;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder>{

    ArrayList<DepartmentDomain>item;
    Context context;

    public DepartmentAdapter(ArrayList<DepartmentDomain> item){
        this.item = item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_places, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name_place.setText(item.get(position).getTitle());

        int drawablaResourceId = holder.itemView.getResources().getIdentifier(item.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawablaResourceId)
                .into(holder.image_place);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemDetail.class);
            intent.putExtra("object", item.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name_place;
        ImageView image_place;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_place = itemView.findViewById(R.id.name_place);
            image_place = itemView.findViewById(R.id.image_place);
        }
    }

}
