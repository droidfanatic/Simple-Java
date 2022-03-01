import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class Piano extends JFrame{
	
	//main that calls display function
	public static void main(String[] args) {
		display();
	}
	
	//creates window and calls other functions based on button clicked
	public static void display() {
		//creates main menu
		JFrame frame = new JFrame();
		
		//set title of main menu
		frame.setTitle("Desktop Piano Menu");
		//sets size of window
		frame.setPreferredSize(new Dimension(500, 500));
        
		//create buttons to click
        JButton playButton = new JButton("Play");
        JButton helpButton = new JButton("Help");
        JButton creditButton = new JButton("Credits");
        
        //sets size and location of buttons
        playButton.setBounds(200,250,100,50);
        helpButton.setBounds(200,310,100,50);
        creditButton.setBounds(200,370,100,50);
        
        //listeners to detect when button is clicked
        playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		playDisplay();
        	}
        });
        helpButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		helpDisplay();
        	}
        });
        creditButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		creditDisplay();
        	}
        });
        
        //add main menu logo to screen
        ImageIcon logo = new ImageIcon("logo.jpg");
        JLabel homeLogo = new JLabel(logo);
        homeLogo.setBounds(0, 0, 500, 240);
        
        //sets background to white
        JPanel homePage = new JPanel();
        homePage.setBounds(0, 0, 500, 500);
        homePage.setBackground(Color.white);
        
        //adds all labels and buttons to frame
        frame.getContentPane().add(playButton);
        frame.getContentPane().add(helpButton);
        frame.getContentPane().add(creditButton);
        frame.getContentPane().add(homeLogo);
        frame.getContentPane().add(homePage);
        
        frame.setLayout(null);
        frame.pack();
        //sets to the middle of screen
        frame.setLocationRelativeTo(null);
        //displays window
        frame.setVisible(true);
        //window can't be resized
        frame.setResizable(false);
        //ends program on closure
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//creates piano window window funcation is called
	public static void playDisplay() {
		//create window
		JFrame playFrame = new JFrame();
		
		//sets name of window
		playFrame.setTitle("Desktop Piano");
		//sets size of window
		playFrame.setPreferredSize(new Dimension(495, 415));
		
		//displays picture of piano
		ImageIcon keys = new ImageIcon("piano_keys.jpg");
        JLabel pianoKeys = new JLabel(keys);
        pianoKeys.setBounds(-315, -5, 1500, 405);
		
        //add piano to playframe
		playFrame.getContentPane().add(pianoKeys);
		
		//checks for mouse click in window
		playFrame.addMouseListener(new MouseListener() {
		    @Override
		    //retrieves coordinates of mouse click and calls playSound function
		    public void mouseClicked(MouseEvent e) {
		    	int x=e.getX();
		        int y=e.getY();
		        playSound(x,y);
		    }

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
		playFrame.setLayout(null);
		playFrame.pack();
		//sets to the middle of screen
		playFrame.setLocationRelativeTo(null);
		//displays window
		playFrame.setVisible(true);
		//window can't be resized
		playFrame.setResizable(false);
		//window closes and nothing else happens
		playFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void helpDisplay() {
		//create window
		JFrame helpFrame = new JFrame();
		
		//sets text on label
		String helpText = "<html><h1 align = 'center'><font style = "
				+ "\"font-size: 48pt;\">Help</h1>";
		helpText += "<h1 align = 'center'><font style = \"font-size: 24pt;\">";
		helpText += "Clicking different keys on the piano will<br />";
		helpText += "produce different sounds.<br />";
		
		//sets name of window
		helpFrame.setTitle("Desktop Piano Help");
		//sets size of window
		helpFrame.setPreferredSize(new Dimension(500, 250));
		
		//sets background to white
		JPanel pageBackground = new JPanel();
		pageBackground.setBounds(0, 0, 500, 500);
		pageBackground.setBackground(Color.white);
		
		//create label
		JLabel helpLabel = new JLabel();
		helpLabel.setText(helpText);
		helpLabel.setBounds(15, 0, 500, 250);
		
		//adds label to helpframe
		helpFrame.getContentPane().add(helpLabel);
		helpFrame.getContentPane().add(pageBackground);
		
		helpFrame.setLayout(null);
		helpFrame.pack();
		//sets to the middle of screen
		helpFrame.setLocationRelativeTo(null);
		//displays window
		helpFrame.setVisible(true);
		//window can't be resized
		helpFrame.setResizable(false);
		//window closes and nothing else happens
		helpFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void creditDisplay() {
		//create window
		JFrame creditFrame = new JFrame();
		
		//sets text on label
		String creditText = "<html><h1 align = 'center'><font style = "
				+ "\"font-size: 48pt;\">Credits</h1>";
		creditText +="<h1 align = 'center'><font style = \"font-size: 24pt;\">";
		creditText += "This program was created by Daycee<br />";
		creditText += "Duncen for CLP in Fall 2019.<br />";
		creditText += "Pictures from google images.<br />";
		creditText += "Sounds from freesound.org.<br />";
		
		//sets name of window
		creditFrame.setTitle("Desktop Piano Credits");
		//sets size of window
		creditFrame.setPreferredSize(new Dimension(500, 250));
		
		//sets background to white
		JPanel pageBackground = new JPanel();
		pageBackground.setBounds(0, 0, 500, 500);
		pageBackground.setBackground(Color.white);
		
		//create label
		JLabel creditLabel = new JLabel();
		creditLabel.setText(creditText);
		creditLabel.setBounds(30, 0, 500, 250);

		//adds label to creditframe
		creditFrame.getContentPane().add(creditLabel);
		creditFrame.getContentPane().add(pageBackground);
		
		creditFrame.setLayout(null);
		creditFrame.pack();
		//sets to the middle of screen
		creditFrame.setLocationRelativeTo(null);
		//displays window
		creditFrame.setVisible(true);
		//window can't be resized
		creditFrame.setResizable(false);
		//window closes and nothing else happens
		creditFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void playSound(int x, int y) {
		//if y coord is on the lower half
		if(y >= 307) {
			//checks x coord for key location on the bottom
			if(x <= 100) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("2-a.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 170) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("4-b.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 237) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("5-c.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 307) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("7-d.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 372) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("9-e.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 442) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("10-f.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("12-g.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
		}
		//if y coord is on the upper half
		else {
			//checks x coord for key location on the bottom
			if(x <= 60) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("1-af.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 75) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("2-a.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 125) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("3-bf.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 170) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("4-b.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 213) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("5-c.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 260) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("6-df.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 280) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("7-d.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 330) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("8-ef.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 372) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("9-e.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 417) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("10-f.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else if(x <= 467) {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("11-gf.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
			else {
				try {
					//creates audioInputStream using .wav file
					AudioInputStream audioInputStream = 
							AudioSystem.getAudioInputStream(
									new File("12-g.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				}
				catch(Exception ex) {}
			}
		}
	}

}
