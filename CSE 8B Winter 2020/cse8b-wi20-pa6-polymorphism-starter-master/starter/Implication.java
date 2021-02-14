/**
 * Filename: Implication.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that isable to evaluate two boolean expressions in a implicated manner
 */

/**
 * This class contains the methods needed to evaluate two other boolean expressions in an implicated manner where order matters
 * and the first booleanexpression is before the if
 */
public class Implication extends BooleanExpression {

  /**
   * Constructor that takes in two booleanexpressions
   */
  public Implication(BooleanExpression one, BooleanExpression two) {
    this.firstVari = one;
    this.secondVari = two;
  }

  /**
   * Method that evalutes the two booleanexpressions in a implcated manner
   * @return value that represents the value of the two booleanexpressions in an implicated manner
   */
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
    if (firstTruth1 == false) {
      Value implication = new BooleanValue(true);
      return implication;
    } else {
      if (secondTruth1 == false) {
        Value implication = new BooleanValue(false);
        return implication;
      } else {
        Value implication = new BooleanValue(true);
        return implication;
      }
    }
  }
}