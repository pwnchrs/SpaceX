package com.example.spacexlaunchtracker.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.spacexlaunchtracker.R;
import com.google.gson.Gson;

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    public Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
    public void removeProgressDialog() {
        if (progressDialog == null || !progressDialog.isShowing()) return;
        try {
            if (!isFinishing())
                progressDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void showProgressDialog() {
        try {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(this);
            }

            progressDialog.setMessage("Please wait..");
            progressDialog.show();
            progressDialog.setCancelable(false);

            progressDialog.setOnKeyListener(new Dialog.OnKeyListener() {

                @Override
                public boolean onKey(DialogInterface arg0, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        progressDialog.setCancelable(true);
                        progressDialog.dismiss();
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}