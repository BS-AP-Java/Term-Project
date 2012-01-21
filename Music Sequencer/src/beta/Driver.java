//********************************************************************
//  Driver.java       
// Author: Kwun Chan and Nanyou Guan
//The Driver that runs the program
//
//********************************************************************

package beta;
//import necessary classes
import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try 
	    {//try to set the look and feel of the frame
	      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
	    } 
	  //catch any exception
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
	    //Declare and isntantiate a new backbone object
	    Backbone b = new Backbone();
	    //call the run method of the backbone class to run the project
	    b.run();
	}

}
