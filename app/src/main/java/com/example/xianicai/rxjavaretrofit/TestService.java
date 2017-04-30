package com.example.xianicai.rxjavaretrofit;

import com.example.xianicai.rxjavaretrofit.retrofit.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Zhanglibin on 2017/4/24.
 */

public interface TestService {
    @GET("https://api.github.com/users/{user}/repos")
    Observable<HttpResult<TestBean>> getComicDetialData(@Path("user") String user);

}
