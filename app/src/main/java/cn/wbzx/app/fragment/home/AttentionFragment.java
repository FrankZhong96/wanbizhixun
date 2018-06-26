package cn.wbzx.app.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.wbzx.app.R;
import cn.wbzx.app.fragment.base.BaseFragment;

/**
 * Created by Frank on 2018/6/26.
 *
 * @fuction
 */

public class AttentionFragment extends BaseFragment {
    private View mContentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_attention_layout, container, false);
        return mContentView;
    }
}
