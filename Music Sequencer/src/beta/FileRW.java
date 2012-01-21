package beta;
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
  
  private String fileName;
  private JFileChooser fileChooser;
  private String file;
  private Scanner scanner;
  
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
  
  public void writeFile() throws IOException
  {
    FileWriter y = new FileWriter("C:/Users/Kwun/Desktop"+ fileName + ".txt");
    BufferedWriter x = new BufferedWriter(y);
    PrintWriter z = new PrintWriter(x);
    
    z.print("la la la la ala ala alalal" + "\n afdfasdfadf");
    z.close();
  }
  
  public void readFile() {
	  String pianoRow1 = scanner.next();
	  String pianoRow2 = scanner.next();
	  String doubleBassRow1 = scanner.next();
	  String doubleBassRow2 = scanner.next();
	  String snareDrumRow = scanner.next();
	  String bassDrumRow = scanner.next();
	  String clickRow = scanner.next();
  }
  
  
}
   
   
