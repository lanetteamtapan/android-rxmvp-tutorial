package com.tapan.rxmvp.activities.login.dagger;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.google.firebase.auth.FirebaseAuth;
import com.tapan.rxmvp.activities.login.mvp.LoginModel;
import com.tapan.rxmvp.activities.login.mvp.LoginPresenter;
import com.tapan.rxmvp.activities.login.mvp.LoginView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lcom64 on 17/10/17.
 */
@Module
public class LoginModule {

    Activity activity;
    CallbackManager callbackManager;
    private LoginPresenter loginPresenter;
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginModule(Activity activity) {
        this.activity = activity;
    }

    @LoginScope
    @Provides
    CallbackManager callbackManager() {
        return this.callbackManager = CallbackManager.Factory.create();
    }

    @Provides
    @LoginScope
    public LoginView view() {
        return this.loginView = new LoginView(activity);
    }


    @LoginScope
    @Provides
    public LoginModel model(FirebaseAuth firebaseAuth) {
        return this.loginModel = new LoginModel(activity, callbackManager, firebaseAuth);
    }

    @LoginScope
    @Provides
    public LoginPresenter LoginPresenter(LoginModel loginModel) {
        return this.loginPresenter = new LoginPresenter(loginView, loginModel);
    }

}
