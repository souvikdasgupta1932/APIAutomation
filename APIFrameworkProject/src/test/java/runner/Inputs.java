package runner;

import java.io.*;
import java.util.Properties;

public class Inputs {

	public static FileReader reader= null;
	public static String PetEndpoint = null;
	public static String TotalPets = null;
	public static String NewPetPostPath = null;
	public static String TempFilePath = null;
	
	public static void inputs() throws IOException {
		
		reader = new FileReader("./src/main/resources/config.properties");
		Properties p = new Properties();
		p.load(reader);
		PetEndpoint = p.getProperty("PetEndpoint");
		TotalPets = p.getProperty("TotalPets");
		NewPetPostPath = p.getProperty("NewPetPostPath");
		TempFilePath = p.getProperty("TempFilePath");
		
	}
	
	

}
