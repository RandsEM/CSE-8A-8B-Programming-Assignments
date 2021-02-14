/**
* Filename: DataStructure.java
* Name: Darren Yeung; email:dyeung@ucsd.edu; PID: A15943292
* Login: cs8bwi20rr
* Date: 2/10/2020
* Sources of Help: podcasts, lectures, brain, google.
* This file contains an abstract class that implements the interface BasicMethod. Every subclass of this class 
* must implement the provided abstract methods 
*/

/**
 * This class contains the abstract methods add and size that must be
 * implemented by its child classes
 */
public abstract class DataStructure implements BasicMethods {

  protected int[] array;

  /**
   * Abstract method that is implemented by subclass that adds an element to
   * specific datastructure
   * 
   * @param element The integer that is supposed to be added
   */
  public abstract void add(int element);

  /**
   * Abstract method that is implemented by subclass that returns size of the
   * specific datastructure
   * 
   * @return size of the datastructure
   */
  public abstract int size();

}