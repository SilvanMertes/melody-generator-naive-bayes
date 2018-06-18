package Core;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;


//Klasse zum errechnen der Klassifikatoren, nur für Melodie
public class NaiveBayesPitches {
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
		
		if(valueSet.feature[1] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature1True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature1False;
		}
		
		
		if(valueSet.feature[2] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature2True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature2False;
		}
		
		if(valueSet.feature[3] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature3True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature3False;
		}
		
		if(valueSet.feature[4] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature4True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature4False;
		}
		
		if(valueSet.feature[7] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature7True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature7False;
		}
		
		if(valueSet.feature[8] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature8True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature8False;
		}
		
		if(valueSet.feature[9] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature9True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature9False;
		}
		
		if(valueSet.feature[11] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature11True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature11False;
		}
		
		if(valueSet.feature[12] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature12True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature12False;
		}
		
		
		if(valueSet.feature[13] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature13True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature13False;
		}
		
		
		if(valueSet.feature[14] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature14True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature14False;
		}
		
		
		if(valueSet.feature[15] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature15True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature15False;
		}
		
		
		if(valueSet.feature[16] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature16True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature16False;
		}
		
		
		
		
		if(valueSet.feature[23] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature23True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature23False;
		}
		
		
		
		
		if(valueSet.feature[25] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature25True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature25False;
		}
		
		
		
		if(valueSet.feature[26] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature26True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature26False;
		}
		
		
		
		
		if(valueSet.feature[31] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature31True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature31False;
		}
		
		if(valueSet.feature[32] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature32True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature32False;
		}
		
		
		if(valueSet.feature[33] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature33True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature33False;
		}
		
		if(valueSet.feature[35] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature35True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature35False;
		}
		
		
		if(valueSet.feature[39] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature39True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityGoodFeature39False;
		}
		
		
		System.out.println(ergebnis + " good");
		
		
		return ergebnis;
	}
	
	public static double calculateBadClassificator(ValueSet valueSet) {
		double ergebnis = NaiveBayesAttributes.ProbabilityBad;
		
		if(valueSet.feature[1] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature1True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature1False;
		}
		
		if(valueSet.feature[2] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature2True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature2False;
		}
		
		if(valueSet.feature[3] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature3True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature3False;
		}
		
		if(valueSet.feature[4] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature4True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature4False;
		}
		
		if(valueSet.feature[7] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature7True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature7False;
		}
		
		if(valueSet.feature[8] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature8True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature8False;
		}
		
		if(valueSet.feature[9] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature9True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature9False;
		}
		
		if(valueSet.feature[11] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature11True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature11False;
		}
		
		
		if(valueSet.feature[12] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature12True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature12False;
		}
		
		if(valueSet.feature[13] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature13True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature13False;
		}
		
		if(valueSet.feature[14] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature14True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature14False;
		}
		
		if(valueSet.feature[15] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature15True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature15False;
		}
		
		if(valueSet.feature[16] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature16True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature16False;
		}
		
		
		if(valueSet.feature[23] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature23True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature23False;
		}
		
		
		
		if(valueSet.feature[25] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature25True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature25False;
		}
		
		if(valueSet.feature[26] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature26True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature26False;
		}
		
		
		
		
		if(valueSet.feature[31] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature31True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature31False;
		}
		
		if(valueSet.feature[32] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature32True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature32False;
		}
		
		if(valueSet.feature[33] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature33True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature33False;
		}
		
		if(valueSet.feature[35] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature35True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature35False;
		}
		
		if(valueSet.feature[39] == 1) {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature39True;
		} else {
			ergebnis = ergebnis * NaiveBayesAttributes.PosterioriProbabilityBadFeature39False;
		}
		
		
		System.out.println(ergebnis + " bad");
		
		
		
		return ergebnis;
	}
}
