package com.example.myconastat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
@BindView(R.id.continentTextView) TextView mContinentTextView;
@BindView(R.id.listview)  ListView mListView;
private String[] countries = new String[] {"China", "Us", "Vietnam", "United Kingdom", "United Arab Emirates", "Ghana", "Kenya", "France", "Mexico", "Australia"};
private String[] continents = new String[] {"Asia", "North America", "Asia","Europe", "Asia", "Africa", "Africa", "Europe", "North America", "Oceania"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.listview);
        mContinentTextView = (TextView) findViewById(R.id.continentTextView);

        MyCountryArrayAdapter adapter
    }
}