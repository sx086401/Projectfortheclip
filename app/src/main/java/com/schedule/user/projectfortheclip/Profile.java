package com.schedule.user.projectfortheclip;


import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by user on 2017/5/16.
 */

public class Profile {
    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("url")
    @Expose
    public Drawable imageUrl;

    @SerializedName("thedate")
    @Expose
    public String thedate;

    @SerializedName("location")
    @Expose
    public String location;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Drawable imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return thedate;
    }

    public void setDate(String theDate) {
        this.thedate = theDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}