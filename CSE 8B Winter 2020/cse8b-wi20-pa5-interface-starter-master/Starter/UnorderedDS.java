/**
 * Filename: UnorderedDS.java
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

public abstract class UnorderedDS extends DataStructure{

  /**
   * Abstract method that is to be implemented by classes that inherit this class. Converts a datastructure
   * to a sorted list so its elements are sorted from least to greatest and returns the sortedlist
   * @return sortedlist a datastructure equivalent to the caller except all its elements are sorted from least 
   * to greatest
   */
  public abstract SortedList toSortedList();
}