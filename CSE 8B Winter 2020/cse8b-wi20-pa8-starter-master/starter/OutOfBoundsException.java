/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class OutOfBoundExceptionSpaceException which 
 * extends the class Exception. In this assignment, this class should 
 * be used when the user is trying to access something that cannot 
 * be in the position specified (Read
 * Box file and PokemonStoragefor more information)
 */

/**
 * This class is called NoStorageSpaceException and it extends 
 * the parent class Exception. Is it thrown when the user 
 * is trying to access an item (in this case, pokemon) that 
 * cannot be in the position specified and contains the instance variable 
 * errorLocation which is the location the user was trying to access 
 * which was out of bounds
 */
public class OutOfBoundsException extends Exception{
  private static final String EXCEPT_MSG = "Out of bounds: %s\n";
  private String errorLocation;

  /**
   * This is the default constructor used to create the exception 
   * that takes in the position the user was trying to access. It also 
   * initializes the errorLocation to loc
   * @param loc Location that the user was trying to access which obviously
   * doesn't exist
   */
  public OutOfBoundsException(String loc){
    super(String.format(EXCEPT_MSG, loc));
    this.errorLocation = loc; 
  }

  @Override
  public String toString(){
    return (String.format(EXCEPT_MSG, this.errorLocation));
  }
  
}