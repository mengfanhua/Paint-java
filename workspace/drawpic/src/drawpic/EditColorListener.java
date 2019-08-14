package drawpic;
import java.awt.event.*;
//import java.awt.*;
import javax.swing.*;


/**
 * 
 * @author ASUS
 *
 * @time 下午6:06:49
 *
 * @description 此处传入dialog对象，但参数要有主窗体对象，并且该dialog的监听器已经设置好
 *
 */

public class EditColorListener implements ActionListener {
	JFrame frame;
	JButton f;
	JButton b;
	JLabel[] a;
	public EditColorListener(JFrame frame,JButton f,JButton b,JLabel[] a) {
		this.frame = frame;
		this.f = f;
		this.b = b;
		this.a = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EditDialog dialog = new EditDialog(frame,f,b,a);
		dialog.setVisible(true);
	}
}
