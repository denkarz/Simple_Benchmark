package com.denkarz.benchmarktest.entities;

import static com.denkarz.benchmarktest.gui.MainWindow.jBasicTable;

/**
 * Implenetation of Cramer algorithm.
 *
 * @author Karzykin Denis
 */
public class CramerSystem {
    /**
     * Total time value.
     */
    private long finalTimeout;
    /**
     * Matrix of coefficients.
     */
    private double[][] a = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
    };
    /**
     * Matrix of the right part of equations.
     */
    private double[] b = {10, 20, 5, 2, 1, 0, 0, 10, 5};

    /**
     * Calculate determinant using recursion.
     * If on input - smallest square matrix (2x2) - calculate determinant by "cross" method, else separate matrix for minors.
     * For every minor calculate itself determinant recursively.
     *
     * @param matrix matrix
     * @return its determinant
     */
    private double getDeterminant(final double[][] matrix) {
        double calcResult = 0.0;
        if (matrix.length == 2) {
            calcResult = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            int coefficient = 1;
            for (int i = 0, length = matrix.length; i < length; i++) {
                if (i % 2 == 1)
                    coefficient = -1;
                else
                    coefficient = 1;
                calcResult += coefficient * matrix[0][i] * this.getDeterminant(this.getMinor(matrix, i));
            }
        }
        return calcResult;
    }

    /**
     * Get minor from matrix.
     *
     * @param matrix matrix
     * @param column column number which is needed to strike out
     * @return matrix minor
     */
    private double[][] getMinor(final double[][] matrix, final int column) {
        int minorLength = matrix.length - 1;
        double[][] minor = new double[minorLength][minorLength];
        int dI = 0;
        int dJ;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++)
                if (i == 0)
                    dI = 1;
                else if (j == column)
                    dJ = 1;
                else
                    minor[i - dI][j - dJ] = matrix[i][j];
        }
        return minor;
    }

    /**
     * Get result by Cramer algorithm.
     */
    public void solutionOfCramerSystem() {
        double[][] tmp = new double[a.length][a.length];
        double[] x = new double[a.length];
        double detA;
        long timeout = System.currentTimeMillis();
        detA = getDeterminant(a);
        for (int m = 0, n = a.length; m < n; m++) {
            for (int i = 0; i < n; i++)
                System.arraycopy(a[i], 0, tmp[i], 0, n);
            for (int j = 0; j < n; j++)
                tmp[j][m] = b[j];
            x[m] = getDeterminant(tmp) / detA;
        }
        timeout = System.currentTimeMillis() - timeout;
        finalTimeout += timeout;
        jBasicTable.setValueAt(getTimeout(), 2, 1);
    }

    /**
     * Get timeout.
     *
     * @return time in milliseconds
     */
    private long getTimeout() {
        return finalTimeout;
    }
}
