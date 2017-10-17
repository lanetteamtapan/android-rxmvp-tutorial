package com.tapan.rxmvp.activities.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tapan.rxmvp.activities.login.dagger.DaggerLoginComponent;
import com.tapan.rxmvp.activities.login.dagger.LoginModule;
import com.tapan.rxmvp.activities.login.mvp.LoginPresenter;
import com.tapan.rxmvp.activities.login.mvp.LoginView;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginActivity extends AppCompatActivity {


    @Inject
    LoginView view;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerLoginComponent.builder().loginModule(new LoginModule(LoginActivity.this)).build().injectLoginActivity(this);
        Timber.d("created");
        setContentView(view);
        presenter.onCreate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
