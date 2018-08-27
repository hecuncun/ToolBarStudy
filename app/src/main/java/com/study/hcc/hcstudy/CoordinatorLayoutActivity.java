package com.study.hcc.hcstudy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.study.hcc.hcstudy.utils.StatusBarUtils;

/**
 * Created by hecuncun on 2018/8/27
 */

public class CoordinatorLayoutActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor);
        initView();
    }

    private void initView() {
        final Toolbar toolbar = findViewById(R.id.appBar_layout_toolbar);
        StatusBarUtils.setTranslucentImageHeader(this,0,toolbar);
        toolbar.setTitleTextColor(Color.TRANSPARENT);
        toolbar.inflateMenu(R.menu.menu_search);

        AppBarLayout appBarLayout = findViewById(R.id.appbar_layout);

        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapse_layout);
        collapsingToolbarLayout.setTitle("");//和toolbar同时设置title,要显示toolbar的而设置的
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("height","appBarHeight:"+appBarLayout.getHeight()+"appBarScrollRange:"+appBarLayout.getTotalScrollRange()+"offset:"+verticalOffset);
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    collapsingToolbarLayout.setTitle("AppbarLayout");
                }else{
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });
    }
}
