package galpr.rasterization.algorithms;

import galpr.G_Color;
import galpr.G_Graphics;

public class Trivial {
    public static void render(int x1, int x2, int y1, int y2, G_Graphics graphics) {
        // Trivial algorithm

        double dx = x2 - x1;
        double dy = y2 - y1;

        if (Math.abs(y2 - y1) >= Math.abs(x2 - x1)) {

            if ((x1 == x2) && (y1 == y2)) {
                graphics.putPixel(x1, y1, G_Color.G_cBlack);

            } else {
                if (y2 < y1) {
                    int tmp = x2;
                    x2 = x1;
                    x1 = tmp;

                    tmp = y2;
                    y2 = y1;
                    y1 = tmp;
                }

                double k = dx / (double) dy;
                double q = x1 - k * y1;

                for (int y = y1; y < y2; y++) {
                    int x = (int) (k * y + q);
                    graphics.putPixel(x, y, G_Color.G_cBlack);
                }
            }


        } else {
            if (x2 < x1) {
                int tmp = x2;
                x2 = x1;
                x1 = tmp;

                tmp = y2;
                y2 = y1;
                y1 = tmp;
            }

            double k = dy / (double) dx;
            double q = y1 - k * x1;

            for (int x = x1; x < x2; x++) {
                int y = (int) (k * x + q);
                graphics.putPixel(x,y, G_Color.G_cBlack);
            }
        }
    }
}
