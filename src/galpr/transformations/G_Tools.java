package galpr.transformations;

public class G_Tools {

    public static int[][] multiplyMatrices(int[][] a, int[][] b){
        int[][] returnedMatrix = new int[a.length][b[0].length];

        if (a[0].length == b.length){
            for (int i = 0; i <a.length ; i++) {
                for (int j = 0; j <b[0].length ; j++) {
                    returnedMatrix[i][j] = 0;
                    for (int k = 0; k < 3; k++) {
                        returnedMatrix[i][j] += a[i][k] * b[k][j];

                    }
                    System.out.print(returnedMatrix[i][j] + " ");
                }
                System.out.println();
            }
            return returnedMatrix;
        }else return new int[0][0];

    }


}


