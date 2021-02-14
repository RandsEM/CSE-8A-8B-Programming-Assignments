/**
 * Filename: Conjunction.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This files allows two booleanexpression to be expressed as a conjucntion.
 */

/**
 * This class contains the methods that allows it to represented two booleanexpressions in a conjuncted 
 * manner
 */
public class Conjunction extends BooleanExpression {

  /**
   * Constructor that takes in two parameters
   */
  public Conjunction(BooleanExpression one, BooleanExpression two) {
    this.firstVari = one;
    this.secondVari = two;
  }

  /**
   * Method that returns a boolean value based on the conjunction of two other boolean values
   * @return Value that represents the conjuncted form of two booleanexpressions
   */
  @Override
  public Value evaluate() {
    if (this.firstVari == null || this.secondVari == null) {
      return null;
    }
    if (this.firstVari.evaluate() == null || this.secondVari.evaluate() == null) {
      return null;
    }
    Value firstTruth = (this.firstVari).evaluate();
    Value secondTruth = (this.secondVari.evaluate());

    if(! (firstTruth instanceof BoolEvaluable) || !(secondTruth instanceof BoolEvaluable) ){
      return null; 
    } 
    boolean firstTruth1 = ((BooleanValue) firstTruth).boolEvaluate();
    boolean secondTruth1 = ((BooleanValue) secondTruth).boolEvaluate();

   
    Value conjuncted = new BooleanValue(firstTruth1 && secondTruth1);
    return conjuncted;
  }
}