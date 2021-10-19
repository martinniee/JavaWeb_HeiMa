package cn.nathan.filegenerator;

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
            FileReader fileReader = new FileReader("spring_nav.txt");
            BufferedReader in = new BufferedReader(fileReader);
            String content_str;
            //开始获取文件中每行的内容
            while ((content_str = in.readLine()) !=null) {
                //2、创建文件夹

                if (content_str.startsWith("- ")) {
                    // 如果是文件,是以"- "开头
                    //如果以"- "开头,则去除"- "的内容,并将剩下的字符串作为文件名,创建文件
                    // 获取剩余的字符串,将"- "替换为“”空字符串
                    // strNew 为去除"- " 后的字符串
                    String strNew = content_str.replaceFirst("- ", "").concat(".md");
                    try {
                        File file = new File(dir + "/" + strNew); ///4、根据变量创建文件
                        if (file.createNewFile())
                            System.out.println("文件创建成功！");
                        else
                            System.out.println("出错了，该文件已经存在。");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {// 如果不是文件,就创建文件夹
                    content_str = in.readLine();
                   dir = new File(content_str); // 根据当前行内容创建文件,content_str是文件夹名
                    if (!dir.exists()) {//如果文件夹不存在
                        dir.mkdir();//创建文件夹
                    }
                }
            }
        } catch (IOException e) {
        }


    }

    public void  FileGenrator(){
        File dir = new File("");

        try {
            // 1、读取外部文件内容
//            FileReader fileReader = new FileReader("nav.txt");
            FileReader fileReader = new FileReader("spring_nav.txt");
            BufferedReader in = new BufferedReader(fileReader);
            String content_str;
            //开始获取文件中每行的内容
            while ((content_str = in.readLine()) !=null) {
                //2、创建文件夹

                if (content_str.startsWith("- ")) {
                    // 如果是文件,是以"- "开头
                    //如果以"- "开头,则去除"- "的内容,并将剩下的字符串作为文件名,创建文件
                    // 获取剩余的字符串,将"- "替换为“”空字符串
                    // strNew 为去除"- " 后的字符串
                    String strNew = content_str.replaceFirst("- ", "").concat(".md");
                    try {
                        File file = new File(dir + "/" + strNew); ///4、根据变量创建文件
                        if (file.createNewFile())
                            System.out.println("文件创建成功！");
                        else
                            System.out.println("出错了，该文件已经存在。");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {// 如果不是文件,就创建文件夹
                    content_str = in.readLine();
                    dir = new File(content_str); // 根据当前行内容创建文件,content_str是文件夹名
                    if (!dir.exists()) {//如果文件夹不存在
                        dir.mkdir();//创建文件夹
                    }
                }
            }
        } catch (IOException e) {
        }

    }

}

