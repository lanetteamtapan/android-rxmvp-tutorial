package com.tapan.rxmvp.app.dagger.module;

import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tapan.rxmvp.app.dagger.AppScope;
import com.tapan.rxmvp.ext.GithubAdapterFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

  @AppScope
  @Provides
  public Gson context() {
    return Converters.registerAll(new GsonBuilder())
        .registerTypeAdapterFactory(GithubAdapterFactory.create())
        .create();
  }
}
