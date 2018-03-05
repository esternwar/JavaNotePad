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
		info = new JLabel("Â path ïðîïèñûâàéòå äèñê äëÿ windows â ôîðìå: C:\\\\, äëÿ linux Ñ://");
		info1 = new JLabel("Â name ïðîñòî íàçâàíèå ôàéëà ÁÅÇ ðàñøèðåíèÿ");
		panel = new JPanel();
		panel.add(info,BorderLayout.CENTER);
		panel.add(info1);
		add(panel);
		
		}
}
