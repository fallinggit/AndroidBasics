package com.example.phone.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.phone.R;
import com.example.phone.utils.ToastUtil;

public class SharedPreferencesActivity extends AppCompatActivity {
    private Button mBtnSave, mBtnShow;
    private EditText mEtName;
    private TextView mTvShow;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvShow = findViewById(R.id.tv_show);

        mSharedPreferences = this.getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        /*
        * 终端查看文件
        * 1.abd shell
        * 2.run-as com.example.phone
        * 3.ls cd shared_prefs
        * 4.ls cat data.xml
        *
        * <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <string name="name">123123123&#10;梵蒂冈地方</string>
</map>
         * */
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name", mEtName.getText().toString());
//                mEditor.commit(); // 同步存储
                mEditor.apply(); // 先修改内存内容 然后异步存储磁盘
                ToastUtil.showMessage(SharedPreferencesActivity.this, "保存成功");
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShow.setText(mSharedPreferences.getString("name", ""));
                ToastUtil.showMessage(SharedPreferencesActivity.this, "显示成功");
            }
        });

    }
}