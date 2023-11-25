package com.example.spacexlaunchtracker.network;

import android.content.Context;

import com.example.spacexlaunchtracker.constant.Constants;
import com.example.spacexlaunchtracker.model.ApiResponseModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCall {

    private static APIService service;

    public static ApiCall getInstance(Context context) {
        if (service == null) {
            service = RestClient.getClient();
        }
        return new ApiCall();
    }


    public void getAllRecords(final IApiCallback iApiCallback) {
        Call<ArrayList<ApiResponseModel>> call = service.getAllRecords();
        call.enqueue(new Callback<ArrayList<ApiResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ApiResponseModel>> call, Response<ArrayList<ApiResponseModel>> response) {
                iApiCallback.onSuccess(Constants.Services.apiName,response,null);
            }
            @Override
            public void onFailure(Call<ArrayList<ApiResponseModel>> call, Throwable t) {
                iApiCallback.onFailure("" + t.getMessage());
            }
        });
    }
}
