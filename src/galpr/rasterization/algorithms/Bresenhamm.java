package galpr.rasterization.algorithms;

import galpr.G_Color;
import galpr.G_Graphics;

public class Bresenhamm {
    public static void render(int x1, int x2, int y1, int y2, G_Graphics graphics) {
        // Bresenham's algorithm

        if ((x1 == x2) && (y1 == y2)) {
            graphics.putPixel(x1, y1, G_Color.G_cBlack);

        } else {
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            int rozdil = dx - dy;

            int posun_x, posun_y;

            if (x1 < x2) posun_x = 1; else posun_x = -1;
            if (y1 < y2) posun_y = 1; else posun_y = -1;

            while ((x1 != x2) || (y1 != y2)) {

                int p = 2 * rozdil;

                if (p > -dy) {
                    rozdil = rozdil - dy;
                    x1 = x1 + posun_x;
                }
                if (p < dx) {
                    rozdil = rozdil + dx;
                    y1 = y1 + posun_y;
                }
                //drawPixel(x1, y1, barva);
                graphics.putPixel(x1, y1, G_Color.G_cBlack);
            }
        }
    }
}
