package Core;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

//Klasse zum Errechnen der Klassifikatoren, nur für Rhythmus
public class NaiveBayesRhythm {
	public static boolean classify(Melody melodie) throws InvalidMidiDataException, IOException {
		ValueSet valueSet = Functions.calculateValueSet(melodie);
		double classificatorGood = calculateGoodClassificator(valueSet);
		double classificatorBad = calculateBadClassificator(valueSet);
			
		if (classificatorGood > classificatorBad) {
			return true;
		} else {return false;}
		
	}
	
	public static double calculateGoodClassificator(ValueSet valueSet) {
		double ergebnis = NaiveBayesAttributes.ProbabilityGood;
		
		
		
		if(valueSet.feature[17] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature17True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature17False;
		}
		
		
		if(valueSet.feature[19] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature19True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature19False;
		}
		
		
		
		if(valueSet.feature[20] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature20True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature20False;
		}
		
		
		
		
		
		if(valueSet.feature[24] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature24True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature24False;
		}
		
	
		
		
		if(valueSet.feature[27] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature27True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature27False;
		}
		
		
		
		if(valueSet.feature[28] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature28True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature28False;
		}
		
		
		if(valueSet.feature[29] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature29True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature29False;
		}
		
		
		
		if(valueSet.feature[30] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature30True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature30False;
		}
		
		
	
		
		
		System.out.println(ergebnis + " good");
		
		
		return ergebnis;
	}
	
	public static double calculateBadClassificator(ValueSet valueSet) {
		double ergebnis = NaiveBayesAttributes.ProbabilityBad;
		
		
		if(valueSet.feature[17] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature17True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature17False;
		}
		
		if(valueSet.feature[19] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature19True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature19False;
		}
		
		if(valueSet.feature[20] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature20True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature20False;
		}
	
		
		if(valueSet.feature[24] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature24True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature24False;
		}
		
		
		
		if(valueSet.feature[27] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature27True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature27False;
		}
		
		if(valueSet.feature[28] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature28True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature28False;
		}
		
		
		if(valueSet.feature[29] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature29True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature29False;
		}
		
		if(valueSet.feature[30] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature30True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature30False;
		}
		
		
		
		
		System.out.println(ergebnis + " bad");
		
		
		
		return ergebnis;
	}
}
