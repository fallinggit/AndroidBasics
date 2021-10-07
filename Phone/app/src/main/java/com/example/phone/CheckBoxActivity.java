package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox mCb5, mCb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mCb5 = findViewById(R.id.cb_5);
        mCb6 = findViewById(R.id.cb_6);

        setChecked();
    }

    private void setChecked() {
        OnCheckedChange checkChange = new OnCheckedChange();
        mCb5.setOnCheckedChangeListener(checkChange);
        mCb6.setOnCheckedChangeListener(checkChange);
    }

    private class OnCheckedChange implements CompoundButton.OnCheckedChangeListener {

        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param buttonView The compound button view whose state has changed.
         * @param isChecked  The new checked state of buttonView.
         */
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast.makeText(CheckBoxActivity.this, isChecked?buttonView.getText():"未选中"+buttonView.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}