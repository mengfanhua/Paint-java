package drawpic;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:38:02
 *
 * @description �˼�����aΪ���������bΪ�޸Ķ���ʹ��ʱҪע��˳��
 *
 */

public class ColorSelectListener implements ActionListener{
	JButton[] button;
	public ColorSelectListener(JButton a,JButton b) {
		button = new JButton[2];
		button[0] = a;
		button[1] = b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		button[0].setBackground(new Color(0,162,232));
		button[1].setBackground(new Color(220,220,220));
		button[0].updateUI();
		button[1].updateUI();
	}
}