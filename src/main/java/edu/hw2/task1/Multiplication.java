package edu.hw2.task1;

public record Multiplication(Expression first, Expression second) implements Expression {

    @Override
    public double evaluate() {
        return first.evaluate() * second.evaluate();
    }

}
