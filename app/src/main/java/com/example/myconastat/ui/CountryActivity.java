package com.example.myconastat.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myconastat.Adapter.CountryListAdapter;
import com.example.myconastat.MyCountryArrayAdapter;
import com.example.myconastat.R;
import com.example.myconastat.models.All;
import com.example.myconastat.models.CovidCases;
import com.example.myconastat.network.CovidApi;
import com.example.myconastat.network.CovidClient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.prefs.PreferenceChangeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {
    private static final String TAG = CountryActivity.class.getSimpleName();
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    public String continent1;

    private CountryListAdapter mAdapter;

    private List<All> all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String continent = intent.getStringExtra("continent");


        CovidApi client = CovidClient.getClient();
        Call<CovidCases> call  = client.getCases(continent, "country");

        call.enqueue(new Callback<CovidCases>() {
            @Override
            public void onResponse(Call<CovidCases> call, Response<CovidCases> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    all = response.body().getAll();
                    Log.d(TAG, "onResponse:"+all);
                    mAdapter = new CountryListAdapter(CountryActivity.this, all);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(CountryActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showCountry();
                } else {
                    showUnsucessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<CovidCases> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();

//                Log.d(TAG, "on the on failure method", t);
            }
        });

    }

       private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
       }
       private void showUnsucessfulMessage() {
        mErrorTextView.setText("Something went wrong. Kindly input relevant field");
        mErrorTextView.setVisibility(View.VISIBLE);
       }

       private void showCountry() {
           mRecyclerView.setVisibility(View.VISIBLE);
       }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
       }
