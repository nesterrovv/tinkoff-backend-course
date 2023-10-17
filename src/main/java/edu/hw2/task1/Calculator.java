package edu.hw2.task1;

public final class Calculator {

    private Calculator() {}

    public static void main(String[] args) {
        calculate(args);
    }

    public static void calculate(String[] args) {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));
        System.out.println(res + " = " + res.evaluate());
    }

}
