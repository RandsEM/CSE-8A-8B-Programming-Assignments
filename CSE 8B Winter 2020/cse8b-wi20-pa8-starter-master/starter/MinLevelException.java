/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class MinLevelException that is used when the user 
 * is trying to create a pokemon that has a level lower than 1
 * The class extends the parent class Exception
 */

/**
 * This class is used to create a new MinLevelException object which is 
 * an exception thrown when the user tries to create a new Pokemon object 
 * that is lower than the level of 1. Every exception thrown
 * has a pokemon object attached to it which is the pokemon that 
 * caused the exception in the first place.
 */
public class MinLevelException extends Exception {

  private static final String EXCEPT_MSG = "%s can't be less than level 1!\n";
  private String pokemonName;

  /**
   * Constructor that is used to create a new MinLevelException object. It
   * takes in a String which is the name of the pokemon that caused
   * the exception, attaches it to EXCEPT_MSG, and calls its super constructor
   * with that string. Initilizes the pokemonname to the name 
   * @param name Name of the pokemon that caused the exception
   */
  public MinLevelException(String name){
    super(String.format(EXCEPT_MSG, name));
    this.pokemonName = name; 
  }

  @Override
  public String toString(){
    return(String.format(EXCEPT_MSG, this.pokemonName));
  }
  
}