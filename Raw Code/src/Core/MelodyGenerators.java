package Core;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

public class MelodyGenerators {
	
	//erzeugt Zufallsmelodie
	public static Melody generateZufallsMelodie() throws InvalidMidiDataException, IOException {
		Melody melody = generateZufallsRhythmus();
		boolean RhythmClass = NaiveBayesRhythm.classify(melody);
		boolean PitchClass;
		GUI.Hauptframe.label.setText("Generiere Rhythmus...");
		
		System.out.println(RhythmClass);
		
		while(RhythmClass == false) {
			melody = generateZufallsRhythmus();
			RhythmClass = NaiveBayesRhythm.classify(melody);
			System.out.println("test");
		}
		
		//In melody steckt nun ein guter Rhythmus
		
		
		/*Melody melody3 = new Melody();
		for(int m = 0; m <= 31; m++) {
			melody3.MelodyArray[m] = melody.MelodyArray[m];
		}
		*/
		
		
		Melody melody2 = generateMelodyOutOfRhythm(melody);
		PitchClass = NaiveBayesPitches.classify(melody2);
		
		while(PitchClass == false) {
			melody2 = generateMelodyOutOfRhythm(melody);
			PitchClass = NaiveBayesPitches.classify(melody2);
		}
		
		
		
		//for(int i = 0; i<=31; i++) {
		//	System.out.println(melody2.MelodyArray[i]);
		//}
		return melody2;
	}
	
	//erzeugt Zufallsrhythmus
	public static Melody generateZufallsRhythmus() throws InvalidMidiDataException {
		Melody melody = new Melody();
		melody.MelodyArray[0] = 1;
		int random;
		for (int i = 1; i <= 31; i++) {
			random = Functions.getRandomPercentage();
			if(random < 50) {
				melody.MelodyArray[i] = 0;
			} else {
				melody.MelodyArray[i] = 1;
			}
			
		}
		
		return melody;
	}
	
	//wandelt Rhythmus zu Melodie um
	public static Melody generateMelodyOutOfRhythm(Melody melody1) throws InvalidMidiDataException {
		Melody melody = new Melody();
		for(int n = 0; n <= 31; n++) {
			melody.MelodyArray[n] = melody1.MelodyArray[n];
		}
		melody.MelodyArray[0] = Functions.getRandomNoteWithoutPauses();
		int last = melody.MelodyArray[0];
		int x;
		for (int i = 1; i <= 31; i++) {
			x = Functions.getRandomNoteWithoutPauses();
			
			//Im Folgenden bedeutet die 10, dass zu 5 Prozent auch Noten mit großen Sprüngen zugelassen werden
			while(!((Math.abs(last-x) <= 5)
					|| (Functions.getRandomPercentage() < 5 )
					)) {
				x = Functions.getRandomNoteWithoutPauses();
			}
			if(melody.MelodyArray[i] == 1) {
				melody.MelodyArray[i] = x;
				last = melody.MelodyArray[i];
			}
		}
		return melody;
	}
	
}
