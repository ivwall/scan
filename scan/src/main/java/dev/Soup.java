package dev;

import java.util.ArrayList;
import java.util.Iterator;

public class Soup {
  
  private int r = 0;
  private int c = 0;
  
  private char[][] matrix;
  
  private ArrayList<String> findThese = new ArrayList<String>();
  private ArrayList<WordCoordinates> words = new ArrayList<WordCoordinates>();
  
  public Soup(int a, int b){
    r = a;
    c = b;
    matrix = new char[r][c];
  }
  
  public void addCharMatrix(char[][] m){
    System.out.println(" m.length "+m.length);
    System.out.println(" m[0].length "+m[0].length);
    matrix = m;
  }
  
  public void addChar2Matrix(int r, int c, char x) {
    //System.out.println("addChar2Matrix r("+r+")c("+c+") = "+x);
    matrix[r][c] = x;
  }
  
  public void printMatrixWithCoordinates(){
    for (int r=0; r<matrix.length; r++) {
      for (int c=0; c<matrix[0].length; c++) {
        System.out.print("["+r+"]["+c+"]"+matrix[r][c]+" ");
      }
      System.out.println();
    }
  }
  
  public void printMatrix(){
    for (int r=0; r<matrix.length; r++) {
      for (int c=0; c<matrix[0].length; c++) {
        System.out.print(""+matrix[r][c]);
      }
      System.out.println();
    }
  }
  
  public void addString(String s) {
    //System.out.println("soup.addString "+s);
    findThese.add(s);
    words.add(new WordCoordinates(s));
  }
  
  public void findTheWords() {
    System.out.println("findTheWords()");
    for (int i=0; i<words.size(); i++) {
      //System.out.println(((WordCoordinates)words.get(i)).getWord()+" "+((WordCoordinates)words.get(i)).getFound());
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        //System.out.println();
        lookHorizontallyForward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        //System.out.println();
        //String rWord = new StringBuilder(words.get(i)).reverse().toString();
        //System.out.println
        lookHorizontallyBackward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        //System.out.println();
        lookVerticallyForward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        //System.out.println();
        lookVerticallyBackward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        //System.out.println();
      }
      
    }
  }
  
  private WordCoordinates lookHorizontallyForward(WordCoordinates wc) {
    //System.out.println("lookHorizontallyForward "+wc.getWord());
    
    for (int r=0; r<matrix.length; r++) {
      String row = new String(matrix[r]);
      //System.out.println(row);
      
      if (row.contains(wc.getWord())) {
        //System.out.println("r "+r);
        
        int start = row.indexOf(wc.getWord());
        //System.out.println("start "+start);
        int finish = start + wc.getWord().length();
        System.out.println(wc.getWord()+" "+r+":"+start+" "+r+":"+finish);
        //System.out.println("row.contains(wc.getWord()) "+row.contains(wc.getWord()));
        wc.setFound(true);
      }
    }
    
    return wc;
  }
  
  private WordCoordinates lookHorizontallyBackward(WordCoordinates wc) {
    //System.out.println("lookHorizontallyBackward "+wc.getReverseWord());
    for (int r=0; r<matrix.length; r++) {
      String row = new String(matrix[r]);
      //System.out.println(row);
      
      if (row.contains(wc.getReverseWord())) {
        //System.out.println("r "+r);
        
        int start = row.indexOf(wc.getReverseWord());
        //System.out.println("start "+start);
        int finish = start + wc.getReverseWord().length();
        System.out.println(wc.getReverseWord()+" "+r+":"+(finish-1)+" "+r+":"+start);
        //System.out.println("row.contains(wc.getWord()) "+row.contains(wc.getReverseWord()));
        wc.setFound(true);
      }
    }
    return wc;
  }
  
  private WordCoordinates lookVerticallyForward(WordCoordinates wc) {
    //System.out.println("lookVerticallyForward "+wc.getWord());
    
    for (int c=0; c<matrix[0].length; c++) {
      
      //String col = new String(matrix[0][c]);
      //System.out.println( col );
      char[] columnOfChars = new char[matrix.length];
      for (int r=0; r<matrix.length; r++) {
        columnOfChars[r] = matrix[r][c];
      }
      
      String columnStr = new String(columnOfChars);
      
      //System.out.println("lookVerticallyForward colum["+c+"]"+columnStr);
      
      if (columnStr.contains(wc.getWord())) {
      /*****
        System.out.println("r "+r);
        
        int start = row.indexOf(wc.getReverseWord());
        System.out.println("start "+start);
        int finish = start + wc.getReverseWord().length();
        System.out.println(wc.getReverseWord()+" "+r+":"+(finish-1)+" "+r+":"+start);
        
        System.out.println("row.contains(wc.getWord()) "+row.contains(wc.getReverseWord()));
        wc.setFound(true);
      ****/
      }
    }
    
    
    return wc;
  }
  
  private WordCoordinates lookVerticallyBackward(WordCoordinates wc) {
    //System.out.println("lookVerticallyBackward "+wc.getWord());
    return wc;
  }
  
  public void review() {
    //System.out.println("findTheWords()");
    for (int i=0; i<words.size(); i++) {
      System.out.println(((WordCoordinates)words.get(i)).getWord()+" "+((WordCoordinates)words.get(i)).getFound());
    }
  }

}