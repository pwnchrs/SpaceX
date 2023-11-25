package com.example.spacexlaunchtracker.network;

import com.example.spacexlaunchtracker.constant.Constants;
import com.example.spacexlaunchtracker.model.ApiResponseModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET(Constants.Services.apiName)
    Call<ArrayList<ApiResponseModel>> getAllRecords();
}
