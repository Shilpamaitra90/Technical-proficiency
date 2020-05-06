package com.example.technicalproficiency.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.technicalproficiency.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import com.example.technicalproficiency.model.DataDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DatadisplayAdaptor  extends RecyclerView.Adapter<DatadisplayAdaptor.ViewHolder> {
    List<DataDetail> itemlist;
    private ArrayList<DataDetail> selectedItems =new ArrayList<>();
    DataDetail datalist = null;
    Context context;
    private LayoutInflater layoutInflater;



    public DatadisplayAdaptor(Context context,int layoutInflater, List<DataDetail> itemlist) {
        this.context=context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemlist=itemlist;

    }


    @Override
    public DatadisplayAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_data_display,parent,false);
        DatadisplayAdaptor.ViewHolder viewHolder = new DatadisplayAdaptor.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final DatadisplayAdaptor.ViewHolder holder, final int position) {

        datalist = itemlist.get(position);
        holder.title.setText(datalist.getTitle()+":");
        Log.e("Response from title", " " + datalist.getTitle());
        if (datalist.getDescription()==null){
            holder.desc.setText(datalist.getDescription());
        }
        else {
           holder.desc.setText(datalist.getDescription().replaceAll("\\s+"," ").replaceAll(",$", ""));

        }

        Log.e("Response from desc", " " + datalist.getDescription());
        Picasso.get().load(datalist.getimageHref()).into(holder.imageView);
        Log.e("Response from image", " " + datalist.getimageHref());
    }



    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardview) CardView cv;
        @BindView(R.id.title) TextView title;
        @BindView(R.id.description) TextView desc;
        @BindView(R.id.imageView) ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }



    public ArrayList<DataDetail> getSelectedItems() {
        return selectedItems;
    }
}


