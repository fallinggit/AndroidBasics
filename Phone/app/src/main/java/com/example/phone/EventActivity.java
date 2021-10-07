package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.phone.utils.ToastUtil;
import com.example.phone.widget.MyButton;

/* View的事件分发
* 1.dispatchTouchEvent->setOnTouchListener->onTouchEvent
* 2.onClick/onLongClick来自onTouchEvent的处理
* onTouchEvent手指按下ACTION_DOWN 延迟100ms检查ACTION_UP，延迟400ms检查手指是否离开控件，长按事件至少要500ms
*
* */

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnEvent;
    private MyButton mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent = findViewById(R.id.btn_event);
        mBtnMy = findViewById(R.id.btn_my);

        // 先执行监听器里的方法 在执行回调
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "OnTouchListener");
                        break;
                }

                return false;
            }
        });

        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener", "onClick: ");
            }
        });

        mBtnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("Listener", "onLongClick: ");
                return false; // true不会继续传递事件 false会继续onClick
            }
        });

        // 1.内部类实现
        mBtnEvent.setOnClickListener(new OnClick());

        // 2.匿名内部类
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("匿名内部类", "click");
                ToastUtil.showMessage(EventActivity.this, "匿名内部类实现");;
            }
        });

        // 3.通过事件源所在的内部类实现 当前Activity实现implements View.OnClickListener
        mBtnEvent.setOnClickListener(EventActivity.this);

        // 4.通过事件源所在的外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
    }

    /**
     * 3.通过事件源所在的内部类实现 当前Activity实现implements View.OnClickListener
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Log.d("事件源所在的内部类", "click");
        ToastUtil.showMessage(EventActivity.this, "事件源所在的内部类实现");;
    }

    // 内部类
    class OnClick implements View.OnClickListener {

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Log.d("内部类", "click");

            switch (v.getId()) {
                case R.id.btn_event:
                    ToastUtil.showMessage(EventActivity.this, "内部类实现");;
                    break;
            }
        }
    }

    // 5.通过layout中onClick实现
    public void show(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                ToastUtil.showMessage(EventActivity.this, "layout中onClick实现");;
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "onTouchEvent");
                break;
        }
        return false;
    }
}