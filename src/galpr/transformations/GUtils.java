package galpr.transformations;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GUtils {
    static double mat[][] = { { 1.4, 2.4, 3.6, 4.7 },
            { 5.2, 6.3, 7.4, 8.7 },
            { 9.6, 10.3, 11.5, 12.4 } };

    static double mat2[][] = { { 1.4, 2.4, 3.6, 4.7 },
            { 5.2, 6.3, 7.4, 8.7 }};

    //
    public static boolean AreMatrixMultiplicatable(double firstMatrix[][], double[][] secondMatrix2) {

        var firstMatrixColumnCount = firstMatrix.length;
        var secondMatrixRowCount = secondMatrix2[0].length;

        // Počet sloupců jedné matice se musí rovnat počtu řádků druhé
        return firstMatrixColumnCount == secondMatrixRowCount;
    }

    static int n = 3;

    // Function that return
    // dot product of two vector array.
    public static int dotProduct(int vect_A[], int vect_B[])
    {

        int product = 0;

        // Loop for calculate cot product
        for (int i = 0; i < n; i++)
            product = product + vect_A[i] * vect_B[i];
        return product;
    }


    public static double scalarProduct(int vect_A[], int vect_B[]) {

        int[] result = new int[vect_A.length];

        var test = (vect_A[0] * vect_B[0] + vect_A[1] * vect_B[1] + vect_A[2]* vect_B[2]) / (Math.sqrt(Math.pow(vect_A[0], 2) + Math.pow(vect_A[1], 2))+ Math.pow(vect_A[2], 2))
                * (Math.sqrt(Math.pow(vect_B[0], 2) + Math.pow(vect_B[1], 2))+ Math.pow(vect_B[2], 2));





        return test;

    }












    // Function to find
    // cross product of two vector array.
    public static void crossProduct(int vect_A[], int vect_B[],
                             int cross_P[])

    {

        cross_P[0] = vect_A[1] * vect_B[2]
                - vect_A[2] * vect_B[1];
        cross_P[1] = vect_A[0] * vect_B[2]
                - vect_A[2] * vect_B[0];
        cross_P[2] = vect_A[0] * vect_B[1]
                - vect_A[1] * vect_B[0];
    }



    /* Matrix multiplication */
    public static double[][] matrixMultiplication(double[][] firstMatrix, double[][] secondMatrix) {

        double c[][]=new double[firstMatrix.length][secondMatrix.length];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                c[i][j]=0;
                for(int k=0;k<3;k++)
                {
                    c[i][j]+=firstMatrix[i][k]*secondMatrix[k][j];
                }
                //System.out.print(c[i][j]+" ");
        }
            //System.out.println();
        }

        return c;

    }




}
