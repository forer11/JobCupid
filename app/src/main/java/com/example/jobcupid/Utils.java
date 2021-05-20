package com.example.jobcupid;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String TAG = "Utils";

    public static List<Candidate> loadCandidates(Context context){
        try{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray array = new JSONArray(loadJSONFromAsset(context, "job_seekers_data.json"));
            List<Candidate> profileList = new ArrayList<>();
            for(int i=0;i<array.length();i++){
                Candidate profile = gson.fromJson(array.getString(i), Candidate.class);
                profileList.add(profile);
            }
            return profileList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Candidate> loadBusinesses(Context context){
        try{
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray array = new JSONArray(loadJSONFromAsset(context, "businesses.json"));
            List<Candidate> profileList = new ArrayList<>();
            for(int i=0;i<array.length();i++){
                Candidate profile = gson.fromJson(array.getString(i), Candidate.class);
                profileList.add(profile);
            }
            return profileList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static String loadJSONFromAsset(Context context, String jsonFileName) {
        String json = null;
        InputStream is=null;
        try {
            AssetManager manager = context.getAssets();
            Log.d(TAG,"path "+jsonFileName);
            is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static void showToast(Context context, String text, boolean isLong) {
        Toast.makeText(context, text, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }
}