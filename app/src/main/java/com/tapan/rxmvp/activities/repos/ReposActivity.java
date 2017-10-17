package com.tapan.rxmvp.activities.repos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tapan.rxmvp.activities.repos.dagger.DaggerReposComponent;
import com.tapan.rxmvp.activities.repos.dagger.ReopsModule;
import com.tapan.rxmvp.activities.repos.mvp.ReposPresenter;
import com.tapan.rxmvp.activities.repos.mvp.view.ReposView;
import com.tapan.rxmvp.app.GithubApplication;
import com.tapan.rxmvp.app.network.model.GitHubRepo;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ReposActivity extends AppCompatActivity {

  public static final String INTENT_DATA_REPOS = "repoList";

  public static void start(Context context, List<GitHubRepo> repoList) {
    Intent intent = new Intent(context, ReposActivity.class);
    intent.putExtra(INTENT_DATA_REPOS, new ArrayList<>(repoList));
    context.startActivity(intent);
  }

  @Inject
  ReposView view;

  @Inject
  ReposPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerReposComponent.builder()
        .appComponent(GithubApplication.get(this).component())
        .reopsModule(new ReopsModule(this))
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
