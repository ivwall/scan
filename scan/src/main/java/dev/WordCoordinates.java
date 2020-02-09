package dev;


public class WordCoordinates {
  private String word;
  private boolean found = false;
  private String coordinates = "not set";
  public WordCoordinates(String s) {
    word = s;
  }
  public String getWord() {
    return word;
  }
  public String getReverseWord() {
    String rWord = new StringBuilder(word).reverse().toString();
    return rWord;
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