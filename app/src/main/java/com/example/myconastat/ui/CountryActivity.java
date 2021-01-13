package com.example.myconastat.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myconastat.MyCountryArrayAdapter;
import com.example.myconastat.R;

import butterknife.BindView;

public class CountryActivity extends AppCompatActivity {
    @BindView(R.id.continentTextView)
    TextView mContinentTextView;
    @BindView(R.id.listview)
    ListView mListView;
    private String[] country = new String[] {"China", "Us", "Vietnam", "United Kingdom", "United Arab Emirates", "Ghana", "Kenya", "France", "Mexico", "Australia"};
    private String[] continent = new String[] {"Asia", "North America", "Asia","Europe", "Asia", "Africa", "Africa", "Europe", "North America", "Oceania"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        mListView = (ListView) findViewById(R.id.listview);
        mContinentTextView = (TextView) findViewById(R.id.continentTextView);

        MyCountryArrayAdapter adapter = new MyCountryArrayAdapter(this, android.R.layout.simple_list_item_1, country, continent);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String country = ((TextView)view).getText().toString();
                Toast.makeText(CountryActivity.this, country, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String continent = intent.getStringExtra("continent");
        mContinentTextView.setText("Specific Continent:" + continent);
    }
}