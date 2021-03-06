import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午7:20:39
 *
 * @description 创建主界面
 *
 */

public class MyFrame {
	JFrame frame;
	Vector<BufferedImage> undo;
	Vector<BufferedImage> redo;
	BufferedImage cutboard;
	String name;
	public MyFrame() {
		frame = new JFrame();
		frame.setBounds(80,10,1200,750);
		frame.setTitle("简易绘图板");
		try {
			frame.setIconImage(ImageIO.read(new File("icon/peach.png")));
		} catch (IOException e) {
			//理论上不会触发，除非用户误删文件
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//测试方便关闭
		undo = new Vector<BufferedImage>();
		redo = new Vector<BufferedImage>();
		cutboard = null;
		name = null;
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
}
