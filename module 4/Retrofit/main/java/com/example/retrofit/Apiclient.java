package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient

{

    static Retrofit retrofit= null;
    public static final String BASE_URL="https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/";

    public static Retrofit getapiclient()
    {
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }
}
