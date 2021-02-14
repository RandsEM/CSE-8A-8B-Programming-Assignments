/**
 * Filename: Product.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This files contains class to make a product of two arithmetic expressions
 */

/**
 * This class contains the method to evalaute two arithmetic expressions in a producted manner
 */
public class Product extends ArithmeticExpression{

  /**
   * Constructor that takes in two arithmetcexpression
   */
  public Product(ArithmeticExpression one, ArithmeticExpression two){
    this.firstVari = one; 
    this.secondVari = two;  
  }

  /**
   * Method that evaluates two arithmetic expressions in a producted manner 
   * @return value that represnts two arithmetic expressions multiplied together
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

    Value multiplied = new IntegerValue(firstNumber1 * seocndNumber2);
    return multiplied; 
  }
}