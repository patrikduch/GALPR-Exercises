package galpr;

/**
 * Rozhraní obsahující abstraktní metody pro stištění a uvolnění tlačítka.
 *
 * @author Pavel Vlašánek
 */
public interface G_Controls {

    /**
     * Abstraktní metoda pro stištění tlačítka.
     *
     * @param button Proměnná s informací, které tlačítko myši bylo zmáčknuto
     * (levé, pravé nebo žádné).
     * @param x Souřadnice x pozice, na které došlo k zmáčknutí tlačítka myši.
     * @param y Souřadnice y pozice, na které došlo k zmáčknutí tlačítka myši.
     */
    public void G_mousePressed(G_Button button, int x, int y);

    /**
     * Abstraktní metoda pro uvolnění tlačítka.
     *
     * @param button Proměnná s informací, které tlačítko myši bylo uvolněno
     * (levé, pravé nebo žádné).
     * @param x Souřadnice x pozice, na které došlo k uvolnění tlačítka myši.
     * @param y Souřadnice y pozice, na které došlo k uvolnění tlačítka myši.
     */
    public void G_mouseReleased(G_Button button, int x, int y);

    /**
     * Abstraktní metoda pro zmáčknutí tlačítka.
     *
     * @param c Klávesa, která byla zmáčknuta.
     */
    public void G_keyPressed(char c);
}
