package com.example.myconastat.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myconastat.MyCountryArrayAdapter;
import com.example.myconastat.R;
import com.example.myconastat.models.CovidCases;
import com.example.myconastat.network.CovidApi;
import com.example.myconastat.network.CovidClient;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {
    private static final String TAG = CountryActivity.class.getSimpleName();
    @BindView(R.id.continentTextView)
    TextView mContinentTextView;
    @BindView(R.id.listview)
    ListView mListView;
    public String continentName;
//    private String[] country = new String[] {"China", "Us", "Vietnam", "United Kingdom", "United Arab Emirates", "Ghana", "Kenya", "France", "Mexico", "Australia"};
//    private String[] continent = new String[] {"Asia", "North America", "Asia","Europe", "Asia", "Africa", "Africa", "Europe", "North America", "Oceania"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        mListView = (ListView) findViewById(R.id.listview);
        mContinentTextView = (TextView) findViewById(R.id.continentTextView);

        MyCountryArrayAdapter adapter = new MyCountryArrayAdapter(this, android.R.layout.simple_list_item_1, country, continent);
        mListView.setAdapter(adapter);

        CovidApi client = CovidClient.getClient();
        Call<CovidCases> call = client.getCases(continentName, "country");

        call.enqueue(new Callback<CovidCases>() {
            @Override
            public void onResponse(Call<CovidCases> call, Response<CovidCases> response) {
//                restaurants = response.body().getBusinesses();
//                mAdapter = new RestaurantListAdapter(RestaurantsActivity.this, continentName);
//                mRecyclerView.setAdapter(mAdapter);
//                RecyclerView.LayoutManager layoutManager =
//                        new LinearLayoutManager(RestaurantsActivity.this);
//                mRecyclerView.setLayoutManager(layoutManager);
//                mRecyclerView.setHasFixedSize(true);
//
//                showRestaurants();
            }

            @Override
            public void onFailure(Call<CovidCases> call, Throwable t) {

                Log.d(TAG, "on the on failure method", t);
            }
        });

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