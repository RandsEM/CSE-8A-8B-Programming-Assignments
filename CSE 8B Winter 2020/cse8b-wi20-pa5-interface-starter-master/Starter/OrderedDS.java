/**
 * Filename: LifoList.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * 
 * This file contains an abstract class that inherits the Datastructure interface
 */

/**
 * This class inherits the abstract parent class Datastructure so any subclass of this class must implement the 
 * the methods in Datastructure as well as this abstract class 
 */

 
public abstract class OrderedDS extends DataStructure{

  /**
   * Abstract method that is to be implemebted by subclasses
   * @return Integer that is the first element of the datastructure
   */
  public abstract int peek();

  /**
   * Abstract method that is to be implemebted by subclasses
   * @return First element that is to be and will be deleted from the datastructure
   */
  public abstract int delete();
}