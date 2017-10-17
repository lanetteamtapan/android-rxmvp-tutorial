package com.tapan.rxmvp.activities.login.mvp;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.jakewharton.rxbinding.view.RxView;
import com.tapan.rxmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by lcom64 on 17/10/17.
 */

public class LoginView extends ConstraintLayout {
    @BindView(R.id.btnFaceBook)
    LoginButton btnFaceBook;
    @BindView(R.id.btnGoogle)
    AppCompatButton btnGoogle;
    @BindView(R.id.txtTitle)
    AppCompatTextView txtTitle;

    public LoginView(Activity context) {
        super(context);
        inflate(getContext(), R.layout.activity_login, this);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnFaceBook, R.id.btnGoogle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFaceBook:
                break;
            case R.id.btnGoogle:
                break;
        }
    }

    public Observable<Void> observeFaceBook() {
        return RxView.clicks(btnFaceBook);
    }

    public Observable<Void> observeGoogle() {
        return RxView.clicks(btnGoogle);
    }

    public void registerFacebookCallBack(CallbackManager callbackManager, FacebookCallback<LoginResult> loginResultFacebookCallback) {
        btnFaceBook.setReadPermissions("email");

        btnFaceBook.registerCallback(callbackManager, loginResultFacebookCallback);
    }
}
