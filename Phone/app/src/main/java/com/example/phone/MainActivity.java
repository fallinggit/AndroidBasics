package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phone.broadcast.BroadcastActivity;
import com.example.phone.datastorage.DataStorageActivity;
import com.example.phone.fragment.ContainerActivity;
import com.example.phone.gridview.GridViewActivity;
import com.example.phone.jump.AActivity;
import com.example.phone.listview.ListViewActivity;
import com.example.phone.recycleview.RecycleViewActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.Manifest.permission.CALL_PHONE;
import static android.content.Intent.ACTION_CALL;

public class MainActivity extends AppCompatActivity {
    EditText mobileText;

    // m是member的缩写
    private Button mBtnTextView, mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton, mBtnCheckBox, mBtnImageView,
            mBtnListView, mBtnGridView, mBtnRecyleView,
            mBtnWebView, mBtnToast, mBtnAlert;
    private Button mBtnProgress;
    private Button mBtnCustomAlert;
    private Button mBtnPopup;
    private Button mBtnLifeActivity, mBtnJump;
    private Button mBtnMainFragment;
    private Button mBtnEvent, mBtnHandler;
    private Button mBtnData;
    private Button mBtnBroadcast;
    private Button mBtnAnimation;

    private ArrayList list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileText = findViewById(R.id.mobile);

        Button button = (Button) this.findViewById(R.id.buttonClick);
        button.setOnClickListener(new ButtonClickListener());
        
        Person person = new Person();
        System.out.println(person.add(3, 9));

        mBtnTextView = findViewById(R.id.btn_textView);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_login);
        mBtnRadioButton = findViewById(R.id.btn_radio);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnRecyleView = findViewById(R.id.btn_recycle_view);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnAlert = findViewById(R.id.btn_alert_dialog);
        mBtnProgress = findViewById(R.id.btn_progress);
        mBtnCustomAlert = findViewById(R.id.btn_custom_alert_dialog);
        mBtnPopup = findViewById(R.id.btn_main_popup);
        mBtnLifeActivity = findViewById(R.id.btn_life_activity);
        mBtnJump = findViewById(R.id.btn_main_jump);
        mBtnMainFragment = findViewById(R.id.btn_main_fragment);
        mBtnEvent = findViewById(R.id.btn_main_event);
        mBtnHandler = findViewById(R.id.btn_main_handler);
        mBtnData = findViewById(R.id.btn_main_data);
        mBtnBroadcast = findViewById(R.id.btn_main_broadcast);
        mBtnAnimation = findViewById(R.id.btn_main_animation);
        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyleView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnAlert.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomAlert.setOnClickListener(onClick);
        mBtnPopup.setOnClickListener(onClick);
        mBtnLifeActivity.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnMainFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnHandler.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnAnimation.setOnClickListener(onClick);
    }

    private final class ButtonClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{ CALL_PHONE}, 1); // 获取权限
            }
            else  {
                call();
            }
        }

        private void call() {
            String number = mobileText.getText().toString();
            System.out.println(number);
            Intent intent = new Intent(ACTION_CALL); // ACTION_CALL直接拨打电话 ACTION_DIAL跳转到拨号界面，用户手动点击拨打
            Uri data = Uri.parse("tel:" + number);
            intent.setData(data);
            startActivity(intent);
        }
    }

    private  class OnClick implements View.OnClickListener {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textView:
                    // 跳转到TextView演示界面
                    intent = new Intent(MainActivity.this, TextViewActivity.class);

                    break;
                case R.id.btn_button:
                    // 跳转到Button演示界面
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;

                case R.id.btn_login:
                    // 跳转到EditText演示界面
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;

                case R.id.btn_radio:
                    // 跳转到RadioButton演示界面
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;

                case R.id.btn_checkbox:
                    // 跳转到CheckBox演示界面
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;

                case R.id.btn_imageview:
                    // 跳转到ImageView演示界面
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;

                case R.id.btn_listview:
                    // 跳转到ListView演示界面
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;

                case R.id.btn_gridview:
                    // 跳转到GridView演示界面
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;

                case R.id.btn_recycle_view:
                    // 跳转到RecycleView演示界面
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    break;

                case R.id.btn_webview:
                    // 跳转到WebView演示界面
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;

                case R.id.btn_toast:
                    // 跳转到Toast演示界面
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;

                case R.id.btn_alert_dialog:
                    // 跳转到AlertDialog演示界面
                    intent = new Intent(MainActivity.this, AlertDialogActivity.class);
                    break;

                case R.id.btn_progress:
                    // 跳转到Progress演示界面
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;

                case R.id.btn_custom_alert_dialog:
                    // 跳转到自定义AlertDialog演示界面
                    intent = new Intent(MainActivity.this, CustomAlertDialogActivity.class);
                    break;

                case R.id.btn_main_popup:
                    // 跳转到自定义PopupWindow演示界面
                    intent = new Intent(MainActivity.this, PopupWindowActivity.class);
                    break;

                case R.id.btn_life_activity:
                    // 跳转到Activity生命周期演示界面
                    intent = new Intent(MainActivity.this, LifeActivity.class);
                    break;

                case R.id.btn_main_jump:
                    // 跳转到Jump数据传递演示界面
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;

                case R.id.btn_main_fragment:
                    // 跳转到Fragment演示界面
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;

                case R.id.btn_main_event:
                    // 跳转到Event演示界面
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;

                case R.id.btn_main_handler:
                    // 跳转到Handler演示界面
                    intent = new Intent(MainActivity.this, HandlerActivity.class);
                    break;

                case R.id.btn_main_data:
                    // 跳转到DataStorage演示界面
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;

                case R.id.btn_main_broadcast:
                    // 跳转到Broadcast演示界面
                    intent = new Intent(MainActivity.this, BroadcastActivity.class);
                    break;

                case R.id.btn_main_animation:
                    // 跳转到Broadcast演示界面
                    intent = new Intent(MainActivity.this, AnimationActivity.class);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
            startActivity(intent);
        }
    }
}