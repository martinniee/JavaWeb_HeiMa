package cn.nathan.filegenerator;

/**
 * @author nathan
 * @create 2021-10-18-15:54
 **/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BrowseAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(MainFrame.buttonBrowseSource)) {
            JFileChooser fcDlg = new JFileChooser();
            //
            fcDlg.setDialogTitle("请选择文本文件md用于生成文件夹结构");
            //文件过滤
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "文本文件(*.txt;*.md)", "txt", "md");
            fcDlg.setFileFilter(filter);
            int returnVal = fcDlg.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String filepath = fcDlg.getSelectedFile().getPath();
                MainFrame.sourcefile.setText(filepath);
            }
            //如果点击事件是‘目标文件路径’的按钮
        } else if (e.getSource().equals(MainFrame.buttonBrowseTarget)) {
            JFileChooser fcDlg = new JFileChooser();
            fcDlg.setDialogTitle("请选择用于储存生成的文件夹结构的目录");
            fcDlg.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = fcDlg.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String filepath = fcDlg.getSelectedFile().getPath();
                MainFrame.targetfile.setText(filepath);
            }
        }
    }

}