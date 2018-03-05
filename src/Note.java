package test1;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Note extends JFrame{
	
	  MenuBar menuBar = new MenuBar();
	  private MenuItem menuOpen;
	  private MenuItem menuSave;
	  private MenuItem menuExit;
	  private MenuItem menuAbout;
	  public JTextArea theText;

	  
	public Note()
	{
		super("Note");
		initMenu();
		initMenuPanel();
		initListener();
	}
	
	private void initMenu() {
		
		PopupMenu file = new PopupMenu("File");
		PopupMenu about = new PopupMenu("About");
		
		menuOpen = new 	MenuItem("Open");
		menuSave = new 	MenuItem("Save");
		menuExit = new 	MenuItem("Exit");
		menuAbout = new MenuItem("About");
		
		file.add(menuOpen);
		file.add(menuSave);
		file.add(menuExit);
		
		about.add(menuAbout);
		
		menuBar.add(file);
		menuBar.add(about);
		this.setMenuBar(menuBar);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initMenuPanel(){
		JPanel panel = new JPanel(new BorderLayout());
		theText = new JTextArea();
		panel.add(new JScrollPane(theText),BorderLayout.CENTER);
		getContentPane().add(panel);
	}
	
	private void initListener() {
	    this.addWindowListener(new WindowAdapter(){
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    
	    menuExit.addActionListener(new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent e) {
	    				System.exit(0);
	    			}
	    		});
	    
	    menuOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				OpenPath open = new OpenPath();
				open.setVisible(true);
				open.pack();
				}
			});
	    
	    menuSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				SavePath cl = new SavePath(theText);
				cl.setVisible(true);
				cl.pack();
				
				//System.out.println(cl.writeText().getText());
			}
		});
	    
	    menuAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				About a = new About();
				a.setBounds(300,300, 400,100);
				a.setVisible(true);
				
			}
		});
	    }
	
	class OpenPath extends JFrame{

		private JLabel pathLab;
		private JLabel nameLab;
		private JTextField path;
		private JTextField name; 
		private JButton butOpen;
		public JTextArea theText;
		public String str = "";
		
		
		public OpenPath()
		{
			super("OpenPath");
				initOpen();
				ConstructOpenPath();

		}
		
		private void initOpen() {
			pathLab = new JLabel("Path");
			nameLab = new JLabel("Name");
			path = new JTextField(10);
			name = new JTextField(10);
			butOpen = new JButton("Open");
			theText = new JTextArea();
			
			JPanel panelUp = new JPanel(new FlowLayout());
			panelUp.add(pathLab);
			panelUp.add(path);
			
			JPanel panelBot = new JPanel(new FlowLayout());
			panelBot.add(nameLab);
			panelBot.add(name);
			
			add(panelUp,BorderLayout.NORTH);
			add(panelBot);
			add(butOpen,BorderLayout.AFTER_LAST_LINE);
		}
		
		public void ConstructOpenPath()
		{
			butOpen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Note.this.theText.setText("");
				str = path.getText() + name.getText() + ".txt";
				 try(FileReader reader = new FileReader(str))
			        {
			            int c;
			            while((c=reader.read())!=-1){
			            	Note.this.theText.append(""+(char)c);
			            } 
			        }
			        catch(IOException ex){
			             
			            System.out.println(ex.getMessage());
			        }
				 dispose();
				}
			
			});
		}
	}
}

