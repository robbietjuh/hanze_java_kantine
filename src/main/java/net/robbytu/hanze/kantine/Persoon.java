package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */


/**
 * Persoon
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 18-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class Persoon {

    int BSN;
    String voornaam;
    String achternaam;
    int dag;
    int maand;
    int jaar;
    char geslacht;
    Dienblad dienblad;



    /**
     * Initializes a new instance of the Persoon class
     * without any par
     */
    public Persoon()
    {
        this.setGeslacht('O');
        this.setGeboortedatum(0, 0, 0);
    }



    /**
     * Initializes a new instance of the Persoon class
     * @param BSN BSN
     * @param voornaam Voornaam
     * @param achternaam Achternaam
     * @param dag Dag
     * @param maand Maand
     * @param jaar Jaar
     * @param geslacht Geslacht
     */
    public Persoon(int BSN, String voornaam, String achternaam, int dag, int maand, int jaar, char geslacht) {
        this.setBSN(BSN);
        this.setVoornaam(voornaam);
        this.setAchternaam(achternaam);
        this.setGeboortedatum(dag, maand, jaar);
        this.setGeslacht(geslacht);
    }

    /**
     * Sets the BSN
     * @param BSN BSN
     */
    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    /**
     * Sets the first name
     * @param voornaam Voornaam
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * Sets the last name
     * @param achternaam Achternaam
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * Checks wether the birthdate is valid
     * @param dag The day, should be between 01 and 31
     * @param maand The month, should be between 01 and 12
     * @param jaar The year, should be between 1900 and 2100
     * @return Wether the birthdate is valid
     */
    private boolean checkGeboortedatum(int dag, int maand, int jaar) {
        int[] dagen = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if(jaar < 1900 || jaar > 2100) return false;
        if(maand < 1 || maand > 12) return false;
        if(((jaar % 4 == 0 && jaar % 100 != 0) || jaar % 400 == 0) && maand == 2 && dag == 29) return  true;
        if(dag < 1 || dag > dagen[maand - 1]) return false;
        if(((jaar % 100 == 0) && jaar % 400 != 0)) return false;
        return true;
    }

    /**
     * Sets the birthdate
     * @param dag The day, should be between 01 and 31
     * @param maand The month, should be between 01 and 12
     * @param jaar The year, should be between 1900 and 2100
     */
    public void setGeboortedatum(int dag, int maand, int jaar) {
        boolean isValid = this.checkGeboortedatum(dag, maand, jaar);

        this.dag = (isValid) ? dag : 0;
        this.maand = (isValid) ? maand : 0;
        this.jaar = (isValid) ? jaar : 0;
    }

    /**
     * Sets the gender.
     * @param geslacht Gender. Should be one of 'M' or 'V'
     */
    public void setGeslacht(char geslacht) {
        this.geslacht = (geslacht == 'M' || geslacht == 'V') ? geslacht : 'N';
    }

    /**
     * Returns the BSN
     * @return BSN
     */
    public int getBSN() {
        return this.BSN;
    }

    /**
     * Returns the first name
     * @return Voornaam
     */
    public String getVoornaam() {
        return this.voornaam;
    }

    /**
     * Returns the last name
     * @return Achternaam
     */
    public String getAchternaam() {
        return this.achternaam;
    }

    /**
     * Returns a formatted birthdate
     * @return Geboortedatum
     */
    public String getGeboortedatum() {
        String formattedGeboortedatum = "Onbekend";
        if(dag != 0 && maand != 0 && jaar != 0) formattedGeboortedatum = dag + "/" + maand + "/" + jaar;

        return formattedGeboortedatum;
    }

    /**
     * Returns the gender
     * @return Geslacht (M/V)
     */
    public String getGeslacht() {
        if(this.geslacht == 'M') return "Man";
        else if(this.geslacht == 'V') return "Vrouw";
        else return "Onbekend";
    }

    /**
     * Prints details about this person into stdout
     */
    public void drukAf() {
        System.out.println("Details over persoon met BSN " + this.getBSN() + ": ");
        System.out.println(" * Voornaam:      " + this.getVoornaam());
        System.out.println(" * Achternaam:    " + this.getAchternaam());
        System.out.println(" * Geboortedatum: " + this.getGeboortedatum());
        System.out.println(" * Geslacht:      " + this.getGeslacht());
    }

    /**
     * Add a Dienblad to persoon
     * @param dienblad A dienblad
     */
    public void pakDienblad(Dienblad dienblad){if(this.dienblad == null){this.dienblad = dienblad;}}

    /**
     * Add artikel to dienblad
     * @param artikel What artikel to add
     */
    public void pakArtikel(Artikel artikel){if(dienblad != null){dienblad.voegToe(artikel);}}

    /**
     * returns totaalprijs
     * @return de totaalprijs
     */
    public double getTotaalPrijs(){if(dienblad != null){return dienblad.getTotaalPrijs();}return 0;}

    /**
     * returns amount of artikelen
     * @return
     */
    public int getAantalArtikelen(){if(dienblad != null){return dienblad.getAantalArtikelen();}return 0;}
}
