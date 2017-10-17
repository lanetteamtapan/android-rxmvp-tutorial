package com.tapan.rxmvp.activities.repos.mvp;

import com.tapan.rxmvp.activities.repos.mvp.view.ReposView;

import rx.subscriptions.CompositeSubscription;

@SuppressWarnings("Convert2MethodRef")
public class ReposPresenter {

  private final ReposView view;
  private final ReopsModel model;
  private final CompositeSubscription compositeSubscription = new CompositeSubscription();

  public ReposPresenter(ReposView view, ReopsModel model) {
    this.view = view;
    this.model = model;
  }

  public void onCreate() {
    setIntentData();
  }

  public void onDestroy() {
    compositeSubscription.clear();
  }

  private void setIntentData() {
    view.setData(model.gitHubReposIntent());
  }


}
