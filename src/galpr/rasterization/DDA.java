package galpr.rasterization;

import galpr.G_Color;
import galpr.G_Graphics;

public class DDA {
    public void renderline(int x1, int x2, int y1, int y2, G_Color color, G_Graphics graphics) {

        double dx = x2-x1;
        double dy = y2-y1;

        if(dx == 0) {
             // yz< yk
            graphics.verticalLine(x1,x2, y1, y2, color);
            return;
        }

        if(dy == 0) {
            // xz< xk
            graphics.horizontalLine(x1, x2, y1, y2, color);
            return;
        }


        double a =  dy / dx;

        if(Math.abs(a) <= 1) { // Absolutní hodnota směrnice je je menší nebo rovna 1

            if (x1 > x2) {

                var tempx = x1;
                x1 = x2;

                x2 = tempx;

                var tempy = y1;
                y1 = y2;
                y2 = tempy;

                System.out.println(x1);
                System.out.println(x2);
            }

            int cele_y;
            double y = y1; // Inicializace na y pocatecni

            for (int x = x1 ; x <= x2 ; x++) {
                cele_y = (int)Math.round(y);
                graphics.putPixel(x, cele_y, color);
                y += a;
            }


        } else { // Prohodit x za y  (přepočitat po každé v cyklu směrnici)

            if (y2 < y1) {
                int tmp = x2;
                x2 = x1;
                x1 = tmp;

                tmp = y2;
                y2 = y1;
                y1 = tmp;
            }

            double k = (double) dx / dy;
            int cele_x;
            double x = (double) x1;
            for (int y = y1; y <= y2; y++) {
                cele_x = (int) Math.round(x);
                graphics.putPixel(cele_x, y, color);
                x += k;

            }

        }


    }




    public void render(int x1, int x2, int y1, int y2, G_Color color, G_Graphics graphics) {

        double dx = x2-x1;
        double dy = y2-y1;

        System.out.println("dx:" + dx);
        System.out.println("dy" + dy);

        if(dx == 0) {
            graphics.verticalLine(x1,x2, y1, y2, color);
            return;
        }

        if(dy == 0) {
            graphics.horizontalLine(x1, x2, y1, y2, color);
            return;
        }


        double a =  dy / dx;

        //System.out.println(a);

        if (Math.abs(y2 - y1) <= Math.abs(x2 - x1)) {

            if ((x1 == x2) && (y1 == y2)) {
                graphics.putPixel(x1, y1, color);
            } else {
                if (x2 < x1) {
                    int tmp = x2;
                    x2 = x1;
                    x1 = tmp;

                    tmp = y2;
                    y2 = y1;
                    y1 = tmp;
                }

                double k = (double)dy/dx;
                int cele_y;
                double y = (double)y1;

                for (int x = x1 ; x <= x2 ; x++) {
                    cele_y = (int)Math.round(y);
                    graphics.putPixel(x, cele_y, color);
                    //drawPixel(x, cele_y, barva);
                    y += k;
                }
            }
        } else {

            if (y2 < y1) {
                int tmp = x2;
                x2 = x1;
                x1 = tmp;

                tmp = y2;
                y2 = y1;
                y1 = tmp;
            }

            double k = (double)dx/dy;
            int cele_x;
            double x = (double)x1;
            for (int y = y1; y <= y2; y++) {
                cele_x = (int)Math.round(x);
                graphics.putPixel(cele_x, y, color);
                x += k;
            }
        }
    }
}
