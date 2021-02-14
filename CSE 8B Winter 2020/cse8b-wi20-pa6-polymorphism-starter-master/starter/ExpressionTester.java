/**
 * File: ExpressionTester.java
 * Author: ME!
 * 
 * This file is given to you for you to add your own test cases. You will not 
 * need to turn this in, but adding test cases is only for your own benefit. 
 */
public class ExpressionTester
{
    public static void main(String[] args)
    {
        //Arithmetic expression tests
        ArithmeticExpression one = new IntegerValue(1);
        ArithmeticExpression two = new IntegerValue(2);
        ArithmeticExpression three = new IntegerValue(3);
        ArithmeticExpression seven = new IntegerValue(7);
        ArithmeticExpression nine = new IntegerValue(9);

        //1 + 2, expected 3
        Expression arith1 = new Sum(one, two);
        System.out.println("1 + 2 evaluated to: " + arith1.evaluate());

        //3 - 1, expected 2
        Expression arith2 = new Difference(three, one);
        System.out.println("3 - 1 evaluated to: " + arith2);

        //1 + (3 - 2), expected 2
        Expression arithComplex = new Sum(one, new Difference(three, two));
        System.out.println("1 + (3 - 2) evaluated to: " + arithComplex);


        //Boolean expression tests
        BooleanExpression myTrue = new BooleanValue(true);
        BooleanExpression myFalse = new BooleanValue(false);

        //True && false, expected false
        Expression bool1 = new Conjunction(myTrue, myFalse);
        System.out.println("True && false evaluated to: " + bool1);

        //Convert a non-zero IntegerValue to a boolean, expect true
        boolean nonZeroInt = new IntegerValue(1).boolEvaluate(); 
        System.out.println("IntegerValue(1) evaluated as a boolean to: " 
                                + nonZeroInt); 

        //Convert a false BooleanValue to an int, expect 0
        int falseIntValue = new BooleanValue(false).intEvaluate(); 
        System.out.println("BooleanValue(false) evaluated as an integer to: " 
                                + falseIntValue); 




        /* Add your own test cases here! */
        Expression difference12 = new Difference(new Negative(new Sum(new IntegerValue(5), new IntegerValue(3))), new Quotient(new Product(three,seven), three));
        System.out.println(difference12);
        Expression difference123 = new Difference(new Negative(new Sum(new IntegerValue(2), new IntegerValue(3))), new Quotient(new Product(three,seven), three));
        System.out.println(difference123);

        
        Expression boolean1 = new Equivalence(new Conjunction(myTrue, myFalse),new Disjunction(new BooleanValue(false), new Implication(new Negation(myFalse), new Equivalence(new ExclusiveDisjunction(myTrue, myFalse), new BooleanValue(true)))));
        //false, 



        System.out.println(difference12.equals(difference123));



    }


}