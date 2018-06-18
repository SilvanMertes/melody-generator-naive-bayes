package Core;

import java.sql.SQLException;

//Hilfsklasse, um die aktuellen Wahrscheinlichkeiten zwischenzuspeichern

import javax.sound.midi.InvalidMidiDataException;

public class NaiveBayesAttributes {
	public static int NumberAllMelodies;
	
	public static int NumberGoodMelodies;
	public static int NumberBadMelodies;
	
	public static double ProbabilityGood;
	public static double ProbabilityBad;
	
	public static int NumberGoodAndFeature1;
	public static int NumberGoodAndFeature2;
	public static int NumberGoodAndFeature3;
	public static int NumberGoodAndFeature4;
	public static int NumberGoodAndFeature7;
	public static int NumberGoodAndFeature8;
	public static int NumberGoodAndFeature9;
	public static int NumberGoodAndFeature11;
	public static int NumberGoodAndFeature12;
	public static int NumberGoodAndFeature13;
	public static int NumberGoodAndFeature14;
	public static int NumberGoodAndFeature15;
	public static int NumberGoodAndFeature16;
	public static int NumberGoodAndFeature17;
	public static int NumberGoodAndFeature19;
	public static int NumberGoodAndFeature20;
	public static int NumberGoodAndFeature23;
	public static int NumberGoodAndFeature24;
	public static int NumberGoodAndFeature25;
	public static int NumberGoodAndFeature26;
	public static int NumberGoodAndFeature27;
	public static int NumberGoodAndFeature28;
	public static int NumberGoodAndFeature29;
	public static int NumberGoodAndFeature30;
	public static int NumberGoodAndFeature31;
	public static int NumberGoodAndFeature32;
	public static int NumberGoodAndFeature33;
	public static int NumberGoodAndFeature35;
	public static int NumberGoodAndFeature39;
	
	public static int NumberBadAndFeature1;
	public static int NumberBadAndFeature2;
	public static int NumberBadAndFeature3;
	public static int NumberBadAndFeature4;
	public static int NumberBadAndFeature7;
	public static int NumberBadAndFeature8;
	public static int NumberBadAndFeature9;
	public static int NumberBadAndFeature11;
	public static int NumberBadAndFeature12;
	public static int NumberBadAndFeature13;
	public static int NumberBadAndFeature14;
	public static int NumberBadAndFeature15;
	public static int NumberBadAndFeature16;
	public static int NumberBadAndFeature17;
	public static int NumberBadAndFeature19;
	public static int NumberBadAndFeature20;
	public static int NumberBadAndFeature23;
	public static int NumberBadAndFeature24;
	public static int NumberBadAndFeature25;
	public static int NumberBadAndFeature26;
	public static int NumberBadAndFeature27;
	public static int NumberBadAndFeature28;
	public static int NumberBadAndFeature29;
	public static int NumberBadAndFeature30;
	public static int NumberBadAndFeature31;
	public static int NumberBadAndFeature32;
	public static int NumberBadAndFeature33;
	public static int NumberBadAndFeature35;
	public static int NumberBadAndFeature39;
	
