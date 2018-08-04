package cn.xiaojii.cashgift.interactor.impl;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import cn.xiaojii.cashgift.bean.GlobalBean;
import cn.xiaojii.cashgift.bean.ProjectBean;
import cn.xiaojii.cashgift.util.JsonToListUtil;
import cn.xiaojii.cashgift.util.ReadFileToStringUtil;
import cn.xiaojii.cashgift.view.impl.DiscoverFragment;
import cn.xiaojii.cashgift.view.impl.FriendsAndRelativesFragment;
import cn.xiaojii.cashgift.view.impl.MoreFragment;
import cn.xiaojii.cashgift.view.impl.ProjectTableFragment;
import cn.xiaojii.cashgift.view.impl.RunningAccountFragment;

/**
 * @author dmrfcoder
 * @date 2018/8/3
 */

public class MainInterator {
    public MainInterator() {
        projectBeanList = new ArrayList<>();
    }

    private List<ProjectBean> projectBeanList;


    public interface OnInitDataListener {
        void OnInitError();

        void OnInitSuccess(List<ProjectBean> projectBeanList);
    }

    public void initData(OnInitDataListener onInitDataListener) {

        String fileContent = ReadFileToStringUtil.read(GlobalBean.filename);
        List<ProjectBean> projectBeanList = JsonToListUtil.jsonToList(fileContent);

        if (projectBeanList == null) {

            this.projectBeanList = new ArrayList<>();
            ProjectBean projectBean=new ProjectBean();
            ProjectBean projectBean1=new ProjectBean();
            ProjectBean projectBean2=new ProjectBean();
            ProjectBean projectBean3=new ProjectBean();
            ProjectBean projectBean4=new ProjectBean();

            projectBean.setName("张三");
            projectBean.setMoney(800);
            projectBean.setProject("婚礼");
            this.projectBeanList.add(projectBean);






            projectBean1.setName("王五");
            projectBean1.setMoney(-800);
            projectBean1.setProject("婚礼");
            this.projectBeanList.add(projectBean1);



            projectBean2.setName("二麻子");
            projectBean2.setMoney(-100);
            projectBean2.setProject("婚礼");
            this.projectBeanList.add(projectBean2);


            projectBean3.setName("demo");
            projectBean3.setMoney(900);
            projectBean3.setProject("婚礼");
            this.projectBeanList.add(projectBean3);

            projectBean4.setName("李四");
            projectBean4.setMoney(900);
            projectBean4.setProject("婚礼");
            this.projectBeanList.add(projectBean4);

            onInitDataListener.OnInitError();


        } else {
            this.projectBeanList = projectBeanList;

            onInitDataListener.OnInitSuccess(projectBeanList);


        }

    }


    public interface OnGetDataListener {
        /**
         * 获取收据失败
         */
        void OnGetDataError();

        /**
         * 获取数据包成功
         *
         * @param projectBeanList
         */
        void OnGetDataSuccess(List<ProjectBean> projectBeanList);
    }


    public void GetData(OnGetDataListener onGetDataListener) {
        if (projectBeanList == null) {
            onGetDataListener.OnGetDataError();
        } else {
            onGetDataListener.OnGetDataSuccess(projectBeanList);
        }
    }

}
