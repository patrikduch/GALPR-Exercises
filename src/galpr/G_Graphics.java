package galpr;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Třída pro kreslení do obrazu.
 *
 * @author Pavel Vlašánek
 */
public class G_Graphics {

    private BufferedImage bitmap;
    private Graphics2D g;

    /**
     * Parametrický konstruktor.
     *
     * @param b Obraz do kterého bude třída kreslit.
     */
    public G_Graphics(BufferedImage b) {
        bitmap = b;
        g = bitmap.createGraphics();
    }

    /**
     * Vybarví pixel na daných souřadnicích danou barvou.
     *
     * @param x Souřadnice x pozice vybarvovaného pixelu.
     * @param y Souřadnice y pozice vybarvovaného pixelu.
     * @param color Barva jenž je pixel vybarven.
     */
    public void putPixel(int x, int y, G_Color color) {
        Color color_help = new Color(color.r, color.g, color.b);

        bitmap.setRGB(x, y, color_help.getRGB());
    }

    /**
     * Vrací barvu pixelu na dané pozici.
     *
     * @param x Souřadnice x pozice pixelu.
     * @param y Souřadnice y pozice pixelu.
     * @return Barva pixelu na dané pozici.
     */
    public G_Color getPixel(int x, int y) {
        Color color_help = new Color(bitmap.getRGB(x, y));
        G_Color color = new G_Color();

        color.r = color_help.getRed();
        color.g = color_help.getGreen();
        color.b = color_help.getBlue();

        return color;
    }

    /**
     * Překreslení celého obrazu bílou barvou (tedy "vymazání" celého obrazu).
     *
     */
    public void clear() {
        g.setBackground(new Color(255, 255, 255));
        g.clearRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    /**
     * Zobrazí obraz načtený z zdroje.
     *
     * @param path Cesta k obrazu (např. cesta k souboru na disku).
     */
    public void showImage(String path) {
        try {
            BufferedImage bitmap_help = (BufferedImage) ImageIO.read(new File(path));
            g.drawImage(bitmap_help, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
