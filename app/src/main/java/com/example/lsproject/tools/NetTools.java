package com.example.lsproject.tools;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.cyf.nfcproject.bean.BaseBean;
import com.cyf.nfcproject.tools.SPTools;
import com.example.lsproject.activity.main.LoginActivity;
import com.example.lsproject.app.MyApp;
import com.example.lsproject.bean.FileBean;
import com.example.lsproject.constant.Constant;
import com.google.gson.Gson;
import com.hhkj.highschool.base.BaseActivity;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.request.RequestCall;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/25 0025.
 */

public class NetTools {

    public static void net(String url, final Activity context, final MyCallBack myCallBack) {
        net(new HashMap<String, String>(), url, context, myCallBack, "正在加载...");
    }

    public static void net(String url, final Activity context, final MyCallBack myCallBack, final boolean isShow, final boolean isDismiss) {
        net(new HashMap<String, String>(), url, context, myCallBack, "正在加载...", isShow, isDismiss);
    }

    public static void net(String url, final Activity context, final MyCallBack myCallBack, final String msg, final boolean isShow, final boolean isDismiss) {
        net(new HashMap<String, String>(), url, context, myCallBack, msg, isShow, isDismiss);
    }

    public static void net(Map<String, String> map, String url, final Activity context, final MyCallBack myCallBack) {
        net(map, url, context, myCallBack, "正在加载...");
    }

    public static void net(Map<String, String> map, String url, final Activity context, final MyCallBack myCallBack, final String msg) {
        net(map, url, context, myCallBack, msg, true, true);
    }

    public static void net(Map<String, String> map, String url, final Activity context, final MyCallBack myCallBack, final boolean isShow, final boolean isDismiss) {
        String s = new Gson().toJson(map);
        net(s, url, context, myCallBack, "正在加载...", isShow, isDismiss);
    }

    public static void net(Map<String, String> map, String url, final Activity context, final MyCallBack myCallBack, final String msg, final boolean isShow, final boolean isDismiss) {
        String s = new Gson().toJson(map);
        net(s, url, context, myCallBack, msg, isShow, isDismiss);
    }

    public static void net(String json, String url, final Activity context, final MyCallBack myCallBack) {
        net(json, url, context, myCallBack, "正在加载...");
    }

    public static void net(String json, String url, final Activity context, final MyCallBack myCallBack, final String msg) {
        net(json, url, context, myCallBack, msg, true, true);
    }

    public static void net(String json, final String url, final Activity context, final MyCallBack myCallBack, final String msg, final boolean isShow, final boolean isDismiss) {
        // 网络请求
        RequestCall call = OkHttpUtils.postString().url(url)
                .addHeader(Constant.TOKEN, (String) SPTools.INSTANCE.get(context, Constant.TOKEN, ""))
                // .addHeader("sessionkey", "cyf")
                .mediaType(MediaType.parse("application/json"))
                .content(json)
                .tag(context)
                .build();
        call.execute(new Callback<BaseBean>() {
            @Override
            public void onBefore(Request request, int id) {
                if (isShow) {
                    ((BaseActivity) context).showProgressDialog(msg);
                }
            }

            @Override
            public BaseBean parseNetworkResponse(Response response, int id) throws Exception {
                String json = response.body().string();
                Log.i("cyf7", "token: " + (String) SPTools.INSTANCE.get(context, Constant.TOKEN, ""));
                Log.i("cyf7", "url: " + url);
                Log.e("cyf7", "response : " + json);
                JSONObject jsonObject = new JSONObject(json);
                BaseBean bean = new BaseBean();
                bean.setCode(jsonObject.optString("code"));
                bean.setMsg(jsonObject.optString("message"));
                bean.setData(jsonObject.optString("data"));
                return bean;
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                // 无数据布局隐藏(后期可做网络错误显示)
                ((BaseActivity) context).setListToastView(0, "", 0, false);
                if (e.getClass().getSimpleName().equals("ConnectException")) {
                    // 无法连接网络
                    Toast.makeText(context, "无法连接服务器", Toast.LENGTH_SHORT).show();
                } else if (e.getClass().getSimpleName().equals("SocketTimeoutException")) {
                    // 网络连接超时
                    Toast.makeText(context, "当前网络不给力，请检查网络", Toast.LENGTH_SHORT).show();
                } else {
                    // 其它异常
                    Log.e("Exception gson：", e.toString());
                }
                ((BaseActivity) context).dismissProgressDialog();
            }

            @Override
            public void onResponse(BaseBean baseBean, int id) {
                // 无数据布局隐藏
                // 处理结果：0=成功，2=异地登陆，=失败
                ((BaseActivity) context).setListToastView(0, "", 0, false);
                if ("0".equals(baseBean.getCode())) {
                    myCallBack.getData(baseBean);
                    if (isDismiss) {
                        ((BaseActivity) context).dismissProgressDialog();
                    }
                } else if ("2".equals(baseBean.getCode())) {
                    // 登录信息失效
                    try {
                        OkHttpUtils.getInstance().cancelTag(context);
                        Toast.makeText(context, baseBean.getMsg(), Toast.LENGTH_SHORT).show();
                        SPTools.INSTANCE.put(context, Constant.TOKEN, "");
                        for (int i = 0; i < MyApp.Companion.getActivies().size(); i++) {
                            MyApp.Companion.getActivies().get(i).finish();
                        }
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.putExtra("isShow", true);
                        context.startActivity(intent);
                        Log.e("cyf_err1", "url: " + url);
                    } catch (Exception e) {
                        Log.e("cyf_err0", "cancelTag: " + url);
                    }
                } else {
                    Toast.makeText(context, baseBean.getMsg(), Toast.LENGTH_SHORT).show();
                    ((BaseActivity) context).dismissProgressDialog();
                    Log.e("cyf_err2", "url: " + url);
                }
            }

            @Override
            public void onAfter(int id) {
//                try {
//                    if (context.findViewById(R.id.listView) != null &&
//                            context.findViewById(R.id.listView) instanceof PullToRefreshListView) {
//                        ((PullToRefreshListView) context.findViewById(R.id.listView)).onRefreshComplete();
//                    }
//                } catch (Exception e) {
//
//                }
            }

        });
    }

