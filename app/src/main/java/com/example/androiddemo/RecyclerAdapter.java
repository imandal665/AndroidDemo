package com.example.androiddemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/*
 steps
 1.extend your RecyclerAdapter to RecyclerView.Adapter
 2.create a ViewHolder class inside RecyclerAdapter class and extend it to RecyclerView.ViewHolder{} and press alt enter to import constructor
 3.make changes in  RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.your_view_holder_class_name>{} in this case RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{}
  and press alt enter to import methods
 4. create your Adapter public constructer in this case   public RecyclerAdapter(Context context, ArrayList<String> numbers) {}
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> numbers;

    /**
     * @param context
     * @param numbers the list of items in this case numbers
     */
    public RecyclerAdapter(Context context, ArrayList<String> numbers) {
        this.context = context;
        this.numbers = numbers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the custom item layout
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {


        //set your item views and attach listeners

        holder.tv.setText("item no - " + numbers.get(position));
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.tv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //return the size of items
        return numbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // create your item view objects
        TextView tv;
        CardView parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //fetch your views id and initialize
            tv = itemView.findViewById(R.id.text_view);
            parentlayout = itemView.findViewById(R.id.parent);
        }
    }


}
