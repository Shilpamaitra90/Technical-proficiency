package com.example.technicalproficiency;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.technicalproficiency.Adapter.DatadisplayAdaptor;
import com.example.technicalproficiency.callback.ApiInterface;
import com.example.technicalproficiency.model.DataDetail;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private List<DataDetail> itemlist = new ArrayList<DataDetail>();


    String headertitle;


    @BindView(R.id.headertitle) TextView title;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LoadResults();
        setSupportActionBar(toolbar);



        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }




    private void LoadResults(){
        final ProgressDialog progressDoalog = new ProgressDialog(this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Please wait..");
        progressDoalog.setTitle("Loading Products");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        Call<DataDetail> call = api.getResponse("rows","title");
        call.enqueue(new Callback<DataDetail>() {
            @Override
            public void onResponse(Call<DataDetail> call, Response<DataDetail> response) {

                progressDoalog.dismiss();

                itemlist = response.body().getRows();
                Log.e("datalist", String.valueOf(itemlist));

               headertitle=String.valueOf(response.body().getTitle());
                Log.e("title1",headertitle);
               title.setText(headertitle);

             recyclerView.setAdapter(new DatadisplayAdaptor(MainActivity.this, android.R.layout.simple_dropdown_item_1line, itemlist));

               Log.d("TAG", String.valueOf(response.body().getRows().get(0)));

            }

            @Override
            public void onFailure(Call<DataDetail> call, Throwable t) {
                progressDoalog.dismiss();

                Log.d("TAG", t.toString());

            }
        });


    }


}
