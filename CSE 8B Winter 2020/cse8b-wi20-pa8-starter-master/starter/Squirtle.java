/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class Squirtle which is a child 
 * class of the class Pokemon. Squirtle is a type of Pokemon 
 * that has its own information seperate from those of 
 * other pokemons
 */

/**
 * The class Squirtle is used so that the user can create a new 
 * Squirtle object. Each Squritle has its own name, DEX number,
 * and the initial level 5. It also has its own different attack damange 
 * due to chance
 */
public class Squirtle extends Pokemon {
  private static final String NAME = "Squirtle";
  private static final String DEX_NUMBER = "007";
  private static final int INITIAL_LEVEL = 5;
  private static final int THREEDAMANGE = 3; 
  private static final int EIGHTDAMANGE  = 8; 

  /**
  * Default constructor that is used to make a new Squirtle object. 
  * Method calls on the super constructor which takes in its name,dex number, 
  * and initial level. If level is above 100 or below 1, throws an exception
  * @throws MinLevelException Thrown if level is below 1
  * @throws MaxLevelException Thrown if leve is above 100
  */
  public Squirtle() throws MinLevelException, MaxLevelException {
    super(NAME, DEX_NUMBER, INITIAL_LEVEL);
  }

  @Override
  public int attack() {
    int randomZeroToOne = this.getRandom().nextInt(2);
    if (randomZeroToOne == 0) {
      return THREEDAMANGE;
    } else {
      return EIGHTDAMANGE;
    }
  }
}
