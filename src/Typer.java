import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Typer {
	
	private UI ui;
	private String word = "";
	private String input = "";
	private ArrayList<String> words = new ArrayList<String>();
	int i = 0;
	
	public Typer(){
		this.ui = new UI();
		
        try (BufferedReader br = new BufferedReader(new FileReader("src/nouns.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                words.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/adjectives.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                words.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/verbs.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                words.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
		Random rand = new Random();
		int randNum = rand.nextInt(words.size());
		word = words.get(randNum);
		ui.setWordString(word);
		double timer = System.currentTimeMillis();
		DecimalFormat df = new DecimalFormat("#.##");
		
		while(true){

			if(word.equals(input)){
				ui.updateStats();
				ui.setInputString("");
				
				randNum = rand.nextInt(words.size());
				//Check not the same index as previous
				if(randNum != i){
					i = randNum;
				}
				word = words.get(i);
				ui.setWordString(word);
				
				
			}
			
			input = ui.getInputString();
			ui.updateTime(((System.currentTimeMillis()-timer)/1000));
		}
	}

	public static void main(String[] args) {
		Typer typer = new Typer();
	}

}
