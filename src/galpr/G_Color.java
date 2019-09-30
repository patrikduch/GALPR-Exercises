package galpr;

/**
 * Třída reprezentující barvu.
 *
 * @author Pavel Vlašánek
 */
public class G_Color {

    /**
     * Statická proměnná reprezentující černou barvu.
     *
     */
    public static G_Color G_cBlack = new G_Color(0, 0, 0);

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
