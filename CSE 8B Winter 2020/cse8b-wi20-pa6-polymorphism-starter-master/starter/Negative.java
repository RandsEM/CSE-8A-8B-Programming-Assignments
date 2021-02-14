/**
 * Filename: Negative.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that used to turn an integer into negative version
 */

/**
 * This class contains the method to represent an integer in negative form
 */
public class Negative extends ArithmeticExpression{

  /**
   * Constructor that takes in an arithmetcexpression
   */
  public Negative(ArithmeticExpression arithmeticexpression){
    this.firstVari = arithmeticexpression; 
  }

  /**
   * Method that evalutes the integervalue and turns it into a negative
   * @return value that represents the integer in negative
   */
  @Override
  public Value evaluate(){
    if(this.firstVari == null){
      return null; 
    }
    if(this.firstVari.evaluate() == null){
      return null; 
    }
    Value firstNumber = (this.firstVari).evaluate();
    if(! (firstNumber instanceof IntEvaluable) ){
      return null; 
    }
    int firstNumber1 = ((IntegerValue)firstNumber).intEvaluate();
    Value negativeVersion = new IntegerValue(firstNumber1 * -1);
    return negativeVersion;
    
  }
}


