package beta;

import java.io.File;
import java.util.ArrayList;

public class SoundManager {
	private File bassDrumDir, clickDir, doubleBassDir, pianoDir, snareDrumDir;
	private File[] bassDrumFiles, clickFiles, doubleBassFiles, pianoFiles, snareDrumFiles;

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
	}
}
