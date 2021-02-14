/**
 * Filename: ExclusiveDisjunction.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the methods to evaluate booleanexpressions in an exclusivedisjuncted manner 
 */

/**
 * This file contains methods to evaluate two booleanexpression in an exclusivedisjuncted manner 
 */
public class ExclusiveDisjunction extends BooleanExpression {

  /**
   * constructor that takes in two booleanexpressions
   */
  public ExclusiveDisjunction(BooleanExpression one, BooleanExpression two) {
    this.firstVari = one;
    this.secondVari = two;
  }

  /**
   * Method that evalutes the two booleanexpressions in an exclusivedisjuncted manner 
   * @return Boolean value that is the result of putting the two booleanexpressions in a exclusive disjuncted manner
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
    
    Value exclusiveDisjuncted = new BooleanValue(firstTruth1 ^ secondTruth1);
    return exclusiveDisjuncted;
  }
}