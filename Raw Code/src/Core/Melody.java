package Core;

import java.io.File;
import java.io.IOException;

import javax.sound.*;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

//repräsentiert eine Melodie

public class Melody {
	public int[] MelodyArray = new int[32];
	public Sequence MidiRepresenter = new Sequence(Sequence.PPQ, 1);
	public Track track = MidiRepresenter.createTrack();
	
	
	
	public Melody() throws InvalidMidiDataException{
		//System.out.println("Es wurde eine neue Melodie erzeugt.");
		
	}
	
	//Midi-Struktur wird aus Melodie erzeugt erzeugt
	public void buildMidi() throws InvalidMidiDataException, IOException {
		int pitch;
		int lastNoteOn = 0;
		
		//iteriere durchs Zeitraster, schalte jeweils letzten angespielten Ton aus
		for (int i = 0; i <= 31; i++){
			if(MelodyArray[i] == 0) {
				continue;
			}	
			ShortMessage message = new ShortMessage();
			ShortMessage message2 = new ShortMessage();	
			pitch = Functions.getPitchValue(MelodyArray[i]);	
			//System.out.println("Der Pitch von Note" + i + "ist gleich" + pitch);
			//System.out.println("Ausgeschalten wird" + i + "ist gleich" + lastNoteOn);
			
			//bei der ersten Note muss kein Ton abgeschalten werden
			if(i != 0){
			 message2.setMessage(ShortMessage.NOTE_OFF,lastNoteOn,127);
			 MidiEvent event2 = new MidiEvent(message2, i);
			 track.add(event2);		 	
			}
			message.setMessage(ShortMessage.NOTE_ON,pitch,127);	
			MidiEvent event = new MidiEvent(message, i);
			track.add(event);
			lastNoteOn = pitch;		
		}
		
		//schalte letzte Note aus
		ShortMessage message3 = new ShortMessage();
		message3.setMessage(ShortMessage.NOTE_OFF,lastNoteOn,127);
		MidiEvent event3 = new MidiEvent(message3, 32);
		track.add(event3);
		
		//Create Playback-Progression: Am, F, C, G
		//Am
				ShortMessage message4 = new ShortMessage();
				message4.setMessage(ShortMessage.NOTE_ON, 57, 100);
				MidiEvent event4 = new MidiEvent(message4, 0);
				track.add(event4);
				ShortMessage message5 = new ShortMessage();
				message5.setMessage(ShortMessage.NOTE_ON, 60, 100);
				MidiEvent event5 = new MidiEvent(message5,0);
				track.add(event5);
				ShortMessage message6 = new ShortMessage();
				message6.setMessage(ShortMessage.NOTE_ON, 64, 100);
				MidiEvent event6 = new MidiEvent(message6,0);
				track.add(event6);
		
		//F
				ShortMessage message7 = new ShortMessage();
				message7.setMessage(ShortMessage.NOTE_ON, 57, 100);
				MidiEvent event7 = new MidiEvent(message7, 8);
				track.add(event7);
				ShortMessage message8 = new ShortMessage();
				message8.setMessage(ShortMessage.NOTE_ON, 60, 100);
				MidiEvent event8 = new MidiEvent(message8,8);
				track.add(event8);
				ShortMessage message9 = new ShortMessage();
				message9.setMessage(ShortMessage.NOTE_ON, 65, 100);
				MidiEvent event9 = new MidiEvent(message9,8);
				track.add(event9);
				
		//C
				ShortMessage message10 = new ShortMessage();
				message10.setMessage(ShortMessage.NOTE_ON, 55, 100);
				MidiEvent event10 = new MidiEvent(message10, 16);
				track.add(event10);
				ShortMessage message11 = new ShortMessage();
				message11.setMessage(ShortMessage.NOTE_ON, 60, 100);
				MidiEvent event11 = new MidiEvent(message11,16);
				track.add(event11);
				ShortMessage message12 = new ShortMessage();
				message12.setMessage(ShortMessage.NOTE_ON, 64, 100);
				MidiEvent event12 = new MidiEvent(message12,16);
				track.add(event12);		
				
				
		//G
				ShortMessage message13 = new ShortMessage();
				message13.setMessage(ShortMessage.NOTE_ON, 55, 80);
				MidiEvent event13 = new MidiEvent(message13, 24);
				track.add(event13);
				ShortMessage message14 = new ShortMessage();
				message14.setMessage(ShortMessage.NOTE_ON, 59, 80);
				MidiEvent event14 = new MidiEvent(message14,24);
				track.add(event14);
				ShortMessage message15 = new ShortMessage();
				message15.setMessage(ShortMessage.NOTE_ON, 62, 80);
				MidiEvent event15 = new MidiEvent(message15,24);
				track.add(event15);		
		
				
		//Functions.saveSequence(MidiRepresenter, "midi2.midi");
		
	}

}
