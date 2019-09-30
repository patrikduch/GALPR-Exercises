package galpr;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Třída reprezentující plátno.
 *
 * @author Pavel Vlašánek
 */
public class MyCanvas extends java.awt.Canvas {

    private static final long serialVersionUID = 1L;
    private BufferedImage bitmap;

    /**
     * Parametrický konstruktor.
     *
     * @param b Obraz, který se bude vykreslovat na plátno.
     */
    MyCanvas(BufferedImage b) {
        bitmap = b;
    }

    @Override
    public void paint(Graphics g) {
        bitmap.flush();
        g.drawImage(bitmap, 0, 0, this);
    }
}
