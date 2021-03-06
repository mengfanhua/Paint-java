//import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author ASUS
 *
 * @time 下午5:24:58
 *
 * @description 所有menu区域的集合，方便传参数
 * allMenu分别代表三个菜单，文件、编辑、帮助
 * allMenuItem前五个为文件子选项，新建、打开、保存、另存为、退出
 * 之后五个为编辑子选项，撤销、重做、复制、剪切、粘贴
 * 最后两个为帮助子选项，显示帮助、关于
 * 其中有调用文件管理器的，有调用新的dialog的，还有产生效果的
 *
 */

public class AllMenu {
	JMenu[] allMenu;
	JMenuItem[] allMenuItem;
	public AllMenu() {
		FileMenu fileMenu = new FileMenu();
		EditMenu editMenu = new EditMenu();
		HelpMenu helpMenu = new HelpMenu();
		allMenu = new JMenu[3];
		allMenuItem = new JMenuItem[12];
		allMenu[0] = fileMenu.fileMenu;
		allMenu[1] = editMenu.editMenu;
		allMenu[2] = helpMenu.helpMenu;
		allMenuItem[0] = fileMenu.newMenu;
		allMenuItem[1] = fileMenu.openMenu;
		allMenuItem[2] = fileMenu.saveMenu;
		allMenuItem[3] = fileMenu.saveAsMenu;
		allMenuItem[4] = fileMenu.exitMenu;
		allMenuItem[5] = editMenu.undoMenu;
		allMenuItem[6] = editMenu.redoMenu;
		allMenuItem[7] = editMenu.copyMenu;
		allMenuItem[8] = editMenu.cutMenu;
		allMenuItem[9] = editMenu.pasteMenu;
		allMenuItem[10] = helpMenu.showHelpMenu;
		allMenuItem[11] = helpMenu.aboutMenu;
	}
}
