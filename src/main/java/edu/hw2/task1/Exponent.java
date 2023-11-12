package edu.hw2.task1;

public record Exponent(Expression base, int power) implements Expression {

    @Override
    public double evaluate() {
        return Math.pow(base.evaluate(), power);
    }

}
