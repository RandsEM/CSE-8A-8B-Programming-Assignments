/**
 * Filename: LifoList.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * 
 * This file contains the class that is used to make a last in last out type datastructure; 
 */

/**
 * This class inherits the Ordered Datastructure class. It contains the methods
 * to manipulate and create last in last out type datastructure.
 */

public class LifoList extends OrderedDS {
  private int maxSize;

  //Printed when list is empty
  private static final String EMPTY_ERROR = "LifoList is empty";
  
  //Printed when trying to add an element to a full list
  private static final String MAX_SIZE_ERROR = "LifoList maximum limit reached";
  private int currentIndex;
  private int currentSize = 0;

  /**
   * Default constructor that sets the max size to zero and the array to null
   */
  public LifoList() {
    this.maxSize = 0;
    this.array = null;
  }

  /**
   * Constructor that takes in anohter Lifolist and deepcopies it 
   * @param s LifoList that is going to have its elements deepcopied into the caller
   */
  public LifoList(LifoList s) {
    if (s == null) {
      this.array = null;
      this.maxSize = 0;

    } else {
      for (int i = 0; i < s.array.length; i++) {
        this.array[i] = s.array[i];
      }
    }
  }

  /**
   * Constructor that takes in a maxSize parameter and sets its datastructure max size to it 
   * @param maxSize The maximum size the datastructure is going to have
   */
  public LifoList(int maxSize) {
    if (maxSize < 0) {
      this.maxSize = 0;
      this.array = null;
    } else {
      this.maxSize = maxSize;
      this.array = new int[maxSize];
      this.currentIndex = maxSize - 1;
    }
  }

  /**
   * Method that adds an element to the LifoList datastructure
   * @param element Element that is going to be added to the LifoList datastruture
   */
  @Override
  public void add(int element) {
    if (currentSize >= maxSize) {
      System.out.println(MAX_SIZE_ERROR);
    } else {
      this.array[currentIndex] = element;
      currentIndex -= 1;
      this.currentSize += 1;
    }
  }

  /**
   * Method that deletes the first element from the LifoList datastructure
   * @return Integer that is going to be deleted from the datastructure, or this case, the last element
   * that the user inputed
   */
  @Override
  public int delete() {
    if (this.currentSize == 0 || this.array == null) {
      System.out.println(this.EMPTY_ERROR);
      return -1;
    } else {
      int firstElement = this.array[currentIndex + 1];
      this.array[currentIndex + 1] = 0;
      this.currentIndex += 1;
      this.currentSize -= 1;
      return firstElement;
    }
  }

  /**
   * Method that takes a look at the first element of the datastructure 
   * @return Integer that is the first element of the datastructure, or in this case, 
   * the element that the user inputed last
   */
  @Override
  public int peek() {
    if (this.currentSize == 0 || this.array == null) {
      System.out.println(this.EMPTY_ERROR);
      return -1;
    } else {
      return this.array[currentIndex + 1];
    }
  }

  /**
   * Method that returns the number of current elements in the datastructure
   * @return the current number of elements that the user inputed in the datastructure
   */
  @Override
  public int size() {
    return this.currentSize;
  }

  /**
   * Method that prints out the current elements in the datastructure
   * @return String that represents all the elements in the datastructure, from what the user inputed last 
   * to what the user inputed first 
   */
  @Override
  public String toString() {
    if (this.currentSize == 0 || this.array == null) {
      return "";
    } else {
      String goingOut = "";
      for (int i = currentIndex + 1; i < maxSize; i++) {
        if (i == maxSize - 1) {
          goingOut += this.array[i];
        } else {
          goingOut += this.array[i] + "-";
        }
      }
      return goingOut;
    }
  }
}