package galpr.rasterization.algorithms;

import galpr.G_Color;
import galpr.G_Graphics;

public class BresenhammV2 {

    public static void renderLine(G_Graphics graphics) {
        for(int i = 0; i< 10; i++) {

            graphics.putPixel(i, 10, G_Color.G_cBlack);
        }
    }
}
