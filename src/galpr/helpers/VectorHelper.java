package galpr.helpers;

public class VectorHelper {

    public static double scalarProduct(int vect_A[], int vect_B[]) {

        double v1Res =  (vect_A[0] * vect_B[0]);
        double v2Res = (vect_A[1] * vect_B[1]);

        double sqrtv1Res = Math.abs((Math.pow(vect_A[0], 2) + Math.pow(vect_A[1], 2)));
        double sqrtv2Res = Math.abs((Math.pow(vect_B[0], 2) + Math.pow(vect_B[1], 2)));

        return (v1Res + v2Res) / Math.sqrt(sqrtv1Res * sqrtv2Res);

    }
}
