/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class to make a Position object. A position object 
 * basically stores the position of a specific object. 
 */

 /**
  * This is the class Position that the user can create to associate this position with
  * any object. It allows the user to place an object with this position and to check
  * whether or not anything is there. It contains the instance varible pokemon because for
  * this assignment, we are dealing with Pokemon objects
  * @param <T>
  */
public class Position <T> {

  private T pokemon;

  /**
   * This is the default constructor that takes in an object, in this case 
   * a pokemon and initializes the instance varible pokemon to what the user 
   * inputed
   * @param pokemon The pokemon object that is going to be stored at this position
   */
  public Position(T pokemon){
    this.pokemon = pokemon; 
  }

  /**
   * This method allows the user to retrieve the pokemon at this position
   * @return The pokemon at this position
   */
  public T getPokemon(){
    return this.pokemon; 
  }

  /**
   * This method allows the user to set a pokemon to this position
   * @param newPokemon The pokemon that is going to take the place of this
   * position
   */
  public void setPokemon(T newPokemon){
    this.pokemon = newPokemon;
  }

  /**
   * This method returns a boolean value to show whether or not something is
   * already in this position
   * @return True if there is something in this position, false otherwise
   */
  public boolean isOpen(){
    if(this.pokemon == null){
      return true; 
    }else{
      return false; 
    }
  }
}