import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:25:36
 *
 * @description Ϊ�Ӵ֣�б�壬�»���׼��������
 *
 */

public class FontListener implements ActionListener{
	JButton button;
	public FontListener(JButton s) {
		button = s;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(button.getBackground().equals(new Color(255,255,255))) {
			button.setBackground(new Color(175,175,175));
		}
		else {
			button.setBackground(new Color(255,255,255));
		}
		button.updateUI();
	}
}