package com.example.parsaniahardik.json_recyclerview_zerone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RogerAdapter extends RecyclerView.Adapter<RogerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<RogerModel> rogerModelArrayList;

    public RogerAdapter(Context ctx, ArrayList<RogerModel> rogerModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.rogerModelArrayList = rogerModelArrayList;
    }

    @Override
    public RogerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RogerAdapter.MyViewHolder holder, int position) {

        if(rogerModelArrayList.get(position).getImgURL()!=null && !rogerModelArrayList.get(position).getImgURL().equalsIgnoreCase("null")){
            Picasso.get().load(rogerModelArrayList.get(position).getImgURL()).into(holder.iv);
        }  else{
            holder.iv.setImageResource(R.mipmap.ic_launcher);
        }

        holder.name.setText(rogerModelArrayList.get(position).getTitle());
        holder.country.setText(rogerModelArrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return rogerModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView country, name, city;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            country = (TextView) itemView.findViewById(R.id.country);
            name = (TextView) itemView.findViewById(R.id.name);
            city = (TextView) itemView.findViewById(R.id.city);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
