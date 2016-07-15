package com.arvin.graduate.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXY on 2016/7/13.
 */

public class Exercise implements Parcelable {
    private String response;

    private List<Home_banner> home_banner ;

    public void setResponse(String response){
        this.response = response;
    }
    public String getResponse(){
        return this.response;
    }
    public void setHome_banner(List<Home_banner> home_banner){
        this.home_banner = home_banner;
    }
    public List<Home_banner> getHome_banner(){
        return this.home_banner;
    }
    /**********************************/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.response);
        dest.writeList(this.home_banner);
    }

    public Exercise() {
    }

    protected Exercise(Parcel in) {
        this.response = in.readString();
        this.home_banner = new ArrayList<Home_banner>();
        in.readList(this.home_banner, Home_banner.class.getClassLoader());
    }

    public static final Parcelable.Creator<Exercise> CREATOR = new Parcelable.Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel source) {
            return new Exercise(source);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };
}
