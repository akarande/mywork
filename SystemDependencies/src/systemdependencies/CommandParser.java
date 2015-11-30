package systemdependencies;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandParser {

	String line;
	BufferedReader reader;
	OperationsImpl operation = new OperationsImpl();
	
	public void readInput(String filename) throws FileNotFoundException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		List<String>lines = new ArrayList<String>();
		try {
			while((line = reader.readLine())!=null) {
				lines.add(line);
			}
			readInput(lines);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readInput(List<String> inputLines) {
		for(String line : inputLines) {
			processInput(line);
		}
	}
	
	public void processInput(String line) {
		String eachWord[] = line.split("\\s+");
		int currentLength = eachWord.length;
		if(eachWord[0].equals("DEPEND")) {
			for(int i = currentLength-1; i-1 > 0; i--) {
				operation.depend(eachWord[i-1], eachWord[i]);
			}
		} else if(eachWord[0].equals("INSTALL")) {
			operation.install(eachWord[1]);
		} else if(eachWord[0].equals("REMOVE")) {
			operation.remove(eachWord[1]);
		} else if(eachWord[0].equals("LIST")) {
			operation.list();
		} else if(eachWord[0].equals("END")) {
			operation.end();
		} else {
			System.out.println("Invalid input command");
		}
	}
}
