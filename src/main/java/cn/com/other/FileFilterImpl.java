package cn.com.other;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author: wenguoxing
 * @Date: 2019/12/31 13:14
 * @Version 1.0
 */
public class FileFilterImpl implements FileFilter {

    /**
        过滤的规则:
        在accept方法中,判断File对象是否是以.java结尾
        是就返回true
        不是就返回false
        如果pathname是一个文件夹,返回true,继续遍历这个文件夹
     */
    @Override
    public boolean accept(File pathname) {

        /*
        if(pathname.isDirectory()){
            return true;
        }
         */

        return pathname.getName().toLowerCase().endsWith(".cs");
    }
}
