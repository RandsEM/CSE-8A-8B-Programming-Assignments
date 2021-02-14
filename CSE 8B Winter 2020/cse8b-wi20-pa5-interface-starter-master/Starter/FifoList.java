/**
 * Filename: FifoList.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * 
 * This file contains the class that is used create a first in first out datastructure
 */

/**
 * This class inherits the OrderedDS class and contains the methods to
 * manipulate a first in first out type list including adding and deleteing
 * elements.
 */
public class FifoList extends OrderedDS {

  private int maxSize;
  private int currentsize = 0;

  //Printed when fifolist is empty 
  private static final String EMPTY_ERROR = "FifoList is empty";

  //Printed when trying to add an element to a full list
  private static final String MAX_SIZE_ERROR = "FifoList maximum limit reached";

  /**
   * Default constructor that sets the maximum size of the datastructure to 0 and
   * its array to null
   */
  public FifoList() {
    this.maxSize = 0;
    this.array = null;
  }

  /**
   * Constructor that sets the array size to a specific user input unless it is a
   * negative integer
   * 
   * @param maxSize The size and the maximum size of the datastructure
   */
  public FifoList(int maxSize) {
    if (maxSize < 0) {
      this.maxSize = 0;
      this.array = null;
    } else {
      this.maxSize = maxSize;
      this.array = new int[maxSize];
    }
  }

  /**
   * Constructor that deep copies another first in first out list
   * 
   * @param q A fifolist that is going to be deepcopied into the caller
   */
  public FifoList(FifoList q) {
    if (q == null) {
      this.maxSize = 0;
      this.array = null;

    } else {
      for (int i = 0; i < q.array.length; i++) {
        this.array[i] = q.array[i];
      }
    }

  }

  /**
   * Method that adds an element to the fifo datastructure unless if it is full or
   * the array is null
   * 
   * @param element Element that is going to be added to the fifo datastructure
   */
  @Override
  public void add(int element) {
    if (this.array == null || currentsize == this.array.length) {
      System.out.println(FifoList.MAX_SIZE_ERROR);

    } else {

      this.array[this.currentsize] = element;
      this.currentsize += 1;
    }
  }

  /**
   * Method that looks at the first element of the array
   * 
   * @return Integer that is the first element of the array or in this case, the
   *         first element the user inputed
   */
  @Override
  public int peek() {
    if (this.currentsize == 0 || this.array == null) {
      System.out.println(FifoList.EMPTY_ERROR);
      return -1;
    } else {
      return this.array[0];
    }
  }

  /**
   * Method that deletes the first element in the array
   * 
   * @return Integer that is deleted from the array or in this case, the first
   *         element that the user inputed
   */
  @Override
  public int delete() {
    if (this.currentsize == 0 || this.array == null) {
      System.out.println(FifoList.EMPTY_ERROR);
      return -1;
    } else {
      this.currentsize -= 1;
      int firstElement = this.array[0];
      for (int i = 0; i < this.array.length - 1; i++) {
        this.array[i] = this.array[i + 1];
      }
      this.array[this.array.length - 1] = 0;
      return firstElement;
    }
  }

  /**
   * Method that gets the size of the current datastructure (not the max size)
   * 
   * @return Integer that represents how many elements are in the current data
   *         structure
   */
  @Override
  public int size() {
    return this.currentsize;
  }

  /**
   * Method that prints out the elements of the datastructure that follows first
   * in first out logic
   * 
   * @return String that represents the elements the user inputed in order,
   *         printing the first inputed valued first and the last inputed value
   *         last
   */
  @Override
  public String toString() {
    if (this.currentsize == 0 || this.array == null) {
      return "";
    } else {
      String goingOut = "";
      for (int i = 0; i < currentsize; i++) {
        if (i == currentsize - 1) {
          goingOut += this.array[i];
        } else {
          goingOut += this.array[i] + "-";
        }
      }
      return goingOut;
    }
  }

}