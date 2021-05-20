package com.example.jobcupid.FireBaseHandlers;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.jobcupid.AppData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class FireBaseAuthHandler {
    private static final String WEB_ID = "404398597564-0ndahe83e60jonr1n18enap0vvef3gg5.apps.googleusercontent.com";
    private Context context;
    public FirebaseUser user = null;
    public FirebaseAuth firebaseAuth;
    public GoogleSignInClient googleSignInClient;


    public FireBaseAuthHandler(Context context) {
        this.context = context;
        firebaseAuth = FirebaseAuth.getInstance();
        configureGoogleSignIn();
        userStateListener();
    }

    private void userStateListener() {
        final FirebaseAuth.IdTokenListener userListener = new FirebaseAuth.IdTokenListener() {
            @Override
            public void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    AppData appData = (AppData) context.getApplicationContext();
                    appData.fireStoreHandler.setUserKey(appData.fireBaseAuthHandler.user);
                }
            }
        };
        firebaseAuth.addIdTokenListener(userListener);
    }

    private void configureGoogleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(WEB_ID)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(context, gso);
    }
}
