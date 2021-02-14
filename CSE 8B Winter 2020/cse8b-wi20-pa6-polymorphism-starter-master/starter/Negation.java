/**
 * Filename: Negation.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that is used to negate a booleanexpression
 */

/**
 * This class contains the methods that is used to represented a negated version of its booleanexprssion
 */public class Negation extends BooleanExpression{


  /**
   * Constructor that takes in a booleanexpression
   */
  public Negation(BooleanExpression booleanexpression){
    this.firstVari = booleanexpression; 
  }

  /**
   * Methods that evalutes the booleanexpression in an negated form 
   * @return Value that represents the negated form of booleanexpression
   */
  @Override
  public Value evaluate() {
    if (this.firstVari == null){
      return null; 
    }

    if(this.firstVari.evaluate() == null ){
      return null; 
    }
    
    Value firstTruth = (this.firstVari).evaluate();
    if(! (firstTruth instanceof BoolEvaluable) ){
      return null; 
    } 
    boolean firstTruth1 = ((BooleanValue)firstTruth).boolEvaluate();

    if(firstTruth1 == false){
      Value negated = new BooleanValue(true);
      return negated; 
    }else{
      Value negated = new BooleanValue(false);
      return negated; 
    }
    
  }

}