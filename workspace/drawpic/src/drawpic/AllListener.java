package drawpic;
//import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author ASUS
 *
 * @time 下午3:23:25
 *
 * @description 总体的listener，具体需要什么listener，根据组件功能自行设定，参数传入方式构造即可
 * !!!注意，添加完组件后，要完成该处AllListener的构造函数
 *
 */
public class AllListener {
	ActionListener[] action;
	FocusListener[] focus;
	KeyListener[] key;
	MouseListener[] mouse;
	MouseMotionListener[] mouseMotion;
	BorderListener asd;
	public AllListener(AllButton b,AllMenu m,AllTool t,CanPaintLabel c,MyFrame fram) {
		/*例：
		 * action = new ActionListener["总体的个数，此处需要改动"];
		 * ...此处为其他的listener
		 * action["此处为对应的listener的序号"] = MyListener("参数"，"参数"，。。。);
		 * !上述listener可能不全，如果有需要可以添加额外的listener，或者删除掉多余的listener
		 */
		//为了可以调试，暂时为每一种添加60个对象
		action = new ActionListener[40];
		focus = new FocusListener[60];
		key = new KeyListener[60];
		mouse = new MouseListener[60];
		mouseMotion = new MouseMotionListener[60];
		for(int i=0;i<14;i++) {
			action[i] = new LeftButtonListener(b.allButton,i);
		}
		action[14] = new ColorSelectListener(t.allButton[0].button,t.allButton[1].button);
		action[15] = new ColorSelectListener(t.allButton[1].button,t.allButton[0].button);
		action[16] = new EditColorListener(fram.frame,t.allButton[0].button,
				t.allButton[1].button,t.allLabel);
		for(int i=0;i<3;i++) {
			action[i+17] = new FontListener(t.allButton[i+3].button);
		}
		for(int i=0;i<20;i++) {
			action[i+20] = new ColorBoxListener(t.allLabel,t.allButton[0].button,
					t.allButton[1].button,t.allColor[i]);
		}
		asd = new BorderListener(b,m,t,c,fram);
		//下方为尚未实现的监听器
		for(int i=0;i<60;i++) {
			focus[i] = new FocusListener() {

				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void focusLost(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			};
			key[i] = new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}};
			mouse[i] = new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}};
			mouseMotion[i] = new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}};
		}
	}
}
