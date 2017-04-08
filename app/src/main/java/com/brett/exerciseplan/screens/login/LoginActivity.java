package com.brett.exerciseplan.screens.login;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.brett.exerciseplan.R;
import com.brett.exerciseplan.commons.BaseActivity;
import com.brett.exerciseplan.commons.GoogleSignInApi;
import com.brett.exerciseplan.screens.main.MainActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements GoogleApiClient.OnConnectionFailedListener, LoginView {
    private String TAG = LoginActivity.class.getSimpleName();
    private GoogleSignInApi googleSignInApi;

    @BindView(R.id.buttonGoogleSignin)
    SignInButton googleSignInButton;

    private static final int RC_SIGN_IN = 007;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindButterKnife(this);

        changeButtonText("Sign in with google");
    }

    private void changeButtonText(String text) {
        googleSignInButton = (SignInButton)findViewById(R.id.buttonGoogleSignin);
        googleSignInApi = googleSignInApi.getInstance(this);
        googleSignInButton.setScopes(googleSignInApi.setSignInApi(this, this).getScopeArray());
        for(int i = 0; i < googleSignInButton.getChildCount(); i++){
            if(googleSignInButton.getChildAt(i) instanceof TextView)
                ((TextView)googleSignInButton.getChildAt(i)).setText(text);
        }
    }

    @OnClick(R.id.buttonGoogleSignin)
    public void googleSignIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleSignInApi.getGoogleApiClient());
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Fail to sign in", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case RC_SIGN_IN:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                boolean returnBool = googleSignInApi.handleSignInResult(result);
                Log.d(TAG, "onActivityResult_returnBool is " + returnBool + " " + data.getDataString());
                for (String key : data.getExtras().keySet()) {
                    Object value = data.getExtras().get(key);
                    Log.d(TAG + "1", String.format("%s %s (%s)", key,
                            value.toString(), value.getClass().getName()));
                }
                if (returnBool) {
                    // presenter.requestLoginWithGoogle(result.getSignInAccount().getIdToken());
                } else {
                    if (resultCode != RESULT_CANCELED) {
                        //showAlertMsgDialog("Your Account is invalid. Please check again");
                    }
                }

                moveToMain();
                break;

            default:
                break;
        }

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void moveToMain() {
        // TODO : login 설정 저장

        Toast.makeText(this, "Log in succeed", Toast.LENGTH_SHORT);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
