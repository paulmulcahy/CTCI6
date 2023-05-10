package ca.pmulcahy.ctci6.chp01.q08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestZeroMatrix {

  private static long[][] initializeMatrix(final int ySize, final int xSize) {
    final long[][] matrix = new long[ySize][];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i] = new long[xSize];
    }
    return matrix;
  }

  @Test
  public void nSizeTwo() {
    final int N_SIZE = 2;

    final long[][] toZero = initializeMatrix(N_SIZE, N_SIZE);
    toZero[0][0] = 0;
    toZero[0][1] = 2;
    toZero[1][0] = 3;
    toZero[1][1] = 4;

    final long[][] expected = initializeMatrix(N_SIZE, N_SIZE);
    expected[0][0] = 0;
    expected[0][1] = 0;
    expected[1][0] = 0;
    expected[1][1] = 4;

    final long[][] actual = ZeroMatrix.zeroMatrix(toZero);

    for (int i = 0; i < N_SIZE; i++) {
      for (int j = 0; j < N_SIZE; j++) {
        assertEquals(
            expected[i][j],
            actual[i][j],
            "expected was " + expected[i][j] + " but actual was " + actual[i][j] + ".");
      }
    }
  }

  @Test
  public void nSizeThree() {
    final int N_SIZE = 3;

    final long[][] toZero = initializeMatrix(N_SIZE, N_SIZE);
    toZero[0][0] = 1;
    toZero[0][1] = 2;
    toZero[0][2] = 3;
    toZero[1][0] = 4;
    toZero[1][1] = 5;
    toZero[1][2] = 6;
    toZero[2][0] = 7;
    toZero[2][1] = 0;
    toZero[2][2] = 9;

    final long[][] expected = initializeMatrix(N_SIZE, N_SIZE);
    expected[0][0] = 1;
    expected[0][1] = 0;
    expected[0][2] = 3;
    expected[1][0] = 4;
    expected[1][1] = 0;
    expected[1][2] = 6;
    expected[2][0] = 0;
    expected[2][1] = 0;
    expected[2][2] = 0;

    final long[][] actual = ZeroMatrix.zeroMatrix(toZero);

    for (int i = 0; i < N_SIZE; i++) {
      for (int j = 0; j < N_SIZE; j++) {
        assertEquals(
            expected[i][j],
            actual[i][j],
            "expected was " + expected[i][j] + " but actual was " + actual[i][j] + ".");
      }
    }
  }

  @Test
  public void nTwoByThree() {
    final int Y_SIZE = 2;
    final int X_SIZE = 3;

    final long[][] toZero = initializeMatrix(Y_SIZE, X_SIZE);
    toZero[0][0] = 1;
    toZero[0][1] = 0;
    toZero[0][2] = 3;
    toZero[1][0] = 4;
    toZero[1][1] = 5;
    toZero[1][2] = 6;

    final long[][] expected = initializeMatrix(Y_SIZE, X_SIZE);
    expected[0][0] = 0;
    expected[0][1] = 0;
    expected[0][2] = 0;
    expected[1][0] = 4;
    expected[1][1] = 0;
    expected[1][2] = 6;

    final long[][] actual = ZeroMatrix.zeroMatrix(toZero);

    for (int i = 0; i < Y_SIZE; i++) {
      for (int j = 0; j < X_SIZE; j++) {
        assertEquals(
            expected[i][j],
            actual[i][j],
            "expected was " + expected[i][j] + " but actual was " + actual[i][j] + ".");
      }
    }
  }

  public void nJagged() {
    final int N_SIZE = 3;

    final long[][] toZero = initializeMatrix(N_SIZE, N_SIZE);
    toZero[1] = new long[2];
    toZero[0][0] = 1;
    toZero[0][1] = 2;
    toZero[0][2] = 0;
    toZero[1][0] = 4;
    toZero[1][1] = 5;
    // toZero[1][2] does not exist
    toZero[2][0] = 7;
    toZero[2][1] = 8;
    toZero[2][2] = 9;

    final long[][] expected = initializeMatrix(N_SIZE, N_SIZE);
    toZero[1] = new long[2];
    expected[0][0] = 0;
    expected[0][1] = 0;
    expected[0][2] = 0;
    expected[1][0] = 4;
    expected[1][1] = 5;
    // expected[1][2] does not exist
    expected[2][0] = 7;
    expected[2][1] = 8;
    expected[2][2] = 0;

    final long[][] actual = ZeroMatrix.zeroMatrix(toZero);

    for (int i = 0; i < toZero.length; i++) {
      for (int j = 0; j < toZero[i].length; j++) {
        assertEquals(
            expected[i][j],
            actual[i][j],
            "expected was " + expected[i][j] + " but actual was " + actual[i][j] + ".");
      }
    }
  }
}
