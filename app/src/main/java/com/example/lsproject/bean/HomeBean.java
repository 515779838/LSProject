package com.example.lsproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caoyingfu on 2017/11/9.
 */

public class HomeBean implements Serializable {

    private String id;// 资源Key
    private String name;// 资源名称
    private String icon;

    public HomeBean() {
        super();
    }

    public HomeBean(String id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
