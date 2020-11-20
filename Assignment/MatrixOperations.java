package HW1;

/**
 * Homework 6 -- Matrix Operations
 *
 * This program perform matrix operations to matrices the user enters.
 * It will utilize the constructor in Matrix Class.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version February 26, 2020
 *
 *
 */

public class MatrixOperations {

    public boolean sameSizeMatrix(Matrix m1, Matrix m2) {
        if (m1.matrix.length == m2.matrix.length) {
            for (int i = 0; i < m1.matrix.length; i++) {
                if (m1.matrix[i].length != m2.matrix[i].length) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public Matrix addMatrix(Matrix m1, Matrix m2) {
        boolean res = sameSizeMatrix(m1, m2);
        if (!res) {
            return null;
        } else {
            int [][] newMatrix = new int [m1.matrix.length][m1.matrix.length];
            Matrix m3 = new Matrix(newMatrix);

            for (int i = 0; i < m1.matrix.length; i++) {
                for (int j = 0; j < m1.matrix[i].length; j++) {
                    m3.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
                }
            }
            return m3;
        }

    }

    public Matrix subtractMatrix(Matrix m1, Matrix m2) {
        boolean res = sameSizeMatrix(m1, m2);
        if (!res) {
            return null;
        } else {
            int [][] newMatrix = new int [m1.matrix.length][m1.matrix.length];
            Matrix m3 = new Matrix(newMatrix);

            for (int i = 0; i < m1.matrix.length; i++) {
                for (int j = 0; j < m1.matrix[i].length; j++) {
                    m3.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
                }
            }
            return m3;
        }

    }

    public Matrix transposeMatrix(Matrix m1) {
        int [][] newMatrix = new int [m1.matrix.length][m1.matrix.length];
        Matrix m3 = new Matrix(newMatrix);

        for (int i = 0; i < m1.matrix.length; i++) {
            for (int j = 0; j < m1.matrix[i].length; j++) {
                m3.matrix[i][j] = m1.matrix[j][i];
            }
        }
        return m3;


    }

    public Matrix productMatrix(Matrix m1, Matrix m2) {
        if (m1.matrix[0].length != m2.matrix.length) {
            return null;
        } else {
            int [][] newMatrix = new int [m1.matrix.length][m2.matrix[0].length];
            Matrix m3 = new Matrix(newMatrix);

            int [] row1 = new int [m1.matrix.length * m1.matrix[0].length];
            int [] column1 = new int [m2.matrix.length * m2.matrix[0].length];
            int rowElement;
            int colElement;
            int sum = 0;


            for (int i = 0; i < m1.matrix.length; i++) {
                for (int j = 0; j < m2.matrix[0].length; j++) {

                    for (int k = 0; k < m1.matrix[0].length; k++) {
                        rowElement = m1.matrix[i][k];
                        colElement = m2.matrix[k][j];
                        sum += rowElement * colElement;
                    }
                    m3.matrix[i][j] = sum;
                    sum = 0;

                }

            }

            return m3;
        }


    }

    public void printMatrix(Matrix m1) {
        if (m1 != null) {
            for (int[] row : m1.matrix) {
                for (int word : row) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        } else {
            return;
        }

    }

}
