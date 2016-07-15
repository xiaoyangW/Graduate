package com.arvin.graduate.Entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WXY on 2016/7/13.
 */

public class Home_banner implements Parcelable {
    private int id;

    private String pic;

    private String title;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public String getPic(){
        return this.pic;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    /*****************************************/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.pic);
        dest.writeString(this.title);
    }

    public Home_banner() {
    }

    protected Home_banner(Parcel in) {
        this.id = in.readInt();
        this.pic = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<Home_banner> CREATOR = new Parcelable.Creator<Home_banner>() {
        @Override
        public Home_banner createFromParcel(Parcel source) {
            return new Home_banner(source);
        }

        @Override
        public Home_banner[] newArray(int size) {
            return new Home_banner[size];
        }
    };
}
