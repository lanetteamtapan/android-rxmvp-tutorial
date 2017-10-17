package com.tapan.rxmvp.activities.login.mvp;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.util.Log;

import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;
import com.google.firebase.auth.FacebookAuthProvider;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import rxfirebase2.auth.RxFirebaseAuth;
import timber.log.Timber;

/**
 * Created by lcom64 on 17/10/17.
 */

public class LoginPresenter {
    LoginView loginView;
    LoginModel loginModel;
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Inject
    public LoginPresenter(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    public void onCreate() {
        createFaceBookLoginObserver();
        loginView.registerFacebookCallBack(loginModel.callbackManager, loginModel.loginResultFacebookCallback);


    }

    private void createFaceBookLoginObserver() {

        loginModel.getFbObserver().subscribe(loginResult -> {
            RxFirebaseAuth
                    .signInWithCredential(loginModel.getmAuth(),
                            FacebookAuthProvider.getCredential(loginResult.getAccessToken().getToken()))
                    .subscribe(firebaseUser -> {
                        Log.d("firebaseUser", "" + firebaseUser);
                    });

        });
    }


    public void onDestroy() {


    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        loginModel.callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
