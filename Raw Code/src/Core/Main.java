package Core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

import GUI.Hauptframe;

public class Main {

	public static void main(String[] args) throws InvalidMidiDataException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Programm wurde gestartet.");
		Functions.Key = 1;
		
		
		Hauptframe hauptmenu = new Hauptframe();
		hauptmenu.start();
		NaiveBayesAttributes.refreshNaiveBayesAttributes();
		GUI.Hauptframe.label.setText("Datenbank initialisiert. Es kann losgehen!");
		
		
		
		Melody y = Test.generateAlleMeineEntchen();
		
		
		//Die folgenden auskommentierten Bereiche sind Testbausteine und für die finale Funktion irrelevant
		
		/*
		for(int i = 0; i <= 2000; i++) {
			y = Test.generateZufallsMelodie();
			Database.database.persistMelody(y, false);
		}
		*/
		
		/*
		Melody melodie1 = Test.generateZufallsMelodie();
		
		
		boolean testbo = NaiveBayes.classify(melodie1);
		
		int x = 1;
		
		while (testbo == false) {
			
			melodie1 = Test.generateZufallsMelodie();
			
			
			 testbo = NaiveBayes.classify(melodie1);
			
			 System.out.println(x);
			x++;
			
		}
		if (testbo == true) {
			System.out.println("Das war eine gute Melodie");
		} 
		
		if (testbo == false) {
			System.out.println("Das war eine schlechte Melodie");
		} 
		
		*/
		/*
		NaiveBayesAttributes.refreshNaiveBayesAttributes();
		int x = NaiveBayesAttributes.NumberBadAndFeature11;
		System.out.println(x);
		*/
		
		/*
		int x = Database.ReadFunctions.getNumberOfAllMelodies();
		System.out.println(x);
		*/
		
		/*
		int x = Database.ReadFunctions.getFeatureAndClassificationCount(8, 1);
		System.out.println(x);
		*/
		
		/*
		int x = Database.ReadFunctions.getNumberOfGoodMelodies();
		System.out.println("Anzahl guter Melodien: " + x);
		x = Database.ReadFunctions.getNumberOfBadMelodies();
		System.out.println("Anzahl schlechter Melodien: " + x);
		*/
		
		/*
		for(int y = 0; y <= 500; y++) {
		melodie1 = Test.generateZufallsMelodie();
		Database.database.persistMelody(melodie1, true);
		}
		*/
		
		//melodie1 = Test.generateKids();
		//Database.database.persistMelody(melodie1, true);
		
		/*
		Melody melodie1 = new Melody();
		melodie1 = Test.generateAlleMeineEntchen();
		Test.printFeatureValues(melodie1);
		*/
		
		/*
		double test = 0;
		double test2 = 0;
		melodie1 = Test.generateZufallsMelodie();
		test = Features.feature19(melodie1);
		test2 = Features.feature20(melodie1);
		int z = 0;
		
		
		
		
		while(test < 0.5 || test2 < 0.5) {
		melodie1 = Test.generateZufallsMelodie();
		test = Features.feature19(melodie1);
		test2 = Features.feature20(melodie1);
		System.out.println(z);
		
	
		z++;
		}
		*/
		

		
		/*
		ResultSet rs = Database.database.readAllMelodies();
		try {
			while(rs.next()) {
				int y;
				y = rs.getInt("note0");
				System.out.println("database-read" + y);
			}
		} catch (Exception e) {}
		*/
		/*
		melodie1.buildMidi();
		Database.database.persistMelody(melodie1, false);
		*/
	}

}
