package galpr.rasterization.algorithms;

import galpr.G_Color;
import galpr.G_Graphics;

import java.util.Stack;

public class SeedFill {

    public static void fill(int sx, int sy, G_Color boundaryColor, G_Color fillColor, G_Graphics graphics) {

        // bounds check
        if (sx  < 0) return;
        if (sy < 0) return;


        // check current pixel is old_color or not
        if (graphics.getPixel(sx, sy).equals(boundaryColor))
            return;

        // Stack
        Stack<Object> stack = new Stack<>();

        // Add start points to the  stack
        stack.push(new int[] {sx,sy});

        while( !stack.isEmpty() ) { // Stack is not empty

            int[] c = (int[]) stack.pop();
            var x = c[0];
            var y = c[1];

            graphics.putPixel(x, y, fillColor);

            if (!(graphics.getPixel(x-1, y).equals(boundaryColor))
                    && !(graphics.getPixel(x-1,y).equals(fillColor))) {
                stack.push(new int[] {x-1,y});
            }

            if (!(graphics.getPixel(x+1, y).equals(boundaryColor))
                    && !(graphics.getPixel(x+1,y).equals(fillColor))) {
                stack.push(new int[] {x+1,y});
            }

            if (!(graphics.getPixel(x, y+1).equals(boundaryColor))
                    && !(graphics.getPixel(x,y+1).equals(fillColor))) {
                stack.push(new int[] {x,y+1});
            }


            if (!(graphics.getPixel(x, y-1).equals(boundaryColor))
                    && !(graphics.getPixel(x,y-1).equals(fillColor))) {
                stack.push(new int[] {x,y-1});
            }

        }

    }
}