package Core;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;


//verschiedene Testfunktionen
public class Test {
	public static Melody generateAlleMeineEntchen() throws InvalidMidiDataException{
		Melody melodie1 = new Melody();

		melodie1.MelodyArray[0]=1; //c
		melodie1.MelodyArray[1]=2; //d
		melodie1.MelodyArray[2]=3; //e
		melodie1.MelodyArray[3]=4; //f
		
		melodie1.MelodyArray[4]=5; //g
		melodie1.MelodyArray[5]=0;
		melodie1.MelodyArray[6]=5; //g
		melodie1.MelodyArray[7]=0;
		
		
		melodie1.MelodyArray[8]=6;	//a	
		melodie1.MelodyArray[9]=6;  //a
		melodie1.MelodyArray[10]=6; //a
		melodie1.MelodyArray[11]=6; //a
		
		melodie1.MelodyArray[12]=5; //g
		melodie1.MelodyArray[13]=0;  
		melodie1.MelodyArray[14]=0;
		melodie1.MelodyArray[15]=0;
		
		
		melodie1.MelodyArray[16]=6;	//a	
		melodie1.MelodyArray[17]=6; //a
		melodie1.MelodyArray[18]=6; //a
		melodie1.MelodyArray[19]=6; //a
		
		melodie1.MelodyArray[20]=5; //g
		melodie1.MelodyArray[21]=0;
		melodie1.MelodyArray[22]=0;
		melodie1.MelodyArray[23]=0;
		
		
		melodie1.MelodyArray[24]=4; //f
		melodie1.MelodyArray[25]=4; //f
		melodie1.MelodyArray[26]=4; //f
		melodie1.MelodyArray[27]=4; //f
		
		melodie1.MelodyArray[28]=3; //e
		melodie1.MelodyArray[29]=0; 
		melodie1.MelodyArray[30]=3; //e
		melodie1.MelodyArray[31]=0;
		
		return melodie1;
		
		
	}
	
	public static Melody generateKids() throws InvalidMidiDataException{
		Melody melodie1 = new Melody();

		melodie1.MelodyArray[0]=1; //c
		melodie1.MelodyArray[1]=0; //
		melodie1.MelodyArray[2]=2; //d
		melodie1.MelodyArray[3]=0; //
		
		melodie1.MelodyArray[4]=3; //e
		melodie1.MelodyArray[5]=0;
		melodie1.MelodyArray[6]=5; //g
		melodie1.MelodyArray[7]=0;
		
		
		melodie1.MelodyArray[8]=6;	//a	
		melodie1.MelodyArray[9]=0;  //
		melodie1.MelodyArray[10]=7; //h
		melodie1.MelodyArray[11]=6; //a
		
		melodie1.MelodyArray[12]=0; //
		melodie1.MelodyArray[13]=5;  //g
		melodie1.MelodyArray[14]=0;
		melodie1.MelodyArray[15]=3; //e
		
		
		melodie1.MelodyArray[16]=0;	//
		melodie1.MelodyArray[17]=0; //
		melodie1.MelodyArray[18]=0; //
		melodie1.MelodyArray[19]=0; //
		
		melodie1.MelodyArray[20]=0; //
		melodie1.MelodyArray[21]=0; //
		melodie1.MelodyArray[22]=0; //
		melodie1.MelodyArray[23]=0; //
		
		
		melodie1.MelodyArray[24]=2; //d
		melodie1.MelodyArray[25]=0; //
		melodie1.MelodyArray[26]=0; //
		melodie1.MelodyArray[27]=0; //
		
		melodie1.MelodyArray[28]=0; //
		melodie1.MelodyArray[29]=0; 
		melodie1.MelodyArray[30]=0; //
		melodie1.MelodyArray[31]=0;
		
		return melodie1;
	}
	
	public static Melody generateZufallsMelodie() throws InvalidMidiDataException{
		Melody melodie1 = new Melody();
		for(int n = 0; n <= 31; n++) {
			int x = Functions.getRandomNote();
			if(n > 0) {
				while(Math.abs(melodie1.MelodyArray[n-1]-x) > 5 ){
					
					if(Functions.getRandomPercentage() > 100){break;}
					x = Functions.getRandomNote();
				}
			}
			melodie1.MelodyArray[n] = x;
			//System.out.println(x);
			
		}
		return melodie1;
	}
	
