package dev;

import java.util.ArrayList;

public class Soup {
  
  private int r = 0;
  private int c = 0;
  
  private char[][] matrix;
  
  private ArrayList<String> findThese = new ArrayList<String>();
  
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
  
  public void addString(String s) {
    findThese.add(s);
  }
  
  public void find() {
    
  }
  
  private boolean lookHorizontallyForward() {
    return false;
  }
  
  private boolean lookHorizontallyBackward() {
    return false;
  }
  
  private boolean lookVerticallyForward() {
    return false;
  }
  
  private boolean lookVerticallyBackward() {
    return false;
  }
}