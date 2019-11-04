package galpr;

import galpr.rasterization.shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Třída reprezentující okno.
 *
 * @author Pavel Vlašánek
 */
public final class Form1 extends javax.swing.JFrame implements G_Controls {

    private static final long serialVersionUID = 1L;

    private G_Graphics graphic;
    private MyCanvas canvas;
    private BufferedImage image;

    /**
     * Bezparametrický Konstruktor.
     */
    public Form1() {
        super();
        init();
        G_draw();

    }

    /**
     * Obsahuje kód který se provede v rámci konstruktoru. Zde studenti volají
     * své vlastní metody (vykreslení úsečky atp.).
     */
    public void G_draw() {
        graphic.clear();


        //DDA dda = new DDA();
        //Square square = new Square();


        //DDA.renderTest(0, 190, 20, 20, graphic);





        //int[] xVertices = new int[]{4,100,4,100};
        //int[] yVertices = new int[] {0, 0, 40, 40};



        //square.setVertices(xVertices, yVertices);
        //square.setEdges();


       // square.rasterize(G_cBlack, graphic);


        /*

        double mat[][] = { { 1.4, 2.4, 3.6},
                { 5.2, 6.3, 7.4},
                { 9.6, 10.3, 11.5 } };

        double mat2[][] = { { 1.4, 2.4, 3.6 },
                { 5.2, 6.3, 7.4},
                { 9.6, 10.3, 11.5  } };
       */

        //GUtils.isMatrixsEqual(mat, mat2);
        //double a[][]={{1.2,1.4,1.8},{2.4,2.8,2.3},{3.2,3.4,3.3}};
        //double b[][]={{1.7,1.4,1.6},{2.5,2.5,2.5},{3.7,3.7,3.7}};

        //var resultMatrix = GUtils.matrixMultiplication(a,b);



        //graphic.dda(0, 45, 120, 45);//horizontal
        //graphic.dda(45, 0, 45, 120);//vertical
/*
        int xs = 0;
        int ys = 0;
        for(int y = 560; y >= 0; y -= 20)
        {
            System.out.println("y: " + y);
            graphic.dda(xs, ys, 500, y);
        }*/

        /*

        int [][] arr = {
                {20, 80, 80, 20},
                {20, 20, 80, 80},
        };
/*
        int [][] arr = {
                {20, 80, 80, 20},
                {20, 20, 120, 120},
        };*/

        /*

        int [][] hArr = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}};

        Square sqr = new Square(arr, hArr);
        graphic.drawSquare(sqr);
        System.out.println(sqr);
        */

        /*
            Vertices array first row x vertices second row y vertices
        */
        int[][] vertices = new int[][] {
                {20,80,80,20},
                {20,20,120,120}
        };


        //Square square = new Square(vertices);

        //square.rasterize(graphic);


        Square square = new Square(new int[] {20,60, 60, 20}, new int[] {20,20, 60, 60});
        square.render(graphic);









    }

    /**
     * Kód této metody se provede při stisknutí tlačítka myši (pouze při jeho
     * stisknutí, nikoliv při jeho uvolnění!).
     *
     * @param button Proměnná s informací, které tlačítko myši bylo zmáčknuto
     *               (levé, pravé nebo žádné).
     * @param x      Souřadnice x pozice, na které došlo k zmáčknutí tlačítka myši.
     * @param y      Souřadnice y pozice, na které došlo k zmáčknutí tlačítka myši.
     */
    @Override
    public void G_mousePressed(G_Button button, int x, int y) {

    }

    /**
     * Kód této metody se provede při uvolnění tlačítka myši (pouze při jeho
     * uvolnění, nikoliv při jeho stisknutí!).
     *
     * @param button Proměnná s informací, které tlačítko myši bylo uvolněno
     *               (levé, pravé nebo žádné).
     * @param x      Souřadnice x pozice, na které došlo k uvolnění tlačítka myši.
     * @param y      Souřadnice y pozice, na které došlo k uvolnění tlačítka myši.
     */
    @Override
    public void G_mouseReleased(G_Button button, int x, int y) {

    }

    /**
     * Kód této metody se provede při stisknutí znaku na klávesnici.
     *
     * @param c Znak klávesy, která byla zmáčknuta.
     */
    @Override
    public void G_keyPressed(char c) {

    }

    /**
     * Překreslení kreslící plochy (proměnná canvas). Obraz, kterým je kreslící
     * plocha překreslena, je udržován v třídní proměnné image.
     */
    public void G_repaint() {
        canvas.repaint();
    }

    //Inicializace třídních proměnných a nastavení samotného okna. Studenti do této metody nemusí zasahovat.
    private void init() {
        // JFrame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Framework GALPR");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        // BufferedImage
        image = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_RGB);

        // graphic
        graphic = new G_Graphics(image);

        // canvas
        canvas = new MyCanvas(image);
        canvas.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height));

        // content
        getContentPane().add(canvas, java.awt.BorderLayout.CENTER);

        // mouse listener
        canvas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                G_Button button = G_Button.B_NONE;

                if (evt.getButton() == MouseEvent.BUTTON1) {
                    button = G_Button.B_LEFT;
                }
                if (evt.getButton() == MouseEvent.BUTTON2) {
                    button = G_Button.B_RIGHT;
                }

                G_mousePressed(button, evt.getX(), evt.getY());
            }

            public void mouseReleased(MouseEvent evt) {
                G_Button button = G_Button.B_NONE;

                if (evt.getButton() == MouseEvent.BUTTON1) {
                    button = G_Button.B_LEFT;
                }
                if (evt.getButton() == MouseEvent.BUTTON2) {
                    button = G_Button.B_RIGHT;
                }

                G_mouseReleased(button, evt.getX(), evt.getY());
            }
        });

        canvas.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                G_keyPressed(e.getKeyChar());
            }

        });

        pack();
    }
}