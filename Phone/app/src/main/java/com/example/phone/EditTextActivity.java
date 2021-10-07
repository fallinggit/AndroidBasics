package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class EditTextActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText userNameET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        userNameET = findViewById(R.id.et_1);
        userNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordET = findViewById(R.id.et_2);

        loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNameET.getText().length() == 0) {
                    makeText(EditTextActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (passwordET.getText().length() == 0) {
                    makeText(EditTextActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                makeText(EditTextActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });


    }
}