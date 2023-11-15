package edu.hw3.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AtbashCipherTest {

    @ParameterizedTest
    @CsvSource({
        "a, z",
        "b, y",
        "c, x",
        "d, w",
        "e, v",
        "f, u",
        "g, t",
        "h, s",
        "i, r",
        "j, q",
        "k, p",
        "l, o",
        "m, n",
        "n, m",
        "o, l",
        "p, k",
        "q, j",
        "r, i",
        "s, h",
        "t, g",
        "u, f",
        "v, e",
        "w, d",
        "x, c",
        "y, b",
        "z, a",
    })
    void testLowerCaseAlphabet(String original, String expected) {
        // Arrange & Act
        String result = AtbashCipher.encrypt(original);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "A, Z",
        "B, Y",
        "C, X",
        "D, W",
        "E, V",
        "F, U",
        "G, T",
        "H, S",
        "I, R",
        "J, Q",
        "K, P",
        "L, O",
        "M, N",
        "N, M",
        "O, L",
        "P, K",
        "Q, J",
        "R, I",
        "S, H",
        "T, G",
        "U, F",
        "V, E",
        "W, D",
        "X, C",
        "Y, B",
        "Z, A",
    })
    void testUpperCaseAlphabet(String original, String expected) {
        // Arrange & Act
        String result = AtbashCipher.encrypt(original);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testNotLetterEncrypt() {
        // Arrange
        String notLetters = "!> \u0000\u0085`";
        // Act
        String result = AtbashCipher.encrypt(notLetters);
        // Assert
        assertThat(result).isEqualTo(notLetters);
    }

    @Test
    void testEmptyInput() {
        // Arrange
        String input = "";
        // Act
        String result = AtbashCipher.encrypt(input);
        // Assert
        assertThat(result).isEqualTo(input);
    }

    @Test
    void testNullInput() {
        // Arrange
        String input = null;
        // Act
        String result = AtbashCipher.encrypt(null);
        // Assert
        assertThat(result).isNull();
    }

    @Test
    void testStringInput() {
        // Arrange
        String original = "Any fool can write code that a computer can understand. " +
            "Good programmers write code that humans can understand. ― Martin Fowler";
        String expected = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. " +
            "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        // Act
        String result = AtbashCipher.encrypt(original);
        // Assert
        assertThat(result).isEqualTo(expected);
    }

}
