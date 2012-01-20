package beta;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileRW{
  
  private String fileName;
  
  public FileRW(String x)
  { 
    fileName = x;
  }
  
  public void setName(String x)
  {
    fileName = x ;
  }
  
  public String getName()
  {
    return fileName;
  }
  
  public void writeToFile() throws IOException
  {
    FileWriter y = new FileWriter("C:/Users/Kwun/Desktop"+ fileName + ".txt");
    BufferedWriter x = new BufferedWriter(y);
    PrintWriter z = new PrintWriter(x);
    
    z.print("la la la la ala ala alalal" + "\n afdfasdfadf");
    z.close();
  }
}
   
   
