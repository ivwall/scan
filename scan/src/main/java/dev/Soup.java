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
  
  public void printMatrixWithSpaces(){
    for (int r=0; r<matrix.length; r++) {
      for (int c=0; c<matrix[0].length; c++) {
        System.out.print(""+matrix[r][c]+" ");
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
    findThese.add(s);
    words.add(new WordCoordinates(s));
  }
  
  public void findTheWords() {
    for (int i=0; i<words.size(); i++) {
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        lookHorizontallyForward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        lookHorizontallyBackward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        lookVerticallyForward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        lookVerticallyBackward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        lookDiagonallyForward(words.get(i));
      }
      
      if (!((WordCoordinates)words.get(i)).getFound()) {
        lookDiagonallyBackward(words.get(i));
      }
      
    }
  }
  
  private WordCoordinates lookHorizontallyForward(WordCoordinates wc) {
    
    for (int r=0; r<matrix.length; r++) {
      String row = new String(matrix[r]);
      
      if (row.contains(wc.getWord())) {
        
        int start = row.indexOf(wc.getWord());
        int finish = start + wc.getWord().length();
        wc.setCoordinates(" "+r+":"+start+" "+r+":"+finish+" horizontal forward");
        wc.setFound(true);
      }
    }
    
    return wc;
  }
  
  private WordCoordinates lookHorizontallyBackward(WordCoordinates wc) {
    for (int r=0; r<matrix.length; r++) {
      String row = new String(matrix[r]);
      
      if (row.contains(wc.getReverseWord())) {
        
        int start = row.indexOf(wc.getReverseWord());
        int finish = start + wc.getReverseWord().length();
        // when reverse
        // finish word, numerically, is ealier than start of word, numerically
        wc.setCoordinates(" "+r+":"+(finish-1)+" "+r+":"+start+" horizontal reverse");
        wc.setFound(true);
      }
    }
    return wc;
  }
  
  private WordCoordinates lookVerticallyForward(WordCoordinates wc) {
    
    for (int c=0; c<matrix[0].length; c++) {
      
      char[] columnOfChars = new char[matrix.length];
      for (int r=0; r<matrix.length; r++) {
        columnOfChars[r] = matrix[r][c];
      }
      
      String columnStr = new String(columnOfChars);
      
      if (columnStr.contains(wc.getWord())) {
        
        int start = columnStr.indexOf(wc.getWord());
        int finish = start + wc.getWord().length();
        wc.setCoordinates(" "+start+":"+c+" "+finish+":"+c+" vertical forward");
        wc.setFound(true);
      }
    }
    return wc;
  }
  
  private WordCoordinates lookVerticallyBackward(WordCoordinates wc) {
    //System.out.println("lookVerticallyBackward");
    for (int c=0; c<matrix[0].length; c++) {
      
      char[] columnOfChars = new char[matrix.length];
      for (int r=0; r<matrix.length; r++) {
        columnOfChars[r] = matrix[r][c];
      }
      
      String columnStr = new String(columnOfChars);
      
      if (columnStr.contains(wc.getReverseWord())) {
        
        int start = columnStr.indexOf(wc.getReverseWord());
        System.out.println("start "+start);
        int finish = start + wc.getWord().length();
        // when reverse
        // finish word, numerically, is ealier than start of word, numerically
        wc.setCoordinates(" "+finish+":"+(c+1)+" "+start+":"+(c+1)+" vertical, word reverse");
        wc.setFound(true);
      }
    }
    return wc;
  }

  private WordCoordinates lookDiagonallyForward(WordCoordinates wc) {
    System.out.println("lookDiagonallyForward");
    char[] wordCA = wc.getWord().toCharArray();
    
    System.out.println("first char o word "+wordCA[0]);
    
    // take the first character
    // loop through row by row
    //    if char matches then
    //       start going diagonally
    //       if matches if found stop
    boolean continueScanning = true;
    int rx = 0;
    int cx = 0;
    int wx = 0;
    
    int rWordMax = matrix.length - wordCA.length;
    int cWordMax = matrix[0].length - wordCA.length; 
    
    try {
      
      while ( continueScanning ) {
        
        if ( matrix[rx][cx] == wordCA[wx] ) {
          
          System.out.println(" rx("+rx+")cx("+cx+") = "+matrix[rx][cx]);
          diagonalForwardCheck(rx,cx,wordCA);
          
        }
        
        //System.out.println(" rx("+rx+")cx("+cx+")");
        
        if ( cx < cWordMax ) {
          //rx++;
          cx++;
        }
        
        if ( cx == cWordMax ) {
          rx++;
          cx = 0;
        } 
        
        if ( rx == rWordMax ) {
          continueScanning = false;
        }
        
      }
      
    } catch ( Exception ex ) {
    }
    
    //System.out.println(" rx("+rx+")cx("+cx+") cWordMax("+
    //                   cWordMax+")  rWordMax("+rWordMax+")");
    
    return wc;
  }
  
  private WordCoordinates lookDiagonallyBackward(WordCoordinates wc) {
    System.out.println("lookDiagonallyBackward");
    return wc;
  }
  
  private boolean diagonalForwardCheck(int x, int y, char[] word) {
    int ix = x;
    int iy = y;
    int wordLength = word.length;
    //char[] matrixWord = new char[];
    int wordY = 0;
    boolean result = true;
    boolean scan = true;
    
    try {
    
      while ( scan ) {
        if (matrix[ix][iy] == word[wordY]) {
          System.out.println("diagonalForwardCheck matrix["+
                           ix+"]["+iy+"]="+matrix[ix][iy]+" = word["+wordY+"]"+word[wordY]);
        } else {
          scan = false;
        }
        ix++;
        iy++;
        wordY++;
        if (wordY == word.length) {
          scan = false;
        }
      }
    
    } catch ( Exception ex ) {
      ex.printStackTrace();
    }
    
    System.out.println(">>> scan");
    
    ix = x;
    iy = y;
    wordY = 0;
    
    
    
    char[] diagWord = new char[word.length];
    //boolean copy = true;
    int step = 0;
    while (step < word.length) {
      //ix = ix + step;
      //iy = iy + step;
      System.out.println("step("+step+")ix("+ix+")iy("+iy+") matrix[ix][iy]="+matrix[ix][iy]);
      diagWord[step] = matrix[ix][iy];
      ix++;
      iy++;
      step++;
    }
    String s = new String(diagWord);
    System.out.println(">>>>  "+s);
    //for () {
    //}
    
    
    System.out.println("result "+result);
    return result;
  }
  
  
  
  public void displayWordsToFind() {
    for (int i=0; i<words.size(); i++) {
      System.out.println(((WordCoordinates)words.get(i)).getWord());
    }
  }
  
  public void displayScanResults() {
    System.out.println("OUTPUT");
    for (int i=0; i<words.size(); i++) {
      System.out.println(((WordCoordinates)words.get(i)).getWord()+" "+((WordCoordinates)words.get(i)).getCoordinates()+" "+((WordCoordinates)words.get(i)).getFound());
    }
  }
  
}