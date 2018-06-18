package Core;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

public class Features {
	
	//Feature1: Tonhöhenvielfalt
	//Wert zwischen 0 und 1: 1 bedeutet höchste Vielfalt, 0 bedeutet keine Vielfalt
	public static double feature1(Melody melody){
		int anzahlToene = 0;
		int anzahlVerschieden = 0;
		int[] bucket = new int[32];
		for(int i = 0; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				bucket[melody.MelodyArray[i]] = 1;
				anzahlToene++;
			}
		}	
		for(int j = 1; j <= 14; j++) {
			if(bucket[j] == 1) {
				anzahlVerschieden++;
			}
		}	
		
		return ((double)anzahlVerschieden/(double)anzahlToene);		
	}
	
	//Feature2: Tonhöhenumfang in Stufen
	//Wert zwischen 0 und 12. ABWEICHEND ZU KLINGER. 12 bedeutet größter Umfang, 0 bedeutet kein Umfang
	//Neue Formel: tonhöhenumfang = Maximale Stufe - Minimale Stufe
	public static double feature2(Melody melody) {
		int max = 0;
		int min = 14;
		for(int i = 0; i <= 31; i++) {
			if (melody.MelodyArray[i] < min && melody.MelodyArray[i] > 0) {
				min = melody.MelodyArray[i];
			}
			if (melody.MelodyArray[i] > max) {
				max = melody.MelodyArray[i];
			}
		}
		
		return (double)(((double)(max - min))/(double)13);
	}
	
	//Feature3: Schlüsselzentrierung
	//Wert zwischen 0 und 1. 1 bedeutet sehr hohe Schlüsselzentrierung
	public static double feature3(Melody melody){
		int anzahlPrimQuint = 0;
		int anzahlToene = Functions.anzahlToene(melody);
		int akkordNummer = 0;
		
		
		for(int i = 0; i <= 31; i++) {
			if(i >= 0 && i <= 7) {
				akkordNummer = 1;
			} else if(i >= 8 && i <= 15) {
				akkordNummer = 2;
			} else if(i >= 16 && i <= 23) {
				akkordNummer = 3;
			} else if(i >= 24 && i <= 31) {
				akkordNummer = 4;
			}
		
			//bei Am wird entweder bei a oder bei e hochgezählt
			if(akkordNummer == 1) {
				if((melody.MelodyArray[i] == 6) || (melody.MelodyArray[i] == 13) || (melody.MelodyArray[i] == 3) || (melody.MelodyArray[i] == 10)) {
					anzahlPrimQuint++;	
				}
			}
			
			//bei F wird entweder bei f oder bei c hochgezählt
			if(akkordNummer == 2) {
				if((melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8) || (melody.MelodyArray[i] == 4) || (melody.MelodyArray[i] == 11)) {
					anzahlPrimQuint++;		
				}
			}
			
			//bei C wird entweder bei c oder bei g hochgezählt
			if(akkordNummer == 3) {
				if((melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8) || (melody.MelodyArray[i] == 5) || (melody.MelodyArray[i] == 12)) {
					anzahlPrimQuint++;					
				}
			}
			
			//bei G wird entweder bei g oder bei d hochgezählt
			if(akkordNummer == 4) {
				if((melody.MelodyArray[i] == 5) || (melody.MelodyArray[i] == 12) || (melody.MelodyArray[i] == 2) || (melody.MelodyArray[i] == 9)) {
					anzahlPrimQuint++;					
				}
			}
		}
		//System.out.println("Schlüsselzentrierung: " + anzahlPrimQuint + "Primen oder Quinten in" + anzahlToene + "Tönen.");
		return (((double)anzahlPrimQuint)/((double)anzahlToene));
	}
	
	
	//Feature 4:Schlüsselzentrierung nach Zeiteinheiten. (Restriktion: Auf die erste Zählzeit keine Pause
	//Wert zwischen 0 und 1. 1 bedeutet sehr hohe Schlüsselzentrierung nach Zeiteinheiten
	public static double feature4(Melody melody) throws InvalidMidiDataException, IOException{
		
		
		
		Melody hilfsMelody = new Melody();
		hilfsMelody.MelodyArray[0] = melody.MelodyArray[0];
		for(int i = 1; i <= 31; i++) {
			if(melody.MelodyArray[i] == 0) {
				hilfsMelody.MelodyArray[i] = hilfsMelody.MelodyArray[i-1];
			} else { hilfsMelody.MelodyArray[i] = melody.MelodyArray[i];}	
		}
		return feature3(hilfsMelody);
	}
	
	
	//Feature 7: Dissonante Intervalle 
	//Wert zwischen 0 und 1. 1 bedeutet viele Dissonanzen;
	//Der Wert wird aus Dissonanzgewichten aggregiert: Prim, Quart, Quint => 0, Terz, Sext => 0,5, Sekund, Sept => 1 
	//Nach Theorie Konsonanz/Unvollkommene Konsonanz/Dissonanz
	public static double feature7(Melody melody) throws InvalidMidiDataException {
		int intervall;
		Melody hilfsMelody = new Melody();
		int anzahlIntervalle = Functions.anzahlToene(melody) - 1;
		
		double sum = 0;
		
		hilfsMelody.MelodyArray[0] = melody.MelodyArray[0];
		for(int j = 1; j <= 31; j++) {
			if(melody.MelodyArray[j] == 0) {
				hilfsMelody.MelodyArray[j] = hilfsMelody.MelodyArray[j-1];
			} else { hilfsMelody.MelodyArray[j] = melody.MelodyArray[j];}	
		}
		
		
		for(int i = 0; i <= 30; i++) {
			intervall = Math.abs(hilfsMelody.MelodyArray[i] - hilfsMelody.MelodyArray[i+1]);
			//if(intervall == 0 || intervall == 3 || intervall == 4 || intervall == 7 || intervall == 10 || intervall == 11) {
			//	sum = sum + 0;
			//}
			if((intervall == 2) || (intervall == 5) || (intervall == 9) || (intervall == 12)) {
				sum = sum + 0.5;
			}
			if((intervall == 1) || (intervall == 6) || (intervall == 8) || (intervall == 13)) {
				sum = sum + 1;
			}
		}
		return(sum/((double)(anzahlIntervalle)));
			
	}
	
	//Feature 8: Harmonie (Töne innerhalb des aktuellen Akkords)
	//Wert zwischen 0 und 1. 1 bedeutet viele akkordeigene Töne
			public static double feature8(Melody melody) {
				
				int anzahlToene = Functions.anzahlToene(melody);
				int akkordNummer = 0;
				int anzahlAkkordEigen = 0;
				
				for(int i = 0; i <= 31; i++) {
					if(i >= 0 && i <= 7) {
						akkordNummer = 1;
					} else if(i >= 8 && i <= 15) {
						akkordNummer = 2;
					} else if(i >= 16 && i <= 23) {
						akkordNummer = 3;
					} else if(i >= 24 && i <= 31) {
						akkordNummer = 4;
					}
					

					//bei Am wird entweder bei a, c oder e hochgezählt
					if(akkordNummer == 1) {
						if((melody.MelodyArray[i] == 6) || (melody.MelodyArray[i] == 13) || (melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8) || (melody.MelodyArray[i] == 3) || (melody.MelodyArray[i] == 10)) {
							anzahlAkkordEigen++;	
						}
					}
					
					//bei F wird entweder bei f, a oder c hochgezählt
					if(akkordNummer == 2) {
						if((melody.MelodyArray[i] == 4) || (melody.MelodyArray[i] == 11) || (melody.MelodyArray[i] == 6) || (melody.MelodyArray[i] == 13) || (melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8)) {
							anzahlAkkordEigen++;		
						}
					}
					
					//bei C wird entweder bei c, e oder g hochgezählt
					if(akkordNummer == 3) {
						if((melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8) || (melody.MelodyArray[i] == 3) || (melody.MelodyArray[i] == 10) || (melody.MelodyArray[i] == 5) || (melody.MelodyArray[i] == 12)) {
							anzahlAkkordEigen++;					
						}
					}
					
					//bei G wird entweder bei g, h oder d hochgezählt
					if(akkordNummer == 4) {
						if((melody.MelodyArray[i] == 5) || (melody.MelodyArray[i] == 12) || (melody.MelodyArray[i] == 7) || (melody.MelodyArray[i] == 14) || (melody.MelodyArray[i] == 2) || (melody.MelodyArray[i] == 9)) {
							anzahlAkkordEigen++;					
						}
					}
					
				}
				return (((double)anzahlAkkordEigen)/((double)anzahlToene));
			}
			
			
	//Feature 9: Lange Töne in Akkord. Als langer Ton gilt nach Klinger ein Ton, welcher mindestens 2 Viertelschläge andauert.
			//Zurückgegeben wird das Verhältnis von Langen Tönen in Akkorden zu allen langen Tönen .
			//Wert zwischen 0 und 1, 1 heißt viele lange Töne in Akkord
			//Es zählt der Zeitpunkt, zu dem der Ton angespielt wird als Referenz zum jeweiligen Akkord
	public static double feature9(Melody melody) {
		
		int anzahlLangeToene = 0;
		int akkordNummer = 0;
		int anzahlAkkordEigenLang = 0;
		
		
		
		for(int j = 0; j <= 28; j++) {
			if((melody.MelodyArray[j] != 0) && (melody.MelodyArray[j+1] == 0) && (melody.MelodyArray[j+2] == 0) && (melody.MelodyArray[j+3] == 0))
				anzahlLangeToene++;	
		}
		
		
		for(int i = 0; i <= 28; i++) {
			if(i >= 0 && i <= 7) {
				akkordNummer = 1;
			} else if(i >= 8 && i <= 15) {
				akkordNummer = 2;
			} else if(i >= 16 && i <= 23) {
				akkordNummer = 3;
			} else if(i >= 24 && i <= 31) {
				akkordNummer = 4;
			}
			

			//bei Am wird entweder bei a, c oder e hochgezählt
			if(akkordNummer == 1) {
				if((melody.MelodyArray[i] == 6) || (melody.MelodyArray[i] == 13) || (melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8) || (melody.MelodyArray[i] == 3) || (melody.MelodyArray[i] == 10)) {
					if((melody.MelodyArray[i+1] == 0) && (melody.MelodyArray[i+2] == 0) && (melody.MelodyArray[i+3] == 0))
						anzahlAkkordEigenLang++;	
				}
			}
			
			//bei F wird entweder bei f, a oder c hochgezählt
			if(akkordNummer == 2) {
				if((melody.MelodyArray[i] == 4) || (melody.MelodyArray[i] == 11) || (melody.MelodyArray[i] == 6) || (melody.MelodyArray[i] == 13) || (melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8)) {
					if((melody.MelodyArray[i+1] == 0) && (melody.MelodyArray[i+2] == 0) && (melody.MelodyArray[i+3] == 0))
						anzahlAkkordEigenLang++;		
				}
			}
			
			//bei C wird entweder bei c, e oder g hochgezählt
			if(akkordNummer == 3) {
				if((melody.MelodyArray[i] == 1) || (melody.MelodyArray[i] == 8) || (melody.MelodyArray[i] == 3) || (melody.MelodyArray[i] == 10) || (melody.MelodyArray[i] == 5) || (melody.MelodyArray[i] == 12)) {
					if((melody.MelodyArray[i+1] == 0) && (melody.MelodyArray[i+2] == 0) && (melody.MelodyArray[i+3] == 0))
						anzahlAkkordEigenLang++;					
				}
			}
			
			//bei G wird entweder bei g, h oder d hochgezählt
			if(akkordNummer == 4) {
				if((melody.MelodyArray[i] == 5) || (melody.MelodyArray[i] == 12) || (melody.MelodyArray[i] == 7) || (melody.MelodyArray[i] == 14) || (melody.MelodyArray[i] == 2) || (melody.MelodyArray[i] == 9)) {
					if((melody.MelodyArray[i+1] == 0) && (melody.MelodyArray[i+2] == 0) && (melody.MelodyArray[i+3] == 0))
						anzahlAkkordEigenLang++;					
				}
			}
			
		}
		
		double d = (((double)anzahlAkkordEigenLang)/((double)anzahlLangeToene));
		if(anzahlLangeToene == 0) {
			d = 1;
		}
		return d;
		
	}
	
	//Feature11: Konturrichtung
	//Hier wird die Summe aller steigenden Intervalle im Verhältnis zur Summe aller Intervalle betrachtet.
	//Dies ergibt die Tendenz der Melodie, also ob sie fällt oder steigt.
	//Wert zwischen 0 und 1, 1 heißt, die Melodie steigt eher
	public static double feature11(Melody melody) {
		int anzahlIntervalle = Functions.anzahlToene(melody) - 1;
		int letzteStufe = melody.MelodyArray[0];
		int anzahlSteigend = 0;
		
		for(int i = 1; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				if(melody.MelodyArray[i] > letzteStufe) {
					anzahlSteigend ++;
				}
				letzteStufe = melody.MelodyArray[i];
			}
		}
		
		return (double)(((double)anzahlSteigend)/((double)anzahlIntervalle));
	}
	
	//Feature12: Konturstabilität
	//Im Gegensatz zu Klinger wird mit der Anzahl der Intervalle gerechnet, nicht mit Anzahl Intervalle - 1.
	public static double feature12(Melody melody) {
		int anzahlIntervalle = Functions.anzahlToene(melody) - 1;
		
		int anzahlAufsteigend = 0;
		int anzahlAbsteigend = 0;
		int letzterAuf = melody.MelodyArray[0];
		int letzterAb = melody.MelodyArray[0];
		int merkAuf = 0;
		int merkAb = 0;
		int groeßer;
		
		for(int i = 1; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				if (melody.MelodyArray[i] >= letzterAuf) {
					anzahlAufsteigend++;
				} else {
					if (merkAuf < anzahlAufsteigend) {
						merkAuf = anzahlAufsteigend;
					}
					anzahlAufsteigend = 0;
				}
				letzterAuf = melody.MelodyArray[i];
			}
		}
		if (merkAuf < anzahlAufsteigend) {
			merkAuf = anzahlAufsteigend;
		}
		
		for(int j = 1; j <= 31; j++){
			if(melody.MelodyArray[j] != 0) {
				if (melody.MelodyArray[j] <= letzterAb) {
					anzahlAbsteigend++;
				} else {
					if (merkAb < anzahlAbsteigend) {
						merkAb = anzahlAbsteigend;
					}
					anzahlAbsteigend = 0;
				}
				letzterAb = melody.MelodyArray[j];
			}
		}
		if (merkAb < anzahlAbsteigend) {
			merkAb = anzahlAbsteigend;
		}
		
		if(merkAb >= merkAuf) {
			groeßer = merkAb;
		} else {groeßer = merkAuf;}
		
		//System.out.println("auf: " + merkAuf + " ,ab: " + merkAb + "groeßer: " + groeßer);
		return (((double)groeßer)/((double)anzahlIntervalle));
		
	}
	
	//Feature 13: Schrittweise Bewegung
	public static double feature13(Melody melody) {
		int anzahlIntervalle = Functions.anzahlToene(melody) - 1;
		int anzahlDiatonisch = 0;
		int letzter = melody.MelodyArray[0];
		double abs = 0;
		
		for(int i = 1; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				abs = Math.abs(melody.MelodyArray[i] - letzter);
				
				if (abs == 1) {
					anzahlDiatonisch++;
				}
				
				letzter = melody.MelodyArray[i];
			}
			
		}
		//System.out.println("ergebnis " + anzahlDiatonisch);
		return (((double)anzahlDiatonisch)/((double)anzahlIntervalle));
	}
	
	//Feature 14: Sprungrückkehr
	public static double feature14(Melody melody) {
		int[] ohneNullen = new int[32];
		int n = 0;
		int großeSpruenge = 0;
		int großeSpruengeOhneRueckkehr = 0;
		
		for(int i = 0; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				ohneNullen[n] = melody.MelodyArray[i];
				n++;
			}
		}
		//an n-1 steht also nun die letzte relevante Zahl
		
		for(int j = 1; j < n-1; j++){
			if(Math.abs(ohneNullen[j-1]-ohneNullen[j]) > 5) {
				großeSpruenge++;
				
				if(ohneNullen[j-1] > ohneNullen[j] && (ohneNullen[j+1] <= ohneNullen[j] || ohneNullen[j+1] > ohneNullen[j-1])) {
					großeSpruengeOhneRueckkehr++;
				}
				if(ohneNullen[j-1] < ohneNullen[j] && (ohneNullen[j+1] >= ohneNullen[j] || ohneNullen[j+1] < ohneNullen[j-1])) {
					großeSpruengeOhneRueckkehr++;
				}
			}
		}
		
		if((Math.abs(ohneNullen[n-1] - ohneNullen[n-2])) > 5) {
			großeSpruenge++;
			großeSpruengeOhneRueckkehr++;
		}
		
	
		if(großeSpruenge == 0) {
			return (double) 1;
		}
		
		return (((double)großeSpruengeOhneRueckkehr)/((double)großeSpruenge));
	}
	
	//Feature 15: Höhepunktstärke. Wert zwischen 1 und 0. 
	//Desto kleiner der Wert, desto höher wird die Melodie wahrgenommen.
	public static double feature15(Melody melody) {
		int hoechsterTon = 0;
		int count = 0;
		
		for(int i = 0; i <= 31; i++) {
			if(melody.MelodyArray[i] > hoechsterTon) {
				hoechsterTon = melody.MelodyArray[i];
			}
		}
		for(int j = 0; j <= 31; j++) {
			if(melody.MelodyArray[j] == hoechsterTon) {
				count++;
			}
		}
		
		if(count == 0) {
			count = 1; 
		}
		return (double)(1/((double)count));
		
	}
	
	//Feature 16: Große Intervalle
	public static double feature16(Melody melody) {
		int anzahlIntervalle = Functions.anzahlToene(melody) - 1;
		int[] ohneNullen = new int[32];
		int n = 0;
		int count = 0;
		
		for(int i = 0; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				ohneNullen[n] = melody.MelodyArray[i];
				n++;
			}
		}
		//an n-1 steht also nun die letzte relevante Zahl
		
		for(int j = 1; j <= n-1 ; j++) {
			if(Math.abs(ohneNullen[j-1] - ohneNullen[j]) >5) {
				count++;
			}
		}
		return (((double)count)/((double)anzahlIntervalle));
		
	}

	//Feature 17: Notendichte
	public static double feature17(Melody melody) {
		int anzahlToene = Functions.anzahlToene(melody);
		return (((double)anzahlToene)/((double)32));
	}
	
	//Feature 19: Tonlängenvielfalt
	//Unterschied zu Klinger: ohne max-Funktion, nur anzahlVerschiedenerLängen/maxAnzahlVerschiedenerLängen
	//mit maxAnzahlVerschiedenerLängen = 7
	public static double feature19(Melody melody) {
		int[] histogramm = new int[32];
		int x;
		int count = 0;
		for(int i = 0; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				x = Functions.berechneNotenlaengeAnIndex(melody, i);
				histogramm[x]++;
			}
		}
		
		for(int j = 0; j <= 31; j++) {
			if(histogramm[j] != 0) {
				count++;
			}
		}
		return (double)(((double)count)/7);
		
	}

	
	//Feature 20: Tonlängenumfang
	//Unterschied zu Klinger: ohne max-Funktion, nur DifferenzLängsteKürzeste/MaximalAngenommen
	//wobei der maximal angenommene Unterschied wie bei Klinger mit 16 angenommen wird.
	public static double feature20(Melody melody) {

		int min = 16;
		int max = 1;
		int aktuelleLaenge;
		int diff;
		
		for(int i = 0; i <=31; i++) {
			if(melody.MelodyArray[i] != 0) {
				aktuelleLaenge = Functions.berechneNotenlaengeAnIndex(melody, i);
				if(aktuelleLaenge < min) {
					min = aktuelleLaenge;
				}
				if(aktuelleLaenge > max) {
					max = aktuelleLaenge;
				}
			}
		}
		diff = max - min;
		return (((double)diff)/((double)16));
		
	}
	
	//Feature 23: Repeated Pitch
	public static double feature23(Melody melody) {
		int anzahlIntervalle = Functions.anzahlToene(melody) - 1;
		int[] ohneNullen = new int[32];
		int n = 0;
		int count = 0;
		
		for(int i = 0; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				ohneNullen[n] = melody.MelodyArray[i];
				n++;
			}
		}
		//an n-1 steht also nun die letzte relevante Zahl
		
		
		for(int j = 1; j <= n-1; j++) {
			if(ohneNullen[j-1] == ohneNullen[j]) {
				count++;
			}
		}
		
		return (((double)count)/((double)anzahlIntervalle));
	}
	
	//Feature 24: Repeated Rhythmic Value
	public static double feature24(Melody melody) {
		int anzahlIntervalle = Functions.anzahlToene(melody) - 1;
		int letzteLaenge = Functions.berechneNotenlaengeAnIndex(melody, 0);
		int count = 0;
		int aktuelleLaenge;
		
		
		for(int i = 1; i <= 31; i++) {
			if(melody.MelodyArray[i] != 0) {
				aktuelleLaenge = Functions.berechneNotenlaengeAnIndex(melody, i);
				if (letzteLaenge == aktuelleLaenge) {
					count++;
				}
				letzteLaenge = aktuelleLaenge;
			}
		}
		return (((double)count)/((double)anzahlIntervalle));
	}
	
	//Feature 25: Repeated Pitch Patterns of Three Notes
	//Unterschied zu Klinger: anzahlToene - 5 , nicht - 4
	public static double feature25(Melody melody) {
		int anzahlToene = Functions.anzahlToene(melody);
		int[] ohneNullen = new int[32];
		int n = 0;
		
		
		for(int j = 0; j <= 31; j++) {
			if(melody.MelodyArray[j] != 0) {
				ohneNullen[n] = melody.MelodyArray[j];
				n++;
			}
		}
		//an n-1 steht also nun die letzte relevante Zahl
		
		int count = 0;
		for(int i = 0; i <= (n - 6); i++) {	
			if((ohneNullen[i] == ohneNullen[i + 3]) && (ohneNullen[i + 1] == ohneNullen[i + 4]) && (ohneNullen[i + 2] == ohneNullen[i + 5])) {
				count++;
			
			}
		}
		if(anzahlToene - 5 <= 0) {return 0;}
		return (((double)count)/((double)(anzahlToene - 5)));
	}
	
	//Feature 26: Repeated Pitch Patterns of Four Notes
	//Unterschied zu Klinger: anzahlToene - 6, nicht -5
	public static double feature26(Melody melody) {
		int anzahlToene = Functions.anzahlToene(melody);
		int[] ohneNullen = new int[32];
		int n = 0;
		
		
		for(int j = 0; j <= 31; j++) {
			if(melody.MelodyArray[j] != 0) {
				ohneNullen[n] = melody.MelodyArray[j];
				n++;
			}
		}
		//an n-1 steht also nun die letzte relevante Zahl
		
		int count = 0;
		for(int i = 0; i <= (n - 8); i++) {	
			if((ohneNullen[i] == ohneNullen[i + 4]) && (ohneNullen[i + 1] == ohneNullen[i + 5]) && (ohneNullen[i + 2] == ohneNullen[i + 6]) && (ohneNullen[i + 3] == ohneNullen[i + 7])) {
				count++;
			
			}
		}
		if(anzahlToene - 6 <= 0) {return 0;}
		return (((double)count)/((double)(anzahlToene - 6)));
	}
	
	//Feature 27: Repeated Rhythm Patterns of Three Notes
	public static double feature27(Melody melody) {
		int[] ohneNullen = new int[32];
		int n = 0;
		int anzahlToene = Functions.anzahlToene(melody);
		
		for(int j = 0; j <= 31; j++) {
			if(melody.MelodyArray[j] != 0) {
				ohneNullen[n] = Functions.berechneNotenlaengeAnIndex(melody, j);
				n++;
			}
		}
		//an n-1 steht also nun die letzte relevante Notenlänge
		
		int count = 0;
		
		for(int i = 0; i <= (n - 6); i++) {	
			if((ohneNullen[i] == ohneNullen[i + 3]) && (ohneNullen[i + 1] == ohneNullen[i + 4]) && (ohneNullen[i + 2] == ohneNullen[i + 5])) {
				count++;
			
			}
		}
		if(anzahlToene - 5 <= 0) {return 0;}
		return (((double)count)/((double)(anzahlToene - 5)));
		
	}
	
	//Feature 28: Repeated Rhythm Patterns of Four Notes
	public static double feature28(Melody melody) {
		int anzahlToene = Functions.anzahlToene(melody);
		int[] ohneNullen = new int[32];
		int n = 0;
		
		
		for(int j = 0; j <= 31; j++) {
			if(melody.MelodyArray[j] != 0) {
				ohneNullen[n] = Functions.berechneNotenlaengeAnIndex(melody, j);
				n++;
			}
		}
		//an n-1 steht also nun die letzte relevante Notenlänge
		
		int count = 0;
		for(int i = 0; i <= (n - 8); i++) {	
			if((ohneNullen[i] == ohneNullen[i + 4]) && (ohneNullen[i + 1] == ohneNullen[i + 5]) && (ohneNullen[i + 2] == ohneNullen[i + 6]) && (ohneNullen[i + 3] == ohneNullen[i + 7])) {
				count++;
			
			}
		}
		if(anzahlToene - 6 <= 0) {return 0;}
		return (((double)count)/((double)(anzahlToene - 6)));
	}
	
	
	
	//Feature 29: Globally Repeated Rhythm Patterns of Three Notes
		public static double feature29(Melody melody) {
			int[] pivot = new int[3];
			int anzahlToene = Functions.anzahlToene(melody);
			int[] ohneNullen = new int[32];
			int n = 0;
			int x = 0;
			int count = 0;
			
			
			for(int j = 0; j <= 31; j++) {
				if(melody.MelodyArray[j] != 0) {
					ohneNullen[n] = Functions.berechneNotenlaengeAnIndex(melody, j);
					n++;
				}
			}
			
			//an n-1 steht also nun die letzte relevante Notenlänge
			
			for(int i = 0; i <= (n - 6); i++) {
				pivot[0] = ohneNullen[i];
				pivot[1] = ohneNullen[i+1];
				pivot[2] = ohneNullen[i+2];
				for(x = (i + 3); x <= (n-3); x++) {
					if((ohneNullen[x] == pivot[0]) && (ohneNullen[x+1] == pivot[1]) && (ohneNullen[x+2] == pivot[2])) {
						count++;
						break;
					}		
				}	
			}
			if(anzahlToene - 5 <= 0) {return 0;}
			return (((double)count)/((double)(anzahlToene - 5)));
			
		}
		
		//Feature 30: Globally Repeated Rhythm Patterns of Four Notes
		public static double feature30(Melody melody) {
			int[] pivot = new int[4];
			int anzahlToene = Functions.anzahlToene(melody);
			int[] ohneNullen = new int[32];
			int n = 0;
			int x = 0;
			int count = 0;
			
			
			for(int j = 0; j <= 31; j++) {
				if(melody.MelodyArray[j] != 0) {
					ohneNullen[n] = Functions.berechneNotenlaengeAnIndex(melody, j);
					n++;
				}
			}
			
			//an n-1 steht also nun die letzte relevante Notenlänge
			
			for(int i = 0; i <= (n - 8); i++) {
				pivot[0] = ohneNullen[i];
				pivot[1] = ohneNullen[i+1];
				pivot[2] = ohneNullen[i+2];
				pivot[3] = ohneNullen[i+3];
				for(x = (i + 4); x <= (n-4); x++) {
					if((ohneNullen[x] == pivot[0]) && (ohneNullen[x+1] == pivot[1]) && (ohneNullen[x+2] == pivot[2]) && (ohneNullen[x+3] == pivot[3])) {
						count++;
						break;
					}		
				}	
			}
			if(anzahlToene - 6 <= 0) {return 0;}
			return (((double)count)/((double)(anzahlToene - 6)));
		}
		
		//Feature 31: Holding Notes Fitting to Chord Change
				public static double feature31(Melody melody) {
					int[] nurAchtel = new int[32];
					int count = 0;
					
					nurAchtel[0] = melody.MelodyArray[0];
					for(int j = 1; j <= 31; j++) {
						if(melody.MelodyArray[j] == 0) {
							nurAchtel[j] = nurAchtel[j-1];
						} else {
							nurAchtel[j] = melody.MelodyArray[j];
						}
					}
					
					
					if((melody.MelodyArray[8] == 0) && 
							
									((nurAchtel[8] == 6) ||
									(nurAchtel[8] == 13) ||
									(nurAchtel[8] == 1) ||
									(nurAchtel[8] == 8)  )
									
									) {
						count++;
					}
					
					if((melody.MelodyArray[16] == 0) && 
							
							((nurAchtel[16] == 1) ||
							(nurAchtel[16] == 8)  )
							
							) {
						count++;
					}
					if((melody.MelodyArray[24] == 0) && 
							
							((nurAchtel[24] == 5) ||
							(nurAchtel[24] == 12) )
							
							) {
						count++;
					}
					
					return (double)(((double)count)/(double)3);  //Es gibt 3 Akkordwechsel
				}
				
				//Feature 32: Holding Notes not Fitting to Chord Change
				public static double feature32(Melody melody) {
					int[] nurAchtel = new int[32];
					int count = 0;
					
					nurAchtel[0] = melody.MelodyArray[0];
					for(int j = 1; j <= 31; j++) {
						if(melody.MelodyArray[j] == 0) {
							nurAchtel[j] = nurAchtel[j-1];
						} else {
							nurAchtel[j] = melody.MelodyArray[j];
						}
					}
					
					
					if((melody.MelodyArray[8] == 0) && 
							
									((nurAchtel[8] == 3) ||
									(nurAchtel[8] == 10)  )
									
									) {
						count++;
					}
					
					if((melody.MelodyArray[16] == 0) && 
							
							((nurAchtel[16] == 4) ||
							(nurAchtel[16] == 11) ||
							(nurAchtel[16] == 6) ||
							(nurAchtel[16] == 13) )
							
							) {
						count++;
					}
					if((melody.MelodyArray[24] == 0) && 
							
							((nurAchtel[24] == 1) ||
							(nurAchtel[24] == 8) ||
							(nurAchtel[24] == 3) ||
							(nurAchtel[24] == 10) )
							
							) {
						count++;
					}	
					return (double)(((double)count)/(double)3);  //Es gibt 3 Akkordwechsel
				}
				
				//Feature 33: Note Pitch Changing with Chord Change
				public static double feature33(Melody melody) {
					int[] nurAchtel = new int[32];
					int count = 0;
					
					nurAchtel[0] = melody.MelodyArray[0];
					for(int j = 1; j <= 31; j++) {
						if(melody.MelodyArray[j] == 0) {
							nurAchtel[j] = nurAchtel[j-1];
						} else {
							nurAchtel[j] = melody.MelodyArray[j];
						}
					}
					
					if(nurAchtel[8] != nurAchtel[7]) {
						count++;
					}
					if(nurAchtel[16] != nurAchtel[15]) {
						count++;
					}
					if(nurAchtel[24] != nurAchtel[23]) {
						count++;
					}
					return (double)(((double)count)/(double)3);  //Es gibt 3 Akkordwechsel
				}
				
				//Feature 35: Downbeat Notes in Chord
				public static double feature35(Melody melody) {
					int countDownbeats = 0;
					int count = 0;
					
					//zähle Betonungen erster Ordnung:
					if(melody.MelodyArray[0] != 0) {
						countDownbeats++;
					}
					if(melody.MelodyArray[8] != 0) {
						countDownbeats++;
					}
					if(melody.MelodyArray[16] != 0) {
						countDownbeats++;
					}
					if(melody.MelodyArray[24] != 0) {
						countDownbeats++;
					}
					
					
					
					//zähle akkordeigene Töne auf erster Betonung
					//Am
					if(
							(melody.MelodyArray[0] == 6) ||
							(melody.MelodyArray[0] == 13) ||
							(melody.MelodyArray[0] == 1) ||
							(melody.MelodyArray[0] == 8) ||
							(melody.MelodyArray[0] == 3) ||
							(melody.MelodyArray[0] == 10)) {							
						count++;
					}
					
					//F
					if(
							(melody.MelodyArray[8] == 4) ||
							(melody.MelodyArray[8] == 11) ||
							(melody.MelodyArray[8] == 6) ||
							(melody.MelodyArray[8] == 13) ||
							(melody.MelodyArray[8] == 1) ||
							(melody.MelodyArray[8] == 8)) {							
						count++;
					}
					
					//C
					if(
							(melody.MelodyArray[16] == 1) ||
							(melody.MelodyArray[16] == 8) ||
							(melody.MelodyArray[16] == 5) ||
							(melody.MelodyArray[16] == 12) ||
							(melody.MelodyArray[16] == 3) ||
							(melody.MelodyArray[16] == 10)) {							
						count++;
					}
					
					//G
					if(
							(melody.MelodyArray[24] == 5) ||
							(melody.MelodyArray[24] == 12) ||
							(melody.MelodyArray[24] == 7) ||
							(melody.MelodyArray[24] == 14) ||
							(melody.MelodyArray[24] == 2) ||
							(melody.MelodyArray[24] == 9)) {							
						count++;
					}
					return (double)(((double)count)/(double)countDownbeats);
				}
				
				//Feature 39: Halfdownbeat Notes in Chord
				public static double feature39(Melody melody) {
					int countDownbeats = 0;
					int count = 0;
					
					//zähle Betonungen zweiter Ordnung:
					if(melody.MelodyArray[4] != 0) {
						countDownbeats++;
					}
					if(melody.MelodyArray[12] != 0) {
						countDownbeats++;
					}
					if(melody.MelodyArray[20] != 0) {
						countDownbeats++;
					}
					if(melody.MelodyArray[28] != 0) {
						countDownbeats++;
					}
					
					
					if(countDownbeats == 0) {
						return 1;
					}
					//zähle akkordeigene Töne auf erster Betonung
					//Am
					if(
							(melody.MelodyArray[4] == 6) ||
							(melody.MelodyArray[4] == 13) ||
							(melody.MelodyArray[4] == 1) ||
							(melody.MelodyArray[4] == 8) ||
							(melody.MelodyArray[4] == 3) ||
							(melody.MelodyArray[4] == 10)) {							
						count++;
					}
					
					//F
					if(
							(melody.MelodyArray[12] == 4) ||
							(melody.MelodyArray[12] == 11) ||
							(melody.MelodyArray[12] == 6) ||
							(melody.MelodyArray[12] == 13) ||
							(melody.MelodyArray[12] == 1) ||
							(melody.MelodyArray[12] == 8)) {							
						count++;
					}
					
					//C
					if(
							(melody.MelodyArray[20] == 1) ||
							(melody.MelodyArray[20] == 8) ||
							(melody.MelodyArray[20] == 5) ||
							(melody.MelodyArray[20] == 12) ||
							(melody.MelodyArray[20] == 3) ||
							(melody.MelodyArray[20] == 10)) {							
						count++;
					}
					
					//G
					if(
							(melody.MelodyArray[28] == 5) ||
							(melody.MelodyArray[28] == 12) ||
							(melody.MelodyArray[28] == 7) ||
							(melody.MelodyArray[28] == 14) ||
							(melody.MelodyArray[28] == 2) ||
							(melody.MelodyArray[28] == 9)) {							
						count++;
					}
					
					return (double)(((double)count)/(double)countDownbeats);
				}
				
				
}


