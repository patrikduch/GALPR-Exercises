package galpr.rasterization;

import galpr.G_Color;
import galpr.G_Graphics;

import java.util.ArrayList;
import java.util.List;

public class Square {

    private int[][] vertices;
    private int[][] edges;

    public int[][] getVertices() {
        return vertices;
    }

    public Square() {
        vertices = new int[4][2];
        edges = new int[4][2];
    }

    public void setVertices(int[] xVertices, int[] yVertices) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                this.vertices[i][j] = xVertices[i];
                this.vertices[i][1] = yVertices[i];
            }
        }

    }

    /*  Set indexes*/
    public void setEdges() {

        this.edges[0][0] = 0;
        this.edges[0][1] = 1;

        this.edges[1][0] = 1;
        this.edges[1][1] = 2;

        this.edges[2][0] = 2;
        this.edges[2][1] = 3;

        this.edges[3][0] = 3;
        this.edges[3][1] = 1;


    }

    public void rasterize(G_Color color, G_Graphics graphics) {

        DDA dda = new DDA();

        var counterX = 0;
        var counterY = 0;

        var xArray = new int[2];
        var yArray = new int[2];

        // Get first two indexes
        for (int i = 0; i < 4; i++) {

            for(int j = 0; j<2; j++) {

                //System.out.println(edges[i][j]);

                var x1 =edges[i][j];

                //System.out.println(x1);

                if(j%2 == 0 && counterX < 2) {
                    //System.out.println(vertices[x1][j]);

                    xArray[counterX] = vertices[x1][j];
                    counterX++;
                }

                if(j%2 ==1 && counterY <2) {
                    System.out.println(vertices[x1][j]);

                    // Assign y values
                    yArray[counterY] = vertices[x1][j];

                    counterY++;
                }

                if(counterX == 2 && counterY == 2) {
                    counterX = 0;
                    counterY = 0;
                }




                dda.renderline(xArray[0], xArray[1], yArray[0], yArray[1], G_Color.G_cBlack, graphics);








            }
        }
    }


    //dda.renderline(firstVertex, secondVertex, yFirstVertex,ySecondVertex, color,graphics);

}
