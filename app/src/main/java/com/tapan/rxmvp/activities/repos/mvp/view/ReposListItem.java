package com.tapan.rxmvp.activities.repos.mvp.view;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tapan.rxmvp.R;
import com.tapan.rxmvp.app.network.model.GitHubRepo;

public class ReposListItem extends FrameLayout {

  @BindView(R.id.repo_name)
  TextView nameTextView;

  @BindView(R.id.repo_desc)
  TextView descTextView;

  public ReposListItem(Context context) {
    super(context);

    inflate(getContext(), R.layout.list_item_repo, this);
    ButterKnife.bind(this);
  }

  public void setRepo(GitHubRepo gitHubRepo) {
    nameTextView.setText(gitHubRepo.name());
    descTextView.setText(gitHubRepo.description());
  }

}
