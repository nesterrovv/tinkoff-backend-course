package edu.hw2.task3;

public class FaultyConnectionManager implements ConnectionManager {

    private final double chanceOfFailure;

    public FaultyConnectionManager(double failureChance) {
        if (failureChance < 0.0 || failureChance > 1.0) {
            throw new IllegalArgumentException();
        }

        this.chanceOfFailure = failureChance;
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(chanceOfFailure);
    }

}
