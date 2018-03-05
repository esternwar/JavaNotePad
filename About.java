package test1;
import java.awt.*;
import javax.swing.*;

public class About extends JFrame {
	private JLabel info;
	private JLabel info1;
	private JPanel panel;
	
	public About()
	{
		super();
		info = new JLabel("В path прописывайте диск для windows в форме: C:\\\\, для linux С://");
		info1 = new JLabel("В name просто название файла БЕЗ расширения");
		panel = new JPanel();
		panel.add(info,BorderLayout.CENTER);
		panel.add(info1);
		add(panel);
		
		}
}
