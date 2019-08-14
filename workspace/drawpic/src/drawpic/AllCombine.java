package drawpic;
import java.awt.Color;

import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author ASUS
 *
 * @time 下午3:33:13
 *
 * @description 此处为所有组件添加监听器的地方，也可以将响应后产生的dialog放到这里，相应产生的监听器事件也就要对应到AllListener中
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
		//工具栏区域只需要实现颜色区的点击事件就可以,其他的参数等到canvas绘图时再提取
		for(int i=0;i<allTool.allButton.length;i++) {
			allTool.allButton[i].button.addActionListener(allListener.action[i+
			                                allButton.allButton.length/*+allMenu.allMenuItem.length*/]);
		}
		for(int i=0;i<allTool.allColor.length;i++) {
			allTool.allColor[i].addActionListener(allListener.action[i+allButton.allButton.length+
			                                /*allMenu.allMenuItem.length+*/allTool.allButton.length]);
		}
		//此处添加监听器,要注意的是,该程序到现在为止,没有设置任何的初始状态,故监听器要考虑到
		allCanvas.addMouseListener(allListener.mouse[0]);
		allCanvas.addMouseMotionListener(allListener.mouseMotion[0]);//暂且保留监听器的数组形式
		//所有监听器赋值完毕后,对该处进行初始化
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
