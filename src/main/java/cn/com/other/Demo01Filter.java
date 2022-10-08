package cn.com.other;

import java.io.File;

/**
 * @Author: wenguoxing
 * @Date: 2019/12/31 13:26
 * @Version 1.0
 */
public class Demo01Filter {
    public static void main(String[] args) {
        File file = new File("c:\\abc");
        getAllFile(file);
    }

    /**
        定义一个方法,参数传递File类型的目录
        方法中对目录进行遍历
     */
    public static void getAllFile(File dir){
        //传递过滤器对象
        File[] files = dir.listFiles(new FileFilterImpl());
        for (File f : files) {
            //对遍历得到的File对象f进行判断,判断是否是文件夹
            if(f.isDirectory()){
                //f是一个文件夹,则继续遍历这个文件夹
                //我们发现getAllFile方法就是传递文件夹,遍历文件夹的方法
                //所以直接调用getAllFile方法即可:递归(自己调用自己)
                getAllFile(f);
            }else{
                //f是一个文件,直接打印即可
                System.out.println(f);
            }
        }
    }
}
