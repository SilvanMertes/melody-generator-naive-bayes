package Database;

import java.sql.Statement;

import javax.sound.midi.InvalidMidiDataException;

import Core.FeatureThresholds;
import Core.Features;
import Core.Melody;
import Core.ValueSet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


//repräsentiert die Datenhaltungsschicht. Baut Datenbankverbindungen auf
public class database{
	private static Connection c = null;
	public static Connection getConn() {
	 try {
		 
		 if(c == null){
			    Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:komposition.db");
			    }
		 
        // Class.forName("org.sqlite.JDBC");
         //String dbURL = "jdbc:sqlite:komposition.db";
         //Connection conn = DriverManager.getConnection(dbURL);
         /*if (conn != null) {
             System.out.println("Connected to the database");
             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
             System.out.println("Driver name: " + dm.getDriverName());
             System.out.println("Driver version: " + dm.getDriverVersion());
             System.out.println("Product name: " + dm.getDatabaseProductName());
             System.out.println("Product version: " + dm.getDatabaseProductVersion());
             
         }*/
         return c;
     } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
	return null;
	}
	
	
	
	//closes a connection
	public static void closeConn(Connection conn){
		try {
		conn.close();
		} catch(SQLException ex) {
			System.out.println("Something went wrong");
		}
	}
	
	
	
	public static void createTable() {
		String query = "CREATE TABLE 'test2' ('note0'	INTEGER, PRIMARY KEY('note0'));";
		int rs;
		Connection conn = getConn();
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Something went wrong in createTable()" + e.getMessage());
		}
	}
	
	
	
	
	
	
	

	
	//persists a melody into the database
	public static void persistMelody(Melody melody, Boolean good) throws SQLException {
		int goodInt = 0;
		if (good == true) goodInt = 1;
		int nextID = ReadFunctions.getNextMelodyID();
		String query = "INSERT INTO melodies VALUES (" + nextID;
		for(int i = 0; i<=31; i++) {
			query = query + "," + melody.MelodyArray[i];
		}
		query = query +"," + goodInt + ", NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
		int rs;
		Connection conn = getConn();
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(query);
			//conn.close();
		} catch (Exception e) {
			System.out.println("Something went wrong in persistMelody()" + e.getMessage());
		}
	}
	
	
	public static void updateFeaturesInDatabase() throws SQLException, InvalidMidiDataException {
		ResultSet allMelodys = ReadFunctions.readAllMelodies();
		Melody focusMelody = new Melody();
		int ID = 0;
		ValueSet valueSet = new ValueSet();
		GUI.Hauptframe.label.setText("Aktualisiere Datenbank...");
		
		try {
			while(allMelodys.next()) {
				
				valueSet = new ValueSet();
				focusMelody.MelodyArray[0] = allMelodys.getInt("note0");
				focusMelody.MelodyArray[1] = allMelodys.getInt("note1");
				focusMelody.MelodyArray[2] = allMelodys.getInt("note2");
				focusMelody.MelodyArray[3] = allMelodys.getInt("note3");
				focusMelody.MelodyArray[4] = allMelodys.getInt("note4");
				focusMelody.MelodyArray[5] = allMelodys.getInt("note5");
				focusMelody.MelodyArray[6] = allMelodys.getInt("note6");
				focusMelody.MelodyArray[7] = allMelodys.getInt("note7");
				focusMelody.MelodyArray[8] = allMelodys.getInt("note8");
				focusMelody.MelodyArray[9] = allMelodys.getInt("note9");
				focusMelody.MelodyArray[10] = allMelodys.getInt("note10");
				focusMelody.MelodyArray[11] = allMelodys.getInt("note11");
				focusMelody.MelodyArray[12] = allMelodys.getInt("note12");
				focusMelody.MelodyArray[13] = allMelodys.getInt("note13");
				focusMelody.MelodyArray[14] = allMelodys.getInt("note14");
				focusMelody.MelodyArray[15] = allMelodys.getInt("note15");
				focusMelody.MelodyArray[16] = allMelodys.getInt("note16");
				focusMelody.MelodyArray[17] = allMelodys.getInt("note17");
				focusMelody.MelodyArray[18] = allMelodys.getInt("note18");
				focusMelody.MelodyArray[19] = allMelodys.getInt("note19");
				focusMelody.MelodyArray[20] = allMelodys.getInt("note20");
				focusMelody.MelodyArray[21] = allMelodys.getInt("note21");
				focusMelody.MelodyArray[22] = allMelodys.getInt("note22");
				focusMelody.MelodyArray[23] = allMelodys.getInt("note23");
				focusMelody.MelodyArray[24] = allMelodys.getInt("note24");
				focusMelody.MelodyArray[25] = allMelodys.getInt("note25");
				focusMelody.MelodyArray[26] = allMelodys.getInt("note26");
				focusMelody.MelodyArray[27] = allMelodys.getInt("note27");
				focusMelody.MelodyArray[28] = allMelodys.getInt("note28");
				focusMelody.MelodyArray[29] = allMelodys.getInt("note29");
				focusMelody.MelodyArray[30] = allMelodys.getInt("note30");
				focusMelody.MelodyArray[31] = allMelodys.getInt("note31");
				ID = allMelodys.getInt("ID");
				
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
				
				persistValueSet(valueSet, ID);
				
			}
		} catch (Exception e) {e.printStackTrace();}
		GUI.Hauptframe.label.setText("Die Datenbank wurde aktualisiert. Es kann weitergehen!");
	}
	
	public static void persistValueSet(ValueSet valueSet, int ID) throws SQLException {
		String query;
		query="UPDATE melodies SET " + 
				"feature1 = " + valueSet.feature[1] + ", " +
				"feature2 = " + valueSet.feature[2] + ", " +
				"feature3 = " + valueSet.feature[3] + ", " +
				"feature4 = " + valueSet.feature[4] + ", " +
				"feature7 = " + valueSet.feature[7] + ", " +
				"feature8 = " + valueSet.feature[8] + ", " +
				"feature9 = " + valueSet.feature[9] + ", " +
				"feature11 = " + valueSet.feature[11] + ", " +
				"feature12 = " + valueSet.feature[12] + ", " +
				"feature13 = " + valueSet.feature[13] + ", " +
				"feature14 = " + valueSet.feature[14] + ", " +
				"feature15 = " + valueSet.feature[15] + ", " +
				"feature16 = " + valueSet.feature[16] + ", " +
				"feature17 = " + valueSet.feature[17] + ", " +
				"feature19 = " + valueSet.feature[19] + ", " +
				"feature20 = " + valueSet.feature[20] + ", " +
				"feature23 = " + valueSet.feature[23] + ", " +
				"feature24 = " + valueSet.feature[24] + ", " +
				"feature25 = " + valueSet.feature[25] + ", " +
				"feature26 = " + valueSet.feature[26] + ", " +
				"feature27 = " + valueSet.feature[27] + ", " +
				"feature28 = " + valueSet.feature[28] + ", " +
				"feature29 = " + valueSet.feature[29] + ", " +
				"feature30 = " + valueSet.feature[30] + ", " +
				"feature31 = " + valueSet.feature[31] + ", " +
				"feature32 = " + valueSet.feature[32] + ", " +
				"feature33 = " + valueSet.feature[33] + ", " +
				"feature35 = " + valueSet.feature[35] + ", " +
				"feature39 = " + valueSet.feature[39] + " " +
				
				"WHERE ID = " + ID + ";";
		
		Connection conn = getConn();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			//conn.close();
			
		} catch (Exception e) {
			System.out.println("Something went wrong in persistValueSet()" + e.getMessage());
		} 
		
		
	}
}
