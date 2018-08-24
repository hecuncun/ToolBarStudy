package com.study.hcc.hcstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolBar);
        final EditText editText = mToolbar.findViewById(R.id.et_text);
        final TextView textView =findViewById(R.id.tv_edit);
        mToolbar.setLogo(R.mipmap.ic_launcher_round);
        //设置左边导航键finish
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        //添加异常菜单
        mToolbar.inflateMenu(R.menu.setting_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_1:
                        Toast.makeText(MainActivity.this, "点击1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_2:
                        Toast.makeText(MainActivity.this, "点击2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_3:
                        Toast.makeText(MainActivity.this, "点击3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(TextUtils.isEmpty(editText.getText().toString().trim())?"未编辑":editText.getText().toString().trim());
            }
        });


    }




}
