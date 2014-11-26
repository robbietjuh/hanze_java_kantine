package net.robbytu.hanze.kantine;


import java.util.ArrayList;

/**
 * Created by Dylan on 26-11-2014.
 */
public class Dienblad {
    private ArrayList<Artikel> artikelen;
    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new ArrayList<Artikel>();
    }

    /**
     * Adds new artikel to the Dienblad
     * @param artikel What artikel to add
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaalprijs = 0;
        for(Artikel artikel : artikelen)
        {
            totaalprijs += artikel.getPrijs();
        }
        return totaalprijs;
    }
}