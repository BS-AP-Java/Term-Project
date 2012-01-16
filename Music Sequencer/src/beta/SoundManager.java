package beta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
	private File bassDrumDir, clickDir, doubleBassDir, pianoDir, snareDrumDir;
	private File[] bassDrumFiles, clickFiles, doubleBassFiles, pianoFiles, snareDrumFiles;
	private Sequencer sq;
	private ArrayList<Sequence> sequences;
	private ArrayList<Sequencer> sequencers;

	public SoundManager() {
		bassDrumDir = new File("resources//Sounds//Bass Drum");
		clickDir = new File("resources//Sounds//Click");
		doubleBassDir = new File("resources//Sounds//Double Bass");
		pianoDir = new File("resources//Sounds//Piano");
		snareDrumDir = new File("resources//Sounds//Snare Drum");
		sequences = new ArrayList<Sequence>();
		sequencers = new ArrayList<Sequencer>();
		loadSounds();
	}
	
	public void loadSounds() {
		bassDrumFiles = bassDrumDir.listFiles();
		clickFiles = clickDir.listFiles();
		doubleBassFiles = doubleBassDir.listFiles();
		pianoFiles = pianoDir.listFiles();
		snareDrumFiles = snareDrumDir.listFiles();
		try {
			for(int i = 0; i < pianoFiles.length; i++) {
				Sequence seq = MidiSystem.getSequence(pianoFiles[i]);
				sequences.add(seq);
			}
			/**
			for(int i = 0; i < sequences.size(); i++) {
				Sequencer sqr = MidiSystem.getSequencer();
				//sqr.open();
				sqr.setSequence(sequences.get(i));
				sequencers.add(sqr);
			}
			**/
			sq = MidiSystem.getSequencer();
			sq.open();
			sq.setSequence(sequences.get(0));
		} catch(Exception e) {
			e.printStackTrace();
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
		/**
		for(int i = 0; i < sequencers.size(); i++) {
			try {
				sequencers.get(i).open();
				sequencers.get(i).setTickPosition(0);
				sequencers.get(i).start();
				Thread.sleep(750);
				sequencers.get(i).stop();
				sequencers.get(i).close();
				System.out.println(i);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		**/
		/**
		 * use this method!
		 * there can only be 16 sequencers because of the 16 channels in midi!
		 * reuse the sequencer like in this method to play another sound
		 */
		for(int i = 0; i < sequences.size(); i++) {
			try {
				sq.stop();
				sq.setSequence(sequences.get(i));
				sq.setTickPosition(0);
				sq.start();
				Thread.sleep(750);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		//sq.stop();
		//sq.setTickPosition(0);
		//sq.start();
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
	
	/**
	 * use this to close a sequencer once the track has finished playing
	sequencer.addMetaEventListener(new MetaEventListener() {

        @Override
        public void meta(MetaMessage metaMsg) {
            if (metaMsg.getType() == 0x2F) {
                sequencer.close();
            }
        }
    });
    **/

}
