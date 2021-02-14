/**
 * Filename: BooleanValue.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file allows the user to store a boolean value true or false 
 */

/**
 * THis class contains the methods required to return the specific value of the booleanvalue object
 */
public class BooleanValue extends BooleanExpression implements Value, IntEvaluable, BoolEvaluable{

  public boolean stateOfBoolean; 

  /**
   * Constructor that takes a boolean value and stores the boolean value in the instance variable stateofBoolean
   */
  public BooleanValue(boolean input){
    stateOfBoolean = input; 
  }

  /**
   * Method that returns this object itself
   * @return the caller object
   */
  @Override
  public Value evaluate(){
    return this;
  }

  /**
   * Returns the state of the boolean in int form (0 for false) (1 for true)
   * @return integer that represents the state of the booleanvalue
   */
  @Override
  public int intEvaluate(){
    if(this.stateOfBoolean == false){
      return 0; 
    }else{
      return 1; 
    }
  }

  /**
   * returns the state of the boolean in boolean form
   * @return false if the booleanvalue is false, true if the booleanvalue is true
   */
  @Override 
  public boolean boolEvaluate(){
    boolean goingOut = this.stateOfBoolean;
    return goingOut; 
  }

  /**
   * returns the string form of the boolean value
   * @return String is false if boolean value is false, true if the boolean value is true
   */
  @Override
  public String toString(){
    if (this.stateOfBoolean == true){
      return "true";
    }else{
      return "false";
    }
  }
}