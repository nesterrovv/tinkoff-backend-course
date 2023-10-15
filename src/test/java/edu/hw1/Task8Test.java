package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {

    private final Task8 task8 = new Task8();

    @ParameterizedTest
    @MethodSource("validChessboardData")
    @DisplayName("Test correct-filled chessboards")
    void testValidChessboards(int[][] board, boolean expected) {
        boolean result = task8.knightBoardCapture(board);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> validChessboardData() {
        return Stream.of(
            Arguments.of(
                new int[][] {
                    new int[] {0, 0, 0, 1, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 1, 0, 0, 0, 1, 0, 0},
                    new int[] {0, 0, 0, 0, 1, 0, 1, 0},
                    new int[] {0, 1, 0, 0, 0, 1, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 1, 0, 0, 0, 0, 0, 1},
                    new int[] {0, 0, 0, 0, 1, 0, 0, 0}
                },
                true
            ),
            Arguments.of(
                new int[][] {
                    new int[] {1, 0, 0, 0, 0, 0, 0, 1},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {1, 0, 0, 0, 0, 0, 0, 1}
                },
                true
            ),
            Arguments.of(
                new int[][] {
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 1, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 1, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0}
                },
                false
            ),
            Arguments.of(
                new int[][] {
                    new int[] {1, 0, 1, 0, 1, 0, 1, 0},
                    new int[] {0, 1, 0, 1, 0, 1, 0, 1},
                    new int[] {0, 0, 0, 0, 1, 0, 1, 0},
                    new int[] {0, 0, 1, 0, 0, 1, 0, 1},
                    new int[] {1, 0, 0, 0, 1, 0, 1, 0},
                    new int[] {0, 0, 0, 0, 0, 1, 0, 1},
                    new int[] {1, 0, 0, 0, 1, 0, 1, 0},
                    new int[] {0, 0, 0, 1, 0, 1, 0, 1}
                },
                false
            )
        );
    }

    @ParameterizedTest
    @MethodSource("nonValidChessboardData")
    @DisplayName("Test incorrect-filled chessboards")
    void testNonValidChessboards(int[][] board, boolean expected) {
        boolean result = task8.knightBoardCapture(board);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> nonValidChessboardData() {
        return Stream.of(
            Arguments.of(
                new int[][] {
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                    new int[] {1, 1, 1, 1, 1, 1, 1, 1}
                },
                false
            ),
            Arguments.of(
                new int[][] {
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                    new int[] {0, 0, 0, 0, 0, 0, 0, 0}
                },
                true
            )
        );
    }

}
