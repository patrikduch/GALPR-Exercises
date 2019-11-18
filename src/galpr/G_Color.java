package galpr;

import java.util.Objects;

/**
 * Třída reprezentující barvu.
 *
 * @author Pavel Vlašánek
 */
public class G_Color {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        G_Color g_color = (G_Color) o;
        return r == g_color.r &&
                g == g_color.g &&
                b == g_color.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }

    public static G_Color getG_cBlack() {
        return G_cBlack;
    }

    public static void setG_cBlack(G_Color g_cBlack) {
        G_cBlack = g_cBlack;
    }

    public static G_Color getG_cWhite() {
        return G_cWhite;
    }

    public static void setG_cWhite(G_Color g_cWhite) {
        G_cWhite = g_cWhite;
    }

    public static G_Color getG_cRed() {
        return G_cRed;
    }

    public static void setG_cRed(G_Color g_cRed) {
        G_cRed = g_cRed;
    }

    /**
     * Statická proměnná reprezentující černou barvu.
     *
     */
    public static G_Color G_cBlack = new G_Color(0, 0, 0);

    public static G_Color G_cWhite = new G_Color(255, 255, 255);

    public static G_Color G_cRed = new G_Color(255, 0, 0);

    /**
     * Červený kanál RGB barvy.
     *
     */
    public int r;

    /**
     * Zelený kanál RGB barvy.
     *
     */
    public int g;

    /**
     * Modrý kanál RGB barvy.
     *
     */
    public int b;

    /**
     * Bezparametrický Konstruktor.
     *
     */
    public G_Color() {
    }

    /**
     * Parametrický Konstruktor.
     *
     * @param rc Červený kanál RGB barvy.
     * @param gc Zelený kanál RGB barvy.
     * @param bc Modrý kanál RGB barvy.
     */
    public G_Color(int rc, int gc, int bc) {
        r = rc;
        g = gc;
        b = bc;
    }

}
