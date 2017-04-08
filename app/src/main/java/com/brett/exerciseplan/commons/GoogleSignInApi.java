package com.brett.exerciseplan.commons;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.brett.exerciseplan.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class GoogleSignInApi {
    private static final String TAG = GoogleSignInApi.class.getCanonicalName();

    private GoogleSignInOptions gso;
    private GoogleApiClient googleApiClient;
    private GoogleSignInAccount acct;
    private static Context context;

    private static GoogleSignInApi instance;

    private GoogleSignInApi() {
    }

    public static GoogleSignInApi getInstance(Context context) {
        if (instance == null) {
            instance = new GoogleSignInApi();
        }

        GoogleSignInApi.context = context;
        return instance;
    }


    public GoogleSignInOptions setSignInApi(FragmentActivity activity, GoogleApiClient.OnConnectionFailedListener listener) {
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.server_client_id))
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(activity, listener)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        return gso;
    }

    public GoogleApiClient getGoogleApiClient() {
        return googleApiClient;
    }

    public boolean handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            acct = result.getSignInAccount();

            Log.e(TAG, "display name: " + acct.getDisplayName());
            Log.e(TAG, "getPhotoUrl: " + acct.getPhotoUrl());
            Log.e(TAG, "get Token : " + acct.getIdToken());
            Log.e(TAG, "get Id " + acct.getId());
            Log.e(TAG, "get server Auth code " + acct.getServerAuthCode());

            String personName = acct.getDisplayName();
            String personPhotoUrl = acct.getPhotoUrl() != null ? acct.getPhotoUrl().toString() : "";
            String email = acct.getEmail();

            Log.e(TAG, "Name: " + personName + ", email: " + email
                    + ", Image: " + personPhotoUrl);

            return true;
        } else {
            // Signed out, show unauthenticated UI.
            return false;
        }
    }

    public GoogleSignInAccount getProfile() {
        return acct;
    }

    public void signOutGoogle(ResultCallback<Status> resultCallback) {
        Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(resultCallback);
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(resultCallback);
    }

    public OptionalPendingResult<GoogleSignInResult> getOpr() {
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        return opr;
    }
}
