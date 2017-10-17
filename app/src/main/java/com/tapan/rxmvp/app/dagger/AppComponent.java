package com.tapan.rxmvp.app.dagger;

import android.content.Context;

import com.facebook.FacebookSdk;
import com.squareup.picasso.Picasso;
import com.tapan.rxmvp.app.dagger.module.AppModule;
import com.tapan.rxmvp.app.dagger.module.GsonModule;
import com.tapan.rxmvp.app.dagger.module.NetworkModule;
import com.tapan.rxmvp.app.network.GithubNetwork;
import dagger.Component;
import okhttp3.OkHttpClient;

@AppScope
@Component(modules = { AppModule.class , NetworkModule.class, GsonModule.class})
public interface AppComponent {

  Context context();

  OkHttpClient okhttpClient();

  GithubNetwork githubNetwork();

  Picasso picasso();


}
