import java.awt.event.*;

import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����11:59:35
 *
 * @description ����������ť�¼�������frame
 *
 */

public class ShowHelpListener implements ActionListener {
	JFrame frame;
	
	public ShowHelpListener(JFrame a) {
		frame = a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		HelpDialog a = new HelpDialog(frame);
		a.setVisible(true);
	}
}