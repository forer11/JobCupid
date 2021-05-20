package com.example.jobcupid.Activities;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jobcupid.AppData;
import com.example.jobcupid.FireBaseHandlers.FireStoreHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.jobcupid.Activities.LoginActivity.BUSINESS_OWNER;

public class OpeningScreenActivity extends AppCompatActivity {
    AppData appData;
    FirebaseAuth firebaseAuth;
    private BroadcastReceiver br;
    private boolean registered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppData();
        openNextActivity();
    }

    private void checkLoginStatus(FirebaseUser currentUser) {
        Intent intent;
        if (currentUser != null) {
            FireStoreHandler fireStoreHandler = appData.fireStoreHandler;
            appData.fireStoreHandler.setUserKey(currentUser);
            fireStoreHandler.getUserCategory(new FireStoreHandler.FireStoreUserCategoryCallback() {
                @Override
                public void onCallBack(String userCategory, Boolean success) {
                    if (success) {
                        Intent intent;
                        if (userCategory.equals(BUSINESS_OWNER)) {
                            intent = new Intent(getApplicationContext(), MainActivity.class);
                        } else {
                            intent = new Intent(getApplicationContext(), CandidateActivity.class);
                        }
                        startActivity(intent);
                        finish();
                    }
                }
            });
        } else {
            intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void getAppData() {
        appData = (AppData) getApplicationContext();
        firebaseAuth = appData.fireBaseAuthHandler.firebaseAuth;
    }


    private void openNextActivity() {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        checkLoginStatus(currentUser);
    }


    @Override
    public void onBackPressed() {
        // we do not allow back press here
    }
}