package com.example.phone.datastorage;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.phone.R;
import com.example.phone.utils.KeyBoardUtils;
import com.example.phone.utils.ToastUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private Button mBtnSave, mBtnShow;
    private EditText mEtName;
    private TextView mTvShow;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private final String mFileName = "test.text";

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
                KeyBoardUtils.hideKeyboard(mEtName);

                boolean isSuccess = save(mEtName.getText().toString());
                if (isSuccess) {
                    ToastUtil.showMessage(FileActivity.this, "保存成功");
                }
                else {
                    ToastUtil.showMessage(FileActivity.this, "保存失败");
                }
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyBoardUtils.hideKeyboard(mEtName);

                if (read() != null) {
                    mTvShow.setText(read());
                    ToastUtil.showMessage(FileActivity.this, "显示成功");
                }
                else {
                    ToastUtil.showMessage(FileActivity.this, "显示失败");
                }
            }
        });

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    // 存储数据 使用完后要关闭输出流
    private boolean save(String content) {
        boolean success = false;
        FileOutputStream fileOutputStream = null;
        try {
            // 内部存储
//            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);

            // 外部存储SD CARD 创建文件夹 需要真机测试
            File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "phone");
            if (!dir.exists()) {
                // 创建文件夹 不带s的穿件单个
                dir.mkdirs();
            }

            // 创建文件
            File file = new File(dir, mFileName);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    ToastUtil.showMessage(FileActivity.this, "路径不存在");
                    return false;
                }
            }
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(content.getBytes());
//            fileOutputStream.close();

            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return success;
    }

    // 读取数据 使用完后要关闭输入流
    private String read() {
        FileInputStream fileInputStream = null;
        try {
            // 内部读取
//            fileInputStream = openFileInput(mFileName);

            // 外部读取
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "phone", mFileName);
            fileInputStream = new FileInputStream(file);

            byte[] buff = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder("");
            int length = 0;
            while ((length = fileInputStream.read(buff)) > 0) {
                stringBuilder.append(new String(buff, 0, length));
            }

            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}