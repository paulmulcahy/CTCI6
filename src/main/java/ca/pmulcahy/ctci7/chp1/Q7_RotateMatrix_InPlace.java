package ca.pmulcahy.ctci7.chp1;

/*
 * Given an image represented by an NXN matrix, where each pixel in the image is 4 bytes, write a method to
 * rotate the image by 90 degress. Can you do this in place?
 */
public class Q7_RotateMatrix_InPlace{
	public static long[][] rotate(long[][] matrix) {
		if(!validateInput(matrix)) {
			return null;
		}
		
		int nSize = matrix.length;		
		
		for(int i=0; i<nSize - 1 - i; i++) {
			for( int j=i; j<nSize - 1 - i; j++) {
				long swap = matrix[nSize - 1 - j][i];
				matrix[nSize - 1 - j][i] = matrix[nSize - 1 - i][nSize - 1 - j];
				matrix[nSize - 1 - i][nSize - 1 - j] = matrix[j][nSize - 1 - i];
				matrix[j][nSize - 1 - i] = matrix[i][j];
				matrix[i][j] = swap;
			}
		}
		
		return matrix;
	}
	
	private static boolean validateInput(long[][] matrix) {
		if(matrix==null) {
			return false;
		}
		int nSize = matrix.length;
		for(int i=0; i<nSize; i++) {
			if(matrix[i] == null || matrix[i].length != nSize) {
				return false;
			}
		}
		return true;
	}
}