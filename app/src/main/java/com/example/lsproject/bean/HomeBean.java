package com.example.lsproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caoyingfu on 2017/11/9.
 */

public class HomeBean implements Serializable {

    private String resourceId;// 资源Key
    private String resourceName;// 资源名称
    private String icon;

    public HomeBean(String resourceId, String resourceName, String icon) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.icon = icon;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "resourceId='" + resourceId + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
