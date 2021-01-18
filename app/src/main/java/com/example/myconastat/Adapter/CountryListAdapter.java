package com.example.myconastat.Adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.myconastat.R;
import com.example.myconastat.models.All;
import com.example.myconastat.models.CovidCases;
import com.example.myconastat.ui.CountryDetailActivity;

import org.parceler.Parcels;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {
//    private List<All> mAll;
    private Context mContext;
    private List <CovidCases> mCorona;


    public CountryListAdapter( Context mContext, List<CovidCases>  mCorona) {
        this.mContext = mContext;
        this.mCorona = mCorona;
    }

    @Override
    public CountryListAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        CountryViewHolder viewHolder = new CountryViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(CountryListAdapter.CountryViewHolder holder, int position) {
        holder.bindAll(mCorona.get(position));
    }


    @Override
    public int getItemCount() {
       return mCorona.size();
    }



    public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.countryNameTextView) TextView mCountryNameTextView;
        @BindView(R.id.confirmedTextView) TextView mConfirmedTextView;
        @BindView(R.id.recoveredTextView) TextView mRecoveredTextView;
        @BindView(R.id.deathsTextView) TextView mDeathTextView;
        private Context mContext;

        public CountryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindAll (CovidCases mCorona) {
//            mCountryNameTextView.setText(String.valueOf(mCorona.getAll().getCountry()));
            mCountryNameTextView.setText(mCorona.getAll().getCountry());
            mConfirmedTextView.setText(String.valueOf(mCorona.getAll().getConfirmed()));
            mRecoveredTextView.setText(String.valueOf(mCorona.getAll().getRecovered()));
            mDeathTextView.setText(String.valueOf(mCorona.getAll().getDeaths()));
        }
        @Override
        public void onClick(View v) {
//            int itemPosition = getLayoutPosition();
//            Intent intent = new Intent(mContext, CountryDetailActivity.class);
//            intent.putExtra("continent", itemPosition);
//            intent.putExtra("country", Parcels.wrap(mCorona));
//            mContext.startActivity(intent);

        }
    }

}
