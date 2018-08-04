package cn.xiaojii.cashgift.util;

import com.google.gson.Gson;

import java.util.List;

import cn.xiaojii.cashgift.bean.ProjectBean;

/**
 * @author dmrfcoder
 * @date 2018/8/3
 */

public class ListToJsonUtil {
    public static String ListToJson(List<ProjectBean> projectBeanList) {
        Gson gson=new Gson();
        String strJson=gson.toJson(projectBeanList);
        return strJson;
    }
}
