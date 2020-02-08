package dev;


public class WordCoordinates {
  private String word;
  private boolean found;
  private String coordinates = "not set";
  public WordCoordinates(String s) {
    word = s;
  }
  public String getWord() {
    return word;
  }
  public void setFound(boolean f){
    found = f;
  }
  public boolean getFound() {
    return found;
  }
  public void setCoordinates(String xy) {
    coordinates = xy;
  }
  public String getCoordinates() {
    return coordinates;
  }
}