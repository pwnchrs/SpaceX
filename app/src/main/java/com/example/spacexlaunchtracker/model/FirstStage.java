package com.example.spacexlaunchtracker.model;

import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
public class FirstStage implements Serializable {
    @SerializedName("cores")
    @Expose
    private List<Core> cores;

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

}
