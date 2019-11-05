package galpr.rasterization.transformations;

/*
* Translation 2D transformation
*/
public class Translation {
    public static int[][] reCalculate(int[][] vertices, int tx, int ty) {

        var resultMatrix = new int[vertices.length][vertices[0].length];

        for(int i=0; i< vertices.length; i++) { // Iterate throught the categories
            for(int j=0; j<vertices[0].length; j++) {

                System.out.println((vertices[i][j]));
                resultMatrix[i][j] = vertices[i][j];

                resultMatrix[0][j] += tx;
                resultMatrix[1][j] += ty;
            }
        }
        return resultMatrix;
    }
}
