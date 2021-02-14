/**
 * Filename: Sum.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class to take two arithmetic expressions and prodocues the sum of them
 */

/**
 * This class contains the method to represent an integer in negative form
 */
public class Sum extends ArithmeticExpression{

  /**
   * Constructor that takes in two arithmetcexpression
   */
  public Sum(ArithmeticExpression one, ArithmeticExpression two){
    this.firstVari = one; 
    this.secondVari = two;  
  }

  
  /**
   * method that evaluates the two arithmetic expressions in a summed up manner
   * @return value that represents the sum of the two arithmetic expressions
   */
  @Override
  public Value evaluate(){
    if(this.firstVari == null || this.secondVari == null){
      return null; 
    }

    if(this.firstVari.evaluate() == null || this.secondVari.evaluate() == null){
      return null; 
    }

    Value firstNumber = (this.firstVari).evaluate();
    Value secondNumber = (this.secondVari.evaluate());
    if(! (firstNumber instanceof IntEvaluable) || !(secondNumber instanceof IntEvaluable) ){
      return null; 
    }
    int firstNumber1 = ((IntegerValue)firstNumber).intEvaluate();
    int seocndNumber2 = ((IntegerValue)secondNumber).intEvaluate();

    Value added = new IntegerValue(firstNumber1 + seocndNumber2);
    return added; 
  }
}