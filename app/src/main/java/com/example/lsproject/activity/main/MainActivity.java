package com.example.lsproject.activity.main;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.cyf.nfcproject.bean.BaseBean;
import com.example.lsproject.R;
import com.example.lsproject.activity.ycpx.YcpxActivity;
import com.example.lsproject.activity.yxxx.YxxxActivity;
import com.example.lsproject.activity.zxdy.ZxdyActivity;
import com.example.lsproject.activity.zxzy.ZxzyActivity;
import com.example.lsproject.adapter.HomeAdapter;
import com.example.lsproject.bean.HomeBean;
import com.example.lsproject.tools.AppTools;
import com.example.lsproject.tools.AssetsTools;
import com.example.lsproject.tools.NetTools;
import com.example.lsproject.url.Urls;
import com.example.lsproject.view.SlideShowView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hhkj.highschool.base.BaseActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private List<HomeBean> homeModels;
    private SlideShowView slideShowView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        // net_appList();
        initData();
    }

    private void initView() {
        setTextTitle(getString(R.string.app_name));

        setRightButton(true, R.mipmap.ic_launcher_round, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zj", "setRightButton");

                startActivity(new Intent(MainActivity.this,PersonalActivity.class));
            }
        });

        setLeftButton(true, R.mipmap.ic_launcher_round, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zj", "setLeftButton");
            }
        });

        slideShowView = findViewById(R.id.slideShowView);
        gridView = findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (homeModels.get(position).getId()) {
                    case "1":
                        intent = new Intent(MainActivity.this, YcpxActivity.class);
                        intent.putExtra("title", homeModels.get(position).getName());
                        break;
                    case "2":
                        intent = new Intent(MainActivity.this, ZxzyActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "3":
                        intent = new Intent(MainActivity.this, YxxxActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "4":
                        functionCheck("是否安装学生自主学习平台模块？",
                                "com.education.teach",
                                "app-debug-1.1.10.1024.apk",
                                "com.education.teach.mvp.ui.activity.LoginActivity");
                        break;

                    case "5":
                        intent = new Intent(MainActivity.this, ZxdyActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "功能暂未开放，敬请期待", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
        // 轮播Banner
        slideShowView.setTimeInterval(5);
        int imgs[] = new int[3];
        imgs[0] = R.mipmap.baaner1;
        imgs[1] = R.mipmap.baaner2;
        imgs[2] = R.mipmap.baaner3;
        slideShowView.initUI(MainActivity.this, 2, imgs);
    }

    private void net_appList() {
        Map<String, String> map = new HashMap();
        NetTools.net(new Urls().appList, this, new NetTools.MyCallBack() {
            @Override
            public void getData(BaseBean response) {
                if ("0".equals(response.getCode())) {
                    homeModels = new Gson().fromJson(response.getData(), new TypeToken<List<HomeBean>>() {
                    }.getType());
                    gridView.setAdapter(new HomeAdapter(homeModels, MainActivity.this));
                } else {
                    Toast.makeText(MainActivity.this, "" + response.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initData() {
        homeModels = new ArrayList<>();
        HomeBean homeBean1 = new HomeBean("1", "远程培训", "" + R.mipmap.ic_launcher);
        HomeBean homeBean2 = new HomeBean("2", "在线资源", "" + R.mipmap.ic_launcher);
        HomeBean homeBean3 = new HomeBean("3", "研修学习", "" + R.mipmap.ic_launcher);
        HomeBean homeBean4 = new HomeBean("4", "学生自主学习", "" + R.mipmap.ic_launcher);
        HomeBean homeBean5 = new HomeBean("5", "在线调研", "" + R.mipmap.ic_launcher);
        homeModels.add(homeBean1);
        homeModels.add(homeBean2);
        homeModels.add(homeBean3);
        homeModels.add(homeBean4);
        homeModels.add(homeBean5);
        gridView.setAdapter(new HomeAdapter(homeModels, MainActivity.this));
    }

    private void functionCheck(String msg, String pkgName, final String apkName, String starActivity) {
        if (!AppTools.checkAppInstalled(this, pkgName)) {
            // 判断没安装自主学习app
            final AlertDialog.Builder normalDialog =
                    new AlertDialog.Builder(MainActivity.this);
            normalDialog.setMessage(msg);
            normalDialog.setPositiveButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String outPath = Environment.getExternalStorageDirectory() + "/" + getString(R.string.app_name) + "/";
                            // 把apk复制到sd卡
                            AssetsTools.copyAssetsSingleFile(MainActivity.this, outPath, apkName);
                            // 安装apk
                            Log.i("cyf", "开始执行安装: " + outPath + apkName);
                            File apkFile = new File(outPath + apkName);
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                Log.w("cyf", "版本大于 N ，开始使用 fileProvider 进行安装");
                                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                Uri contentUri = FileProvider.getUriForFile(
                                        MainActivity.this
                                        , "com.example.lsproject.fileprovider"
                                        , apkFile);
                                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                            } else {
                                Log.w("cyf", "正常进行安装");
                                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
                            }
                            startActivity(intent);
                        }
                    });
            normalDialog.setNegativeButton("取消",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            normalDialog.show();
        } else {
            ComponentName component = new ComponentName(pkgName, starActivity);
            Intent intent = new Intent();
            intent.setComponent(component);
            intent.putExtra("userName", "cyf");
            intent.putExtra("password", "test");
            startActivity(intent);
        }
    }

}
