import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author nathan
 * @create 2021-10-18-15:55
 **/
public class GenerateAction implements ActionListener {


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // 判断源文件文件域的状态
        // 如果输入内容为空,则提示
        if (MainFrame.sourcefile.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请选择待源文件(txt/md)！");
        }
        // 判断输出文件域的状态
        // 如果输入内容为空,则提示
        else if (MainFrame.targetfile.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请选择用于储存生成的文件夹结构的目录路径！");
        }
        // 否则进行处理
        else {
            String sourcepath = MainFrame.sourcefile.getText();
            String targetpath = MainFrame.targetfile.getText();
            // 根据源文件生成文件对象
            File file = new File(sourcepath);
            //获取文件名
            String filename = file.getName();
            //根据目标文件目录生成对象
            File dir = new File(targetpath);

            // 判断源文件是否存在
            if (file.exists() && dir.isDirectory()) {
                File file_dir = null;
                // 根据输入的 源路径名 和 源文件名生成对应的目标目录
                File result = new File(getFinalDir(targetpath, filename));
                if (!result.exists()) { //如果 路径不存在
                    result.mkdir();//创建文件夹
                }else System.out.println("目标储存目录已经存在!");
                // 开始读取文件中的内容
                // 仅需要确定的源文件(路径)
                try {
                    // 源文件的文件读取内容对象
                    FileReader fr = new FileReader(file);
                    // 读取外部文件内容流
                    BufferedReader in = new BufferedReader(fr);
                    String content_str = null; // content_str是每行的内容
                    //开始获取文件中每行的内容
                    System.out.println("I'm here");
                    while ((content_str = in.readLine()) !=null) {
                        System.out.println("content_str: " + content_str);
                        if (content_str.startsWith("- ")) {
                            // 如果是文件,是以"- "开头,则去除"- "的内容,
                            // 并将剩下的字符串作为文件名,创建文件
                            // 获取剩余的字符串,将"- "替换为“”空字符串
                            // strNew 为去除"- " 后的字符串
                            String strNew = content_str.replaceFirst("- ", "").concat(".md");
                            System.out.println("strNew: " + strNew);
                            File file_md = new File(file_dir + "\\" + strNew); ///4、根据最终的行内容生成对应的文件
                            System.out.println("file_md: " + file_md);
                            if (file_md.createNewFile())
                                System.out.println("文件创建成功！");
                            else
                                System.out.println("出错了，该文件已经存在。");
                        } else {// 如果不是文件,就创建文件夹
                            System.out.println("content_str1: " + content_str);
                            // 定义生成的储存文件的文件夹
                            // 根据当前行内容创建文件,content_str是文件夹名
                            file_dir = new File(result, content_str);
                            if (!file_dir.exists()) {//如果文件夹不存在
                                file_dir.mkdir();//创建文件夹
                            }else System.out.println("文件已存在!");

                        }

                    }
                    //文件最后的关闭
                    fr.close();
                    JOptionPane.showMessageDialog(null, "生成成功！");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "未知错误！");
                }
            }
            else if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "用于生成文件夹结构的文件不存在！");
            } else {
                JOptionPane.showMessageDialog(null, "储存生成后的文件夹结构存放目录不存在！");
            }

    }
}
    // 得到最后生成的内容所在的路径目录字符串
        private String getFinalDir(String targetpath, String filename) {
            // 最后生成的文件夹结构储存的地方
            filename = filename.replace(".txt","");
            String finalDir = targetpath + "\\" + filename + "\\" ;
            System.out.println("finalDir:" + finalDir);
            return finalDir;
        }
    }
