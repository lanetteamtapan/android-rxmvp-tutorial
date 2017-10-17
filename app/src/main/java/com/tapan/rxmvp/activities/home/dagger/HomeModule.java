package com.tapan.rxmvp.activities.home.dagger;

import android.app.Activity;
import com.tapan.rxmvp.activities.home.mvp.HomeModel;
import com.tapan.rxmvp.activities.home.mvp.HomePresenter;
import com.tapan.rxmvp.activities.home.mvp.HomeView;
import com.tapan.rxmvp.app.network.GithubNetwork;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

  private final Activity activity;

  public HomeModule(Activity activity) {
    this.activity = activity;
  }

  @Provides
  @HomeScope
  public HomeView view() {
    return new HomeView(activity);
  }
  @Provides
  @HomeScope
  public HomeModel model(GithubNetwork githubNetwork) {
    return new HomeModel(activity, githubNetwork);
  }

  @Provides
  @HomeScope
  public HomePresenter homePresenter(HomeView homeView, HomeModel model) {
    return new HomePresenter(homeView, model);
  }

}
