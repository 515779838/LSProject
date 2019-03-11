package com.example.lsproject.constant;

/**
 * Created by Administrator on 2016/6/16.
 */
public class Constant {

    /**
     * 教育局用户
     */
    public static final String TYPE_BUREAU = "bureau";
    /**
     * 学区用户
     */
    public static final String TYPE_DISTRICT = "district";

    public static final String ZHANGHAO = "zhanghao";//账号
    public static final String MIMA = "mima";//密码
    public static final String TGT = "tgt";
    public static final String TOKEN = "token";
    public static final String USERTYPE = "userType";
    public static final String DISTRICTID = "districtId";
    public static final String DISTRICTNAME = "districtName";
    public static final String USERNAME = "userName";
    public static final String BUREAUNAME = "bureauName";
    public static final String BUREAUID = "bureauId";

    public static final String LOGINURL = "loginUrl";//登录URL,
    public static final String PROJECTNAME = "projectName";//文件访问work名
    public static final String SUCCESSURL = "successUrl";//登录成功URL,
    public static final String LOGOUTURL = "logoutUrl";//登出URL,
    public static final String UPLOADURL = "uploadUrl";//文件上传URL,
    public static final String DOWNLOADURLPREFIX = "downloadUrlPrefix";//文件下载URL前缀,
    public static final String ACCESSURLPREFIX = "accessUrlPrefix";//文件访问URL前缀


//    public static String getHtml(String path) throws Exception {
//        // 通过网络地址创建URL对象
//        URL url = new URL(path);
//        // 根据URL
//        // 打开连接，URL.openConnection函数会根据URL的类型，返回不同的URLConnection子类的对象，这里URL是一个http，因此实际返回的是HttpURLConnection
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        // 设定URL的请求类别，有POST、GET 两类
//        conn.setRequestMethod("GET");
//        //设置从主机读取数据超时（单位：毫秒）
//        conn.setConnectTimeout(5000);
//        //设置连接主机超时（单位：毫秒）
//        conn.setReadTimeout(5000);
//        // 通过打开的连接读取的输入流,获取html数据
//        InputStream inStream = conn.getInputStream();
//        // 得到html的二进制数据
//        byte[] data = readInputStream(inStream);
//        // 是用指定的字符集解码指定的字节数组构造一个新的字符串
//        String html = new String(data, "utf-8");
//        return html;
//    }
//
//    /**
//     * 读取输入流，得到html的二进制数据
//     *
//     * @param inStream
//     * @return
//     * @throws Exception
//     */
//    public static byte[] readInputStream(InputStream inStream) throws Exception {
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = inStream.read(buffer)) != -1) {
//            outStream.write(buffer, 0, len);
//        }
//        inStream.close();
//        return outStream.toByteArray();
//    }

}
