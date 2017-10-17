package com.tapan.rxmvp.activities.login.dagger;

import com.google.firebase.auth.FirebaseAuth;
import com.tapan.rxmvp.activities.login.LoginActivity;
import com.tapan.rxmvp.app.dagger.module.FirebaseAuthModule;

import dagger.Component;

/**
 * Created by lcom64 on 17/10/17.
 */
@LoginScope
@Component(modules = {LoginModule.class, FirebaseAuthModule.class})
public interface LoginComponent {


    void injectLoginActivity(LoginActivity loginActivity);
}
