package drawpic;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:36:30
 *
 * @description 代替canvas用来绘图的板子
 *
 */

@SuppressWarnings("serial")
public class CanPaintLabel extends JLabel{
	public CanPaintLabel() {
		//在这里传入参数,可以自己设定一些参数
		setOpaque(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1200,700));
		setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
	}
	@Override
    protected void paintComponent(Graphics g1) {
		//在这里绘制我们想要的东西,可以通过updateUI()更新图像
		super.paintComponent(g1);
	}
	//这里可以重写JLabel的某些有用的函数
}
