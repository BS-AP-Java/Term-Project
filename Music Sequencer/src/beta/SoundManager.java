//********************************************************************
//SoundManager.java      
//Author: Kwun Chan and Nanyou Guan
// Plays and Load sounds
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
 private Sequencer bassDrumSequencer, clickSequencer, doubleBassSequencer, doubleBassSequencer2, pianoSequencer, pianoSequencer2, snareDrumSequencer;
 private ArrayList<Sequence> bassDrumSequences, clickSequences, doubleBassSequences, pianoSequences, snareDrumSequences;
 public static ArrayList<Integer> bassDrumRow, clickRow, doubleBassRow, doubleBassRow2, pianoRow, pianoRow2, snareDrumRow;
 public static ArrayList<ArrayList<Integer>> piece;
 public static int counter;
 
 //Constructs a new SoundManager object
 public SoundManager() {
  counter = 0;
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
  doubleBassRow2 = new ArrayList<Integer>();
  pianoRow = new ArrayList<Integer>();
  pianoRow2 = new ArrayList<Integer>();
  snareDrumRow = new ArrayList<Integer>();
  piece = new ArrayList<ArrayList<Integer>>();
  piece.add(new ArrayList<Integer>());
  piece.add(new ArrayList<Integer>());
  piece.add(new ArrayList<Integer>());
  piece.add(new ArrayList<Integer>());
  piece.add(new ArrayList<Integer>());
  piece.add(new ArrayList<Integer>());
  piece.add(new ArrayList<Integer>());
  loadSounds();
 }
 
 /**********************************
   //Method Name: public void loadSounds()
   //Loads the sound files
   //
   *********************************/
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
   doubleBassSequencer2 = MidiSystem.getSequencer();
   pianoSequencer = MidiSystem.getSequencer();
   pianoSequencer2 = MidiSystem.getSequencer();
   snareDrumSequencer = MidiSystem.getSequencer();
   bassDrumSequencer.open();
   clickSequencer.open();
   doubleBassSequencer.open();
   doubleBassSequencer2.open();
   pianoSequencer.open();
   pianoSequencer2.open();
   snareDrumSequencer.open();
   bassDrumSequencer.setSequence(bassDrumSequences.get(0));
   clickSequencer.setSequence(clickSequences.get(0));
   doubleBassSequencer.setSequence(doubleBassSequences.get(0));
   doubleBassSequencer2.setSequence(doubleBassSequences.get(0));
   pianoSequencer.setSequence(pianoSequences.get(0));
   pianoSequencer2.setSequence(pianoSequences.get(0));
   snareDrumSequencer.setSequence(snareDrumSequences.get(0));
  } catch(Exception e) {
   e.printStackTrace();
  }
 }
 
 /**********************************
   //Method Name: public void bassDrumPlay(int note)
   //Plays the bass drum note
   //Parameters: int note - note number in array
   *********************************/  
 public void bassDrumPlay(int note) {
  try {
   bassDrumSequencer.stop();
   bassDrumSequencer.setSequence(bassDrumSequences.get(note));
   bassDrumSequencer.setTickPosition(0);
   bassDrumSequencer.start();
  } catch(Exception e) {
   
  }
 }
 
 /**********************************
   //Method Name: public void doubleBassPlay(int note)
   //Plays the note in the 1st double bass sequence
   //Parameters: int note - note number in array
   *********************************/  
 public void doubleBassPlay(int note) {
  try {
   doubleBassSequencer.stop();
   doubleBassSequencer.setSequence(doubleBassSequences.get(note));
   doubleBassSequencer.setTickPosition(0);
   doubleBassSequencer.start();
  } catch(Exception e) {
   
  }
 }
 
 /**********************************
   //Method Name: public void doubleBass2Play(int note)
   //Plays the note in the 2nd double bass sequence
   //Parameters: int note - note number in array
   *********************************/  
 public void doubleBass2Play(int note) {
  try {
   doubleBassSequencer2.stop();
   doubleBassSequencer2.setSequence(doubleBassSequences.get(note));
   doubleBassSequencer2.setTickPosition(0);
   doubleBassSequencer2.start();
  } catch(Exception e) {
   
  }
 }
 
 /**********************************
   //Method Name: public void pianoPlay(int note)
   //Plays the note in the 1st piano sequence
   //Parameters: int note - note number in array
   *********************************/  
 public void pianoPlay(int note) {
  try {
   pianoSequencer.stop();
   pianoSequencer.setSequence(pianoSequences.get(note));
   pianoSequencer.setTickPosition(0);
   pianoSequencer.start();
  } catch(Exception e) {
   
  }
 }
 
 /**********************************
   //Method Name: public void piano2Play(int note)
   //Plays the note in the 2nd piano sequence
   //Parameters: int note - note number in array
   *********************************/  
 public void piano2Play(int note) {
  try {
   pianoSequencer2.stop();
   pianoSequencer2.setSequence(pianoSequences.get(note));
   pianoSequencer2.setTickPosition(0);
   pianoSequencer2.start();
  } catch(Exception e) {
   
  }
 }
 
 /**********************************
   //Method Name: public void snareDrumPlay(int note)
   //Plays the snare drum note
   //Parameters: int note - note number in array
   *********************************/  
 public void snareDrumPlay(int note) {
  try {
   snareDrumSequencer.stop();
   snareDrumSequencer.setSequence(snareDrumSequences.get(note));
   snareDrumSequencer.setTickPosition(0);
   snareDrumSequencer.start();
  } catch(Exception e) {
   
  }
 }
 
 /**********************************
   //Method Name: public synchronized void play()
   //Plays every sequence together for the whole song
   //
   *********************************/  
public synchronized void play() {
  new Thread(new Runnable() {
   public void run() {
    try {
     for(int i = 0; i < piece.get(0).size(); i++) {
      pianoPlay(piece.get(0).get(i).intValue());
      piano2Play(piece.get(1).get(i).intValue());
      doubleBassPlay(piece.get(2).get(i).intValue());
      doubleBassPlay(piece.get(3).get(i).intValue());
      snareDrumPlay(piece.get(4).get(i).intValue());
      bassDrumPlay(piece.get(5).get(i).intValue());
      Thread.sleep(500);
     }
     
    } catch(Exception e) {
     
    }
   }
  }).start();
 }
}