	public static double PosterioriProbabilityGoodFeature1True;
	public static double PosterioriProbabilityGoodFeature2True;
	public static double PosterioriProbabilityGoodFeature3True;
	public static double PosterioriProbabilityGoodFeature4True;
	public static double PosterioriProbabilityGoodFeature7True;
	public static double PosterioriProbabilityGoodFeature8True;
	public static double PosterioriProbabilityGoodFeature9True;
	public static double PosterioriProbabilityGoodFeature11True;
	public static double PosterioriProbabilityGoodFeature12True;
	public static double PosterioriProbabilityGoodFeature13True;
	public static double PosterioriProbabilityGoodFeature14True;
	public static double PosterioriProbabilityGoodFeature15True;
	public static double PosterioriProbabilityGoodFeature16True;
	public static double PosterioriProbabilityGoodFeature17True;
	public static double PosterioriProbabilityGoodFeature19True;
	public static double PosterioriProbabilityGoodFeature20True;
	public static double PosterioriProbabilityGoodFeature23True;
	public static double PosterioriProbabilityGoodFeature24True;
	public static double PosterioriProbabilityGoodFeature25True;
	public static double PosterioriProbabilityGoodFeature26True;
	public static double PosterioriProbabilityGoodFeature27True;
	public static double PosterioriProbabilityGoodFeature28True;
	public static double PosterioriProbabilityGoodFeature29True;
	public static double PosterioriProbabilityGoodFeature30True;
	public static double PosterioriProbabilityGoodFeature31True;
	public static double PosterioriProbabilityGoodFeature32True;
	public static double PosterioriProbabilityGoodFeature33True;
	public static double PosterioriProbabilityGoodFeature35True;
	public static double PosterioriProbabilityGoodFeature39True;
	
	
	public static double PosterioriProbabilityGoodFeature1False;
	public static double PosterioriProbabilityGoodFeature2False;
	public static double PosterioriProbabilityGoodFeature3False;
	public static double PosterioriProbabilityGoodFeature4False;
	public static double PosterioriProbabilityGoodFeature7False;
	public static double PosterioriProbabilityGoodFeature8False;
	public static double PosterioriProbabilityGoodFeature9False;
	public static double PosterioriProbabilityGoodFeature11False;
	public static double PosterioriProbabilityGoodFeature12False;
	public static double PosterioriProbabilityGoodFeature13False;
	public static double PosterioriProbabilityGoodFeature14False;
	public static double PosterioriProbabilityGoodFeature15False;
	public static double PosterioriProbabilityGoodFeature16False;
	public static double PosterioriProbabilityGoodFeature17False;
	public static double PosterioriProbabilityGoodFeature19False;
	public static double PosterioriProbabilityGoodFeature20False;
	public static double PosterioriProbabilityGoodFeature23False;
	public static double PosterioriProbabilityGoodFeature24False;
	public static double PosterioriProbabilityGoodFeature25False;
	public static double PosterioriProbabilityGoodFeature26False;
	public static double PosterioriProbabilityGoodFeature27False;
	public static double PosterioriProbabilityGoodFeature28False;
	public static double PosterioriProbabilityGoodFeature29False;
	public static double PosterioriProbabilityGoodFeature30False;
	public static double PosterioriProbabilityGoodFeature31False;
	public static double PosterioriProbabilityGoodFeature32False;
	public static double PosterioriProbabilityGoodFeature33False;
	public static double PosterioriProbabilityGoodFeature35False;
	public static double PosterioriProbabilityGoodFeature39False;
	
	
	public static double PosterioriProbabilityBadFeature1True;
	public static double PosterioriProbabilityBadFeature2True;
	public static double PosterioriProbabilityBadFeature3True;
	public static double PosterioriProbabilityBadFeature4True;
	public static double PosterioriProbabilityBadFeature7True;
	public static double PosterioriProbabilityBadFeature8True;
	public static double PosterioriProbabilityBadFeature9True;
	public static double PosterioriProbabilityBadFeature11True;
	public static double PosterioriProbabilityBadFeature12True;
	public static double PosterioriProbabilityBadFeature13True;
	public static double PosterioriProbabilityBadFeature14True;
	public static double PosterioriProbabilityBadFeature15True;
	public static double PosterioriProbabilityBadFeature16True;
	public static double PosterioriProbabilityBadFeature17True;
	public static double PosterioriProbabilityBadFeature19True;
	public static double PosterioriProbabilityBadFeature20True;
	public static double PosterioriProbabilityBadFeature23True;
	public static double PosterioriProbabilityBadFeature24True;
	public static double PosterioriProbabilityBadFeature25True;
	public static double PosterioriProbabilityBadFeature26True;
	public static double PosterioriProbabilityBadFeature27True;
	public static double PosterioriProbabilityBadFeature28True;
	public static double PosterioriProbabilityBadFeature29True;
	public static double PosterioriProbabilityBadFeature30True;
	public static double PosterioriProbabilityBadFeature31True;
	public static double PosterioriProbabilityBadFeature32True;
	public static double PosterioriProbabilityBadFeature33True;
	public static double PosterioriProbabilityBadFeature35True;
	public static double PosterioriProbabilityBadFeature39True;
	
	
	public static double PosterioriProbabilityBadFeature1False;
	public static double PosterioriProbabilityBadFeature2False;
	public static double PosterioriProbabilityBadFeature3False;
	public static double PosterioriProbabilityBadFeature4False;
	public static double PosterioriProbabilityBadFeature7False;
	public static double PosterioriProbabilityBadFeature8False;
	public static double PosterioriProbabilityBadFeature9False;
	public static double PosterioriProbabilityBadFeature11False;
	public static double PosterioriProbabilityBadFeature12False;
	public static double PosterioriProbabilityBadFeature13False;
	public static double PosterioriProbabilityBadFeature14False;
	public static double PosterioriProbabilityBadFeature15False;
	public static double PosterioriProbabilityBadFeature16False;
	public static double PosterioriProbabilityBadFeature17False;
	public static double PosterioriProbabilityBadFeature19False;
	public static double PosterioriProbabilityBadFeature20False;
	public static double PosterioriProbabilityBadFeature23False;
	public static double PosterioriProbabilityBadFeature24False;
	public static double PosterioriProbabilityBadFeature25False;
	public static double PosterioriProbabilityBadFeature26False;
	public static double PosterioriProbabilityBadFeature27False;
	public static double PosterioriProbabilityBadFeature28False;
	public static double PosterioriProbabilityBadFeature29False;
	public static double PosterioriProbabilityBadFeature30False;
	public static double PosterioriProbabilityBadFeature31False;
	public static double PosterioriProbabilityBadFeature32False;
	public static double PosterioriProbabilityBadFeature33False;
	public static double PosterioriProbabilityBadFeature35False;
	public static double PosterioriProbabilityBadFeature39False;
	
	
	//Updates the Feature-Values in the Database and refreshes the Naive-Bayes-Attributes
	public static void refreshNaiveBayesAttributes() throws SQLException, InvalidMidiDataException {
		Database.database.updateFeaturesInDatabase();
		
		
		NumberAllMelodies = Database.ReadFunctions.getNumberOfAllMelodies();
		
		NumberGoodMelodies = Database.ReadFunctions.getNumberOfGoodMelodies();
		NumberBadMelodies = Database.ReadFunctions.getNumberOfBadMelodies();
		
		NumberGoodAndFeature1 = Database.ReadFunctions.getFeatureAndClassificationCount(1, 1);
		NumberGoodAndFeature2 = Database.ReadFunctions.getFeatureAndClassificationCount(2, 1);
		NumberGoodAndFeature3 = Database.ReadFunctions.getFeatureAndClassificationCount(3, 1);
		NumberGoodAndFeature4 = Database.ReadFunctions.getFeatureAndClassificationCount(4, 1);
		NumberGoodAndFeature7 = Database.ReadFunctions.getFeatureAndClassificationCount(7, 1);
		NumberGoodAndFeature8 = Database.ReadFunctions.getFeatureAndClassificationCount(8, 1);
		NumberGoodAndFeature9 = Database.ReadFunctions.getFeatureAndClassificationCount(9, 1);
		NumberGoodAndFeature11 = Database.ReadFunctions.getFeatureAndClassificationCount(11, 1);
		NumberGoodAndFeature12 = Database.ReadFunctions.getFeatureAndClassificationCount(12, 1);
		NumberGoodAndFeature13 = Database.ReadFunctions.getFeatureAndClassificationCount(13, 1);
		NumberGoodAndFeature14 = Database.ReadFunctions.getFeatureAndClassificationCount(14, 1);
		NumberGoodAndFeature15 = Database.ReadFunctions.getFeatureAndClassificationCount(15, 1);
		NumberGoodAndFeature16 = Database.ReadFunctions.getFeatureAndClassificationCount(16, 1);
		NumberGoodAndFeature17 = Database.ReadFunctions.getFeatureAndClassificationCount(17, 1);
		NumberGoodAndFeature19 = Database.ReadFunctions.getFeatureAndClassificationCount(19, 1);
		NumberGoodAndFeature20 = Database.ReadFunctions.getFeatureAndClassificationCount(20, 1);
		NumberGoodAndFeature23 = Database.ReadFunctions.getFeatureAndClassificationCount(23, 1);
		NumberGoodAndFeature24 = Database.ReadFunctions.getFeatureAndClassificationCount(24, 1);
		NumberGoodAndFeature25 = Database.ReadFunctions.getFeatureAndClassificationCount(25, 1);
		NumberGoodAndFeature26 = Database.ReadFunctions.getFeatureAndClassificationCount(26, 1);
		NumberGoodAndFeature27 = Database.ReadFunctions.getFeatureAndClassificationCount(27, 1);
		NumberGoodAndFeature28 = Database.ReadFunctions.getFeatureAndClassificationCount(28, 1);
		NumberGoodAndFeature29 = Database.ReadFunctions.getFeatureAndClassificationCount(29, 1);
		NumberGoodAndFeature30 = Database.ReadFunctions.getFeatureAndClassificationCount(30, 1);
		NumberGoodAndFeature31 = Database.ReadFunctions.getFeatureAndClassificationCount(31, 1);
		NumberGoodAndFeature32 = Database.ReadFunctions.getFeatureAndClassificationCount(32, 1);
		NumberGoodAndFeature33 = Database.ReadFunctions.getFeatureAndClassificationCount(33, 1);
		NumberGoodAndFeature35 = Database.ReadFunctions.getFeatureAndClassificationCount(35, 1);
		NumberGoodAndFeature39 = Database.ReadFunctions.getFeatureAndClassificationCount(39, 1);
		
		NumberBadAndFeature1  = Database.ReadFunctions.getFeatureAndClassificationCount(1, 0);
		NumberBadAndFeature2  = Database.ReadFunctions.getFeatureAndClassificationCount(2, 0);
		NumberBadAndFeature3  = Database.ReadFunctions.getFeatureAndClassificationCount(3, 0);
		NumberBadAndFeature4  = Database.ReadFunctions.getFeatureAndClassificationCount(4, 0);
		NumberBadAndFeature7  = Database.ReadFunctions.getFeatureAndClassificationCount(7, 0);
		NumberBadAndFeature8  = Database.ReadFunctions.getFeatureAndClassificationCount(8, 0);
		NumberBadAndFeature9  = Database.ReadFunctions.getFeatureAndClassificationCount(9, 0);
		NumberBadAndFeature11  = Database.ReadFunctions.getFeatureAndClassificationCount(11, 0);
		NumberBadAndFeature12  = Database.ReadFunctions.getFeatureAndClassificationCount(12, 0);
		NumberBadAndFeature13  = Database.ReadFunctions.getFeatureAndClassificationCount(13, 0);
		NumberBadAndFeature14  = Database.ReadFunctions.getFeatureAndClassificationCount(14, 0);
		NumberBadAndFeature15  = Database.ReadFunctions.getFeatureAndClassificationCount(15, 0);
		NumberBadAndFeature16  = Database.ReadFunctions.getFeatureAndClassificationCount(16, 0);
		NumberBadAndFeature17  = Database.ReadFunctions.getFeatureAndClassificationCount(17, 0);
		NumberBadAndFeature19  = Database.ReadFunctions.getFeatureAndClassificationCount(19, 0);
		NumberBadAndFeature20  = Database.ReadFunctions.getFeatureAndClassificationCount(20, 0);
		NumberBadAndFeature23  = Database.ReadFunctions.getFeatureAndClassificationCount(23, 0);
		NumberBadAndFeature24  = Database.ReadFunctions.getFeatureAndClassificationCount(24, 0);
		NumberBadAndFeature25  = Database.ReadFunctions.getFeatureAndClassificationCount(25, 0);
		NumberBadAndFeature26  = Database.ReadFunctions.getFeatureAndClassificationCount(26, 0);
		NumberBadAndFeature27  = Database.ReadFunctions.getFeatureAndClassificationCount(27, 0);
		NumberBadAndFeature28  = Database.ReadFunctions.getFeatureAndClassificationCount(28, 0);
		NumberBadAndFeature29  = Database.ReadFunctions.getFeatureAndClassificationCount(29, 0);
		NumberBadAndFeature30  = Database.ReadFunctions.getFeatureAndClassificationCount(30, 0);
		NumberBadAndFeature31  = Database.ReadFunctions.getFeatureAndClassificationCount(31, 0);
		NumberBadAndFeature32  = Database.ReadFunctions.getFeatureAndClassificationCount(32, 0);
		NumberBadAndFeature33  = Database.ReadFunctions.getFeatureAndClassificationCount(33, 0);
		NumberBadAndFeature35  = Database.ReadFunctions.getFeatureAndClassificationCount(35, 0);
		NumberBadAndFeature39  = Database.ReadFunctions.getFeatureAndClassificationCount(39, 0);
		
		
		//Update Probabilitys:
		
		PosterioriProbabilityGoodFeature1True = (double)((double)NumberGoodAndFeature1 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature2True = (double)((double)NumberGoodAndFeature2 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature3True = (double)((double)NumberGoodAndFeature3 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature4True = (double)((double)NumberGoodAndFeature4 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature7True = (double)((double)NumberGoodAndFeature7 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature8True = (double)((double)NumberGoodAndFeature8 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature9True = (double)((double)NumberGoodAndFeature9 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature11True = (double)((double)NumberGoodAndFeature11 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature12True = (double)((double)NumberGoodAndFeature12 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature13True = (double)((double)NumberGoodAndFeature13 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature14True = (double)((double)NumberGoodAndFeature14 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature15True = (double)((double)NumberGoodAndFeature15 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature16True = (double)((double)NumberGoodAndFeature16 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature17True = (double)((double)NumberGoodAndFeature17 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature19True = (double)((double)NumberGoodAndFeature19 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature20True = (double)((double)NumberGoodAndFeature20 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature23True = (double)((double)NumberGoodAndFeature23 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature24True = (double)((double)NumberGoodAndFeature24 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature25True = (double)((double)NumberGoodAndFeature25 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature26True = (double)((double)NumberGoodAndFeature26 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature27True = (double)((double)NumberGoodAndFeature27 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature28True = (double)((double)NumberGoodAndFeature28 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature29True = (double)((double)NumberGoodAndFeature29 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature30True = (double)((double)NumberGoodAndFeature30 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature31True = (double)((double)NumberGoodAndFeature31/ (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature32True = (double)((double)NumberGoodAndFeature32 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature33True = (double)((double)NumberGoodAndFeature33 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature35True = (double)((double)NumberGoodAndFeature35 / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature39True = (double)((double)NumberGoodAndFeature39 / (double)NumberGoodMelodies);
		
		
		PosterioriProbabilityGoodFeature1False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature1) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature2False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature2) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature3False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature3) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature4False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature4) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature7False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature7) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature8False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature8) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature9False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature9) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature11False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature11) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature12False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature12) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature13False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature13) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature14False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature14) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature15False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature15) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature16False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature16) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature17False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature17) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature19False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature19) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature20False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature20) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature23False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature23) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature24False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature24) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature25False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature25) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature26False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature26) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature27False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature27) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature28False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature28) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature29False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature29) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature30False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature30) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature31False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature31) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature32False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature32) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature33False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature33) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature35False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature35) / (double)NumberGoodMelodies);
		PosterioriProbabilityGoodFeature39False = (double)((double)(NumberGoodMelodies - NumberGoodAndFeature39) / (double)NumberGoodMelodies);
		
		
		PosterioriProbabilityBadFeature1True = (double)((double)NumberBadAndFeature1 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature2True = (double)((double)NumberBadAndFeature2 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature3True = (double)((double)NumberBadAndFeature3 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature4True = (double)((double)NumberBadAndFeature4 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature7True = (double)((double)NumberBadAndFeature7 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature8True = (double)((double)NumberBadAndFeature8 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature9True = (double)((double)NumberBadAndFeature9 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature11True = (double)((double)NumberBadAndFeature11 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature12True = (double)((double)NumberBadAndFeature12 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature13True = (double)((double)NumberBadAndFeature13 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature14True = (double)((double)NumberBadAndFeature14 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature15True = (double)((double)NumberBadAndFeature15 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature16True = (double)((double)NumberBadAndFeature16 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature17True = (double)((double)NumberBadAndFeature17 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature19True = (double)((double)NumberBadAndFeature19 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature20True = (double)((double)NumberBadAndFeature20 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature23True = (double)((double)NumberBadAndFeature23 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature24True = (double)((double)NumberBadAndFeature24 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature25True = (double)((double)NumberBadAndFeature25 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature26True = (double)((double)NumberBadAndFeature26 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature27True = (double)((double)NumberBadAndFeature27 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature28True = (double)((double)NumberBadAndFeature28 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature29True = (double)((double)NumberBadAndFeature29 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature30True = (double)((double)NumberBadAndFeature30 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature31True = (double)((double)NumberBadAndFeature31/ (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature32True = (double)((double)NumberBadAndFeature32 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature33True = (double)((double)NumberBadAndFeature33 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature35True = (double)((double)NumberBadAndFeature35 / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature39True = (double)((double)NumberBadAndFeature39 / (double)NumberBadMelodies);
		
		
		
		
		
		PosterioriProbabilityBadFeature1False = (double)((double)(NumberBadMelodies - NumberBadAndFeature1) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature2False = (double)((double)(NumberBadMelodies - NumberBadAndFeature2) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature3False = (double)((double)(NumberBadMelodies - NumberBadAndFeature3) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature4False = (double)((double)(NumberBadMelodies - NumberBadAndFeature4) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature7False = (double)((double)(NumberBadMelodies - NumberBadAndFeature7) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature8False = (double)((double)(NumberBadMelodies - NumberBadAndFeature8) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature9False = (double)((double)(NumberBadMelodies - NumberBadAndFeature9) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature11False = (double)((double)(NumberBadMelodies - NumberBadAndFeature11) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature12False = (double)((double)(NumberBadMelodies - NumberBadAndFeature12) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature13False = (double)((double)(NumberBadMelodies - NumberBadAndFeature13) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature14False = (double)((double)(NumberBadMelodies - NumberBadAndFeature14) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature15False = (double)((double)(NumberBadMelodies - NumberBadAndFeature15) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature16False = (double)((double)(NumberBadMelodies - NumberBadAndFeature16) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature17False = (double)((double)(NumberBadMelodies - NumberBadAndFeature17) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature19False = (double)((double)(NumberBadMelodies - NumberBadAndFeature19) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature20False = (double)((double)(NumberBadMelodies - NumberBadAndFeature20) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature23False = (double)((double)(NumberBadMelodies - NumberBadAndFeature23) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature24False = (double)((double)(NumberBadMelodies - NumberBadAndFeature24) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature25False = (double)((double)(NumberBadMelodies - NumberBadAndFeature25) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature26False = (double)((double)(NumberBadMelodies - NumberBadAndFeature26) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature27False = (double)((double)(NumberBadMelodies - NumberBadAndFeature27) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature28False = (double)((double)(NumberBadMelodies - NumberBadAndFeature28) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature29False = (double)((double)(NumberBadMelodies - NumberBadAndFeature29) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature30False = (double)((double)(NumberBadMelodies - NumberBadAndFeature30) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature31False = (double)((double)(NumberBadMelodies - NumberBadAndFeature31) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature32False = (double)((double)(NumberBadMelodies - NumberBadAndFeature32) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature33False = (double)((double)(NumberBadMelodies - NumberBadAndFeature33) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature35False = (double)((double)(NumberBadMelodies - NumberBadAndFeature35) / (double)NumberBadMelodies);
		PosterioriProbabilityBadFeature39False = (double)((double)(NumberBadMelodies - NumberBadAndFeature39) / (double)NumberBadMelodies);
		
		ProbabilityGood = (double)(((double)NumberGoodMelodies)/((double)NumberAllMelodies));
		ProbabilityBad = (double)(((double)NumberBadMelodies)/((double)NumberAllMelodies));
		
		
	}

}
