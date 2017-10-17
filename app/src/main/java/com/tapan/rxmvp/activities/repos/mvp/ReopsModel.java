package com.tapan.rxmvp.activities.repos.mvp;

import android.app.Activity;
import com.tapan.rxmvp.activities.repos.ReposActivity;
import com.tapan.rxmvp.app.network.model.GitHubRepo;

import java.util.List;

public class ReopsModel {

  private final Activity activity;

  public ReopsModel(Activity activity) {
    this.activity = activity;
  }

  public List<GitHubRepo> gitHubReposIntent() {
    return activity.getIntent().getParcelableArrayListExtra(ReposActivity.INTENT_DATA_REPOS);
  }

}
