/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class Charmander which is a child 
 * class of the class Pokemon. Charmander is a type of Pokemon 
 * that has its own information seperate from those of 
 * other pokemons
 */

/**
 * The class Charmander is used so that the user can create a new 
 * Charmander object. Each Charmander has its own name, DEX number,
 * and the initial level 5. It also has its own different attack damange 
 * due to chance
 */
public class Charmander extends Pokemon{
  private static final String NAME       = "Charmander";
  private static final String DEX_NUMBER = "004";
  private static final int INITIAL_LEVEL = 5;
  private static final int DAMANGE = 5; 

/**
  * Default constructor that is used to make a new Charmander object. 
  * Method calls on the super constructor which takes in its name,dex number, 
  * and initial level. If level is above 100 or below 1, throws an exception
  * @throws MinLevelException Thrown if level is below 1
  * @throws MaxLevelException Thrown if leve is above 100
  */
  public Charmander() throws MinLevelException, MaxLevelException{
    super(NAME, DEX_NUMBER, INITIAL_LEVEL);
  }

  @Override
  public int attack(){
    return DAMANGE;
  }
  
}