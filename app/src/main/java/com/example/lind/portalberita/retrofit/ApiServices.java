package com.example.lind.portalberita.retrofit;

import com.example.lind.portalberita.Model.ListBeritaModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lind on 04/03/2018.
 */

public interface ApiServices {
    @GET("getBerita.php")//dapet dari web retrofit
    Call<ListBeritaModel> ambilberita ();
}
