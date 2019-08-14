package drawpic;
import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class EditDialog extends JDialog{
	public EditDialog(JFrame frame,JButton f,JButton b,JLabel[] a) {
		super(frame,"编辑颜色",true);
		Container c = getContentPane();
		JPanel center = new JPanel(new GridLayout(1,2));
		JPanel left = new JPanel(new FlowLayout());
		JPanel right = new JPanel(new GridLayout(4,2));
		right.setPreferredSize(new Dimension(260,241));
		JPanel[] righter = new JPanel[4];
		JPanel[] lefter = new JPanel[4];
		for(int i=0;i<4;i++) {
			righter[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			lefter[i] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		}
		/*上面是将该contain的分区部分划分好，以便于之后的组件添加，下面开始构造组件及设置选定组件*/
		JLabel select;
		if(f.getBackground().equals(new Color(0,162,232))) {
			select = a[0];
		}
		else {
			select = a[1];
		}
		JLabel x =new JLabel("",new ImageIcon("icon/color.png"),JLabel.CENTER);
		x.setOpaque(true);
		x.setPreferredSize(new Dimension(240,241));
		//颜色板
		left.add(x);
		ShadeLabel p = new ShadeLabel();//重写JLabel后的渐变背景色的label
		p.setPreferredSize(new Dimension(20,240));
		left.add(p);
		//左边完成
		JLabel[] label = new JLabel[8];
		for(int i=0;i<8;i++) {
			label[i] = new JLabel("",JLabel.CENTER);
			label[i].setPreferredSize(new Dimension(60,40));
		}
		label[0].setText("预览：");
		label[1].setText("red:");
		label[2].setText("green:");
		label[3].setText("blue:");
		for(int i=0;i<4;i++) {
			label[i+4].setOpaque(true);
		}
		label[4].setBackground(select.getBackground());
		label[4].setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
		label[4].setPreferredSize(new Dimension(50,40));
		for(int i=0;i<3;i++) {
			label[i+5].setBackground(Color.WHITE);
		}
		label[5].setText(String.valueOf(select.getBackground().getRed()));
		label[6].setText(String.valueOf(select.getBackground().getGreen()));
		label[7].setText(String.valueOf(select.getBackground().getBlue()));
		for(int i=0;i<4;i++) {
			lefter[i].add(label[i]);
		}
		for(int i=0;i<4;i++) {
			righter[i].add(label[i+4]);
		}
		for(int i=0;i<4;i++) {
			right.add(lefter[i]);
			right.add(righter[i]);
		}
		center.add(left);
		center.add(right);
		//dialog中产生的listener，不添加到AllListener中
		SelectColorBoxListener as = new SelectColorBoxListener(x,this,p,label);
		ThinColorBoxListener as1 = new ThinColorBoxListener(this,p,label);
		x.addMouseListener(as);
		p.addMouseListener(as1);
		JButton con = new JButton("确定");
		con.setBackground(new Color(200,200,200));
		OKListener as2 = new OKListener(select,label[4],this);
		con.addActionListener(as2);
		c.add(center,BorderLayout.CENTER);
		JPanel south = new JPanel(new FlowLayout());
		south.setPreferredSize(new Dimension(400,50));
		south.add(con);
		c.add(south,BorderLayout.SOUTH);
		this.setBounds(100, 100, 570, 350);
		this.setResizable(false);
	}
	
}