    /**
     * 上传文件
     *
     * @param map
     * @param context
     * @param myCallBack
     */
    public static void netFile(Map<String, File> map, final Activity context, final MyCallBack myCallBack) {
        PostFormBuilder builder = OkHttpUtils.post().
                url((String) SPTools.INSTANCE.get(context, Constant.UPLOADURL, ""));
        boolean isImgs = true;
        for (int i = 0; i < map.size(); i++) {
            if (!FileTools.isImgFile(map.get("file" + i).getName())) {
                isImgs = false;
            }
            builder.addFile("file" + i, map.get("file" + i).getName(), map.get("file" + i));
        }
        builder.addParams("transaction", "1");
        if (isImgs) {
            builder.addParams("thumbnail", "1");
        } else {
            builder.addParams("thumbnail", "0");
        }

        RequestCall call = builder.build();
        call.execute(new Callback<BaseBean>() {
            @Override
            public void onBefore(Request request, int id) {
                if (context != null) {
                    ((BaseActivity) context).showProgressDialog("正在上传...");
                }
            }

            @Override
            public BaseBean parseNetworkResponse(Response response, int id) throws Exception {
                String json = response.body().string();
                Log.e("cyf7", "response : " + json);
                JSONObject jsonObject = new JSONObject(json);
                BaseBean bean = new BaseBean();
                // 修改文件返回字端
                bean.setMsg(jsonObject.optString("message"));
                bean.setCode(jsonObject.optString("code"));
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                List<FileBean> fileBeanList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    FileBean fileBean = new FileBean();
                    fileBean.setFileName(jo.optString("originalName"));
                    fileBean.setFileUrl(jo.optString("filePath"));
                    fileBeanList.add(fileBean);
                }
                bean.setData(new Gson().toJson(fileBeanList));
                return bean;
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                if (e.getClass().getSimpleName().equals("ConnectException")) {
                    // 无法连接网络
                    Toast.makeText(context, "无法连接服务器", Toast.LENGTH_SHORT).show();
                } else if (e.getClass().getSimpleName().equals("SocketTimeoutException")) {
                    // 网络连接超时
                    Toast.makeText(context, "服务器连接超时", Toast.LENGTH_SHORT).show();
                } else {
                    // 其它异常
                    Log.e("Exception gson：", e.toString());
                }
                ((BaseActivity) context).dismissProgressDialog();
            }

            @Override
            public void onResponse(BaseBean baseBean, int id) {
                if ("0".equals(baseBean.getCode())) {
                    myCallBack.getData(baseBean);
                } else {
                    ((BaseActivity) context).dismissProgressDialog();
                    Toast.makeText(context, baseBean.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public interface MyCallBack {
        void getData(BaseBean response);
    }

}
