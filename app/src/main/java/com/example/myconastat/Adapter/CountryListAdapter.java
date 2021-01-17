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
import com.example.myconastat.ui.CountryDetailActivity;

import org.parceler.Parcels;



import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {
    private List<All> mAll;
    private Context mContext;



    public CountryListAdapter( Context context, List<All>  all) {
        mContext = context;
        mAll = all;
    }

    @Override
    public CountryListAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        CountryViewHolder viewHolder = new CountryViewHolder(view);
//        mCountry = new ArrayList<>();
        return viewHolder;
    }

    public void onBindViewHolder(CountryListAdapter.CountryViewHolder holder, int position) {
        holder.bindAll(mAll.get(position));
    }

//    @Override
//    public int getItemCount() {
//        return 0;
//    }

    @Override
    public int getItemCount() {
       return mAll.size();
    }



    public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.countryNameTextView) TextView mNameTextView;
        @BindView(R.id.confirmedTextView) TextView mConfirmedTextView;
        @BindView(R.id.recoveredTextView) TextView mRecoveredTextView;
        @BindView(R.id.deathsTextView) TextView mDeathTextView;
        private Context mContext;

        public CountryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindAll (All all) {
            mNameTextView.setText(all.getCountry());
            mConfirmedTextView.setText(all.getConfirmed());
            mRecoveredTextView.setText(all.getRecovered());
            mDeathTextView.setText(all.getDeaths());
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, CountryDetailActivity.class);
            intent.putExtra("continent", itemPosition);
            intent.putExtra("country", Parcels.wrap(mAll));
            mContext.startActivity(intent);

        }
    }

}
