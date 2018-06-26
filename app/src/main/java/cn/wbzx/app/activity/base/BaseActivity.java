package cn.wbzx.app.activity.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Frank on 2018/6/26.
 *
 * @fuction
 */

public abstract class BaseActivity extends AppCompatActivity {

    public String TAG;
    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();//类名
        mContext = this;
        this.initView();
        this.initData();
        //沉浸式状态栏
        //ImmersionBar.with(this).init();
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();
    /**
     * 初始化数据
     */
    protected abstract void initData();
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
