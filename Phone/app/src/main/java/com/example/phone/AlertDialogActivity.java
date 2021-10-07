package com.example.phone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phone.utils.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {
    private Button mBtnDialog1, mBtnDialog2, mBtnDialog3, mBtnDialog4, mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mBtnDialog5 = findViewById(R.id.btn_dialog5);

        Onclick onClick = new Onclick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("请回答")
                            .setMessage("你觉得你学废了吗")
                            .setIcon(R.drawable.username)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(AlertDialogActivity.this, "Very Good");
                                }
                            })
                            .setNeutralButton("还行", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(AlertDialogActivity.this, "Good");
                                }
                            })
                            .setNegativeButton("不好", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(AlertDialogActivity.this, "Bad");
                                }
                            })
                            .show();

//                    builder.setMessage("你觉得你学废了吗");

                    break;
                case R.id.btn_dialog2:
                    String[] array2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("请选择性别")
                            .setItems(array2, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(AlertDialogActivity.this, array2[which]);
                                }
                            }).show();

                    break;

                case R.id.btn_dialog3:
                    String[] array3 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("请选择性别")
                            .setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMessage(AlertDialogActivity.this, array3[which]);
                                    dialog.dismiss();
                                }
                            })
                            .setCancelable(false)
                            .show();

                    break;

                case R.id.btn_dialog4:
                    String[] array4 = new String[]{"唱歌", "跳舞", "写代码"};
                    boolean[] isSelect = new boolean[] {false, false, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("请选择兴趣")
                            .setMultiChoiceItems(array4, isSelect, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    ToastUtil.showMessage(AlertDialogActivity.this, array4[which]+"："+isChecked);
                                }
                            })
                            .setCancelable(false)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();

                    break;

                case R.id.btn_dialog5: // 自定义
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_dialog, null);
                    EditText userName = view.findViewById(R.id.dialog_et_user_name);
                    EditText password = view.findViewById(R.id.dialog_et_password);
                    Button loginButton = view.findViewById(R.id.dialog_login);
                    builder5.setTitle("请登录").setView(view);
                    // 先要获取dialog 在按钮事件中登录时隐藏dialog
                    AlertDialog dialog = builder5.show();
                    loginButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (userName.length() == 0) {
                                ToastUtil.showMessage(AlertDialogActivity.this, "请输入用户名");

                                return;
                            }
                            if (password.getText().length() == 0) {
                                ToastUtil.showMessage(AlertDialogActivity.this, "请输入密码");

                                return;
                            }
                            ToastUtil.showMessage(AlertDialogActivity.this, "登录成功");
                            dialog.dismiss();
                        }
                    });
                    break;
                default:

                    break;
            }
        }
    }
}