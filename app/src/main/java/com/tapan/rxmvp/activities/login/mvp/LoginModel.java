package com.tapan.rxmvp.activities.login.mvp;

import android.app.Activity;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.tapan.rxmvp.activities.login.dagger.LoginModule;


import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * Created by lcom64 on 17/10/17.
 */

public class LoginModel {

    private static final String TAG = "LoginModel";
    private final Activity loginActivity;


    private final Observable<LoginResult> fbObserver;



    private final FirebaseAuth mAuth;
    private LoginPresenter presenter;
    CallbackManager callbackManager;
    FacebookCallback<LoginResult> loginResultFacebookCallback;

    public LoginModel(Activity loginActivity, CallbackManager callbackManager, FirebaseAuth firebaseAuth) {
        FacebookSdk.sdkInitialize(getApplicationContext());

        this.loginActivity = loginActivity;
        this.callbackManager = CallbackManager.Factory.create();
        this.mAuth = firebaseAuth;


        fbObserver = Observable.create(new Observable.OnSubscribe<LoginResult>() {
            @Override
            public void call(Subscriber<? super LoginResult> subscriber) {
                LoginModel.this.loginResultFacebookCallback = new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
//                        handleFacebookAccessToken(loginResult.getAccessToken());
                        subscriber.onNext(loginResult);
                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "onCancel() called");
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d(TAG, "onError() called with: error = [" + error + "]");
                    }
                };
            }
        });
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());

    }

    public Observable<LoginResult> getFbObserver() {
        return fbObserver;
    }
    public FirebaseAuth getmAuth() {
        return mAuth;
    }
}
