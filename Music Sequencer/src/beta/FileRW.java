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
  
  //the constructor
  public FileRW()
  {   
  }
  
  public void setName(String x)
  {
    fileName = x ;
  }
  
  public String getName()
  {
    return fileName;
  }
  
  /**********************************
  //Method Name: public void getFile()
  //
  //
  *********************************/
  public void getFile() {
	  try {
		  UIManager.put("Synthetica.extendedFileChooser.sortEnabled", false);
		  fileChooser = new JFileChooser();
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		  fileChooser.setFileFilter(filter);
		  int returnVal = fileChooser.showOpenDialog(null);
		  if(returnVal == JFileChooser.APPROVE_OPTION) {
			  file = fileChooser.getSelectedFile().getPath();
		  }
		  if(file != null) {
			  scanner = new Scanner(new File(file));
		  }
	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
  
  /**********************************
  //Method Name: public void writeFile()
  //
  //
  *********************************/
  public void writeFile() throws IOException
  {
    FileWriter y = new FileWriter("C:/Users/Kwun/Desktop"+ fileName + ".txt");
    BufferedWriter x = new BufferedWriter(y);
    PrintWriter z = new PrintWriter(x);
    
    z.print("la la la la ala ala alalal" + "\n afdfasdfadf");
    z.close();
  }
  
  public void readFile() {
	  String pianoRow1 = scanner.nextLine();
	  String pianoRow2 = scanner.nextLine();
	  String doubleBassRow1 = scanner.nextLine();
	  String doubleBassRow2 = scanner.nextLine();
	  String snareDrumRow = scanner.nextLine();
	  String bassDrumRow = scanner.nextLine();
	  String clickRow = scanner.nextLine();
	  String[] row1 = pianoRow1.split(":");
	  String[] row2 = pianoRow2.split(":");
	  String[] row3 = doubleBassRow1.split(":");
	  String[] row4 = doubleBassRow2.split(":");
	  String[] row5 = snareDrumRow.split(":");
	  String[] row6 = bassDrumRow.split(":");
	  String[] row7 = clickRow.split(":");
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
		  int num = Integer.parseInt(note);
		  Integer noteNum = new Integer(num);
		  SoundManager.piece.get(4).add(noteNum);
	  }
	  for(String note : row6) {
		  int num = Integer.parseInt(note);
		  Integer noteNum = new Integer(num);
		  SoundManager.piece.get(5).add(noteNum);
	  }
	  for(String note : row7) {
		  int num = Integer.parseInt(note);
		  Integer noteNum = new Integer(num);
		  SoundManager.piece.get(6).add(noteNum);
	  }
	  //System.out.printf("%s\n%s\n%s\n", pianoRow1, pianoRow2, doubleBassRow1);
  }
  
}
   
   
