package cn.xiaojii.cashgift.presenter.impl;

import android.content.BroadcastReceiver;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import cn.xiaojii.cashgift.bean.ContantsValue;
import cn.xiaojii.cashgift.bean.ProjectBean;
import cn.xiaojii.cashgift.bean.ProjectListMessageEvent;
import cn.xiaojii.cashgift.interactor.IBaseInteractor;
import cn.xiaojii.cashgift.interactor.IRunningAccountInteractor;
import cn.xiaojii.cashgift.interactor.impl.RunningAccountInteractor;
import cn.xiaojii.cashgift.presenter.IBasePresenter;
import cn.xiaojii.cashgift.view.IRunningAccountView;

/**
 * @author dmrfcoder
 * @date 2018/8/3
 */

public class RunningAccountPresenter implements RunningAccountInteractor.OnAddProjrctListener,
        IBasePresenter, IBaseInteractor.AddProjectListener, IRunningAccountInteractor.UpdateRAViewListener {

    private IRunningAccountView runningAccountView;
    private BroadcastReceiver dataReceive;


    public RunningAccountPresenter(IRunningAccountView runningAccountView, RunningAccountInteractor runningAccountInteractor) {
        this.runningAccountView = runningAccountView;
        this.runningAccountInteractor = runningAccountInteractor;
        EventBus.getDefault().register(this);
    }


    private RunningAccountInteractor runningAccountInteractor;


    @Override
    public void addProjectFromDialog(ProjectBean projectBean) {

        runningAccountInteractor.addProject(projectBean, this);
    }


    @Override
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void initDataFromMainInteractor(ProjectListMessageEvent projectListMessageEvent) {
        if (projectListMessageEvent.getTag().equals(ContantsValue.TAG_MAINPRESENTER)) {
            List dataList = projectListMessageEvent.getProjectBeans();
            runningAccountInteractor.initData(dataList, this);
        }
    }

    @Override
    public void updateView() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onAddError() {

    }

    @Override
    public void onAddSuccess(List<ProjectBean> projectBeanList) {

    }


    @Override
    public void onAddProjectError() {

    }

    @Override
    public void onAddProjectSuccess(List beanList) {

    }


    @Override
    public void onUpdateViewError() {

    }

    @Override
    public void onUpdateViewSuccess(List dataList) {
        runningAccountView.updateListView(dataList);
    }
}
