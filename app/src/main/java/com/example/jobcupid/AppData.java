package com.example.jobcupid;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.example.jobcupid.FireBaseHandlers.FireBaseAuthHandler;
import com.example.jobcupid.FireBaseHandlers.FireStoreHandler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppData extends Application{
    public FireStoreHandler fireStoreHandler;
    public FireBaseAuthHandler fireBaseAuthHandler;
    private Context context;
    public Candidate candidate;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        fireBaseAuthHandler = new FireBaseAuthHandler(getApplicationContext());
        fireStoreHandler = new FireStoreHandler(getApplicationContext());
        printHashKey();
    }

    public void printHashKey() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.shortmaker",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (
                PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            Log.d("ERROR", e.toString());
        }
    }

    public Context getContext() {
        return context;
    }
}
