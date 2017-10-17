package com.tapan.rxmvp.app.dagger.module;

import com.google.firebase.auth.FirebaseAuth;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lcom64 on 17/10/17.
 */
@Module
public class FirebaseAuthModule {

    @Provides
    FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}
