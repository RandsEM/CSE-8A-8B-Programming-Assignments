/**
 * Filename: Integervalue.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that is used to store an integer 
 */

/**
 * This class has methods that allows the user to access the integer value of this class and also its boolean form
 */
public class IntegerValue extends ArithmeticExpression implements Value, IntEvaluable, BoolEvaluable{
  public int stateOfInt; 

  /**
   * Constructor that takes in an integer
   */
  public IntegerValue(int input){
    this.stateOfInt = input; 
  }

  /**
   * method that returns the object itself
   * @return this object itself
   */
  @Override
  public Value evaluate(){
    return this; 
  }

  /**
   * Returns the intergfer reprsetnation of this integer
   * @return integer represntation of this integerbvalue object
   */
  @Override
  public int intEvaluate(){
    return this.stateOfInt;
  }

  /**
   * returns the boolean represtnation of this integer value 
   * @return boolean represtnation of this integerbvalue
   */
  @Override
  public boolean boolEvaluate(){
    if(this.stateOfInt == 0){
      return false; 
    }else if(this.stateOfInt == 1){
      return true; 
    }
    return false; 
  }

  /**
   * Returns string form of this integer 
   * @return String version of the stored integer 
   */
  @Override
  public String toString(){
    String goingOut = "" + this.stateOfInt;
    return goingOut; 
  }

  
}