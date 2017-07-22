import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class UI implements KeyListener{
	private JFrame mainFrame;
	private JLabel wordLabel;
	private JLabel inputLabel;
	private String inputString = "";
	private String wordString = "";

	
	public UI(){
		mainFrame = new JFrame("Typer");
		mainFrame.setSize(600, 800);
		mainFrame.setLocationByPlatform(true);
		mainFrame.setLayout(new GridLayout(4,1));
		
		wordLabel = new JLabel("",JLabel.CENTER);
		wordLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		inputLabel = new JLabel("",JLabel.CENTER);
		inputLabel.setFont(new Font("Courier New", Font.PLAIN, 36));
		
		mainFrame.addKeyListener(this);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}      
		});
		
		mainFrame.add(wordLabel);
		mainFrame.add(inputLabel);
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
