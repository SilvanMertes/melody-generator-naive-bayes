package Core;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Functions {
	public static int Key;
	
	
	//Wandelt eine Stufe in einen Midi-Pitch-Wert um
	public static int getPitchValue(int stufe) {
		
		//Key = 1 bedeutet C-Dur
		if(Key == 1) {
			switch(stufe) {
			case 1: return 60; //c
			case 2: return 62; //d
			case 3: return 64; //e 
			case 4: return 65; //f
			case 5: return 67; //g
			case 6: return 69; //a
			case 7: return 71; //h
			case 8: return 72; //c
			case 9: return 74; //d
			case 10: return 76; //e
			case 11: return 77; //f
			case 12: return 79; //g
			case 13: return 81; //a
			case 14: return 83; //h
			default: return 0;
			}
		}
		return 0;	
	}
	
	public static void saveSequence(Sequence sequence, String filename) throws IOException {
		File file = new File(filename);
		MidiSystem.write(sequence,0, file);
		
	}
	
	public static int getRandomNote() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 14 + 1);
		//System.out.println("Randomnummer ist" + randomNum);
		return randomNum;
	}
	
	public static int getRandomNoteWithoutPauses() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 14 + 1);
		//System.out.println("Randomnummer ist" + randomNum);
		return randomNum;
	}
	
	public static int getRandomPercentage() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		//System.out.println("RandomnummerPERCENTAGE ist" + randomNum);
		return randomNum;
	}
	
	public static int anzahlToene(Melody melody){
		int anzahlToene = 0;
		
		for(int i = 0; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				anzahlToene++;
			}
		}	
		return anzahlToene;		
	}
	
	public static int berechneNotenlaengeAnIndex(Melody melody, int i) {
		int count = 1;
		int j = i+1;
		while(j <= 31 && (melody.MelodyArray[j] == 0)) {
			count++;
			j++;
		}
		return count;
	}
	
	//Merkmals-Satz wird berechnet
	public static ValueSet calculateValueSet(Melody focusMelody) throws InvalidMidiDataException, IOException {
		
		ValueSet valueSet = new ValueSet();
		if(Features.feature1(focusMelody) >= FeatureThresholds.thresholdFeature1) {
			valueSet.feature[1] = 1;
		}
		if(Features.feature2(focusMelody) >= FeatureThresholds.thresholdFeature2) {
			valueSet.feature[2] = 1;
		}
		if(Features.feature3(focusMelody) >= FeatureThresholds.thresholdFeature3) {
			valueSet.feature[3] = 1;
		}
		if(Features.feature4(focusMelody) >= FeatureThresholds.thresholdFeature4) {
			valueSet.feature[4] = 1;
		}
		if(Features.feature7(focusMelody) >= FeatureThresholds.thresholdFeature7) {
			valueSet.feature[7] = 1;
		}
		if(Features.feature8(focusMelody) >= FeatureThresholds.thresholdFeature8) {
			valueSet.feature[8] = 1;
		}
		if(Features.feature9(focusMelody) >= FeatureThresholds.thresholdFeature9) {
			valueSet.feature[9] = 1;
		}
		if(Features.feature11(focusMelody) >= FeatureThresholds.thresholdFeature11) {
			valueSet.feature[11] = 1;
		}
		if(Features.feature12(focusMelody) >= FeatureThresholds.thresholdFeature12) {
			valueSet.feature[12] = 1;
		}
		if(Features.feature13(focusMelody) >= FeatureThresholds.thresholdFeature13) {
			valueSet.feature[13] = 1;
		}
		if(Features.feature14(focusMelody) >= FeatureThresholds.thresholdFeature14) {
			valueSet.feature[14] = 1;
		}
		if(Features.feature15(focusMelody) >= FeatureThresholds.thresholdFeature15) {
			valueSet.feature[15] = 1;
		}
		if(Features.feature16(focusMelody) >= FeatureThresholds.thresholdFeature16) {
			valueSet.feature[16] = 1;
		}
		if(Features.feature17(focusMelody) >= FeatureThresholds.thresholdFeature17) {
			valueSet.feature[17] = 1;
		}
		if(Features.feature19(focusMelody) >= FeatureThresholds.thresholdFeature19) {
			valueSet.feature[19] = 1;
		}
		if(Features.feature20(focusMelody) >= FeatureThresholds.thresholdFeature20) {
			valueSet.feature[20] = 1;
		}
		if(Features.feature23(focusMelody) >= FeatureThresholds.thresholdFeature23) {
			valueSet.feature[23] = 1;
		}
		if(Features.feature24(focusMelody) >= FeatureThresholds.thresholdFeature24) {
			valueSet.feature[24] = 1;
		}
		if(Features.feature25(focusMelody) >= FeatureThresholds.thresholdFeature25) {
			valueSet.feature[25] = 1;
		}
		if(Features.feature26(focusMelody) >= FeatureThresholds.thresholdFeature26) {
			valueSet.feature[26] = 1;
		}
		if(Features.feature27(focusMelody) >= FeatureThresholds.thresholdFeature27) {
			valueSet.feature[27] = 1;
		}
		if(Features.feature28(focusMelody) >= FeatureThresholds.thresholdFeature28) {
			valueSet.feature[28] = 1;
		}
		if(Features.feature29(focusMelody) >= FeatureThresholds.thresholdFeature29) {
			valueSet.feature[29] = 1;
		}
		if(Features.feature30(focusMelody) >= FeatureThresholds.thresholdFeature30) {
			valueSet.feature[30] = 1;
		}
		if(Features.feature31(focusMelody) >= FeatureThresholds.thresholdFeature31) {
			valueSet.feature[31] = 1;
		}
		if(Features.feature32(focusMelody) >= FeatureThresholds.thresholdFeature32) {
			valueSet.feature[32] = 1;
		}
		if(Features.feature33(focusMelody) >= FeatureThresholds.thresholdFeature33) {
			valueSet.feature[33] = 1;
		}
		if(Features.feature35(focusMelody) >= FeatureThresholds.thresholdFeature35) {
			valueSet.feature[35] = 1;
		}
		if(Features.feature39(focusMelody) >= FeatureThresholds.thresholdFeature39) {
			valueSet.feature[39] = 1;
		}
		
		return valueSet;
		
	}

	 
}
