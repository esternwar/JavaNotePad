package test1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class SavePath extends JFrame{

	private JLabel pathLab;
	private JLabel nameLab;
	private JTextField path;
	private JTextField name; 
	private JButton butSave;
	public JTextArea theText;
	public String str = "";
	
	public SavePath()
	{
		super("SavePath");
		
	}
	
	public SavePath(JTextArea theText)
	{
		super("SavePath");

			initSave();
			ConstructSavePath(theText);
	}
	

	
	private void initSave() {
		pathLab = new JLabel("Path");
		nameLab = new JLabel("Name");
		path = new JTextField(10);
		name = new JTextField(10);
		butSave = new JButton("Save");
		
		JPanel panelUp = new JPanel(new FlowLayout());
		panelUp.add(pathLab);
		panelUp.add(path);
		
		JPanel panelBot = new JPanel(new FlowLayout());
		panelBot.add(nameLab);
		panelBot.add(name);
		
		add(panelUp,BorderLayout.NORTH);
		add(panelBot);
		add(butSave,BorderLayout.AFTER_LAST_LINE);
		
	}
	


	private void ConstructSavePath(JTextArea theText)
	{
		
		butSave.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
						
					   str = path.getText() + name.getText() + ".txt";
					   File fl = new File(str);
					   try {
						FileWriter wr = new FileWriter(fl);
						for(int i =0; i<theText.getText().length(); i++) {
						wr.append(theText.getText().charAt(i));
						}
						wr.close();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					dispose();
									   
				}
			});
	}
}