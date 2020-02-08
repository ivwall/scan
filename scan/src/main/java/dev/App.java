package dev;

import java.util.Scanner;

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
    } catch ( Exception ex ) {
    }
  }
  
  
  public static void main( String[] args ) {
    App app = new App();
    app.parseFile(app.getFileName());
  		
  }
}
