package edu.hw4.animal;

@SuppressWarnings({"MagicNumber"})
public record Animal(

    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD     -> 2;
            case FISH     -> 0;
            case SPIDER   -> 8;
        };
    }

}
