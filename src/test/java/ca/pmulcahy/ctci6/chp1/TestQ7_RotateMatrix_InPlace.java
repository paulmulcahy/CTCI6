package ca.pmulcahy.ctci6.chp1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestQ7_RotateMatrix_InPlace{

    private static long[][] initializeMatrix(int nSize){
        long[][] matrix = new long[nSize][];
		for(int i=0; i< matrix.length; i++) {
			matrix[i] = new long[nSize];
		}
		return matrix;
		
    }

	@Test
	public void nDifferentSizes() {	
		final int X_N_SIZE = 2;
		final int Y_N_SIZE = 3;
	
        long[][] matrix = new long[X_N_SIZE][];
		for(int i=0; i< matrix.length; i++) {
			matrix[i] = new long[Y_N_SIZE];
		}	

		final long[][] actual = Q7_RotateMatrix_InPlace.rotate(matrix);
		
		assertNull(actual, "Provide an uneven array should result in a null return.");
	}
	
	@Test
	public void nSizeTwo() {	
		final int N_SIZE = 2;
	
		final long[][] toRotate = initializeMatrix(N_SIZE);
		toRotate[0][0] = 1;
		toRotate[0][1] = 2;
		toRotate[1][0] = 3;
		toRotate[1][1] = 4;
		
		final long[][] expected = initializeMatrix(N_SIZE);
		expected[0][0] = 3;
		expected[0][1] = 1;
		expected[1][0] = 4;
		expected[1][1] = 2;

		final long[][] actual = Q7_RotateMatrix_InPlace.rotate(toRotate);
		
		for(int i=0; i< N_SIZE; i++) {
			for(int j=0; j< N_SIZE; j++) {
				assertEquals(expected[i][j], actual[i][j], "expected was " + expected[i][j] + " but actual was " + actual[i][j] + ".");
			}
		}
	}
	
	@Test
	public void nSizeThree() {		
		final int N_SIZE = 3;
	
		final long[][] toRotate = initializeMatrix(N_SIZE);
		toRotate[0][0] = 1;
		toRotate[0][1] = 2;
		toRotate[0][2] = 3;
		toRotate[1][0] = 4;
		toRotate[1][1] = 5;
		toRotate[1][2] = 6;
		toRotate[2][0] = 7;
		toRotate[2][1] = 8;
		toRotate[2][2] = 9;
	
		final long[][] expected = initializeMatrix(N_SIZE);
		expected[0][0] = 7;
		expected[0][1] = 4;
		expected[0][2] = 1;
		expected[1][0] = 8;
		expected[1][1] = 5;
		expected[1][2] = 2;
		expected[2][0] = 9;
		expected[2][1] = 6;
		expected[2][2] = 3;

		final long[][] actual = Q7_RotateMatrix_InPlace.rotate(toRotate);

		for(int i=0; i< N_SIZE; i++) {
			for(int j=0; j< N_SIZE; j++) {
				assertEquals(expected[i][j], actual[i][j], "expected was " + expected[i][j] + " but actual was " + actual[i][j] + ".");
			}
		}
	}
	
	@Test
	public void nSizeFour() {		
		final int N_SIZE = 4;
	
		final long[][] toRotate = initializeMatrix(N_SIZE);
		toRotate[0][0] = 1;
		toRotate[0][1] = 2;
		toRotate[0][2] = 3;
		toRotate[0][3] = 4;
		toRotate[1][0] = 5;
		toRotate[1][1] = 6;
		toRotate[1][2] = 7;
		toRotate[1][3] = 8;
		toRotate[2][0] = 9;
		toRotate[2][1] = 10;
		toRotate[2][2] = 11;
		toRotate[2][3] = 12;
		toRotate[3][0] = 13;
		toRotate[3][1] = 14;
		toRotate[3][2] = 15;
		toRotate[3][3] = 16;		
	
		final long[][] expected = initializeMatrix(N_SIZE);
		expected[0][0] = 13;
		expected[0][1] = 9;
		expected[0][2] = 5;
		expected[0][3] = 1;
		expected[1][0] = 14;
		expected[1][1] = 10;
		expected[1][2] = 6;
		expected[1][3] = 2;
		expected[2][0] = 15;
		expected[2][1] = 11;
		expected[2][2] = 7;
		expected[2][3] = 3;
		expected[3][0] = 16;
		expected[3][1] = 12;
		expected[3][2] = 8;
		expected[3][3] = 4;

		final long[][] actual = Q7_RotateMatrix_InPlace.rotate(toRotate);

		for(int i=0; i< N_SIZE; i++) {
			for(int j=0; j< N_SIZE; j++) {
				assertEquals(expected[i][j], actual[i][j], "expected was " + expected[i][j] + " but actual was " + actual[i][j] + ".");
			}
		}
	}
}