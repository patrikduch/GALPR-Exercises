package galpr.rasterization.shapes;

import galpr.G_Color;
import galpr.G_Graphics;
import galpr.helpers.VectorHelper;

public class Sphere {
    public static void renderWithLight(int[] cx, int r, G_Graphics graphics) {

        int[] oVector = new int[] {0, 1, 0};

        for(int y = -r; y<= r; y++) {
            for(int x = -r; x<= r; x++) {

                double z = -Math.pow(x, 2) - Math.pow(y,2) + Math.pow(r, 2);

                if (z < 0) {
                    continue;
                }

                z = Math.abs(z);

                int[] vector = new int[]{x-cx[0],y-cx[1],(int)z};

                double cos = VectorHelper.scalarProduct(vector, oVector);

                if(cos> 0) {

                    continue;
                }

                int G = -(int)((cos) * 255);

                G_Color sphereColor = new G_Color(G, G, G);

                graphics.putPixel(x+cx[0],y+cx[1], sphereColor);

            }
        }
    }
}
