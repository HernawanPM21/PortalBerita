package com.example.lind.portalberita.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lind on 04/03/2018.
 */

public class ApiClient {
    private static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.17.5.140/serverberitabaru/")//url depan
                .addConverterFactory(GsonConverterFactory.create())//karena menggunakan convert er
                .build();//liat di internet baris ke 2
        return retrofit;
    }
    public static  ApiServices getApiServices(){
        return getRetrofit().create(ApiServices.class);
    }
}
