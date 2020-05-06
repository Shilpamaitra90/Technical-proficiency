package com.example.technicalproficiency.model;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataDetail extends BaseObservable {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
   private String description;

    @SerializedName("imageHref")
    @Expose
     private String imageHref;

    public List<DataDetail>rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getimageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        imageHref = imageHref;
    }

    public List<DataDetail> getRows() {
        return rows;
    }

    public void setRows(List<DataDetail> rows) {
        this.rows = rows;
    }




    @Override
    public String toString() {

        return title+""+description+""+imageHref;
    }

}
