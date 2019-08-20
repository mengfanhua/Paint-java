package drawpic;

import java.awt.*;
import java.awt.image.*;
import java.util.*;
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
	private static final double pi = 3.1415926535;
	int selectButton;//选择的工具
	int oldtimes;
	int times;//放大倍数
	int x,y;//绘图的起始位置
	int x1,y1;//绘图的终止位置
	int size;//图像大小
	Color fore;//前景色
	Color back;//背景色
	int flag;//用以判断是否需要paint其他的组件
	BufferedImage image;
	Graphics2D bg;
	BufferedImage teImage;
	Graphics2D gg;
	int temx,temy,temw,temh;//记录image存在时在该组件中的位置
	
	public CanPaintLabel() {
		//在这里传入参数,可以自己设定一些参数
		setOpaque(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1000,500));
		selectButton = 9; times = 1;oldtimes = 1;
		x = 0; y = 0;
		x1 = 0; y1 = 0;
		size = 3;
		fore = new Color(0,0,0);
		back = new Color(255,255,255);
		flag = -1;
		image = new BufferedImage(1000,500,BufferedImage.TYPE_INT_RGB);
		bg = (Graphics2D)image.getGraphics();
		bg.setColor(back);
		bg.fillRect(0, 0, image.getWidth(), image.getHeight());
		bg.setColor(fore);
		teImage = null;
		gg = null;
	}
	
	public void setProperty(int se,int ti,int si,Color fore,Color ba) {
		selectButton = se; times = ti;oldtimes = ti;
		size = si;
		this.fore = fore;
		back = ba;
	}
	@Override
    public void paintComponent(Graphics g1) {
		//在这里绘制我们想要的东西,可以通过updateUI()更新图像
		super.paintComponent(g1);
		if(flag == 1 ) {
			switch(selectButton) {
			case 0:{
				bg.setColor(fore);
				Stroke s = new BasicStroke(3*size+1);
				bg.setStroke(s);
				bg.drawLine(x1, y1, x, y);
				x1 = x;
				y1 = y;
				break;
				}
			case 1:{
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(size*2-1);
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawOval(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size);
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 2:{
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawRoundRect(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
						(teImage.getWidth()-5)/5,(teImage.getHeight()-5)/5);
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 4:{
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				double tr;
				if(x1-x == 0) {
					if(y1-y >0) {
						tr = pi/2;
					}
					else if(y1-y < 0) {
						tr = -pi/2;
					}
					else {
						tr = 0;
					}
					gg.drawArc(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
							(int)(180*tr/pi),180);
				}
				else if(y1-y == 0) {
					tr = 0;
					gg.drawArc(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
							(int)(180*tr/pi),180);
				}
				else {
					tr = -Math.atan(((double)(y1-y))/(x1-x));
					gg.drawArc(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size,
						(int)(180*tr/pi)*((x1-x)/Math.abs(x1-x)),
						180*((x1-x)/Math.abs(x1-x))*((y1-y)/Math.abs(y1-y)));
				}
				
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 5:{
				bg.setColor(back);
				Stroke s = new BasicStroke(2*size+1);
				bg.setStroke(s);
				bg.drawLine(x1, y1, x, y);
				x1 = x;
				y1 = y;
				break;
				}
			case 6:{
				int[] rgb = new int[3];
				int pixel = image.getRGB(x1,y1);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				if(!fore.equals(new Color(rgb[0],rgb[1],rgb[2]))) {
					fill(x1,y1,new Color(rgb[0],rgb[1],rgb[2]));
				}
				break;
			}
			case 7:{
				BufferedImage te = new BufferedImage(image.getWidth()*times/oldtimes,
						image.getHeight()*times/oldtimes,BufferedImage.TYPE_INT_RGB);
				Graphics2D tee = (Graphics2D)te.getGraphics();
				tee.scale(((double)times)/oldtimes, ((double)times)/oldtimes);
				tee.drawImage(image, 0, 0, null);
				image = te;
				bg = tee;
				oldtimes = times;
				break;
			}
			case 8:{
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawLine(x1 - (Math.min(x1, x)-3), y1 - (Math.min(y1, y)-3),
						x - (Math.min(x1, x)-3),  y - (Math.min(y1, y)-3));
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 9:{
				bg.setColor(fore);
				Stroke s = new BasicStroke(size);
				bg.setStroke(s);
				bg.drawLine(x1, y1, x, y);
				x1 = x;
				y1 = y;
				break;
				}
			case 10:{
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				Stroke s = new BasicStroke(2*size-1);
				gg.setStroke(s);
				gg.setColor(fore);
				gg.drawRect(2+size, 2+size, teImage.getWidth()-5-2*size, teImage.getHeight()-5-2*size);
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 11:{
				if(x>this.getPreferredSize().width) {
					x = this.getPreferredSize().width;
				}
				else if(x<0) {
					x = 0;
				}
				if(y>this.getPreferredSize().height) {
					y = this.getPreferredSize().height;
				}
				else if(y<0) {
					y = 0;
				}
				int sx=0;
				int sy=0;
				if(x1>x) {
					sx = x;
				}
				else {
					sx = x1;
				}
				if(y1>y) {
					sy = y;
				}
				else {
					sy = y1;
				}
				teImage = new BufferedImage(Math.abs(x-x1)+5,Math.abs(y-y1)+5,
						BufferedImage.TYPE_INT_ARGB);
				gg = (Graphics2D)teImage.getGraphics();
				gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {
					gg.drawLine(teImage.getWidth()*(i-1)/5, 0, teImage.getWidth()*i/5, 0);
					gg.drawLine(teImage.getWidth()*(i-1)/5, teImage.getHeight()-1,
							teImage.getWidth()*i/5, teImage.getHeight()-1);
					gg.drawLine(0, teImage.getHeight()*(i-1)/5, 0, teImage.getHeight()*i/5);
					gg.drawLine(teImage.getWidth()-1, teImage.getHeight()*(i-1)/5, 
							teImage.getWidth()-1, teImage.getHeight()*i/5);
				}
				temx = sx-2;temy = sy-2;temw = teImage.getWidth();temh = teImage.getHeight();
				break;
			}
			case 12:{
				int rx;
				int ry;
				bg.setColor(fore);
				for(int i=0;i<50;i++) {
					rx = (int)(Math.random()*(size+1)*5/2)-1;
					ry = (int)(Math.random()*(size+1)*5/2)-1;
					bg.drawLine(x+rx, y+ry, x+rx, y+ry);
				}
				break;
			}
			default:break;
			}
		}
		else if(flag == 0){
			BufferedImage temp = new BufferedImage(this.getPreferredSize().width,
					this.getPreferredSize().height,BufferedImage.TYPE_INT_RGB);
			Graphics2D te = (Graphics2D)temp.getGraphics();
			te.setColor(back);
			te.fillRect(0, 0, temp.getWidth(), temp.getHeight());
			if(this.getPreferredSize().width>image.getWidth()&&
					this.getPreferredSize().height>image.getHeight()) {
				te.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
			}
			else if(this.getPreferredSize().width>image.getWidth()&&
					this.getPreferredSize().height<=image.getHeight()) {
				BufferedImage a = image.getSubimage(0, 0, image.getWidth(),
						this.getPreferredSize().height);
				te.drawImage(a, 0, 0, a.getWidth(), a.getHeight(), null);
			}
			else if(this.getPreferredSize().width<=image.getWidth()&&
					this.getPreferredSize().height>image.getHeight()) {
				BufferedImage a = image.getSubimage(0, 0, 
						this.getPreferredSize().width,image.getHeight());
				te.drawImage(a, 0, 0, a.getWidth(), a.getHeight(), null);
			}
			else {
				BufferedImage a = image.getSubimage(0, 0, 
						this.getPreferredSize().width,this.getPreferredSize().height);
				te.drawImage(a, 0, 0, a.getWidth(), a.getHeight(), null);
			}
			image = temp;
			bg = te;
		}
		g1.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		if(teImage != null) {
			g1.drawImage(teImage, temx, temy, temw, temh, null);
		}
	}
	private void fill(int xx,int yy,Color co) {
		Vector<Point> tete = new Vector<Point>();
		tete.addElement(new Point(xx,yy));
		while(!tete.isEmpty()) {
			int[] rgb = new int[3];
			int pixel = image.getRGB(tete.get(0).x,tete.get(0).y);
			rgb[0] = (pixel & 0xff0000) >> 16;
			rgb[1] = (pixel & 0xff00) >> 8;
			rgb[2] = (pixel & 0xff);
			if(co.equals(new Color(rgb[0],rgb[1],rgb[2]))) {
				image.setRGB(tete.get(0).x,tete.get(0).y,fore.getRGB());
				
				if(tete.get(0).x>0) {
					tete.addElement(new Point(tete.get(0).x-1,tete.get(0).y));
				}
				if(tete.get(0).x<image.getWidth()-1) {
					tete.addElement(new Point(tete.get(0).x+1,tete.get(0).y));
				}
				if(tete.get(0).y>0) {
					tete.addElement(new Point(tete.get(0).x,tete.get(0).y-1));
				}
				if(tete.get(0).y<image.getHeight()-1) {
					tete.addElement(new Point(tete.get(0).x,tete.get(0).y+1));
				}
			}
			tete.remove(0);
		}
	}
}
