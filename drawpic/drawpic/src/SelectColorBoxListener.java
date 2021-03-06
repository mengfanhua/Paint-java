import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:44:41
 *
 * @description 用以实现Dialog中颜色板的选择
 *
 */

public class SelectColorBoxListener implements MouseListener {
	JLabel a;
	JDialog b;
	JLabel c;
	ShadeLabel ds;
	JLabel[] zz;
	//传入的参数为:大图，Dialog,重写过的渐变色label，以及预览图和数据图的label
	public SelectColorBoxListener(JLabel s,JDialog q,ShadeLabel d,JLabel[] z) {
		a = s;
		b = q;
		c = new JLabel();
		c.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		c.setBounds(a.getBounds().x-5,a.getBounds().y-5,5,5);
		b.add(c);
		ds=d;
		zz = z;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		c.setLocation(a.getBounds().x+e.getX()-2, a.getBounds().y+e.getY()-2);
		long maxsum = 255-Math.round(e.getY()*128/240.0);
		long minsum = Math.round(e.getY()*127/240.0);
		Color te;
		//此处不用深究,这个是根据画图板的图的颜色分布规律来的
		if(e.getX()<40) {
			te = new Color((int)maxsum,
					(int)(minsum+Math.round(e.getX()*(maxsum-minsum)/40.0)),(int)minsum);
		}
		else if(e.getX()<80) {
			te = new Color((int)(maxsum-Math.round((e.getX()-40)*(maxsum-minsum)/40.0)),
			(int)maxsum,(int)minsum);
		}
		else if(e.getX()<120) {
			te = new Color((int)minsum,
					(int)maxsum,(int)(minsum+Math.round((e.getX()-80)*(maxsum-minsum)/40.0)));
		}
		else if(e.getX()<160) {
			te = new Color((int)minsum,
					(int)(maxsum-Math.round((e.getX()-120)*(maxsum-minsum)/40.0)),(int)maxsum);
		}
		else if(e.getX()<200) {
			te = new Color((int)(minsum+Math.round((e.getX()-160)*(maxsum-minsum)/40.0)),
			(int)minsum,(int)maxsum);
		}
		else {
			te = new Color((int)maxsum,
					(int)minsum,(int)(maxsum-Math.round((e.getX()-200)*(maxsum-minsum)/40.0)));
		}
		ds.setBackground(te);
		ds.updateUI();
		zz[4].setBackground(te);
		zz[4].updateUI();
		//显示出RGB值
		zz[5].setText(String.valueOf(te.getRed()));
		zz[6].setText(String.valueOf(te.getGreen()));
		zz[7].setText(String.valueOf(te.getBlue()));
		for(int i=0;i<3;i++) {
			zz[i+5].updateUI();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
