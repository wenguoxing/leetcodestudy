package cn.com.other;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @Author: wenguoxing
 * @Date: 2019/12/31 11:26
 * @Version 1.0
 */
public class FileInfoScan {

    public FileInfoScan(String[] args) {

        String filePath = args[0];
        List<File> files = FileUtil.loopFiles(filePath, new FileFilterImpl());
        //List<File> files = FileUtil.loopFiles(filePath);
        for (File f : files) {
            Date date = new Date(f.lastModified());
            String dateTemp = DateUtil.format(date, "yyyy-MM-dd");
            //String strTemp = String.format("%s:%s:%s:%s",f.getPath(),f.getAbsoluteFile(),f.getName(),f.length());
            String strTemp = String.format("%-100s%-50s%-10s%-20s",f.getPath(),f.getName(),f.length(),dateTemp);
            System.out.println(strTemp);
        }
    }

    public static void main(String[] args) {
        //FileInfoScan fis = new FileInfoScan(args);

        String str = "******************敬业****";
        String strTemp = str.substring(6,19);
        System.out.println(strTemp);
    }
}
