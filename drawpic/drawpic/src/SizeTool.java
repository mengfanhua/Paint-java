//import java.awt.*;
import javax.swing.*;

public class SizeTool {
	JLabel sizeLabel;
	JComboBox<String> sizeTool;
	public SizeTool() {
		sizeTool = new JComboBox<String>();//����һ����ª��ѡ���С��������
		sizeTool.addItem("��С");
		sizeTool.addItem("С");
		sizeTool.addItem("��");
		sizeTool.addItem("���");
		sizeTool.setSelectedIndex(1);
		sizeLabel = new JLabel("���ʴ�С:",JLabel.CENTER);
		sizeLabel.setOpaque(true);
	}
}