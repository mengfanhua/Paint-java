package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����5:42:45
 *
 * @description ���幤��������Ĺ���
 *
 */

public class FontTool {
	JLabel fontLabel;
	JComboBox<String> fontTool;
	JComboBox<String> fontSizeTool;
	Button blacker;//�Ӻ�
	Button underer;//�»���
	Button leaner;//��б
	public FontTool() {
		fontLabel = new JLabel("����:",JLabel.CENTER);
		fontLabel.setOpaque(true);
		fontTool = new JComboBox<String>();
		//��ȡ��ǰϵͳ�����п�������
		String[] g = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontSizeTool = new JComboBox<String>();
		for(int i=0;i<g.length;i++) {
			fontTool.addItem(g[i]);
		}
		for(int i=1;i<25;i++) {
			fontSizeTool.addItem(""+2*i);
		}
		fontSizeTool.setSelectedIndex(4);
		blacker = new Button();
		underer = new Button();
		leaner = new Button();
		blacker.button.setPreferredSize(new Dimension(25,25));
		underer.button.setPreferredSize(new Dimension(25,25));
		leaner.button.setPreferredSize(new Dimension(25,25));
		blacker.button.setIcon(new ImageIcon("icon/blacker.png"));
		underer.button.setIcon(new ImageIcon("icon/underer.png"));
		leaner.button.setIcon(new ImageIcon("icon/leaner.png"));
		blacker.button.setToolTipText("�Ӵ�");
		underer.button.setToolTipText("�»���");
		leaner.button.setToolTipText("б��");
	}
	/*public static void main(String[] args) {//�������Ե�������Ĵ����,����ʱ��ע��
		// TODO Auto-generated method stub
		FontTool button = new FontTool();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		//JPanel p1 = new JPanel(new GridLayout(5,2,5,5));
		c.add(button.fontTool);
		c.add(button.fontSizeTool);
		frame.setSize(1200,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}*/
}