package beta;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
	private File bassDrumDir, clickDir, doubleBassDir, pianoDir, snareDrumDir;
	private File[] bassDrumFiles, clickFiles, doubleBassFiles, pianoFiles, snareDrumFiles;
	Sequence s;
	Sequencer sq;

	public SoundManager() {
		bassDrumDir = new File("resources//Sounds//Bass Drum");
		clickDir = new File("resources//Sounds//Click");
		doubleBassDir = new File("resources//Sounds//Double Bass");
		pianoDir = new File("resources//Sounds//Piano");
		snareDrumDir = new File("resources//Sounds//Snare Drum");
		loadSounds();
	}
	
	public void loadSounds() {
		bassDrumFiles = bassDrumDir.listFiles();
		clickFiles = clickDir.listFiles();
		doubleBassFiles = doubleBassDir.listFiles();
		pianoFiles = pianoDir.listFiles();
		snareDrumFiles = snareDrumDir.listFiles();
		try {
			s = MidiSystem.getSequence(new File("resources//Sounds//Bass Drum//A#3.mid"));
			sq = MidiSystem.getSequencer();
			sq.open();
			sq.setSequence(s);
			sq.start();
		} catch(Exception e) {
			
		}
		/**
		try {
			sample = AudioSystem.getAudioInputStream(new File("resources//Sounds//Bass Drum//A#3.mid"));
			sound = AudioSystem.getClip();
			sound.open(sample);
		} catch(Exception e) {
			
		}
		**/
	}
	
	public void play() {
		sq.start();
		/**
		sound.stop();
		sound.setFramePosition(0);
		sound.start();
		**/
	}
	
	/**
	public void playSound() {
			try {
	          Clip clip = AudioSystem.getClip();
	          AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("resources//Sounds//test.wav"));
	          clip.open(inputStream);
	          clip.start();
	        } catch (Exception e) {
	          System.err.println(e.getMessage());
	        }
	}
	**/

}
