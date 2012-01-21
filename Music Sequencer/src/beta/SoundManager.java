//********************************************************************
//SoundManager.java      
//Author: Kwun Chan and Nanyou Guan
// 
// 
//********************************************************************
package beta;

//import necessary classes
import java.io.File;
import java.util.ArrayList;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class SoundManager {
	//declare instance variables for this class
	private File bassDrumDir, clickDir, doubleBassDir, pianoDir, snareDrumDir;
	private File[] bassDrumFiles, clickFiles, doubleBassFiles, pianoFiles, snareDrumFiles;
	private Sequencer bassDrumSequencer, clickSequencer, doubleBassSequencer, pianoSequencer, snareDrumSequencer;
	private ArrayList<Sequence> bassDrumSequences, clickSequences, doubleBassSequences, pianoSequences, snareDrumSequences;
	private ArrayList<Integer> bassDrumRow, clickRow, doubleBassRow, pianoRow, snareDrumRow;
	
	//Constructs a new SoundManager object
	public SoundManager() {
		bassDrumDir = new File("resources//Sounds//Bass Drum");
		clickDir = new File("resources//Sounds//Click");
		doubleBassDir = new File("resources//Sounds//Double Bass");
		pianoDir = new File("resources//Sounds//Piano");
		snareDrumDir = new File("resources//Sounds//Snare Drum");
		bassDrumSequences = new ArrayList<Sequence>();
		clickSequences = new ArrayList<Sequence>();
		doubleBassSequences = new ArrayList<Sequence>();
		pianoSequences = new ArrayList<Sequence>();
		snareDrumSequences = new ArrayList<Sequence>();
		bassDrumRow = new ArrayList<Integer>();
		clickRow = new ArrayList<Integer>();
		doubleBassRow = new ArrayList<Integer>();
		pianoRow = new ArrayList<Integer>();
		snareDrumRow = new ArrayList<Integer>();
		loadSounds();
	}
	
	public void loadSounds() {
		bassDrumFiles = bassDrumDir.listFiles();
		clickFiles = clickDir.listFiles();
		doubleBassFiles = doubleBassDir.listFiles();
		pianoFiles = pianoDir.listFiles();
		snareDrumFiles = snareDrumDir.listFiles();
		try {
			for(int i = 0; i < bassDrumFiles.length; i++) {
				Sequence seq = MidiSystem.getSequence(bassDrumFiles[i]);
				bassDrumSequences.add(seq);
			}
			for(int i = 0; i < clickFiles.length; i++) {
				Sequence seq = MidiSystem.getSequence(clickFiles[i]);
				clickSequences.add(seq);
			}
			for(int i = 0; i < doubleBassFiles.length; i++) {
				Sequence seq = MidiSystem.getSequence(doubleBassFiles[i]);
				doubleBassSequences.add(seq);
			}
			for(int i = 0; i < pianoFiles.length; i++) {
				Sequence seq = MidiSystem.getSequence(pianoFiles[i]);
				pianoSequences.add(seq);
			}
			for(int i = 0; i < snareDrumFiles.length; i++) {
				Sequence seq = MidiSystem.getSequence(snareDrumFiles[i]);
				snareDrumSequences.add(seq);
			}
			bassDrumSequencer = MidiSystem.getSequencer();
			clickSequencer = MidiSystem.getSequencer();
			doubleBassSequencer = MidiSystem.getSequencer();
			pianoSequencer = MidiSystem.getSequencer();
			snareDrumSequencer = MidiSystem.getSequencer();
			bassDrumSequencer.open();
			clickSequencer.open();
			doubleBassSequencer.open();
			pianoSequencer.open();
			snareDrumSequencer.open();
			bassDrumSequencer.setSequence(bassDrumSequences.get(0));
			clickSequencer.setSequence(clickSequences.get(0));
			doubleBassSequencer.setSequence(doubleBassSequences.get(0));
			pianoSequencer.setSequence(pianoSequences.get(0));
			snareDrumSequencer.setSequence(snareDrumSequences.get(0));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void bassDrumAddNote(int note) {
		Integer num = new Integer(note);
		bassDrumRow.add(num);
	}
	
	public void clickAddNote(int note) {
		Integer num = new Integer(note);
		clickRow.add(num);
	}
	
	public void doubleBassAddNote(int note) {
		Integer num = new Integer(note);
		doubleBassRow.add(num);
	}
	
	public void pianoAddNote(int note) {
		Integer num = new Integer(note);
		pianoRow.add(num);
	}
	
	public void snareDrumAddNote(int note) {
		Integer num = new Integer(note);
		snareDrumRow.add(num);
	}
	
	
	public void bassDrumPlay(int note) {
		try {
			bassDrumSequencer.stop();
			bassDrumSequencer.setSequence(bassDrumSequences.get(note));
			bassDrumSequencer.setTickPosition(0);
			bassDrumSequencer.start();
		} catch(Exception e) {
			
		}
	}
	
	public void clickPlay(int note) {
		try {
			clickSequencer.stop();
			clickSequencer.setSequence(clickSequences.get(note));
			clickSequencer.setTickPosition(0);
			clickSequencer.start();
		} catch(Exception e) {
			
		}
	}
	
	public void doubleBassPlay(int note) {
		try {
			doubleBassSequencer.stop();
			doubleBassSequencer.setSequence(doubleBassSequences.get(note));
			doubleBassSequencer.setTickPosition(0);
			doubleBassSequencer.start();
		} catch(Exception e) {
			
		}
	}
	
	public void pianoPlay(int note) {
		try {
			pianoSequencer.stop();
			pianoSequencer.setSequence(pianoSequences.get(note));
			pianoSequencer.setTickPosition(0);
			pianoSequencer.start();
		} catch(Exception e) {
			
		}
	}
	
	public void snareDrumPlay(int note) {
		try {
			snareDrumSequencer.stop();
			snareDrumSequencer.setSequence(snareDrumSequences.get(note));
			snareDrumSequencer.setTickPosition(0);
			snareDrumSequencer.start();
		} catch(Exception e) {
			
		}
	}
	
	public void play(String instrument, int note) {
		try {
			if(instrument.equals("bassDrum")) {
				bassDrumSequencer.stop();
				bassDrumSequencer.setSequence(bassDrumSequences.get(note));
				bassDrumSequencer.setTickPosition(0);
				bassDrumSequencer.start();
			} else if(instrument.equals("click")) {
				clickSequencer.stop();
				clickSequencer.setSequence(clickSequences.get(note));
				clickSequencer.setTickPosition(0);
				clickSequencer.start();
			} else if(instrument.equals("doubleBass")) {
				doubleBassSequencer.stop();
				doubleBassSequencer.setSequence(doubleBassSequences.get(note));
				doubleBassSequencer.setTickPosition(0);
				doubleBassSequencer.start();
			} else if(instrument.equals("piano")) {
				pianoSequencer.stop();
				pianoSequencer.setSequence(pianoSequences.get(note));
				pianoSequencer.setTickPosition(0);
				pianoSequencer.start();
			} else if(instrument.equals("snareDrum")) {
				snareDrumSequencer.stop();
				snareDrumSequencer.setSequence(snareDrumSequences.get(note));
				snareDrumSequencer.setTickPosition(0);
				snareDrumSequencer.start();
			}
		} catch(Exception e) {
			
		}
	}
	
	public void play() {
		/**
		 * use this method!
		 * there can only be 16 sequencers because of the 16 channels in midi!
		 * reuse the sequencer like in this method to play another sound
		 */
		for(int i = 0; i < pianoSequences.size(); i++) {
			try {
				pianoSequencer.stop();
				pianoSequencer.setSequence(pianoSequences.get(i));
				pianoSequencer.setTickPosition(0);
				pianoSequencer.start();
				Thread.sleep(750);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
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
