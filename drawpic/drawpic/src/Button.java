import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author MengFanhua
 *
 * @time ����4:28:16
 *
 * @description ��������������һ����ʽ��button�࣬���������ж�Ӧλ�õ�button
 *
 */

public class Button {
	JButton button;
	public Button() {
		//�½�һ��button
		button = new JButton();
		//���ð�ť��С,����ò��û����
		button.setPreferredSize(new Dimension(30,30));
		//���ñ���ɫΪ��ɫ,֮��Ҫ�Ա�����ɫ�ж�ѡ��
		button.setBackground(new Color(255,255,255));
	}
}