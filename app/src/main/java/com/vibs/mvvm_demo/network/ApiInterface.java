package com.vibs.mvvm_demo.network;


import com.vibs.mvvm_demo.model.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> loginRequest(@Field("email") String email,
                                     @Field("password") String password);

}
