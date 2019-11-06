package galpr.rasterization.algorithms;

// Dodělat besiorovu křivku

/*
* https://www.dreamincode.net/forums/topic/26502-drawing-bezier-curves-with-java/
* http://www.enseignement.polytechnique.fr/informatique/INF555/TD/TD2/INF555-TD2-1.html
* https://medium.com/swlh/introduction-to-processing-with-bezier-curves-185dca85e00
*
* */


import galpr.G_Color;
import galpr.G_Graphics;

import java.awt.*;

import static java.lang.Math.pow;

public class Bezier {
    private int[] _x;
    private int[] _y;

    public Bezier() {
        _x = new int[]{200, 100, 200, 250};
        _y = new int[]{200,150,75,100};
    }


    public void bezier (G_Graphics graphics) {
        int i;
        double t, xt, yt;
        for (t = 0.0; t < 1.0; t += 0.0005) {
            xt = pow(1 - t, 3) * this._x[0] + 3 * t * pow(1 - t, 2) * this._x[1] + 3 * pow(t, 2) * (1 - t) * this._x[2] + pow(t, 3) * this._x[3];
            yt = pow(1 - t, 3) * this._y[0] + 3 * t * pow(1 - t, 2) * this._y[1] + 3 * pow(t, 2) * (1 - t) * this._y[2] + pow(t, 3) * this._y[3];
            graphics.putPixel((int)xt, (int)yt, G_Color.G_cBlack);
        }
    }


    public void bezierCurve(int x[] , int y[], G_Graphics graphics)
    {
        double xu = 0.0 , yu = 0.0 , u = 0.0 ;
        int i = 0 ;
        for(u = 0.0 ; u <= 1.0 ; u += 0.0001)
        {
            xu = pow(1-u,3)*x[0]+3*u*pow(1-u,2)*x[1]+3*pow(u,2)*(1-u)*x[2]
                    +pow(u,3)*x[3];
            yu = pow(1-u,3)*y[0]+3*u*pow(1-u,2)*y[1]+3*pow(u,2)*(1-u)*y[2]
                    +pow(u,3)*y[3];
            //SDL_RenderDrawPoint(renderer , (int)xu , (int)yu) ;

            graphics.putPixel((int)xu,(int)yu, G_Color.G_cBlack);


        }
    }





}
