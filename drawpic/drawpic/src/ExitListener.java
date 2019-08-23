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
 * @time ����10:53:53
 *
 * @description �˳���ť�����������Ͻǹرհ�ť�ļ�����
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
			int result = JOptionPane.showConfirmDialog(frame.frame, "�Ƿ񱣴��������ĸ���?","����",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
            	JFileChooser fileChooser = new JFileChooser();// �����ļ�ѡ��Ի���
    			FileFilter filter = new FileNameExtensionFilter("ͼ���ļ���JPG/JPEG/PNG��", "JPG", "JPEG","PNG");// �����ļ���������ֻ�г�JPG��PNG��ʽ��ͼƬ
    			fileChooser.setFileFilter(filter);
    			while(true) {
    				int j = fileChooser.showSaveDialog(frame.frame);// ��ʾ�ļ�ѡ��Ի���
    				// �ж��û��������Ƿ�Ϊ�����桱��ť
    				if (j == JFileChooser.APPROVE_OPTION) {
    					File selectedFile = fileChooser.getSelectedFile();// ���ѡ�е�ͼƬ����
    					if(new File(selectedFile.getAbsolutePath()).exists()) {
    						int res = JOptionPane.showConfirmDialog(fileChooser, 
    								selectedFile.getAbsolutePath()+" �Ѵ��ڣ��Ƿ񸲸���?","ȷ��",
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
			int result = JOptionPane.showConfirmDialog(frame.frame, "�Ƿ񱣴��������ĸ���?","����",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
            	JFileChooser fileChooser = new JFileChooser();// �����ļ�ѡ��Ի���
    			FileFilter filter = new FileNameExtensionFilter("ͼ���ļ���JPG/JPEG/PNG��", "JPG", "JPEG","PNG");// �����ļ���������ֻ�г�JPG��PNG��ʽ��ͼƬ
    			fileChooser.setFileFilter(filter);
    			while(true) {
    				int j = fileChooser.showSaveDialog(frame.frame);// ��ʾ�ļ�ѡ��Ի���
    				// �ж��û��������Ƿ�Ϊ�����桱��ť
    				if (j == JFileChooser.APPROVE_OPTION) {
    					File selectedFile = fileChooser.getSelectedFile();// ���ѡ�е�ͼƬ����
    					if(new File(selectedFile.getAbsolutePath()).exists()) {
    						int res = JOptionPane.showConfirmDialog(fileChooser, 
    								selectedFile.getAbsolutePath()+" �Ѵ��ڣ��Ƿ񸲸���?","ȷ��",
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