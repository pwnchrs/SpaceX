package com.example.spacexlaunchtracker.uility;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static String getDate(String data)
    {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String formattedDate = outputFormat.format(date);
        return  formattedDate;
    }
    public static void openUrl(String url, Context context)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }
}
