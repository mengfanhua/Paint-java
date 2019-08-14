package drawpic;
import java.awt.Color;

import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author ASUS
 *
 * @time ����3:33:13
 *
 * @description �˴�Ϊ����������Ӽ������ĵط���Ҳ���Խ���Ӧ�������dialog�ŵ������Ӧ�����ļ������¼�Ҳ��Ҫ��Ӧ��AllListener��
 * 
 *
 */

public class AllCombine {
	Button[] allPenButton;
	JMenu[] allMenuMenu;
	JMenuItem[] allMenuMenuItem;
	JLabel[] allToolLabel;
	JComboBox<String> sizeToolBox;
	JComboBox<String> fontToolBox;
	JComboBox<String> fontSizeToolBox;
	Button[] allToolButton;
	JButton[] allToolColor;
	CanPaintLabel canvas; 
	JFrame frame;
	public AllCombine() {
		AllButton allButton = new AllButton();
		AllMenu allMenu = new AllMenu();
		AllTool allTool = new AllTool();
		CanPaintLabel allCanvas = new CanPaintLabel();
		MyFrame fram = new MyFrame();
		/*allCanvas.setOpaque(true);
		allCanvas.setBackground(Color.WHITE);
		allCanvas.setPreferredSize(new Dimension(1200,700));
		allCanvas.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));*/
		AllListener allListener = new AllListener(allButton,allMenu,allTool,allCanvas,fram);
		
		for(int i=0;i<allButton.allButton.length;i++) {
			allButton.allButton[i].button.addActionListener(allListener.action[i]);
		}
		/*for(int i=0;i<allMenu.allMenuItem.length;i++) {
			allMenu.allMenuItem[i].addActionListener(allListener.action[i+allButton.allButton.length]);
		}*/
		//����������ֻ��Ҫʵ����ɫ���ĵ���¼��Ϳ���,�����Ĳ����ȵ�canvas��ͼʱ����ȡ
		for(int i=0;i<allTool.allButton.length;i++) {
			allTool.allButton[i].button.addActionListener(allListener.action[i+
			                                allButton.allButton.length/*+allMenu.allMenuItem.length*/]);
		}
		for(int i=0;i<allTool.allColor.length;i++) {
			allTool.allColor[i].addActionListener(allListener.action[i+allButton.allButton.length+
			                                /*allMenu.allMenuItem.length+*/allTool.allButton.length]);
		}
		//�˴����Ӽ�����,Ҫע�����,�ó�������Ϊֹ,û�������κεĳ�ʼ״̬,�ʼ�����Ҫ���ǵ�
		allCanvas.addMouseListener(allListener.mouse[0]);
		allCanvas.addMouseMotionListener(allListener.mouseMotion[0]);//���ұ�����������������ʽ
		//���м�������ֵ��Ϻ�,�Ըô����г�ʼ��
		allPenButton = allButton.allButton;
		allMenuMenu = allMenu.allMenu;
		allMenuMenuItem = allMenu.allMenuItem;
		allToolLabel = allTool.allLabel;
		sizeToolBox = allTool.sizeBox;
		fontToolBox = allTool.fontBox;
		fontSizeToolBox = allTool.fontSizeBox;
		allToolButton = allTool.allButton;
		allToolColor = allTool.allColor;
		canvas = allCanvas;
		frame = fram.frame;
	}
}