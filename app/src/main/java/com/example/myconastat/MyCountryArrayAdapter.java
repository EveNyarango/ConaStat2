package com.example.myconastat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MyCountryArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mCountry;
    private String[] mContinent;

    public MyCountryArrayAdapter(Context mContext, int resource, String[] mCountry, String[] mContinent){
        super(mContext, resource);
        this.mContext = mContext;
        this.mCountry = mCountry;
        this.mContinent = mContinent;
    }
@Override
    public Object getItem(int position){
        String country = mCountry[position];
        String continent = mContinent[position];
        return String.format("%s \nContinent: %s", country, continent);
}
@Override
    public int getCount() {
        return mCountry.length;
}
}