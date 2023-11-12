package edu.project1.gallows.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class GraphicalProcessor {

    private static final int FIRST_STAGE = 1;
    private static final int SECOND_STAGE = 2;
    private static final int THIRD_STAGE = 3;
    private static final int FOURTH_STAGE = 4;
    private static final int FIFTH_STAGE = 5;

    private GraphicalProcessor() {}


    @SuppressWarnings({"MultipleStringLiterals"})
    public static void drawGallows(int stage) {
        switch (stage) {
            case FIRST_STAGE -> {
                log.info(" _____ ");
                log.info(" |    |");
                log.info(" |     ");
                log.info(" |     ");
                log.info(" |     ");
                log.info("_|_____");
            }
            case SECOND_STAGE -> {
                log.info(" _____ ");
                log.info(" |/   |");
                log.info(" |     ");
                log.info(" |     ");
                log.info(" |     ");
                log.info("_|_____");
            }
            case THIRD_STAGE -> {
                log.info("  ____ ");
                log.info(" |/   |");
                log.info(" |    O");
                log.info(" |     ");
                log.info(" |     ");
                log.info("_|_____");
            }
            case FOURTH_STAGE -> {
                log.info("  ____ ");
                log.info(" |/   |");
                log.info(" |    O");
                log.info(" |     ");
                log.info(" |     ");
                log.info("_|_______|=|");
            }
            case FIFTH_STAGE -> {
                log.info("  ____ ");
                log.info(" |/   |");
                log.info(" |    O");
                log.info(" |   /|\\");
                log.info(" |   / \\");
                log.info("_|_______|=|");
            }
            default -> log.info("Incorrect stage");
        }
    }

}
