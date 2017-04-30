package com.example.xianicai.rxjavaretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xianicai.rxjavaretrofit.retrofit.HttpResult;
import com.example.xianicai.rxjavaretrofit.retrofit.HttpResultSubscriber;
import com.example.xianicai.rxjavaretrofit.retrofit.RxSchedulers;
import com.example.xianicai.rxjavaretrofit.retrofit.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getServerData();
    }
    private void getServerData() {
        ServiceFactory.getInstance()
                .createService(TestService.class)
                .getComicDetialData("夏尼采")
                .compose(RxSchedulers.<HttpResult<TestBean>>applySchedulers())
                .subscribe(new HttpResultSubscriber<TestBean>() {
                    @Override
                    public void Success(TestBean detailBean) {
                        Log.d("detailBean", detailBean.toString());
                    }

                    @Override
                    public void Error(Throwable e) {

                    }

                    @Override
                    public void Completed() {

                    }
                });
    }
}
