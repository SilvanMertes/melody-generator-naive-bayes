package Core;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 * An example that plays a Midi sequence. First, the sequence is played once
 * with track 1 turned off. Then the sequence is played once with track 1 turned
 * on. Track 1 is the drum track in the example midi file.
 */
public class MidiTest implements MetaEventListener {

  // The drum track in the example Midi file
  private static final int DRUM_TRACK = 1;

 
  private static MidiPlayer player;


  public static void run(Sequence givenSequence) {

    player = new MidiPlayer();

    // load a sequence
    Sequence sequence = givenSequence;

    // play the sequence
    player.play(sequence, true);

    // turn off the drums
    System.out.println("Playing (without drums)...");
    Sequencer sequencer = player.getSequencer();
    sequencer.setTrackMute(DRUM_TRACK, true);
    
  }

  /**
   * This method is called by the sound system when a meta event occurs. In
   * this case, when the end-of-track meta event is received, the drum track
   * is turned on.
   */
  public void meta(MetaMessage event) {
    if (event.getType() == MidiPlayer.END_OF_TRACK_MESSAGE) {
      Sequencer sequencer = player.getSequencer();
      if (sequencer.getTrackMute(DRUM_TRACK)) {
        // turn on the drum track
        System.out.println("Turning on drums...");
        sequencer.setTrackMute(DRUM_TRACK, false);
      } else {
        // close the sequencer and exit
        System.out.println("Exiting...");
        player.close();
        
      }
    }
  }

}
