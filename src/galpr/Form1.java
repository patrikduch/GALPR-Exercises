package galpr;

import galpr.rasterization.algorithms.Bezier;
import galpr.rasterization.shapes.Square;
import galpr.rasterization.transformations.Translation;
import galpr.transformations.GUtils;
import galpr.transformations.G_Tools;

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

        // Transformations
        Square square = new Square(new int[] {20,60, 60, 20}, new int[] {20,20, 60, 60});
        square.render(graphic);

        // Translation
        var result = Translation.reCalculate(square.getVertices(), 40, 0);
        square.setVertices(result);
        square.render(graphic);

        // Scalling
        result = G_Tools.multiplyMatrices(new int[][] {{0,2, 0, 0}, {2,0,0,0}}, result);
        square.setVertices(result);
        square.render(graphic);

        // Rotation


        Bezier bezier = new Bezier();

        bezier.bezier(graphic);



        //square.setVertices(result);
        //square.render(graphic);

        //Square squaretwo = new Square(new int[] {40,80, 80, 40}, new int[] {40,40, 80, 80});
        //squaretwo.render(graphic);

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