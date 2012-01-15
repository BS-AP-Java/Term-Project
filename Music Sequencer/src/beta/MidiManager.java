package beta;

public class MidiManager {
	private int pitch;
	private int speed;
	private int channel;
	
	public MidiManager(int p, int s, int c) {
		pitch = p;
		speed = s;
		channel = c;
	}
	
	public int getPitch() {
		return pitch;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getChannel() {
		return channel;
	}

}
