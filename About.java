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
		info = new JLabel("� path ������������ ���� ��� windows � �����: C:\\\\, ��� linux �://");
		info1 = new JLabel("� name ������ �������� ����� ��� ����������");
		panel = new JPanel();
		panel.add(info,BorderLayout.CENTER);
		panel.add(info1);
		add(panel);
		
		}
}
