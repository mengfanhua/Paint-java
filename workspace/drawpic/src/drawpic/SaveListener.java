package drawpic;

//import java.awt.*;
import java.awt.event.*;
//import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * 
 * @author ASUS
 *
 * @time 下午10:55:37
 *
 * @description 保存监听器
 *
 */

public class SaveListener implements ActionListener {
	MyFrame frame;
	CanPaintLabel a;

	public SaveListener(MyFrame frame,CanPaintLabel a) {
		this.frame = frame;
		this.a = a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(frame.name == null) {
			JFileChooser fileChooser = new JFileChooser();// 创建文件选择对话框
			FileFilter filter = new FileNameExtensionFilter("图像文件（JPG/JPEG/PNG）", "JPG", "JPEG","PNG");// 设置文件过滤器，只列出JPG或PNG格式的图片
			fileChooser.setFileFilter(filter);
			while(true) {
				int j = fileChooser.showSaveDialog(frame.frame);// 显示文件选择对话框
				// 判断用户单击的是否为“保存”按钮
				if (j == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();// 获得选中的图片对象
					if(new File(selectedFile.getAbsolutePath()).exists()) {
						int res = JOptionPane.showConfirmDialog(fileChooser, 
								selectedFile.getAbsolutePath()+" 已存在，是否覆盖它?","确定",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if(res == JOptionPane.OK_OPTION){
							frame.name = selectedFile.getAbsolutePath();
							break;
						}
					}
					else {
						frame.name = selectedFile.getAbsolutePath();
						break;
					}
				}
				else {
					break;
				}
			}
		}
		String[] tem = frame.name.split("\\.");
    	String tee = tem[tem.length-1];
    	try {
			ImageIO.write(a.image,tee,new File(frame.name));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
