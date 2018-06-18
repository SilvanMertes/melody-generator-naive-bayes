package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Schnittstelle, um Informationen aus der Datenbank zu lesen
public class ReadFunctions {
	
	//returns the number of melodies that where classified as 'good'
		public static int getNumberOfGoodMelodies() {
			String query = "SELECT Count(*) from melodies WHERE good = 1";
			Connection conn = database.getConn();
			ResultSet rs = null;
			int number = 0;
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
			} catch (Exception e) {
				System.out.println("Something went wrong in getNumberOfGoodMelodies()" + e.getMessage());
			}
			
				
				try {
					while(rs.next()) {
						number = rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				return number;
		}
		
		//returns the number of melodies that where classified as 'bad'
			public static int getNumberOfBadMelodies() {
				String query = "SELECT Count(*) from melodies WHERE good = 0";
				Connection conn = database.getConn();
				ResultSet rs = null;
				int number = 0;
				try {
					Statement stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
				} catch (Exception e) {
					System.out.println("Something went wrong in getNumberOfBadMelodies()" + e.getMessage());
				}
				
					
					try {
						while(rs.next()) {
							number = rs.getInt(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
					return number;
			}
			
			
			//returns all melodies in the database
			public static ResultSet readAllMelodies() throws SQLException{

				String query = "SELECT * from melodies";
				ResultSet rs = null;
				Connection conn = database.getConn();
				try {
					Statement stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
				} catch (Exception e) {
					System.out.println("Something went wrong in readAllMelodies()" + e.getMessage());
				}		
				return rs;
			}
			
			public static int getNextMelodyID() throws SQLException {
				int x = 0;
				String query = "SELECT MAX(ID) from melodies";
				ResultSet rs = null;
				Connection conn = database.getConn();
				try {
					Statement stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					x = rs.getInt(1) + 1;
					//conn.close();
				} catch (Exception e) {
					System.out.println("Something went wrong in getNextMelodyID()" + e.getMessage());
				}		
				return x;
			}
			
			//returns the number of melodies that has feature with number 'featureNumber' true and that fit the classification 'classification'
			public static int getFeatureAndClassificationCount(int featureNumber, int classification) {
				String query = "SELECT Count(*) from melodies WHERE good = " +
						classification +
						" AND feature" + featureNumber + " = 1;";
						
						
						
				Connection conn = database.getConn();
				ResultSet rs = null;
				int number = 0;
				try {
					Statement stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
				} catch (Exception e) {
					System.out.println("Something went wrong in getFeatureAndClassificationCount()" + e.getMessage());
				}
				
					
					try {
						while(rs.next()) {
							number = rs.getInt(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
					return number;
			}
			
			
			//returns the number of melodies that are persisted in the database
			public static int getNumberOfAllMelodies() {
				String query = "SELECT Count(*) from melodies;";
				Connection conn = database.getConn();
				ResultSet rs = null;
				int number = 0;
				try {
					Statement stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
				} catch (Exception e) {
					System.out.println("Something went wrong in getNumberOfAllMelodies()" + e.getMessage());
				}
				
					
					try {
						while(rs.next()) {
							number = rs.getInt(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
					return number;
			}
			
		

}
