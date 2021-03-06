package com.example.phone.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.phone.R;

import org.w3c.dom.Text;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {
    private AFragment aFragment;
    private BFragment bFragment;

    private Button mBtnChange, mBtnOrigin;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mBtnChange = findViewById(R.id.btn_fragment_change);
        mBtnOrigin = findViewById(R.id.btn_fragment_origin);
        mTv = findViewById(R.id.tv_fragment);

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();

                    aFragment = (AFragment) getSupportFragmentManager().findFragmentByTag("a");
                    if (aFragment != null) {
                        getSupportFragmentManager().beginTransaction().hide(aFragment).add(R.id.fl_container, bFragment, "b").commitAllowingStateLoss();
                    } else {
                        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, bFragment, "b").commitAllowingStateLoss();
                    }
                }
                else  {
                    aFragment = (AFragment) getSupportFragmentManager().findFragmentByTag("a");
                    if (aFragment != null) {
                        getSupportFragmentManager().beginTransaction().hide(aFragment).show(bFragment).commitAllowingStateLoss();
                    } else {
                        getSupportFragmentManager().beginTransaction().show(bFragment).commitAllowingStateLoss();
                    }
                }
            }
        });

        // ??????????????? ??????
        mBtnOrigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bFragment = (BFragment) getSupportFragmentManager().findFragmentByTag("b");
                if (bFragment != null) {
                    getSupportFragmentManager().beginTransaction().hide(bFragment).show(aFragment).commitAllowingStateLoss();
                }
                else  {
                    getSupportFragmentManager().beginTransaction().show(aFragment).commitAllowingStateLoss();
                }
            }
        });

        // ?????????AFragment ????????????AFragment
        aFragment = AFragment.newInstance("????????????");

        // ???AFragment?????????Activity??????????????????commit?????? getSupportFragmentManager
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, (Fragment)aFragment, "a").commitAllowingStateLoss();
    }

    // ??????????????? ?????????
    public void setData(String text) {
        mTv.setText(text);
    }

    @Override
    public void OnClick(String text) {
        mTv.setText(text);
    }
}