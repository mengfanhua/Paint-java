import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����10:55:24
 *
 * @description �½�������
 *
 */

public class NewListener implements ActionListener{
	MyFrame frame;
	CanPaintLabel a;
	AllMenu b;
	public NewListener(MyFrame frame,CanPaintLabel a,AllMenu b) {
		this.frame = frame;
		this.a = a;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(frame.name != null) {
			int result = JOptionPane.showConfirmDialog(frame.frame, "�Ƿ񱣴��������ĸ���?","����",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
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
		frame.undo.clear();
		frame.redo.clear();
		frame.cutboard = null;
		frame.name = null;
		for(int i=5;i<=9;i++) {
			b.allMenuItem[i].setEnabled(false);
		}
		a.setPreferredSize(new Dimension(1000,500));
		a.image = new BufferedImage(1000,500,BufferedImage.TYPE_INT_RGB);//����RGB��ʽ��ͼ��
		a.bg = (Graphics2D)a.image.getGraphics();//�õ�����
		a.bg.setColor(Color.WHITE);
		a.bg.fillRect(0, 0, a.image.getWidth(), a.image.getHeight());//����ʼ����Ϊ��ɫ
		a.teImage = null;
		a.gg = null;
		a.updateUI();
	}
}