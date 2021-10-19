package cn.nathan.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author nathan
 * @create 2021-10-15-20:18
 **/
public class Demo_test {

    public static void main(String[] args) {
        File dir = new File("");

        try {
            // 1、读取外部文件内容
//            FileReader fileReader = new FileReader("nav.txt");
            FileReader fileReader = new FileReader("spring.txt");
            BufferedReader in = new BufferedReader(fileReader);
            String str;
            while ((str = in.readLine()) !=null) {
                //2、创建文件夹

                if (str.startsWith("- ")) {
                    // 如果是文件,是以"- "开头
                    //如果以"- "开头,则去除"- "的内容,并将剩下的字符串作为文件名,创建文件
                    // 获取剩余的字符串,将"- "替换为“”空字符串
                    String strNew = str.replaceFirst("- ", "").concat(".md");
                    try {
                        ///4、根据变量创建文件
                        File file = new File(dir + "/" + strNew);
                        System.out.println("file: " + file);
                        if (file.createNewFile())
                            System.out.println("文件创建成功！");
                        else
                            System.out.println("出错了，该文件已经存在。");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    // 如果不是文件,就创建文件夹
                    str = in.readLine();
                    // 根据变量创建文件,str是文件夹名
                   dir = new File(str);
                    if (!dir.exists()) {//如果文件夹不存在
                        dir.mkdir();//创建文件夹
                    }
                }
            }
        } catch (IOException e) {
        }


    }


}

