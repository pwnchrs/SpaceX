package com.example.spacexlaunchtracker.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.spacexlaunchtracker.R;
import com.example.spacexlaunchtracker.adapter.MainListAdapter;
import com.example.spacexlaunchtracker.connection.ConnectivityUtils;
import com.example.spacexlaunchtracker.constant.Constants;
import com.example.spacexlaunchtracker.model.ApiResponseModel;
import com.example.spacexlaunchtracker.network.ApiCall;
import com.example.spacexlaunchtracker.network.IApiCallback;

import java.util.ArrayList;

import retrofit2.Response;

public class MainListActivity extends BaseActivity implements IApiCallback {

    private RecyclerView recMainList;
    private MainListAdapter adapter;
    private ArrayList<ApiResponseModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*

        LaunchDatabase launchDatabase = Room.databaseBuilder(this, LaunchDatabase.class, "launch_database").build();
        LaunchDao launchDao = launchDatabase.launchDao();

// Insert a launch
//        launchDao.insertLaunch(launchEntity);

// Query all launches
        List<ApiResponseModel> launches = launchDao.getAllLaunches();
*/

        recMainList = (RecyclerView) findViewById(R.id.recMainList);
        adapter = new MainListAdapter(MainListActivity.this);
        recMainList.setLayoutManager(new LinearLayoutManager(MainListActivity.this));
        list = new ArrayList<>();
        recMainList.setAdapter(adapter);
        getAllRecords();
    }

    private void getAllRecords() {
        if (!ConnectivityUtils.isNetworkEnabled(MainListActivity.this)) {
            Toast.makeText(MainListActivity.this, Constants.ValidationMessage.noInternetConnection, Toast.LENGTH_SHORT).show();
            removeProgressDialog();
            populateLocalData();
        }
         else {
            hitApiGetAllRecords();
        }
    }

    private void populateLocalData() {
//        if (apiResponseModelDao.getAllData() !=null && apiResponseModelDao.getAllData().size()!=0)
//        {
//            list=apiResponseModelDao.getAllData();
//            adapter.updateList(list);
//        }
    }

    private void checkDataInDatabase(ArrayList<ApiResponseModel> body) {
        if (true) {
            if (body.size() != 0) {
                for (int i = 0; i < body.size(); i++) {
//                    apiResponseModelDao.InsertData(body.get(i));
                }
            }
        }
    }

    private void hitApiGetAllRecords() {
        if (!ConnectivityUtils.isNetworkEnabled(MainListActivity.this)) {
            Toast.makeText(MainListActivity.this, Constants.ValidationMessage.noInternetConnection, Toast.LENGTH_SHORT).show();
            removeProgressDialog();
            return;
        }
        showProgressDialog();
        ApiCall.getInstance(MainListActivity.this).getAllRecords(this);
    }

    @Override
    public void onSuccess(Object type, Object data, Object extraData) {
        removeProgressDialog();
        if (type.equals(Constants.Services.apiName)) {
            Response<ArrayList<ApiResponseModel>> response = (Response<ArrayList<ApiResponseModel>>) data;
            if (response.isSuccessful()) {
                if (response.body().size() != 0) {
                    adapter.updateList(response.body());
//                    checkDataInDatabase(response.body());
                }
            }
        }
    }

    @Override
    public void onFailure(Object data) {

    }
}