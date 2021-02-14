
/**
 * Filename: Quotient.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that allows two arithmetic expressions to be divided by one another
 */

/**
 * This class contains the methods that allows the first arithmetic expressions to be divided by another arithmetic expression
 */
public class Quotient extends ArithmeticExpression{

  /**
   * Constructor that takes in two arithmetcexpression
   */
  public Quotient(ArithmeticExpression one, ArithmeticExpression two){
    this.firstVari = one; 
    this.secondVari = two;  
  }

  /**
   * Method that evalutes the two arithmeicexpresisons in a divided manner 
   * @return value that represents the first aritmethic expression divided by the second one 
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

    Value divided = new IntegerValue(firstNumber1 / seocndNumber2);
    return divided; 
  }
}