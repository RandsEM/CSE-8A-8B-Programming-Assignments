/**
 * Filename: Expression.java
 * Name: Darren Yeung; email: dyeung@ucsd.edu; PID:A15943292
 * Login: cs8bwi20rr
 * Date: 1/24/2020
 * Sources of Help: podcasts, lectures, brain, google.
 * This file contains the class that is used to make a Set datastructure
 */

/**
 * This class is the parent class to Booleanexpression and arithmetic expression. It contains 
 * methods to print the expression and to check whether two expressions are equal.
 */
public abstract class Expression{

  public abstract Value evaluate();

  /**
   * method that returns what the expresion evalutes to 
   * @return String representation of what the expression evaluates to
   */
  @Override
  public String toString(){
    if(this.evaluate() == null){
      return "Undefined";
    }
    return this.evaluate().toString();
  }

  /**
   * method that tells whether this expression is equal to the other expression
   * @param o the expression that is passed in to see if it is squal to the caller 
   * @return true or false depending on whether the caller expression is equal to the parameter
   */
  @Override
  public boolean equals(Object o ){
    if(o == null){
      return false; 
    }
    if(!(o instanceof Expression)){
      return false;
    }
    if(this == o){
      return true; 
    }
    Expression testing = (Expression)(o);
    if(testing.toString().equals(this.toString())){
      return true; 
    }
    return false; 
  }
}