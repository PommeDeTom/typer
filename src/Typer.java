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
		
        try (BufferedReader br = new BufferedReader(new FileReader("src/WotW")))
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
				//TODO verify this includes first and last ints
				randNum = rand.nextInt(words.size());
				//Check not the same index as previous
				if(randNum != i){
					i = randNum;
				}
				word = words.get(i);
				ui.setWordString(word);
				
				
			}
			
			input = ui.getInputString();
			//System.out.println(input + " --- " + word);
			ui.updateTime(((System.currentTimeMillis()-timer)/1000));
		}
	}

	public static void main(String[] args) {
		Typer typer = new Typer();
	}

}
