
/**
 * Filename: SortedList.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This files contains the class that is used to make a sortedlist where smaller elements occur first and bigger 
 * elements occur later
 */

/**
 * This class inherts the abstract class Ordered datastructure and contains the
 * methods and constructors needed to manipulate a sortedlist where elements
 * added are automatically sorted in smallest to largest
 */

public class SortedList extends OrderedDS {

  private int maxSize;
  private int currentSize = 0;

  //Printed when sortedlist is empty
  private static final String EMPTY_ERROR = "SortedList is empty";
  //Printed when trying to add an element to a full list
  private static final String MAX_SIZE_ERROR = "SortedList maximum limit reached";

  /**
   * Default constructor that sets the maximum size of the sortedlist to 0 and its array to null
   */
  public SortedList() {
    this.maxSize = 0;
    this.array = null;
  }

  /**
   * Constructor that sets the maxsize of the sortedlist to the user input unless if it is an invalid value(negaitve)
   * Its array is also created with its size deteremined by maxSize
   * @param maxSize the maxsize that the sortedlist can have and the size of its array 
   */
  public SortedList(int maxSize) {
    if (maxSize < 0) {
      this.maxSize = 0;
      this.array = null;
    } else {
      this.maxSize = maxSize;
      this.array = new int[maxSize];
    }
  }
  
  /**
   * Construtor that takes in another sorted list and deepcopies its values into the caller sortedlist
   * @param s the sortedlist that is going to have its elements deepcopied into the caller sortedlist
   */
  public SortedList(SortedList s) {
    if (s == null) {
      this.maxSize = 0;
      this.array = null;
    }
    for (int i = 0; i < s.array.length; i++) {
      this.array[i] = s.array[i];
    }
  }
  
  /**
   * Method to add an element in a sorted fashion where it automatically gets added in front of a value less
   * than it and in the back of value greater than it unless the size is 0 or 1. 
   * @param element Element that is going to be added in accordance with its size relative to other elements 
   *in the sortedlist
   */
  @Override
  public void add(int element) {
    if (currentSize == maxSize || this.array == null) {
      System.out.println(MAX_SIZE_ERROR);
    } else {
      if (this.currentSize == 0) {
        this.array[0] = element;
        currentSize += 1;
      } else if (this.currentSize == 1) {
        if (element > this.array[0]) {
          this.array[1] = element;
          currentSize += 1;
        } else {
          int saved = this.array[0];
          this.array[0] = element;
          this.array[1] = saved;
          currentSize += 1;
        }
      } else {
        for (int i = 0; i <= currentSize; i++) {
          if (i == currentSize) {
            this.array[i] = element;
            currentSize += 1;
            break;
          }
          if (element < this.array[i]) {
            int stored = this.array[i];
            this.array[i] = element;
            for (int j = currentSize - 1; j >= i + 1; j--) {
              this.array[j + 1] = this.array[j];
            }
            this.array[i + 1] = stored;
            currentSize += 1;
            break;
          }
        }
      }
    }
  }
  
  /**
   * Method that deletes the first element in the array or in other words, the element with the least value
   * in the array
   * @return Integer that is going to be and will be deleted from the sortedlist (the smallest integer element)
   */
  @Override
  public int delete() {
    if (this.currentSize == 0 || this.array == null) {
      System.out.println(this.EMPTY_ERROR);
      return -1;
    } else {
      int firstElement = this.array[0];
      int[] changed = new int[this.array.length - 1];
      for (int i = 0; i < changed.length; i++) {
        changed[i] = this.array[i + 1];
      }
      this.currentSize -= 1;
      this.array = changed;
      return firstElement;
    }
  }
  
  /**
   * Method that takes a look at first element of the array. Or in other words, the smallest element in the array
   * since it is sorted
   * @return integer that the smallest element of the array 
   */
  @Override
  public int peek() {
    if (this.currentSize == 0 || this.array == null) {
      System.out.println(this.EMPTY_ERROR);
      return -1;
    } else {
      return this.array[0];
    }
  }
  
  /**
   * Method that returns the size of the array or the number of elements that have been added by the user
   * @return integer that represents the number of elements added to the sortedlist datastructure
   */
  @Override
  public int size() {
    return this.currentSize;
  }
  
  /**
   * Method that returns a string representation of all the values in the datastructure
   * @return String that represents all the elements in the datastructure starting from the smallest values 
   * to the greatest values
   */
  @Override
  public String toString() {
    if (this.currentSize == 0 || this.array == null) {
      return "";
    } else {
      String goingOut = "";
      for (int i = 0; i < currentSize; i++) {
        if (i == currentSize - 1) {
          goingOut += this.array[i];
        } else {
          goingOut += this.array[i] + "-";
        }
      }
      return goingOut;
    }
  }
}