package com.example.technicalproficiency.callback;

import com.example.technicalproficiency.model.DataDetail;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("facts.json")
    Call<DataDetail> getResponse(@Query("rows") String rows,@Query("title") String title);


}
