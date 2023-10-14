package edu.project1.gallows.utils;

public final class GraphicalProcessor {

    private static final int FIRST_STAGE = 1;
    private static final int SECOND_STAGE = 2;
    private static final int THIRD_STAGE = 3;
    private static final int FOURTH_STAGE = 4;
    private static final int FIFTH_STAGE = 5;

    private GraphicalProcessor() {}


    @SuppressWarnings({"MultipleStringLiterals", "RegexpSinglelineJava"})
    public static void drawGallows(int stage) {
        switch (stage) {
            case FIRST_STAGE -> {
                System.out.println(" _____ ");
                System.out.println(" |    |");
                System.out.println(" |     ");
                System.out.println(" |     ");
                System.out.println(" |     ");
                System.out.println("_|_____");
            }
            case SECOND_STAGE -> {
                System.out.println(" _____ ");
                System.out.println(" |/   |");
                System.out.println(" |     ");
                System.out.println(" |     ");
                System.out.println(" |     ");
                System.out.println("_|_____");
            }
            case THIRD_STAGE -> {
                System.out.println("  ____ ");
                System.out.println(" |/   |");
                System.out.println(" |    O");
                System.out.println(" |     ");
                System.out.println(" |     ");
                System.out.println("_|_____");
            }
            case FOURTH_STAGE -> {
                System.out.println("  ____ ");
                System.out.println(" |/   |");
                System.out.println(" |    O");
                System.out.println(" |     ");
                System.out.println(" |     ");
                System.out.println("_|_______|=|");
            }
            case FIFTH_STAGE -> {
                System.out.println("  ____ ");
                System.out.println(" |/   |");
                System.out.println(" |    O");
                System.out.println(" |   /|\\");
                System.out.println(" |   / \\");
                System.out.println("_|_______|=|");
            }
            default -> {
                System.out.println("Incorrect stage");
            }
        }
    }

}
