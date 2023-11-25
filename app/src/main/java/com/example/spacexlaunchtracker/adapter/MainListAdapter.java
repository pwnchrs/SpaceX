package com.example.spacexlaunchtracker.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spacexlaunchtracker.R;
import com.example.spacexlaunchtracker.activity.DetailActivity;
import com.example.spacexlaunchtracker.model.ApiResponseModel;
import com.example.spacexlaunchtracker.uility.Utility;
import com.google.android.material.card.MaterialCardView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<ApiResponseModel> data;

    public MainListAdapter(Context context) {
        mContext = context;
        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public MainListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_content, parent, false);
        return new MainListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainListAdapter.MyViewHolder holder, int position) {
        holder.txtMissionName.setText("Mission Name: "+data.get(position).getMissionName());
        holder.txtLaunchDate.setText("Launch Date: "+ Utility.getDate(data.get(position).getLaunchDateUtc()));
        holder.txtRocketName.setText("Rocket Name: "+data.get(position).getRocket().getRocketName());
        if (data.get(position).getLaunchSuccess()!=null) {
            holder.txtLaunchStatus.setText(data.get(position).getLaunchSuccess() ? "Launch Status: Launched" : "Launch Status: Not Launched");
        }
        else {
            holder.txtLaunchStatus.setText("Launch Status: Not Launched");
        }
        Glide.with(mContext)
                .load(data.get(position).getLinks().getMissionPatchSmall())
                .into(holder.imgThumbnail);
        holder.imgBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.get(position).getBookmarked())
                {
                    data.get(position).setBookmarked(false);
                    holder.imgBookmark.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.bookmark_white));
                }
                else{
                    data.get(position).setBookmarked(true);
                    holder.imgBookmark.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.bookmark));
                }
            }
        });

        holder.llAllView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, DetailActivity.class);
                intent.putExtra("data",data.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateList(ArrayList<ApiResponseModel> body) {
        data = body;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMissionName;
        private TextView txtLaunchDate;
        private TextView txtRocketName;
        private TextView txtLaunchStatus;
        private ImageView imgThumbnail;
        private ImageView imgBookmark;
        private MaterialCardView llAllView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMissionName = itemView.findViewById(R.id.txtMissionName);
            txtLaunchDate = itemView.findViewById(R.id.txtLaunchDate);
            txtRocketName = itemView.findViewById(R.id.txtRocketName);
            txtLaunchStatus = itemView.findViewById(R.id.txtLaunchStatus);
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
            imgBookmark = itemView.findViewById(R.id.imgBookmark);
            llAllView = itemView.findViewById(R.id.llAllView);
        }
    }
}
