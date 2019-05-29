package com.luffy.burypoint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.luffy.burypointlib.mvp.presenter.BuryPointPresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_report)
    public void onViewClicked() {
        BuryPointPresenter mBuryPointPresenter = new BuryPointPresenter();
        mBuryPointPresenter.requestBuryPointGet(this, "", "", "{ \"index\":\"1\",\"url\"：\"https:// www.xxx\"}");
    }
}
