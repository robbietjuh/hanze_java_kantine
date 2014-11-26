package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 26-11-2014.
 */
public class KassaRij {

    /**
     * Constructor
     */
    public KassaRij() {
    }
    /**
    * Persoon sluit achter in de rij aan
    * @param persoon current persoon
    */
    public void sluitAchteraan(Persoon persoon) {
    }
    /**
     * Indien er een rij bestaat, de eerste Persoon uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     * @return Eerste persoon in de rij of null
     */
    public Persoon eerstePersoonInRij() {
        Persoon EerstePersoon = new Persoon();
        return EerstePersoon;
    }
    /**
     * Methode kijkt of er personen in de rij staan.
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return true;
    }
}
