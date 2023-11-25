package com.example.spacexlaunchtracker.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.spacexlaunchtracker.R;
import com.example.spacexlaunchtracker.model.ApiResponseModel;
import com.example.spacexlaunchtracker.uility.Utility;

import java.io.Serializable;

public class DetailActivity extends BaseActivity {
    private TextView txtMissionName;
    private TextView txtLaunchDate;
    private TextView txtRocketName;
    private TextView txtRocketType;
    private TextView txtDescription;
    private TextView txtFirstStage;
    private TextView txtSecondStage;
    private TextView txtStatus;
    private TextView txtFailure;
    private TextView txtLaunchSite;
    private TextView txtHeading;
    private TextView txtLaunchWindow;
    private TextView txtMissionDescription;
    private TextView txtMissionPatch;
    private TextView txtArticleLink;
    private TextView txtWikipedia;
    private TextView txtVideoLink;
    private ImageView imgMissionPatch;
    private ApiResponseModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        model = (ApiResponseModel) getIntent().getSerializableExtra("data");

        txtVideoLink = findViewById(R.id.txtVideoLink);
        txtArticleLink = findViewById(R.id.txtArticleLink);
        txtMissionPatch = findViewById(R.id.txtMissionPatch);
        txtWikipedia = findViewById(R.id.txtWikipedia);
        txtMissionName = findViewById(R.id.txtMissionName);
        txtLaunchDate = findViewById(R.id.txtLaunchDate);
        txtRocketName = findViewById(R.id.txtRocketName);
        txtRocketType = findViewById(R.id.txtRocketType);
        txtDescription = findViewById(R.id.txtDescription);
        txtFirstStage = findViewById(R.id.txtFirstStage);
        txtSecondStage = findViewById(R.id.txtSecondStage);
        txtStatus = findViewById(R.id.txtStatus);
        txtFailure = findViewById(R.id.txtFailure);
        txtLaunchSite = findViewById(R.id.txtLaunchSite);
        txtLaunchWindow = findViewById(R.id.txtLaunchWindow);
        imgMissionPatch = findViewById(R.id.imgMissionPatch);
        txtMissionDescription = findViewById(R.id.txtMissionDescription);
        txtHeading = findViewById(R.id.txtHeading);

        txtMissionName.setText(model.getMissionName());
        txtLaunchDate.setText("Launch Date: " + Utility.getDate(model.getLaunchDateUtc()));
        txtRocketName.setText("Rocket Name: " + model.getRocket().getRocketName());
        txtRocketType.setText("Rocket Type: " + model.getRocket().getRocketType());
        if (model.getRocket().getFairings() != null) {
            txtDescription.setText(model.getRocket().getFairings().getReused() ? "Can be Reused?: Yes" : "Can be Reused?: No");
        } else {
            txtDescription.setText("Can be Reused?: No");
        }
        if (model.getRocket().getFirstStage().getCores() != null && model.getRocket().getFirstStage().getCores().size() != 0) {
            txtFirstStage.setText("Core Serial: " + model.getRocket().getFirstStage().getCores().get(0).getCoreSerial() + "\nFight: " + model.getRocket().getFirstStage().getCores().get(0).getFlight());
        }
        if (model.getRocket().getSecondStage().getPayloads() != null && model.getRocket().getSecondStage().getPayloads().size() != 0) {
            txtSecondStage.setText("Nationality: " + model.getRocket().getSecondStage().getPayloads().get(0).getNationality() + "\nNo. of Block: " + model.getRocket().getSecondStage().getBlock() + "\nManufacturer: " + model.getRocket().getSecondStage().getPayloads().get(0).getManufacturer() + "\nPayload Type: " + model.getRocket().getSecondStage().getPayloads().get(0).getPayloadType());
        }
        txtStatus.setText(model.getLaunchSuccess() ? "Launch Status :Launched" : "Launch Status :Not Launched");
        if (!model.getLaunchSuccess()) {
            txtFailure.setVisibility(View.VISIBLE);
            txtStatus.setText("Launch Failure Details: " + model.getLaunchFailureDetails().getReason());
        } else {
            txtFailure.setVisibility(View.GONE);
        }
        txtLaunchSite.setText("Site Name: " + model.getLaunchSite().getSiteName() + "\nSite Location: " + model.getLaunchSite().getSiteNameLong());
        txtLaunchWindow.setText("Launch Window: " + model.getLaunchWindow());
        Glide.with(DetailActivity.this)
                .load(model.getLinks().getMissionPatch())
                .into(imgMissionPatch);
        if (model.getDetails() != null && model.getDetails().length() != 0) {
            txtMissionDescription.setText(model.getDetails());
            txtMissionDescription.setVisibility(View.VISIBLE);
            txtHeading.setVisibility(View.VISIBLE);
        } else {
            txtMissionDescription.setVisibility(View.GONE);
            txtHeading.setVisibility(View.GONE);
        }

        txtArticleLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openUrl(model.getLinks().getArticleLink(), DetailActivity.this);
            }
        });

        txtMissionPatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openUrl(model.getLinks().getMissionPatch(), DetailActivity.this);
            }
        });

        txtVideoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openUrl(model.getLinks().getVideoLink(), DetailActivity.this);
            }
        });

        txtWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openUrl(model.getLinks().getWikipedia(), DetailActivity.this);
            }
        });
    }
}