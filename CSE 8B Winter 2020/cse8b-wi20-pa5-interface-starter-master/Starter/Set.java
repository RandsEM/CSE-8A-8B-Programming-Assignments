/**
 * Filename: Set.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that is used to make a Set datastructure
 */

/**
 * This class inherits UnorderdDS where is not specific arranagement of the numbers. It contains the methods 
 * and constructors to create a set where the same element cannot be added more than once
 */


public class Set extends UnorderedDS {

  //Printed when trying to add an element already in the list
  private static final String DUPLICATE_ERROR = "Element already exists";

  //Printed when trying to add an element to a full list
  private static final String MAX_SIZE_ERROR = "Set maximum limit reached";
  private int maxSize;
  private int currentSize = 0;

  /**
   * Default constructor that sets the maxsize of the set to 0 and its array to null
   */
  public Set() {
    this.array = null;
    this.maxSize = 0;
  }

  /**
   * Constructor that takes in a maxsize integer and sets the set's maxsize to that value and its array size to 
   * that value as well 
   */
  public Set(int maxSize) {
    if (maxSize < 0) {
      this.maxSize = 0;
      this.array = null;
    } else {
      this.maxSize = maxSize;
      this.array = new int[maxSize];
    }
  }

  /**
   * Constructor that takes in another set and makes a deep copy of its elements 
   * @param s Another set that is going to have its elements deep copied into the caller set 
   */
  public Set(Set s) {
    if (s == null) {
      this.maxSize = 0;
      this.array = null;
    }
    for (int i = 0; i < s.array.length; i++) {
      this.array[i] = s.array[i];
    }
  }

  /**
   * Method that adds an element to the set only if the set does not already contain this element, when it is not 
   * full, and when its array is not null 
   * @param element Element that is to be added into the set
   */
  @Override
  public void add(int element) {
    if (currentSize == maxSize || this.array == null) {
      System.out.println(MAX_SIZE_ERROR);
      return;
    }
    for (int i = 0; i < currentSize; i++) {
      if (this.array[i] == element) {
        System.out.println(DUPLICATE_ERROR);
        return;
      }
    }
    this.array[currentSize] = element;
    currentSize += 1;
  }

  /**
   * Method that returns current size of the set 
   * @return Integer that represents the amount of elements that has been added to the set 
   */
  @Override
  public int size() {
    return this.currentSize;
  }

  /**
   * Method that converts the set into a sortedList 
   * @return SortedList that contains all the elements in the set except that it's sorted
   */
  @Override
  public SortedList toSortedList() {
    SortedList sortedSet = new SortedList(maxSize);
    for (int i = 0; i < currentSize; i++) {
      sortedSet.add(this.array[i]);
    }
    return sortedSet;
  }
}