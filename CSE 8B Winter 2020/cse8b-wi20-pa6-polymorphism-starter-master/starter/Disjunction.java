/**
 * Filename: Disjunction.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that that is used to evaluate two booleanexpressions in a disjuncted manner
 */

/**
 * This class contains the methods that is used to evaluate two booleanexpressions in a disjuncted fashion. 
 */

public class Disjunction extends BooleanExpression {

  /**
   * Constructor that takes in two boolean expressions
   */
  public Disjunction(BooleanExpression one, BooleanExpression two) {
    this.firstVari = one;
    this.secondVari = two;
  }

  /**
   * Method that values the two booleanexpressions in a disjuncted manner.
   * @return Value that is the boolean value of two booleanexpressions.
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

    Value disjuncted = new BooleanValue(firstTruth1 || secondTruth1);
    return disjuncted;
  }
}