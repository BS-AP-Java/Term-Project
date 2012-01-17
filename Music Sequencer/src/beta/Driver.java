package beta;

import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try 
	    {
	      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
		Backbone b = new Backbone();
		b.run();
	}

}
