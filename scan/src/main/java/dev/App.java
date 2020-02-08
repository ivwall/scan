package dev;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import org.apache.commons.io.*;

public class App {
  
  public App() {
  }
  
  public String getFileName() {
    String fName = "not set";
    try {
      Scanner scnr = new Scanner(System.in);
      System.out.print("enter file name> ");
      fName = scnr.next();
      System.out.println(fName);
    } catch ( Exception ex ) {
    }
    return fName;
  }
  
  public void parseFile(String f) {
    try {
      
      BufferedReader reader = new BufferedReader(new FileReader(f));
      String line = reader.readLine();
      if (line != null) {
        System.out.println(line);
        
        int xIndex = line.indexOf('x');
        
        System.out.println(" xIndex "+xIndex);
        
        System.out.println(line.substring(0,xIndex));
        
        String rStr = line.substring(0,xIndex);
        
        int r = Integer.parseInt(rStr);
        
        System.out.println(" r = "+r);
        
        String cStr = line.substring(xIndex+1,line.length());
        
        System.out.println(" cStr "+cStr);
        
        int c = Integer.parseInt(cStr);
        
        if ( r != c ) {
          System.out.println("need to raise an error here r "+r+" != "+c);
        }
        
      }
      
      
      
      
    } catch ( Exception ex ) {
      ex.printStackTrace();
    }
  }
  
  
  public static void main( String[] args ) {
    App app = new App();
    app.parseFile(app.getFileName());
  		
  }
}
