package com.tapan.rxmvp.activities.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tapan.rxmvp.activities.home.dagger.DaggerHomeComponent;
import com.tapan.rxmvp.activities.home.dagger.HomeModule;
import com.tapan.rxmvp.activities.home.mvp.HomePresenter;
import com.tapan.rxmvp.activities.home.mvp.HomeView;
import com.tapan.rxmvp.app.GithubApplication;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  @Inject
  HomeView view;

  @Inject
  HomePresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerHomeComponent.builder()
        .appComponent(GithubApplication.get(this).component())
        .homeModule(new HomeModule(this))
        .build().inject(this);

    setContentView(view);
    presenter.onCreate();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }
}
