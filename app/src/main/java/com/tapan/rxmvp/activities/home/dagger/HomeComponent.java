package com.tapan.rxmvp.activities.home.dagger;

import com.tapan.rxmvp.activities.home.MainActivity;
import com.tapan.rxmvp.app.dagger.AppComponent;

import dagger.Component;

@HomeScope
@Component(modules = { HomeModule.class }, dependencies = AppComponent.class)
public interface HomeComponent {

  void inject(MainActivity mainActivity);

}
