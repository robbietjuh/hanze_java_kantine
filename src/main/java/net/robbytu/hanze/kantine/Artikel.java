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

}
