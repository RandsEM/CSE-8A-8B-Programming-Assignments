/**
 * Filename: Set.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class to see if two boolean expressions are equal
 */

/**
 * This class contains the methods to check of two booleanexpressions are equal to each other
 */
public class Equivalence extends BooleanExpression {

  /**
   * Constructor that takes in two boolean expressions
   */
  public Equivalence(BooleanExpression one, BooleanExpression two) {
    this.firstVari = one;
    this.secondVari = two;
  }

  /**
   * Method that evalutes to true if the two booleanexpressions are equal and false otherwise 
   * @return value that represents if the two boolean expressions are equal
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

    Value areTheyEqual;

    if (firstTruth1 == secondTruth1) {
      areTheyEqual = new BooleanValue(true);
    } else {
      areTheyEqual = new BooleanValue(false);
    }

    return areTheyEqual;

  }
}