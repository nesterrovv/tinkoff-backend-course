package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {

    private final double gotFaultyConnectionFailureChance;
    private final double gotFailureConnectionChance;


    public DefaultConnectionManager(double faultyConnectionChance, double faultyConnectionFailureChance) {
        if (faultyConnectionFailureChance < 0.0 || faultyConnectionFailureChance > 1.0) {
            throw new IllegalArgumentException();
        }
        if (faultyConnectionChance < 0.0 || faultyConnectionChance > 1.0) {
            throw new IllegalArgumentException();
        }
        this.gotFailureConnectionChance = faultyConnectionChance;
        this.gotFaultyConnectionFailureChance = faultyConnectionFailureChance;
    }

    @Override
    public Connection getConnection() {
        if (Math.random() < gotFailureConnectionChance) {
            return new FaultyConnection(gotFaultyConnectionFailureChance);
        }
        return new StableConnection();
    }

}
