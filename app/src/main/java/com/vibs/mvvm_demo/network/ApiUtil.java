package com.vibs.mvvm_demo.network;

import android.content.Context;

public class ApiUtil {

    public static final String BASE_URL = "https://reqres.in/";

    public static ApiInterface getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
