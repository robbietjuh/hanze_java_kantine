package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

/**
 * Artikel
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 18-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class Artikel {

    private String naam;
    private float prijs;

    /**
     * Initializes a new instance of the Artikel class
     * @param artikelNaam Name of the article
     * @param artikelPrijs Pricing of the article
     */
    public Artikel(String artikelNaam, float artikelPrijs) {
        this.naam = artikelNaam;
        this.prijs = artikelPrijs;
    }

    /**
     * Sets the name of article
     * @param naam Name of the article
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Sets the price of the article
     * @param prijs Price of the article
     */
    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    /**
     * Gets the article's name
     * @return Name of the article
     */
    public String getNaam() {
        return this.naam;
    }

    /**
     * Gets the article's price
     * @return Price of the article
     */
    public float getPrijs() {
        return this.prijs;
    }

    /**
     * Prints details about this article into stdout
     */
    public void drukAf() {
        System.out.println(String.format("Dit artikel heeft de naam '%s' meegekregen en kost € %.2f",
                                         this.getNaam(), this.getPrijs()));
    }
}
