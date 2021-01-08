package com.example.myconastat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
@BindView(R.id.findCountryButton)
    Button mfindCountryButton;
@BindView(R.id.continentEditText)
    EditText mContinentEditText;
@BindView(R.id.appNameTextView)
TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mfindCountryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
if(v == mfindCountryButton) {
    String continent = mContinentEditText.getText().toString();
    Intent intent = new Intent(MainActivity.this, CountryActivity.class);
    intent.putExtra("continent", continent);
    startActivity(intent);
}
    }
}