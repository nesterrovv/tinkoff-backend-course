package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task8Test {

    private final Task8 task8 = new Task8();

    @Test
    @DisplayName("Test correct-filled chessboards")
    void testValidChessboards() {
        int[][] board1 = new int[][] {
            new int[] {0, 0, 0, 1, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 0, 0, 1},
            new int[] {0, 0, 0, 0, 1, 0, 0, 0}
        };
        int[][] board2 = new int[][] {
            new int[] {0, 0, 0, 1, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 0, 0, 1},
            new int[] {0, 0, 0, 0, 1, 0, 0, 0}
        };
        int[][] board3 = new int[][] {
            new int[] {1, 0, 0, 0, 0, 0, 0, 1},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {1, 0, 0, 0, 0, 0, 0, 1}
        };
        Assertions.assertTrue((task8.knightBoardCapture(board1)));
        Assertions.assertTrue((task8.knightBoardCapture(board2)));
        Assertions.assertTrue((task8.knightBoardCapture(board3)));
    }

    @Test
    @DisplayName("Test incorrect-filled chessboards")
    void testNonValidChessboards() {
        int[][] board1 = new int[][] {
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 1, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int[][] board2 = new int[][] {
            new int[] {1, 0, 1, 0, 1, 0, 1, 0},
            new int[] {0, 1, 0, 1, 0, 1, 0, 1},
            new int[] {0, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 0, 1, 0, 0, 1, 0, 1},
            new int[] {1, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 1},
            new int[] {1, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 0, 0, 1, 0, 1, 0, 1}
        };
        int[][] board3 = new int[][] {
            new int[] {0, 0, 0, 0, 1, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 1, 0, 0, 0, 0},
            new int[] {1, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 1, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 0},
            new int[] {1, 0, 0, 0, 0, 0, 0, 0}
        };
        Assertions.assertFalse((task8.knightBoardCapture(board1)));
        Assertions.assertFalse((task8.knightBoardCapture(board2)));
        Assertions.assertFalse((task8.knightBoardCapture(board3)));
    }

    @Test
    @DisplayName("Test full-filled chessboard")
    void testFullFieldChessboards() {
        int[][] board = new int[][] {
            new int[] {1, 1, 1, 1, 1, 1, 1, 1},
            new int[] {1, 1, 1, 1, 1, 1, 1, 1},
            new int[] {1, 1, 1, 1, 1, 1, 1, 1},
            new int[] {1, 1, 1, 1, 1, 1, 1, 1},
            new int[] {1, 1, 1, 1, 1, 1, 1, 1},
            new int[] {1, 1, 1, 1, 1, 1, 1, 1},
            new int[] {1, 1, 1, 1, 1, 1, 1, 1},
            new int[] {1, 1, 1, 1, 1, 1, 1, 1}
        };
        Assertions.assertFalse((task8.knightBoardCapture(board)));
    }

    @Test
    @DisplayName("Test empty chessboard")
    void testEmptyChessboard() {
        int[][] board = new int[][] {
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0}
        };
        Assertions.assertTrue((task8.knightBoardCapture(board)));
    }

    @Test
    @DisplayName("Test incorrect input")
    void testIncorrectChessboards() {
        int[][] board1 = new int[][] {
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] board2 = new int[][] {
            new int[] {0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0}
        };
        Assertions.assertFalse((task8.knightBoardCapture(board1)));
        Assertions.assertFalse((task8.knightBoardCapture(board2)));
    }

    @Test
    @DisplayName("Test null input")
    void testNullInput() {
        Assertions.assertFalse((task8.knightBoardCapture(null)));
    }

}
