package galpr.transformations;

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
