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
      
      int r = 0;
      int c = 0;
      
      BufferedReader reader = new BufferedReader(new FileReader(f));
      String line = reader.readLine();
      
      if (line != null) {
        
        System.out.println(line);
        int xIndex = line.indexOf('x');
        String rStr = line.substring(0,xIndex);
        r = Integer.parseInt(rStr);
        String cStr = line.substring(xIndex+1,line.length());
        c = Integer.parseInt(cStr);
        
        if ( r != c ) {
          System.out.println("need to raise an error here r "+r+" != "+c);
        }
        
      }
      
      char[][] matrix = new char[r][c];
      
      Soup soup = new Soup(r,c);
      
      int z = 0;
      
      for ( int x=0; x<r; x++ ) { // row
        line = reader.readLine();
        for ( int lx=0; lx<line.length(); lx++ ) {  // column
          if ( line.charAt(lx) != ' ' ) {
            if (lx==0) {
            } else {
              z++;
            }
            soup.addChar2Matrix(x,z,line.charAt(lx));
          }
        }
        z = 0;
      }
      
      //System.out.println(" row.length "+matrix.length);
      //System.out.println(" col.length "+matrix[0].length);
      soup.printMatrix();
      
      //soup.addCharMatrix(matrix);
      //soup.printMatrix();
      
      line = reader.readLine();
      while ( line != null ) {
        //System.out.println(line);
        soup.addString(line);
        line = reader.readLine();
      }
      
      soup.findTheWords();
      
      soup.review();
      
    } catch ( Exception ex ) {
      ex.printStackTrace();
    }
  }
  
  
  public static void main( String[] args ) {
    App app = new App();
    app.parseFile(app.getFileName());
  }
}
