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

    /*
    public void horizontalLine(int x1, int x2, int y1, int y2) {

        //putPixel(x1, y1, color);
        for(int i = x1; i<= x2; i++) {

            putPixel(i, y1, G_Color.G_cBlack);
        }
    }*/

    public void horizontalLine(int xz, int yz, int xk, int yk)
    {
        if(xk < xz)
        {
            int tmp = xz;
            xz = xk;
            xk = tmp;

            tmp = yz;
            yz = yk;
            yk = tmp;
        }

        for(int i = xz; i <= xk; i++)
        {
            putPixel(i, yz, G_Color.G_cBlack);
        }
    }

    /*
    public void verticalLine(int x1, int x2, int y1, int y2) {

        //putPixel(x1, y1, color);
        for(int i = y1; i<= y2; i++) {

            putPixel(x1, i, G_Color.G_cBlack);
        }
    }*/

    public void verticalLine(int xz, int yz, int xk, int yk)
    {
        if(yk < yz)
        {
            int tmp = xz;
            xz = xk;
            xk = tmp;

            tmp = yz;
            yz = yk;
            yk = tmp;
        }

        for(int i = yz; i <= yk; i++)
        {
            putPixel(xz, i, G_Color.G_cBlack);
        }
    }








    public void dda(int xz, int yz, int xk, int yk) {

        int dx = xk - xz;
        int dy = yk - yz;

        //System.out.println("dx: " + dx);
        //System.out.println("dy: " + dy);

        if (dy == 0) {
            horizontalLine(xz, yz, xk, yk);
            return;
        }
        if (dx == 0) {
            verticalLine(xz, yz, xk, yk);
            return;
        }

        double a = (double) dy / dx;
        //System.out.println("Smernice: " + a);


        //System.out.println("xz: " + xz + " xk: " + xk + " yz: " + yz + " yk: " + yk);

        if (Math.abs(a) <= 1)//1.
        {
            if (xk < xz) {
                int tmp = xz;
                xz = xk;
                xk = tmp;

                tmp = yz;
                yz = yk;
                yk = tmp;
            }
            //System.out.println("xz: " + xz + " xk: " + xk + " yz: " + yz + " yk: " + yk);

            double y = yz;
            for (int x = xz; x <= xk; x++) {
                putPixel(x, (int) y, G_Color.G_cBlack);
                y += a;
            }
            return;
        }

        if (Math.abs(a) > 1)//2.
        {
            if (yk < yz) {
                int tmp = xz;
                xz = xk;
                xk = tmp;

                tmp = yz;
                yz = yk;
                yk = tmp;

                dx = xk - xz;
                dy = yk - yz;
            }
            a = (double) dx / dy;

            System.out.println("a: " + a);
            double x = xz;
            for (int y = yz; y <= yk; y++) {
                putPixel((int) x, y, G_Color.G_cBlack);
                x += a;
            }
            return;
        }
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