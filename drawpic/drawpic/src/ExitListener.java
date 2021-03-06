import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * 
 * @author ASUS
 *
 * @time 下午10:53:53
 *
 * @description 退出按钮与主界面右上角关闭按钮的监听器
 *
 */
public class ExitListener implements ActionListener,WindowListener {
	MyFrame frame;
	CanPaintLabel a;
	public ExitListener(MyFrame frame,CanPaintLabel a) {
		this.frame = frame;
		this.a = a;
	}
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		int flag = 0;
		if(frame.undo.size()!=0||frame.redo.size()!=0) {
			int result = JOptionPane.showConfirmDialog(frame.frame, "是否保存您所作的更改?","保存",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
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
    							String[] tem = selectedFile.getAbsolutePath().split("\\.");
    			            	String tee = tem[tem.length-1];
    			            	try {
    								ImageIO.write(a.image,tee,new File(selectedFile.getAbsolutePath()));
    							} catch (IOException e1) {
    								// TODO Auto-generated catch block
    								e1.printStackTrace();
    							}
    							break;
    						}
    					}
    					else {
    						String[] tem = selectedFile.getAbsolutePath().split("\\.");
			            	String tee = tem[tem.length-1];
			            	try {
								ImageIO.write(a.image,tee,new File(selectedFile.getAbsolutePath()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
    						break;
    					}
    				}
    				else {
    					flag = 1;
    					break;
    				}
    			}
            }
		}
		if(flag == 0) {
			System.exit(0);
		}
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int flag = 0;
		if(frame.undo.size()!=0||frame.redo.size()!=0) {
			int result = JOptionPane.showConfirmDialog(frame.frame, "是否保存您所作的更改?","保存",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
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
    							String[] tem = selectedFile.getAbsolutePath().split("\\.");
    			            	String tee = tem[tem.length-1];
    			            	try {
    								ImageIO.write(a.image,tee,new File(selectedFile.getAbsolutePath()));
    							} catch (IOException e1) {
    								// TODO Auto-generated catch block
    								e1.printStackTrace();
    							}
    							break;
    						}
    					}
    					else {
    						String[] tem = selectedFile.getAbsolutePath().split("\\.");
			            	String tee = tem[tem.length-1];
			            	try {
								ImageIO.write(a.image,tee,new File(selectedFile.getAbsolutePath()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
    						break;
    					}
    				}
    				else {
    					flag = 1;
    					break;
    				}
    			}
            }
		}
		if(flag == 0) {
			System.exit(0);
		}
	}
}
