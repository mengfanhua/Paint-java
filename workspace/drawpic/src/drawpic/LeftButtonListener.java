package drawpic;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����4:02:53
 *
 * @description Ϊ��๦�ܰ������ð�������������button�������������
 *
 */

public class LeftButtonListener implements ActionListener{
	Button[] button;
	int flag;
	public LeftButtonListener(Button[] b,int s) {//���밴ť����˳����Ϊ��־�����ѡ���ĸ��ģ����ı�����ɫ
		button = b;
		flag = s;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Color temp = new Color(175,175,175);
		for(int i=0;i<button.length;i++) {
			if(button[i].button.getBackground().equals(temp)) {//��ԭ�ȵ�ѡ������Ϊԭ������ɫ
				button[i].button.setBackground(new Color(255,255,255));
				button[i].button.updateUI();
			}
			if(i==flag) {//��ǰѡ����
				button[i].button.setBackground(temp);
				button[i].button.updateUI();
			}
		}
	}
}