//********************************************************************
//FileRW.java      
//Author: Kwun Chan and Nanyou Guan
//Allows user to save files for the program and read the saved files
// 
//********************************************************************
package beta;

//import necessary classes
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileRW{
  //declare instance variables for this class
  private String fileName;
  private JFileChooser fileChooser;
  private String file;
  private Scanner scanner;
  private String x;
  
  //the constructor
  public FileRW()
  {   
  }
  
  /**********************************
  //Method Name: public void setName(String x)
  //Sets the name of the file
  //Parameter: String x - the name to be set
  *********************************/
  public void setName(String x)
  {//set fileName to x
    fileName = x ;
  }
  
  /**********************************
  //Method Name: public void getName()
  //Returns the fileName
  //
  *********************************/
  public String getName()
  {//return fileName
    return fileName;
  }
  
  /**********************************
  //Method Name: public void getFile()
  //Gets the file that will be read
  //
  *********************************/
  public void getFile() {
	   try {
	    UIManager.put("Synthetica.extendedFileChooser.sortEnabled", false);
	    //Instantiate a filechooser object
	    fileChooser = new JFileChooser();
	    //Filter it so that only text files show
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
	    fileChooser.setFileFilter(filter);
	    //pops up a open file dialog
	    int returnVal = fileChooser.showOpenDialog(null);
	    //if file is selected get the selected file and its path
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	     file = fileChooser.getSelectedFile().getPath();
	    }
	    //if file does not exist then create a new file
	    if(file != null) {
	     scanner = new Scanner(new File(file));
	    }
	   } catch (Exception e) {
	  e.printStackTrace();
	   }
	  }
  
  /**********************************
  //Method Name: public void getWhereSave()
  //Sets the directory where the user wants to save the file 
  //
  *********************************/
  public String getWhereSave(){
	   //Instantiate a filechooser object
	  fileChooser = new JFileChooser();
	  //pops open a save file dialog
	  int returnVal = fileChooser.showSaveDialog(null);
	  if(returnVal == JFileChooser.APPROVE_OPTION){
	   File file = fileChooser.getSelectedFile();
	   x = file.getAbsolutePath();
	  }
	  else
	  { 
	   x = null;
	  }
	  return x;
	  }

	  /**********************************
	  //Method Name: public void writeFile()
	  //Creates a new file for the program
	  //
	  *********************************/
	  public void writeFile() throws IOException
	  { 
	 //Create a new filewriter object
	    FileWriter y = new FileWriter( x + ".txt");
	    //Create a new BufferedWriter object for increased efficiency
	    BufferedWriter x = new BufferedWriter(y);
	    //Create a new printwriter object
	    PrintWriter z = new PrintWriter(x);
	    z.println();
	    //close the file when done
	    z.close();
	  }
  
  /**********************************
  //Method Name: public void readFile()
  //Reads the file that is chosen by the user 
  //and loads the file
  *********************************/
  public void readFile() {
	  String pianoRow1 = scanner.nextLine();
	  String pianoRow2 = scanner.nextLine();
	  String doubleBassRow1 = scanner.nextLine();
	  String doubleBassRow2 = scanner.nextLine();
	  String snareDrumRow = scanner.nextLine();
	  String bassDrumRow = scanner.nextLine();
	  String[] row1 = pianoRow1.split(":");
	  String[] row2 = pianoRow2.split(":");
	  String[] row3 = doubleBassRow1.split(":");
	  String[] row4 = doubleBassRow2.split(":");
	  String[] row5 = snareDrumRow.split(":");
	  String[] row6 = bassDrumRow.split(":");
	  for(String note : row1) {
		  int num = Integer.parseInt(note);
		  Integer noteNum = new Integer(num);
		  SoundManager.piece.get(0).add(noteNum);
	  }
	  for(String note : row2) {
		  int num = Integer.parseInt(note);
		  Integer noteNum = new Integer(num);
		  SoundManager.piece.get(1).add(noteNum);
	  }
	  for(String note : row3) {
		  int num = Integer.parseInt(note);
		  Integer noteNum = new Integer(num);
		  SoundManager.piece.get(2).add(noteNum);
	  }
	  for(String note : row4) {
		  int num = Integer.parseInt(note);
		  Integer noteNum = new Integer(num);
		  SoundManager.piece.get(3).add(noteNum);
	  }
	  for(String note : row5) {
		  Integer noteNum = new Integer(111);
		  int num = Integer.parseInt(note);
		  if(num != 111) {
			  noteNum = new Integer(0);
		  }
		  SoundManager.piece.get(4).add(noteNum);
	  }
	  for(String note : row6) {
		  Integer noteNum = new Integer(111);
		  int num = Integer.parseInt(note);
		  if(num != 111) {
			  noteNum = new Integer(0);
		  }
		  SoundManager.piece.get(5).add(noteNum);
	  }
	  //System.out.printf("%s\n%s\n%s\n", pianoRow1, pianoRow2, doubleBassRow1);
  }
  
}
   
   
