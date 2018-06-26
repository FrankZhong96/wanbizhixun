package cn.wbzx.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wbzx.app.R;
import cn.wbzx.app.activity.base.BaseActivity;
import cn.wbzx.app.fragment.home.AttentionFragment;
import cn.wbzx.app.fragment.home.IndexFragment;
import cn.wbzx.app.fragment.home.MineFragment;
import cn.wbzx.app.fragment.home.VideoFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.index_layout_view)
    LinearLayout indexLayoutView;
    @BindView(R.id.video_layout_view)
    LinearLayout videoLayoutView;
    @BindView(R.id.attention_layout_view)
    LinearLayout attentionLayoutView;
    @BindView(R.id.mine_layout_view)
    LinearLayout mineLayoutView;
    @BindView(R.id.content_layout)
    RelativeLayout contentLayout;
    @BindView(R.id.index_image_view)
    ImageView indexImageView;
    @BindView(R.id.video_image_view)
    ImageView videoImageView;
    @BindView(R.id.attention_image_view)
    ImageView attentionImageView;
    @BindView(R.id.mine_image_view)
    ImageView mineImageView;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    private IndexFragment mIndexFragment;
    private FragmentManager mSupportFragmentManager;
    private VideoFragment mVideoFragment;
    private AttentionFragment mAttentionFragment;
    private MineFragment mMineFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //设置默认的Fragment
        mIndexFragment = new IndexFragment();
        mSupportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mSupportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mIndexFragment).commit();
    }

    /**
     * 隐藏fragment
     *
     * @param fragment
     * @param ft
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }

    //Fragment切换
    @OnClick({R.id.index_layout_view, R.id.video_layout_view, R.id.attention_layout_view, R.id.mine_layout_view})
    public void onViewClicked(View view) {
        FragmentTransaction fragmentTransaction = mSupportFragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.index_layout_view://首页
                indexImageView.setImageResource(R.mipmap.index_seletced);
                videoImageView.setImageResource(R.mipmap.video);
                attentionImageView.setImageResource(R.mipmap.attention);
                mineImageView.setImageResource(R.mipmap.mine);
                //隐藏其他fragment
                hideFragment(mVideoFragment, fragmentTransaction);
                hideFragment(mAttentionFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mIndexFragment == null) {
                    mIndexFragment = new IndexFragment();
                    fragmentTransaction.add(R.id.content_layout, mIndexFragment);
                } else {
                    //显示fragment
                    fragmentTransaction.show(mIndexFragment);
                }
                break;
            case R.id.video_layout_view://视频
                indexImageView.setImageResource(R.mipmap.index);
                videoImageView.setImageResource(R.mipmap.video_selected);
                attentionImageView.setImageResource(R.mipmap.attention);
                mineImageView.setImageResource(R.mipmap.mine);
                //隐藏其他fragment
                hideFragment(mIndexFragment, fragmentTransaction);
                hideFragment(mAttentionFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mVideoFragment == null) {
                    mVideoFragment = new VideoFragment();
                    fragmentTransaction.add(R.id.content_layout, mVideoFragment);
                } else {
                    //显示fragment
                    fragmentTransaction.show(mVideoFragment);
                }
                break;
            case R.id.attention_layout_view://关注
                indexImageView.setImageResource(R.mipmap.index);
                videoImageView.setImageResource(R.mipmap.video);
                attentionImageView.setImageResource(R.mipmap.attention_selected);
                mineImageView.setImageResource(R.mipmap.mine);
                //隐藏其他fragment
                hideFragment(mVideoFragment, fragmentTransaction);
                hideFragment(mIndexFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mAttentionFragment == null) {
                    mAttentionFragment = new AttentionFragment();
                    fragmentTransaction.add(R.id.content_layout, mAttentionFragment);
                } else {
                    //显示fragment
                    fragmentTransaction.show(mAttentionFragment);
                }
                break;
            case R.id.mine_layout_view://个人
                indexImageView.setImageResource(R.mipmap.index);
                videoImageView.setImageResource(R.mipmap.video);
                attentionImageView.setImageResource(R.mipmap.attention);
                mineImageView.setImageResource(R.mipmap.mine_selected);
                //隐藏其他fragment
                hideFragment(mVideoFragment, fragmentTransaction);
                hideFragment(mAttentionFragment, fragmentTransaction);
                hideFragment(mIndexFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    //显示fragment
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }
        //提交事务
        fragmentTransaction.commit();
    }
}
