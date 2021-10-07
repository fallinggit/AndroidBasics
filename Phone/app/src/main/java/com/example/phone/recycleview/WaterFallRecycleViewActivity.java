package com.example.phone.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.phone.R;

public class WaterFallRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRvWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall_recycle_view);

        mRvWaterFall = findViewById(R.id.rv_waterfall);
        mRvWaterFall.addItemDecoration(new MyDecoration());
        mRvWaterFall.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvWaterFall.setAdapter(new MyWaterFallAdapter(WaterFallRecycleViewActivity.this, new MyWaterFallAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(WaterFallRecycleViewActivity.this, pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }

    class  MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeightFive);
            outRect.set(gap, gap, gap, gap);
        }
    }
}