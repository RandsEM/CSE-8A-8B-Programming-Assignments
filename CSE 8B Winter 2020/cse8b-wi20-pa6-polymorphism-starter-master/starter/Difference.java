/**
 * Filename: Difference
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This files contains the class that is able to subtract two other arithmetic expressions
 */

/**
 * This class containst he methods to evaluate two arithmetic expressions in a subtracted manner
 */
public class Difference extends ArithmeticExpression{

  /**
   * Constructor that takes in two arithmetic expressions
   */
  public Difference(ArithmeticExpression one, ArithmeticExpression two){
    this.firstVari = one; 
    this.secondVari = two;  
  }

  /**
   * Method that returns a value of the difference of two expressions 
   * @return Value that is the difference of two arithmetix espressions
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

    Value subtracted = new IntegerValue(firstNumber1 - seocndNumber2);
    return subtracted; 
  }
}