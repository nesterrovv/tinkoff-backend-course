package edu.hw1;

import edu.exceptions.IncorrectArgumentException;
import java.util.logging.Logger;

public class Task8 {

    private static final Logger LOGGER = Logger.getLogger("LOGGER");
    private static final int BOARD_LENGTH = 8;
    private static final int BIG_NEGATIVE_SHIFT = -2;
    private static final int BIG_POSITIVE_SHIFT = 2;
    private static final int SMALL_NEGATIVE_SHIFT = -1;
    private static final int SMALL_POSITIVE_SHIFT = 1;
    private static final int KNIGHT_EXISTS = 1;

    public boolean knightBoardCapture(int[][] board) {
        try {
            if (board == null || board.length != BOARD_LENGTH || board[0].length != BOARD_LENGTH) {
                throw new IncorrectArgumentException("Board should be a 2D-array with 8 rows nad 8 columns");
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (!isKnightMoveSafe(board, i, j)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (IncorrectArgumentException incorrectArgumentException) {
            LOGGER.severe(incorrectArgumentException.getMessage());
            return false;
        }
    }

    private boolean isKnightMoveSafe(int[][] chessBoard, int row, int column) {
        if (chessBoard[row][column] != KNIGHT_EXISTS) {
            return true;
        }
        int[] possibleRowMoves = {BIG_NEGATIVE_SHIFT, BIG_NEGATIVE_SHIFT, SMALL_NEGATIVE_SHIFT, SMALL_NEGATIVE_SHIFT,
            SMALL_POSITIVE_SHIFT, SMALL_POSITIVE_SHIFT, BIG_POSITIVE_SHIFT, BIG_POSITIVE_SHIFT};
        int[] possibleColMoves = {SMALL_NEGATIVE_SHIFT, SMALL_POSITIVE_SHIFT, BIG_NEGATIVE_SHIFT, BIG_POSITIVE_SHIFT,
            BIG_NEGATIVE_SHIFT, BIG_POSITIVE_SHIFT, SMALL_NEGATIVE_SHIFT, SMALL_POSITIVE_SHIFT};
        for (int i = 0; i < BOARD_LENGTH; i++) {
            int currentRow = row + possibleRowMoves[i];
            int currentColumn = column + possibleColMoves[i];
            if (isValidPosition(currentRow, currentColumn, chessBoard.length, chessBoard[0].length)
                && chessBoard[currentRow][currentColumn] == KNIGHT_EXISTS) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPosition(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

}
