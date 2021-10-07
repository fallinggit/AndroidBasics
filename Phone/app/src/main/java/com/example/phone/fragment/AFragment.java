package com.example.phone.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.phone.R;

import java.util.Random;

public class AFragment extends Fragment {
    private TextView mTvTitle;
//    private Activity mActivity;
    private Button mBtnChange, mBtnReset, mBtnSendMessage;
    private BFragment bFragment;
    private IOnMessageClick listener;


    private String[] mList = {"德玛", "赵信", "蛮子", "瞎子", "亚索", "烬", "诺克", "剑圣", "提莫", "狗头"};

    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public interface IOnMessageClick {
        void OnClick(String text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_a, container, false);
        Log.d("AFragment", "-------onCreateView------");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTvTitle = view.findViewById(R.id.tv_title);
        mBtnChange = view.findViewById(R.id.btn_a_fragment_change);
        mBtnReset = view.findViewById(R.id.btn_a_fragment_reset);
        mBtnSendMessage = view.findViewById(R.id.btn_a_fragment_send_message);

        mBtnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("传递一下");
                listener.OnClick("第二种方法再试一次");
            }
        });

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();

                    Fragment fragment = getFragmentManager().findFragmentByTag("a");
                    if (fragment != null) {
                        /*
                        * addToBackStack(null) 返回时会崩溃 报错信息
                        * Attempt to read from field 'androidx.fragment.app.FragmentManagerImpl androidx.fragment.app.Fragment.mFragmentManager' on a null object reference
                        * */
//                        getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment, "b").addToBackStack(null).commitAllowingStateLoss();
                        getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment, "b").commitAllowingStateLoss();
                    }
                    else  {
                        getFragmentManager().beginTransaction().add(R.id.fl_container, bFragment, "b").commitAllowingStateLoss();
                    }
                }
                else {
                    bFragment = (BFragment) getFragmentManager().findFragmentByTag("b");
                    Fragment fragment = getFragmentManager().findFragmentByTag("a");
                    if (fragment != null) {
//                        getFragmentManager().beginTransaction().hide(fragment).show(bFragment).addToBackStack(null).commitAllowingStateLoss();
                        getFragmentManager().beginTransaction().hide(fragment).show(bFragment).commitAllowingStateLoss();
                    }
                    else  {
                        getFragmentManager().beginTransaction().show(bFragment).commitAllowingStateLoss();
                    }
                }


            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText(mList[(int)(Math.random() * mList.length)]);
            }
        });

        if (getActivity() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }
        else {

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (IOnMessageClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity未实现IOnMessageClick接口方法");
        }
//        mActivity = (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // 取消异步
//        mActivity = null;
    }
}
