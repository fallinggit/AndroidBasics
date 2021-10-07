package com.example.phone.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.phone.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSharedPrefer, mBtnFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        mBtnSharedPrefer = findViewById(R.id.btn_data_preferences);
        mBtnFile = findViewById(R.id.btn_data_file);

        mBtnSharedPrefer.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_data_preferences:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;

            case R.id.btn_data_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
        startActivity(intent);

    }
}