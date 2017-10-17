package com.tapan.rxmvp.activities.repos.dagger;

import com.tapan.rxmvp.activities.repos.ReposActivity;
import com.tapan.rxmvp.app.dagger.AppComponent;
import dagger.Component;

@ReposScope
@Component(modules = { ReopsModule.class }, dependencies = AppComponent.class)
public interface ReposComponent {

  void inject(ReposActivity mainActivity);

}
