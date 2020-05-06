package com.example.technicalproficiency.callback;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shilpa on 19/1/18.
 */

public class ApiClient {

    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endPoint)
                .build();
        return restAdapter.create(clazz);
    }
    public static String getBaseUrl() {
        return BASE_URL;
    }


    public static Retrofit getClientproduct() {
        Retrofit retrofit = null;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://nodejs-application-201006.appspot.com")//BASE_URL
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    ///http://35.201.138.23:8080/Download/RETAIL_STORE_PROD_CPG.jsp?Store_Id=1463635776
    /// https://nodejs-application-201006.appspot.com/RETAIL_STORE_PROD_CPG/1463635776
    public static Retrofit getClient1() {
        Retrofit retrofit = null;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://35.201.138.23:4000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getNodeJsClient() {
        Retrofit retrofit = null;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://nodejs-application-201006.appspot.com")
                    //  .baseUrl("http://192.168.43.13:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit CreatePharmaOrder() {
        Retrofit retrofit = null;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://35.201.138.23:8080/")
                    //  .baseUrl("http://192.168.43.13:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
