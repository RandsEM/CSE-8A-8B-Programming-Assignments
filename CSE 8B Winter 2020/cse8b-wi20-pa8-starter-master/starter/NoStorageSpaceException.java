/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class NoStorageSpaceException which extends 
 * the class Exception. In this assignment, this class should be used 
 * when the user is trying to add something to a filled up Box. (Read
 * Box file and PokemonStorage file for more information)
 */

/**
 * This class is called NoStorageSpaceException and it extends 
 * the parent class Exception. Is it thrown when the user 
 * is trying to add an item (in this case, pokemon) to a filled
 * up box.
 */
public class NoStorageSpaceException extends Exception {
  private static final String EXCEPT_MSG = "No storage left\n";

  /**
   * This is the default constructor that is used to make the exception
   * object. It calls the super method from Exception which takes in the 
   * EXCEPT_MSG which is printed out when it is thrown
   */
  public NoStorageSpaceException(){
    super(EXCEPT_MSG);
  }
  
  @Override
  public String toString(){
    return EXCEPT_MSG;
  }
  
}