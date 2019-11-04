package galpr.rasterization.shapes;
import galpr.G_Graphics;
import galpr.rasterization.algorithms.DDA;

public class Square {

    private int[][] vertices;
    private int[][] edges;

    private void verticesInit(int[] xVertices, int []yVertices) {
        // Creation of square shape
        for (int i = 0; i< xVertices.length; i++) {
            vertices[0][i] = xVertices[i];
        }

        for (int i = 0; i< yVertices.length; i++) {
            vertices[1][i] = yVertices[i];
        }
    }

    public Square(int[] xVertices, int[] yVertices) {

        // Vertices allocation
        vertices = new int[2][xVertices.length];

        // Edges allocation and initialization
        edges = new int[][] {{0,1}, {2,3}, {1,2}, {3,0}};

        // Setup of all vertices
        verticesInit(xVertices, yVertices);
    }

    // Render of Square object
    public void render(G_Graphics graphics) {
        for(int j = 0; j<edges.length; j++) {
            var startIndex = edges[j][0];
            var endIndex = edges[j][1];

            var x1 = this.vertices[0][startIndex];
            var x2 = this.vertices[0][endIndex];

            var y1 = this.vertices[1][startIndex];
            var y2 = this.vertices[1][endIndex];

            DDA.render(x1, x2, y1, y2, graphics);
        }
    }
}
