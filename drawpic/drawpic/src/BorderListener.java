import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time ����8:21:55
 *
 * @description ר�����ڻ�ͼ�������ļ����������е����ֻ������ܣ����ٻ����ļ��Ĵ�����
 *
 */

public class BorderListener implements MouseMotionListener,MouseListener{;
	AllButton b;
	AllMenu m;
	AllTool t;
	CanPaintLabel a;
	MyFrame fram;
	int x,y;
	int x1,y1;
	JTextArea text;
	public BorderListener(AllButton b,AllMenu m,AllTool t,CanPaintLabel c,MyFrame fram) {
		this.b = b;
		this.m = m;
		this.t = t;
		this.a = c;
		this.fram = fram;
		text = new JTextArea();
		text.setOpaque(false);//�ı���͸��
		text.setBorder(BorderFactory.createLineBorder(new Color(238,238,238)));
		text.setBounds(-101, -101, 201, 101);//����Ѱ�����ĵ�
		fram.frame.add(text);//�����������Ӹ��ı����Ա��ڽ��ܼ������źţ��ֲ�����
	}
	@Override
	public void mouseDragged(MouseEvent e) {//����갴�²��϶�
		// TODO Auto-generated method stub
		int m = x+(e.getX()-a.x1);//������С+���µĵ��뵱ǰ��������
		int n = y+(e.getY()-a.y1);
		
		if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)) {//��teImage���ڲ����ƶ����÷�Χ
			a.temx += (e.getX()-a.x1);//�ƶ�����λ������
			a.temy += (e.getY()-a.y1);
			a.updateUI();//���½���ʹ���ƶ�
			a.x1 = e.getX();//�����ı���İ���֮ǰ��λ��
			a.y1 = e.getY();
		}
		else if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR)) {
			//������ƶ������±߽粢�϶�
			if(m>100&&n>50&&m<3000&&n<1500){
				a.setPreferredSize(new Dimension(m,n));//�ж��������С�߽�����
			}
			else if(m>100&&n<=50&&m<3000) {
				a.setPreferredSize(new Dimension(m,50));
			}
			else if(m<=100&&n>50&&n<1500) {
				a.setPreferredSize(new Dimension(100,n));
			}
			else if(m<=100&&n<=50) {
				a.setPreferredSize(new Dimension(100,50));
			}
			else if(m>=3000&&n>50&&n<1500) {
				a.setPreferredSize(new Dimension(3000,n));
			}
			else if(m>100&&m<3000&&n>=1500) {
				a.setPreferredSize(new Dimension(m,1500));
			}
			else if(m>=3000&&n>=1500) {
				a.setPreferredSize(new Dimension(3000,1500));
			}
			else if(m<=100&&n>=1500) {
				a.setPreferredSize(new Dimension(100,1500));
			}
			else {
				a.setPreferredSize(new Dimension(3000,50));
			}
			a.updateUI();//���½���
			
		}
		else if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)) {//�Ҳ��϶���
			if(m<=100) {
				a.setPreferredSize(new Dimension(100,y));//�ж��������С�߽�����
			}
			else if(m>100&&m<3000) {
				a.setPreferredSize(new Dimension(m,y));
			}
			else {
				a.setPreferredSize(new Dimension(3000,y));
			}
			a.updateUI();
		}
		else if(a.getCursor() == Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR)) {//�²�߽���
			if(n<=50) {
				a.setPreferredSize(new Dimension(x,50));//�ж��������С�߽�����
			}
			else if(n>50&&n<1500) {
				a.setPreferredSize(new Dimension(x,n));
			}
			else {
				a.setPreferredSize(new Dimension(x,1500));
			}
			a.updateUI();
		}
		else {//���ܲ�����
			if(text.getBounds().x != -101) {//�ж��ı����Ƿ��ƶ������ƶ�����Ҫ��ԭ
				a.teImage = new BufferedImage(206,106,
						BufferedImage.TYPE_INT_ARGB);
				a.gg = (Graphics2D)a.teImage.getGraphics();//��ʱ��ͼ�񻺴�
				a.gg.setFont(text.getFont());//��������
				a.gg.setColor(a.fore);//������ɫ
				FontMetrics metrics = a.gg.getFontMetrics();//����������λ�õı���
				a.gg.drawString(text.getText(), 5, metrics.getAscent()+3);//��������
				a.temx = x1-2;a.temy = y1-2;a.temw = a.teImage.getWidth();a.temh = a.teImage.getHeight();//������ʱλ���Ա��϶�
				text.setLocation(-101, -101);//��ԭ�ı���λ��
				text.setText("");//����ı����е�����
				a.gg.setColor(Color.BLACK);
				for(int i=1;i<=5;i=i+2) {//�����ʱͼ�񻺴�ı߿�
					a.gg.drawLine(a.teImage.getWidth()*(i-1)/5, 0, a.teImage.getWidth()*i/5, 0);
					a.gg.drawLine(a.teImage.getWidth()*(i-1)/5,a.teImage.getHeight()-1,
							a.teImage.getWidth()*i/5, a.teImage.getHeight()-1);
					a.gg.drawLine(0, a.teImage.getHeight()*(i-1)/5, 0, a.teImage.getHeight()*i/5);
					a.gg.drawLine(a.teImage.getWidth()-1, a.teImage.getHeight()*(i-1)/5, 
							a.teImage.getWidth()-1, a.teImage.getHeight()*i/5);
				}
				a.bg.drawImage(a.teImage.getSubimage(2, 2, a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4), a.temx+2, a.temy+2,a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4, null);//����ʱͼ����Ƶ�ԭͼ����
				a.teImage = null;//�����ʱͼ��
				a.gg = null;//�����ʱͼ��Ļ���
				a.updateUI();
			}
			else if(a.teImage!=null&&a.flag == 0) {//�ж��Ƿ�����ʱͼ�����
				if(a.getCursor() != Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)) {
					a.bg.drawImage(a.teImage.getSubimage(2, 2, a.teImage.getWidth()-4, 
							a.teImage.getHeight()-4), a.temx+2, a.temy+2,a.teImage.getWidth()-4, 
							a.teImage.getHeight()-4, null);//������ʱͼ��ԭͼ��
					a.teImage = null;//�����ʱͼ��
					a.gg = null;//�����ʱͼ��Ļ���
					a.updateUI();
				}
			}
			a.flag = 1;//���û����ź�,������������Ʋ���
			if(a.selectButton != 3&&a.selectButton != 6&&a.selectButton != 7&&
					a.selectButton != 13) {//ȥ�������Ӧ���������
				a.x = e.getX();//������ǰ����ֵ
				a.y = e.getY();
				a.updateUI();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {//����ƶ����޵���¼�
		// TODO Auto-generated method stub
		x = a.getPreferredSize().width;//��¼��ǰ�����Ĵ�С
		y = a.getPreferredSize().height;
		if(a.teImage !=null) {//������ʱͼ�����ʱ
			if(e.getX()>a.temx+1&&e.getX()<a.temx+a.temw-1&&
					e.getY()>a.temy+1&&e.getY()<a.temy+a.temh-1) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			}//�������ƶ�����ʱͼ�������������ʮ�ּ�ͷ���Թ��Ϸ���dragged����
			else {//�������
				if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()&&
					e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
					a.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));//����ƶ������±߽紦������ͬ��
				}
				else if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()) {
					a.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));//����ƶ����ұ߽紦������ͬ��
				}
				else if(e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
					a.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));//����ƶ����±߽紦������ͬ��
				}
				else {
					a.setCursor(Cursor.getDefaultCursor());//����Ĭ�ϵ����ͼ��
				}
			}
		}
		else {//����ʱͼ��
			if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()&&
				e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));//����ͬ��
			}
			else if(e.getX()<=a.getWidth()&&e.getX()+3>=a.getWidth()) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
			}
			else if(e.getY()<=a.getHeight()&&e.getY()+3>=a.getHeight()) {
				a.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
			}
			else {
				a.setCursor(Cursor.getDefaultCursor());
			}
		}
		
		a.x1 = e.getX();//�ƶ�ʱ����λ�ã��Ա��ڹ��ܵ���
		a.y1 = e.getY();
		text.updateUI();//ʵʱˢ���ı��򣬷�����������Ὣ���ס
	}
	@SuppressWarnings("static-access")
	@Override
	public void mouseClicked(MouseEvent e) {//������¼�
		// TODO Auto-generated method stub
		if(text.getBounds().x != -101) {//�ж��ı����Ƿ񱻵��ã�������û�������ı����ǲ��ᴥ������¼���
			//���ı����е����ֱ��ͼƬ�����õ���ʱͼ����
			a.teImage = new BufferedImage(206,106,
					BufferedImage.TYPE_INT_ARGB);
			a.gg = (Graphics2D)a.teImage.getGraphics();
			a.gg.setFont(text.getFont());
			a.gg.setColor(a.fore);
			FontMetrics metrics = a.gg.getFontMetrics();
			a.gg.drawString(text.getText(), 5, metrics.getAscent()+3);
			a.temx = x1-2;a.temy = y1-2;a.temw = a.teImage.getWidth();a.temh = a.teImage.getHeight();
			text.setLocation(-101, -101);
			text.setText("");
			a.gg.setColor(Color.BLACK);
			for(int i=1;i<=5;i=i+2) {//������ʱͼ��߿�
				a.gg.drawLine(a.teImage.getWidth()*(i-1)/5, 0, a.teImage.getWidth()*i/5, 0);
				a.gg.drawLine(a.teImage.getWidth()*(i-1)/5,a.teImage.getHeight()-1,
						a.teImage.getWidth()*i/5, a.teImage.getHeight()-1);
				a.gg.drawLine(0, a.teImage.getHeight()*(i-1)/5, 0, a.teImage.getHeight()*i/5);
				a.gg.drawLine(a.teImage.getWidth()-1, a.teImage.getHeight()*(i-1)/5, 
						a.teImage.getWidth()-1, a.teImage.getHeight()*i/5);
			}
			a.updateUI();//�������
		}
		else if(a.teImage!=null) {//��ʱͼ����и��ĵ��ı��򲻻�ͬʱ����
			if(a.getCursor() != Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)) {//�����ƶ���־
				a.bg.drawImage(a.teImage.getSubimage(2, 2, a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4), a.temx+2, a.temy+2,a.teImage.getWidth()-4, 
						a.teImage.getHeight()-4, null);//����ʱͼ�����ӵ�ԭͼ��
				a.teImage = null;//�����ʱͼ��
				a.gg = null;//�����ʱͼ�񻭱�
				a.updateUI();
			}
		}
		else {
			if(a.selectButton == 13) {//ѡ������Ϊ�ı���
				text.setLocation(e.getXOnScreen()-fram.frame.getBounds().x-105, 
					e.getYOnScreen()-fram.frame.getBounds().y-115);//�����ı���ʹ���λ�����м�
				x1 = e.getX()-100;//��¼��ǰλ�ã�����ת��ͼ��ʱȷ��λ��
				y1 = e.getY()-50;
			}
			else if(a.selectButton == 6) {//���Ϊ��ɫͰ
				a.x1 = e.getX();
				a.y1 = e.getY();
				a.flag = 1;//������ͼ
				a.updateUI();
			}
			else if(a.selectButton == 3) {//���Ϊȡɫ��
				int[] rgb = new int[3];
				int pixel = a.image.getRGB(e.getX(), e.getY());//�õ�����ĵ��RGBֵ
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				if(t.allButton[0].button.getBackground().equals(new Color(0,162,232))) {
					//�жϵ�ǰѡ������ɫ��ǰ�����Ǻ�
					t.allLabel[0].setBackground(new Color(rgb[0],rgb[1],rgb[2]));//������ɫ
					t.allLabel[0].updateUI();
				}
				else {
					t.allLabel[1].setBackground(new Color(rgb[0],rgb[1],rgb[2]));
					t.allLabel[1].updateUI();
				}
			}
			else if(a.selectButton == 7) {//���Ϊ�Ŵ�
				if(e.getButton()==e.BUTTON1) {//�����������
					if(a.image.getWidth()*(a.times+1)/a.oldtimes<=5000&&
							a.image.getHeight()*(a.times+1)/a.oldtimes<=2500) {//����������������5000x2500
						a.times += 1;//�Ŵ��־
						a.setPreferredSize(new Dimension(a.getPreferredSize().width*a.times/a.oldtimes,
								a.getPreferredSize().height*a.times/a.oldtimes));//���Ļ�����С����Ӧͼ���С�ı�
						a.flag = 1;//�����¼�
						a.updateUI();
					}
					
				}
				else if(e.getButton()==e.BUTTON3) {//�Ҽ������
					if(a.times != 1) {
						a.times -= 1;//�Ŵ�����Ϊ������������С
						a.setPreferredSize(new Dimension(a.getPreferredSize().width*a.times/a.oldtimes,
								a.getPreferredSize().height*a.times/a.oldtimes));//���Ļ�����С����Ӧͼ���С�ı�
						a.flag = 1;//�����¼�
						a.updateUI();
					}
				}
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {//������ƶ���������ʱ
		// TODO Auto-generated method stub
		//�˴������������ߵ�����趨�����ĳ�ʼֵ
		int se=0;int ti=a.times;
		String fo;
		int bl=0;int un=0;;int le=0;
		int fs;int si=3;
		Color fore;Color ba;
		for(int i=0;i<b.allButton.length;i++) {
			if(b.allButton[i].button.getBackground().equals(new Color(175,175,175))){
				se = i;
				break;
			}
			else {
				continue;
			}
		}
		fo = (String)t.fontBox.getSelectedItem();
		if(t.allButton[3].button.getBackground().equals(new Color(175,175,175))) {
			bl=1;
		}
		if(t.allButton[4].button.getBackground().equals(new Color(175,175,175))) {
			un=1;
		}
		if(t.allButton[5].button.getBackground().equals(new Color(175,175,175))) {
			le=1;
		}
		fs = Integer.parseInt((String)t.fontSizeBox.getSelectedItem());
		if(((String)t.sizeBox.getSelectedItem()).equals("��С")) {
			si=1;
		}
		else if(((String)t.sizeBox.getSelectedItem()).equals("С")) {
			si=3;
		}
		else if(((String)t.sizeBox.getSelectedItem()).equals("��")) {
			si=5;
		}
		else {
			si=7;
		}
		fore = t.allLabel[0].getBackground();
		ba = t.allLabel[1].getBackground();
		a.setProperty(se, ti, si, fore, ba);//���ó�ʼ����
		a.updateUI();
		HashMap<TextAttribute, Object> hm = new HashMap<TextAttribute, Object>();//�ڴ˴������ı������屸��
		if(un == 1) {
			hm.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // �������»���
		}
		if(le == 1) {
			hm.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);//������б
		}
		if(bl == 1) {
			hm.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);//���üӴ�
		}
		hm.put(TextAttribute.SIZE, fs); // �����ֺ�
		hm.put(TextAttribute.FAMILY, fo); // ����������
		text.setFont(new Font(hm));
		text.setForeground(fore);
		a.flag = 0;//�Ǵ����¼�
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
		if(a.selectButton == 11&&a.teImage != null&&a.flag==1) {//��Ϊѡ������ѡ����ɺ�
			a.gg.drawImage(a.image.getSubimage(a.temx+2, a.temy+2, a.temw-5, a.temh-5),
					2, 2, a.temw-5, a.temh-5, null);//��ȡѡ������ͼ�������ʱ����������ȡԭ������䱳��ɫ
			a.bg.setColor(a.back);
			a.bg.fillRect(a.temx+2, a.temy+2, a.temw-5, a.temh-5);
			a.flag = 0;
			a.updateUI();
			m.allMenuItem[7].setEnabled(true);
			m.allMenuItem[8].setEnabled(true);
		}
		else {
			m.allMenuItem[7].setEnabled(false);
			m.allMenuItem[8].setEnabled(false);
		}
		a.flag = 0;//�˴��ǵ���ѡ����������������������ʱ���ã����Կ��ƻ�ͼƵ��
		fram.undo.addElement(a.image);
		fram.redo.clear();
		if(!fram.undo.isEmpty()) {
			m.allMenuItem[5].setEnabled(true);
		}
		else {
			m.allMenuItem[5].setEnabled(false);
		}
	}
}