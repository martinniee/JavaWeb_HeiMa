import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

/**
 * @author nathan
 * @create 2021-10-18-15:07
 **/
// MainFrame继承JFrame
public class MainFrame extends JFrame {

    // 构造界面

    private  static final long serialVersionUID = 1L;

    //主窗体中的若干元素
    //创建主窗体框架,设置标题 "文件生成器"
    private JFrame mainForm = new JFrame("文件生成器");
    // 设置弹出界面用于选择用于生成文件的文本文件
    private  JLabel label_selectFile = new JLabel("请选择文本文件md/txt用于生成文件夹结构");
    private  JLabel label_storage = new JLabel("请选择用于储存生成的文件夹结构的目录路径");

    //创建选择 生成文件夹结构的源文件或者储存文件夹结构的文本域
    public static JTextField sourcefile = new JTextField();
    public static JTextField targetfile = new JTextField();
    public static JButton buttonBrowseSource = new JButton("浏览");// 浏览按钮
    public static JButton buttonBrowseTarget = new JButton("浏览");// 浏览按钮

    public static JButton buttonGene = new JButton("生成"); // 生成按钮

    //构造方法
    public MainFrame(){

        // 创建画布容器对象
        Container container = mainForm.getContentPane();
        /* 设置主窗体属性 */
        mainForm.setSize(1000, 500);// 设置主窗体大小
        mainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置主窗体关闭按钮样式
        mainForm.setLocationRelativeTo(null);// 设置居于屏幕中央
        mainForm.setResizable(true);// 设置窗口不可缩放
        mainForm.setLayout(null);
        mainForm.setVisible(true);// 显示窗口

        //设置组件字体大小
//        Font font=new Font("宋体",Font.BOLD,26);
//        label_selectFile.setFont(font);
//        sourcefile.setFont(font);
//        buttonBrowseSource.setFont(font);
//        buttonBrowseTarget.setFont(font);
//        label_storage.setFont(font);
//        targetfile.setFont(font);
//        buttonGene.setFont(font);

        /* 设置各元素位置布局 */
        label_selectFile.setBounds(30, 10, 300, 30);
        sourcefile.setBounds(50, 50, 500, 50);
        buttonBrowseSource.setBounds(600, 50, 100, 50);
        label_storage.setBounds(30, 90, 300, 30);
        targetfile.setBounds(50, 130, 500, 50);
        buttonBrowseTarget.setBounds(600, 130, 100, 50);
        buttonGene.setBounds(100, 180, 150, 50);

        /* 为各元素绑定事件监听器 */
        // 需要创建 BrowserAction类
        buttonBrowseSource.addActionListener(new BrowseAction()); // 为源文件浏览按钮绑定监听器，点击该按钮调用文件选择窗口
        buttonBrowseTarget.addActionListener(new BrowseAction()); // 为目标位置浏览按钮绑定监听器，点击该按钮调用文件选择窗口
        // 为按钮绑定事件
        // 需要创建 GenerateAction类
        buttonGene.addActionListener(new GenerateAction()); // 为生成按钮绑定监听器，单击生成按钮会对源文件进行处理并输出到目标位置
        //sourcefile.getDocument().addDocumentListener(new TextFieldAction());// 为源文件文本域绑定事件，如果文件是.txt类型，则禁用解密按钮；如果是.kcd文件，则禁用加密按钮。

        sourcefile.setEditable(true);// 设置源文件文本域不可手动修改
        targetfile.setEditable(true);// 设置目标位置文本域不可手动修改

        // 添加组件到容器container
        // 1、将弹出界面添加
        container.add(label_selectFile);
        container.add(label_storage);
        // 2、将文本域添加
        container.add(sourcefile);
        container.add(targetfile);
        //3、将浏览按钮添加
        container.add(buttonBrowseSource);
        container.add(buttonBrowseTarget);
        //4、将生成按钮添加
        container.add(buttonGene);


    }
    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);

        for (Enumeration keys = UIManager.getDefaults().keys();

             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();

            Object value = UIManager.get(key);

            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);

            }

        }

    }

    // 主方法执行
    public static void main(String args[]) {
        InitGlobalFont(new Font("alias", Font.PLAIN, 26));
        new MainFrame();
    }

}
