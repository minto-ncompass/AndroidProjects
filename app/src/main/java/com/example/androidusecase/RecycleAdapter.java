package com.example.androidusecase;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>
{

    ArrayList<DataModel> dataHolder;


    public RecycleAdapter(ArrayList<DataModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        if(position == 0) {
            holder.container.setBackgroundResource(R.drawable.rounded_corner_top);
        }

        if(position == dataHolder.size()-1) {
            holder.container.setBackgroundResource(R.drawable.rounded_corner_bottom);
        }
        holder.img.setImageResource(dataHolder.get(position).getImage());
//        holder.leaveType.setText(dataHolder.get(position).getLeaveType());

        String leaveType = dataHolder.get(position).getLeaveType();
        if(leaveType.equalsIgnoreCase("Sick Leave"))
        {
            holder.leaveType.setText("Sick Leave");
            holder.leaveType.setBackgroundResource(R.drawable.rounded_corners_leave_type);
            holder.leaveType.setTextColor(Color.parseColor("#F8B00D"));
            holder.leaveType.setBackgroundColor(Color.parseColor("#FEF4DF"));


        }else
        {
            holder.leaveType.setText("Casual Leave");
            holder.leaveType.setBackgroundResource(R.drawable.rounded_corners_leave_type);
            holder.leaveType.setTextColor(Color.parseColor("#0DC3F8"));
            holder.leaveType.setBackgroundColor(Color.parseColor("#DFF7FE"));

        }

        holder.dateTime.setText(dataHolder.get(position).getDateTime());
        holder.name.setText(dataHolder.get(position).getName());
        holder.role.setText(dataHolder.get(position).getRole());
        holder.numberOfDays.setText(dataHolder.get(position).getNumberOfDays());
        holder.dateRange.setText(dataHolder.get(position).getDateRange());

//        holder.status.setText(dataHolder.get(position).getStatus());
        String status = dataHolder.get(position).getStatus();
        int statusIcon = dataHolder.get(position).getStatusIcon();
        if(status.equalsIgnoreCase("Approved"))
        {
            holder.status.setText("Approved");
            holder.status.setTextColor(Color.parseColor("#14BF70"));
            holder.statusIcon.setImageResource(R.drawable.ic_baseline_tick_24);

        }else
        {
            holder.status.setText("Rejected");
            holder.status.setTextColor(Color.parseColor("#D33E1B"));
            holder.statusIcon.setImageResource(R.drawable.ic_baseline_clear_24);
        }

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img, statusIcon;
        TextView leaveType, dateTime, name, role, numberOfDays,dateRange, status;
        LinearLayout container;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            container = itemView.findViewById(R.id.RecycleContainer);
            img = itemView.findViewById(R.id.img1);
            leaveType = itemView.findViewById(R.id.leave_type);
            dateTime = itemView.findViewById(R.id.date_and_time);
            name = itemView.findViewById(R.id.name);
            role = itemView.findViewById(R.id.role);
            numberOfDays = itemView.findViewById(R.id.no_of_days);
            dateRange = itemView.findViewById(R.id.date_range);
            status = itemView.findViewById(R.id.status);
            statusIcon = itemView.findViewById(R.id.status_icon);
        }
    }
}
