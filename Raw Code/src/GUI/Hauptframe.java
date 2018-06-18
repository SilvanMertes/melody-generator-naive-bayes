package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.sound.midi.InvalidMidiDataException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import Core.Functions;
import Core.Melody;
import Core.MidiTest;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

//Diese Klasse baut die GUI auf
public class Hauptframe {
	public static JTextArea label = new JTextArea("Hallo");
	public static Melody guiMelody = null;
	 public static void start()
	    {
	              
	        JFrame meinFrame = new JFrame("Naive-Bayes Composer");
	       
	        meinFrame.setSize(1200,400);
	        meinFrame.setLocationRelativeTo(null);
	       
	        meinFrame.getContentPane().setLayout(null);
	        
	        //JPanel NotePanel= new JPanel(); 
	        //NotePanel.setBounds(30,30,700,100); 
	        
	        meinFrame.getContentPane().setBackground(Color.PINK); 
	        
	        
	        label = new JTextArea("Initialisiere Datenbank...");
	        label.setBackground(Color.PINK);
	        label.setForeground(Color.WHITE);
	        label.setOpaque(true);
	        label.setSize(600, 100);
	        label.setLocation(100, 50);
	        label.setFont(new Font("Futura", Font.ITALIC, 25));
	        label.setLineWrap(true);
	        label.setWrapStyleWord(true);
	        label.setEditable(false);

	        meinFrame.add(label);
	        meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	            
	        
	        JButton playButton = new JButton("Play");
	        meinFrame.add(playButton);
	        playButton.setBounds(1000,50,90, 50); 
	        playButton.setBackground(Color.WHITE);
	        playButton.setForeground(Color.PINK);
	        
	        JButton generateButton = new JButton("Generate");
	        meinFrame.add(generateButton);
	        generateButton.setBounds(1000,100,90, 50); 
	        generateButton.setBackground(Color.WHITE);
	        generateButton.setForeground(Color.PINK);
	        
	        JButton classifyAsGood = new JButton("Das ist eine gute Melodie!");
	        meinFrame.add(classifyAsGood);
	        classifyAsGood.setBounds(100,250,300, 50); 
	        classifyAsGood.setBackground(Color.WHITE);
	        classifyAsGood.setForeground(Color.PINK);
	        
	        JButton classifyAsBad = new JButton("Das ist eine schlechte Melodie!");
	        meinFrame.add(classifyAsBad);
	        classifyAsBad.setBounds(400,250,300, 50); 
	        classifyAsBad.setBackground(Color.WHITE);
	        classifyAsBad.setForeground(Color.PINK);
	        
	        JButton refreshButton = new JButton("Datenbank aktualisieren");
	        meinFrame.add(refreshButton);
	        refreshButton.setBounds(1000,250,180, 50); 
	        refreshButton.setBackground(Color.WHITE);
	        refreshButton.setForeground(Color.PINK);
	        
	        JButton saveButton = new JButton("Melodie speichern");
	        meinFrame.add(saveButton);
	        saveButton.setBounds(1000,300,180, 50); 
	        saveButton.setBackground(Color.WHITE);
	        saveButton.setForeground(Color.PINK);

	        
	        meinFrame.setVisible(true);
	        
	        
	        saveButton.addActionListener((ActionEvent event) -> {
	        	
	        	if (guiMelody != null) {
	        		

	                // JFileChooser-Objekt erstellen
	                JFileChooser chooser = new JFileChooser();
	                // Dialog zum Oeffnen von Dateien anzeigen
	                int rueckgabeWert = chooser.showSaveDialog(null);
	                
	                /* Abfrage, ob auf "Öffnen" geklickt wurde */
	                if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
	                {
	                     // Ausgabe der ausgewaehlten Datei
	                    System.out.println("Die zu öffnende Datei ist: " +
	                          chooser.getSelectedFile());
	                }
	                try {
	                	guiMelody.buildMidi();
						Functions.saveSequence(guiMelody.MidiRepresenter, chooser.getSelectedFile().getPath() + ".midi");
						label.setText("Gespeichert!");
						guiMelody = null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidMidiDataException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	} else { label.setText("Du musst erst eine Melodie erzeugen, die Du abspeichern willst.");}
	        });
	        
	        
	        refreshButton.addActionListener((ActionEvent event) -> {
	        	
	        	try {
	        		
					Database.database.updateFeaturesInDatabase();
				} catch (SQLException | InvalidMidiDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        });
	        
	        classifyAsBad.addActionListener((ActionEvent event) -> {
	        	if(guiMelody != null) {
	        		try {
	        			Database.database.persistMelody(guiMelody, false);
	        			label.setText("Die Melodie wurde von Dir als schlecht klassifiziert und in die Datenbank übernommen.");
	        			guiMelody = null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}} else {
					label.setText("Du musst erst eine Melodie erzeugen, bevor du sie klassifizierst.");
				}
	        	
	        });
	        
	        classifyAsGood.addActionListener((ActionEvent event) -> {
	        	if(guiMelody != null) {
	        		try {
	        			Database.database.persistMelody(guiMelody, true);
	        			label.setText("Die Melodie wurde von Dir als gut klassifiziert und in die Datenbank übernommen.");
	        			guiMelody = null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}} else {
					label.setText("Du musst erst eine Melodie erzeugen, bevor du sie klassifizierst.");
				}
	        	
	        });
	        
	        
	        
	        playButton.addActionListener((ActionEvent event) -> {
	        	if(guiMelody == null) {
	        		label.setText("Du hast noch keine Melodie erzeugt, die abgespielt werden könnte!");
	        	} else {
	            try {
					guiMelody.buildMidi();
					MidiTest.run(guiMelody.MidiRepresenter);
					label.setText("Spiele Melodie ab...");
				} catch (InvalidMidiDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
	        });
	        
	        generateButton.addActionListener((ActionEvent event) -> {
	        	label.setText("Generiere eine neue Melodie...");
	        	try {
					guiMelody = Core.MelodyGenerators.generateZufallsMelodie();
				} catch (InvalidMidiDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	label.setText("Es wurde eine Melodie erzeugt!");
	        });
	        
	        
	    }

}
