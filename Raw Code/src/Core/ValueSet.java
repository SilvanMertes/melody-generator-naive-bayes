package Core;


//Diese Klasse repräsentiert ein Set von Feature-Werten. Dabei wird nicht der exakte Wert gespeichert, sondern nur,
//ob das Feature erfüllt ist oder nicht.
public class ValueSet {
	public int[] feature;
	
	public ValueSet() {
		feature = new int[40];
		for(int i = 0; i <= 39 ;i++) {
			feature[i] = 0;
		}
	}

}
