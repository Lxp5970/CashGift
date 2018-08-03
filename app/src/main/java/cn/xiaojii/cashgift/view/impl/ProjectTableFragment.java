package cn.xiaojii.cashgift.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xiaojii.cashgift.R;
import cn.xiaojii.cashgift.view.IProjectTableView;

/**
 * @author dmrfcoder
 * @date 2018/8/3
 */

public class ProjectTableFragment extends BaseFragment implements IProjectTableView {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projecttable, null);
        return view;
    }
}
