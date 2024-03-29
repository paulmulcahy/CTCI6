package ca.pmulcahy.ctci6.chp01.q08;

import java.util.HashSet;
import java.util.Set;

/*
 * Write an algorithm such that if an element in an MXN matrix is 0, its entire row and column are set to 0.
 *
 * Note: This implementation will work with different-sized jagged arrays.
 */
public class ZeroMatrix {
  public static long[][] zeroMatrix(final long[][] matrix) {
    if (matrix == null) {
      return null;
    }

    final Set<Integer> columnsToZero = new HashSet<>();
    final Set<Integer> rowsToZero = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rowsToZero.add(i);
          columnsToZero.add(j);
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (rowsToZero.contains(i) || columnsToZero.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
    return matrix;
  }
}
