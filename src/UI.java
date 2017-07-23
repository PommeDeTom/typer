import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.Border;

public class UI implements KeyListener{
	private JFrame mainFrame;
	private JPanel scorePanel;
	private JLabel wordLabel;
	private JLabel inputLabel;
	private JLabel timeLabel;
	private JLabel numDoneLabel;
	private JLabel avgTimeLabel;
	private String inputString = "";
	private String wordString = "";
	
	private double time = 0.0;


	private double avgTime = 0.0;
	private int numDone = 0;

	
	public UI(){
		mainFrame = new JFrame("Typer");
		mainFrame.setSize(600, 800);
		mainFrame.setLocationByPlatform(true);
		mainFrame.setLayout(new GridLayout(3,1));
		
		scorePanel = new JPanel(new GridLayout(3,1));
		
		wordLabel = new JLabel("",JLabel.CENTER);
		wordLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));

		inputLabel = new JLabel("",JLabel.CENTER);
		inputLabel.setFont(new Font("Courier New", Font.PLAIN, 36));
		
		timeLabel = new JLabel("Time elapsed: ",JLabel.LEFT);
		timeLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		
		numDoneLabel = new JLabel("Words typed: ",JLabel.LEFT);
		numDoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		
		avgTimeLabel = new JLabel("Avg time per word: ",JLabel.LEFT);
		avgTimeLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		
		
		mainFrame.addKeyListener(this);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}      
		});

		mainFrame.add(wordLabel);
		mainFrame.add(inputLabel);
		scorePanel.add(avgTimeLabel);
		scorePanel.add(numDoneLabel);
		scorePanel.add(timeLabel);
		mainFrame.add(scorePanel);
		mainFrame.setVisible(true); 
	}

	//TODO Get rid of the strings and just make get and set to the label
	public void setInputString(String input){
		this.inputString = input;
		inputLabel.setText(this.inputString);
	}
	
	public String getInputString(){
		return this.inputString;
	}
	
	public void setWordString(String word){
		this.wordString = word;
		this.wordLabel.setText(this.wordString);
	}
	
	public String getWordString(){
		return this.wordString;
	}

	public void updateTime(double time) {
		DecimalFormat df = new DecimalFormat("#.##");
		this.time = time;
		timeLabel.setText("Time elapsed: " + df.format((this.time)));
	}

	public void updateStats() {
		this.numDone += 1;
		this.avgTime = this.time/this.numDone;
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		numDoneLabel.setText("Words typed: " + String.valueOf(numDone));
		avgTimeLabel.setText("Avg time per word: " + df.format((this.avgTime)));
	}


	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE){
			if(inputString.length()>0){
				setInputString(inputString.substring(0, inputString.length()-1));
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent k) {
		

	}


	@Override
	public void keyTyped(KeyEvent k) {
		if((int)k.getKeyChar() != 8){
			setInputString(inputString += (k.getKeyChar()));
		}
	}

}
