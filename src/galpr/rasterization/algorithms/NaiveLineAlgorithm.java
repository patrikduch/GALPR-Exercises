package galpr.rasterization.algorithms;

import galpr.G_Color;
import galpr.G_Graphics;

public class NaiveLineAlgorithm {

    public static void renderHorizontalLine(int x1, int x2, int y1, int y2, G_Graphics graphics) {

        for(int x = 0; x< Math.max(x1,x2); x++) {
            graphics.putPixel(x, y1, G_Color.G_cBlack);
        }

    }

    public static void renderVerticalLine(int x1, int x2, int y1, int y2, G_Graphics graphics) {

    }

    public static void render(int x1, int x2, int y1, int y2, G_Graphics graphics) {
        // y = kx + q or y=ax+q
        int dx = x2-x1;
        int dy = y2 -y1;

        if(dx == 0) { // Vertical line
            for(int y = 0; y< Math.max(y1,y2); y++) {
                graphics.putPixel(x1, y, G_Color.G_cBlack);
            }
        }
        else if (dy == 0) { // Horizontal line
            renderHorizontalLine(x1, x2, y1, y2, graphics);
        } else {
            float m = dy/dx;

            // Calculation of x from mathematic formula y=mx+b => b = y - mx
            float b = (y1 - (m*x1)); // Intercept

            if (Math.abs(m) > 1.0f) { // Steep slope

                for(int y = 0; y< Math.max(y1,y2); y++) {
                    int x = (int)((y-b) /m);
                    graphics.putPixel(x, y, G_Color.G_cBlack);
                }


            } else { // Shallow slope

                for(int x = 0; x< Math.max(x1,x2); x++) {
                    int y =  (int)((m*x) + b);
                    graphics.putPixel(x, y, G_Color.G_cBlack);
                }

            }

        }

    }
}
