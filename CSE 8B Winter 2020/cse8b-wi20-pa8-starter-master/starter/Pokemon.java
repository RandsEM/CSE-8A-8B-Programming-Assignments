/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class Pokemon which is used to make a new 
 * Pokemon object. It allows the user to get multiple pieces of 
 * information
 * from the pokemon and also interactive methods like attack
 */
import java.util.*;

/**
 * The class pokemon contains information regarding the
 * pokemon like it's like dexnumber, name, and its level. The class 
 * basically allows the user to retrieve information from the pokemon
 * created and each Pokemon contains its own random object that 
 * dictates the amount of damange the pokemon can do
 */
public class Pokemon{
  private static final int MAX_DAMAGE = 10;
  private static final int MAX_LEVEL  = 100;

  private String dexNumber;
  private String name;
  private int level;
  private Random random;

  /**
   * This is the default constructor used to create the new Pokemon Object.
   * An exception is thrown when the user is trying to create a 
   * Pokemon with an invalid level
   * @param dexNumber Basically an id number that corresponds to a specific
   * pokemon
   * @param name The name of the pokemon
   * @param level The level of the pokemon
   * @throws MinLevelException Thrown when the pokemon has a level lower than 1
   * @throws MaxLevelException Thrown when the pokemon has a level higher than 100
   */
  public Pokemon(String dexNumber, String name, int level)
  throws MinLevelException, MaxLevelException{
    this.dexNumber = dexNumber; 
    this.name = name; 
    if(level < 1){
      throw new  MinLevelException(name);
    }else if(level > 100){
      throw new MaxLevelException(name);
    }
    this.level = level; 
    this.random = new Random();
  }

  /**
   * This method returns the name of the pokemon
   * @return Name of the pokemon in String form
   */
  public String getName(){
    return this.name; 
  }
  
  /**
   * This method returns the level of the pokemon
   * @return Level of the pokemon in int form
   */
  public int getLevel(){
    return this.level; 
  }

  /**
   * This method returns the random object associated 
   * with the pokemon
   * @return Random object that is attached to the pokemon
   */
  public Random getRandom(){
    return this.random;
  }

  @Override
  public String toString(){
    return this.dexNumber;
  }

  /**
   * This method returns a random integer that was created by the 
   * Pokemon's random object which represents the amount of damange it 
   * did when the attack method was called 
   * @return int representing how much damange the pokemon did on the
   * attack
   */
  public int attack(){
    return this.random.nextInt(MAX_DAMAGE);
  }
    
}