package com.example.lsproject.tools;

/**
 * Created by caoyingfu on 2017/10/17.
 */

public class FileTools {

    public static boolean isImgFile(String string) {
        // jpeg/jpg/gif/bmp/png
        if (string != null && !"".equals(string)) {
            string = string.toLowerCase();
            if (string.endsWith("png")) {
                return true;
            }
            if (string.endsWith("jpg")) {
                return true;
            }
            if (string.endsWith("jpeg")) {
                return true;
            }
//            if (string.endsWith("gif")) {
//                return true;
//            }
            if (string.endsWith("bmp")) {
                return true;
            }
        }
        return false;
    }

}