	public static Melody generateTestMelodie() throws InvalidMidiDataException{
		Melody melodie1 = new Melody();

		melodie1.MelodyArray[0]=1; //Am
		melodie1.MelodyArray[1]=0; 
		melodie1.MelodyArray[2]=0; 
		melodie1.MelodyArray[3]=0; 
		
		melodie1.MelodyArray[4]=0; 
		melodie1.MelodyArray[5]=0;
		melodie1.MelodyArray[6]=0; 
		melodie1.MelodyArray[7]=2;
		
		
		melodie1.MelodyArray[8]=0;	//F
		melodie1.MelodyArray[9]=0;  
		melodie1.MelodyArray[10]=0; 
		melodie1.MelodyArray[11]=0; 
		
		melodie1.MelodyArray[12]=6; 
		melodie1.MelodyArray[13]=1;  
		melodie1.MelodyArray[14]=0;
		melodie1.MelodyArray[15]=2;
		
		
		melodie1.MelodyArray[16]=1;	//C
		melodie1.MelodyArray[17]=0; 
		melodie1.MelodyArray[18]=0; 
		melodie1.MelodyArray[19]=0; 
		
		melodie1.MelodyArray[20]=5; 
		melodie1.MelodyArray[21]=0;
		melodie1.MelodyArray[22]=0;
		melodie1.MelodyArray[23]=0;
		
		
		melodie1.MelodyArray[24]=4; //G
		melodie1.MelodyArray[25]=0; 
		melodie1.MelodyArray[26]=0; 
		melodie1.MelodyArray[27]=0; 
		
		melodie1.MelodyArray[28]=3; 
		melodie1.MelodyArray[29]=0; 
		melodie1.MelodyArray[30]=0; 
		melodie1.MelodyArray[31]=0;
		
		return melodie1;
	}
	
	public static void printFeatureValues(Melody melodie1) throws InvalidMidiDataException, IOException {
		double feature1;
		double feature2;
		double feature3;
		double feature4;
		double feature7;
		double feature8;
		double feature9;
		double feature11;
		double feature12;
		double feature13;
		double feature14;
		double feature15;
		double feature16;
		double feature17;
		double feature19;
		double feature20;
		double feature23;
		double feature24;
		double feature25;
		double feature26;
		double feature27;
		double feature28;
		double feature29;
		double feature30;
		double feature31;
		double feature32;
		double feature33;
		double feature35;
		double feature39;
		
System.out.println("Melodie1 Anzahl Töne: " + Functions.anzahlToene(melodie1));
		
		feature1 = Features.feature1(melodie1);
		System.out.println("Melodie1 Feature 1: " + feature1);
		
		
		feature2 = Features.feature2(melodie1);
		System.out.println("Melodie1 Feature 2: " + feature2);
		
		
		feature3 = Features.feature3(melodie1);
		System.out.println("Melodie1 Feature 3: " + feature3);
		
		
		feature4 = Features.feature4(melodie1);
		System.out.println("Melodie1 Feature 4: " + feature4);
		
		
		feature7 = Features.feature7(melodie1);
		System.out.println("Melodie1 Feature 7: " + feature7);
		
		feature8 = Features.feature8(melodie1);
		System.out.println("Melodie1 Feature 8: " + feature8);
		
		feature9 = Features.feature9(melodie1);
		System.out.println("Melodie1 Feature 9: " + feature9);
		
		feature11 = Features.feature11(melodie1);
		System.out.println("Melodie1 Feature 11: " + feature11);
		
		feature12 = Features.feature12(melodie1);
		System.out.println("Melodie1 Feature 12: " + feature12);
		
		feature13 = Features.feature13(melodie1);
		System.out.println("Melodie1 Feature 13: " + feature13);
		
		feature14 = Features.feature14(melodie1);
		System.out.println("Melodie1 Feature 14: " + feature14);
		
		feature15 = Features.feature15(melodie1);
		System.out.println("Melodie1 Feature 15: " + feature15);
		
		feature16 = Features.feature16(melodie1);
		System.out.println("Melodie1 Feature 16: " + feature16);
		
		feature17 = Features.feature17(melodie1);
		System.out.println("Melodie1 Feature 17: " + feature17);
		
		feature19 = Features.feature19(melodie1);
		System.out.println("Melodie1 Feature 19: " + feature19);
		
		feature20 = Features.feature20(melodie1);
		System.out.println("Melodie1 Feature 20: " + feature20);
		
		feature23 = Features.feature23(melodie1);
		System.out.println("Melodie1 Feature 23: " + feature23);
		
		feature24 = Features.feature24(melodie1);
		System.out.println("Melodie1 Feature 24: " + feature24);
		
		feature25 = Features.feature25(melodie1);
		System.out.println("Melodie1 Feature 25: " + feature25);
		
		feature26 = Features.feature26(melodie1);
		System.out.println("Melodie1 Feature 26: " + feature26);
		
		feature27 = Features.feature27(melodie1);
		System.out.println("Melodie1 Feature 27: " + feature27);
		
		feature28 = Features.feature28(melodie1);
		System.out.println("Melodie1 Feature 28: " + feature28);
		
		feature29 = Features.feature29(melodie1);
		System.out.println("Melodie1 Feature 29: " + feature29);
		
		feature30 = Features.feature30(melodie1);
		System.out.println("Melodie1 Feature 30: " + feature30);
		
		feature31 = Features.feature31(melodie1);
		System.out.println("Melodie1 Feature 31: " + feature31);
		
		feature32 = Features.feature32(melodie1);
		System.out.println("Melodie1 Feature 32: " + feature32);
		
		feature33 = Features.feature33(melodie1);
		System.out.println("Melodie1 Feature 33: " + feature33);
		
		feature35 = Features.feature35(melodie1);
		System.out.println("Melodie1 Feature 35: " + feature35);
		
		feature39 = Features.feature39(melodie1);
		System.out.println("Melodie1 Feature 39: " + feature39);
		
	
	}
}
