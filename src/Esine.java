
/**
 * Esineillä on hahmon statseihin vaikuttavia ominaisuuksia
 * @author Lauri
 */
public class Esine {
    
    boolean equipable;
    boolean equiped;
    boolean consumable;
    boolean consumed;
    String nimi;
    String ominaisuudet;
    String kuvaus;

    /**
     * Konstruktori "Tyhjälle" esineelle jolla ei ole ominaisuuksia
     */
    public Esine() {

        equipable = false;
        equiped = false;
        consumable = false;
        consumed = false;
        nimi = "EI NIMEÄ";
        ominaisuudet = "";
        kuvaus = "EI KUVAUSTA";

    }

    /**
     * Konstruktori esineelle, jolla nimi ja ominaisuudet ja tieto käyttötavoista
     * @param nimi Esineen nimi.
     * @param ominaisuudet Esineen ominaisuudet. Ominaisuudet kirjataan muodossa "STA1:INT1,STA2:INT2,...,STAi:INTi", jossa STAi on status, johon halutaan vaikuttaa ja INTi on vaikutuksen suuruus. Esim "STR:3,HP:-6" lisää voimaa kolmella ja vähentä HP:itä kuudella
     * @param equipable Totuusarvo siitä, voiko esinettä käyttää varusteena
     * @param consumable Totuusarvo siitä, voiko esineen nauttia
     */
    public Esine(String nimi, String ominaisuudet, boolean equipable, boolean consumable) {

        this.equipable = equipable;
        equiped = false;
        this.consumable = consumable;
        consumed = false;
        this.nimi = nimi;
        this.ominaisuudet = ominaisuudet;
        kuvaus = "EI KUVAUSTA";
    }

    /**
     * Konstruktori esineelle, jolla nimi, ominaisuudet ja kuvaus ja tieto käyttötavoista
     * @param nimi Esineen nimi.
     * @param ominaisuudet Esineen ominaisuudet. Ominaisuudet kirjataan muodossa "STA1:INT1,STA2:INT2,...,STAi:INTi", jossa STAi on status, johon halutaan vaikuttaa ja INTi on vaikutuksen suuruus. Esim "STR:3,HP:-6" lisää voimaa kolmella ja vähentä HP:itä kuudella
     * @param kuvaus Vapaamuotoinen kuvaus esineen ominaisuuksista
     * @param equipable Totuusarvo siitä, voiko esinettä käyttää varusteena
     * @param consumable Totuusarvo siitä, voiko esineen nauttia
     */
    public Esine(String nimi, String ominaisuudet, String kuvaus, boolean equipable, boolean consumable) {
        this.equipable = equipable;
        equiped = false;
        this.consumable = consumable;
        consumed = false;
        this.nimi = nimi;
        this.ominaisuudet = ominaisuudet;
        this.kuvaus = kuvaus;
    }

    /**
     * 
     * @return Palauttaa esineen nimen
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * 
     * @return Palauttaa esineen ominaisuudet
     */
    public String getOminaisuudet() {
        return ominaisuudet;
    }

    /**
     * 
     * @return Palauttaa esineen kuvauksen
     */
    public String getKuvaus() {
        return kuvaus;
    }

    /**
     * 
     * @return Palauttaa totuusarvon siitä, voiko esineen nauttia
     */
    public boolean getConsumable() {
        return consumable;
    }

    /**
     * 
     * @return Palauttaa totuusarvon siitä, onko esine jo nautittu
     */
    public boolean getConsumed() {
        return consumed;
    }

    /**
     * 
     * @return Palauttaa totuusarvon siitä, että voiko esinettä käyttää varusteena
     */
    public boolean getEquipable() {
        return equipable;
    }

    /**
     * 
     * @return Palauttaa totuusarvon siitä, onko esine jo käytössä
     */
    public boolean getEquiped() {
        return equiped;
    }

    /**
     * Metodi vaihtaa esineen nimen parametrissa annettuun
     * @param nimi Esineen uusi nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Metodi vaihtaa esineen ominaisuudet parametrissa annettuihin
     * @param ominaisuudet Esineen uudet ominaisuudet
     */
    public void setOminaisuudet(String ominaisuudet) {
        this.ominaisuudet = ominaisuudet;
    }

    /**
     * Metodi vaihtaa esineen kuvauksen parametrissa annettuun
     * @param kuvaus Esineen uusi kuvaus
     */
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    /**
     * Metodi vaihtaa esineen consumable-totuusarvon parametrissa annettuun
     * @param consumable Uusi totuusarvo
     */
    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    /**
     * Metodi vaihtaa esineen consumed-totuusarvon parametrissa annettuun
     * @param consumed uusi totuusarvo
     */
    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    /**
     * Metodi vaihtaa esineen equipable-totuusarvon parametrissa annettuun
     * @param equipable Uusi totuusarvo
     */
    public void setEquipable(boolean equipable) {
        this.equipable = equipable;
    }

    /**
     * Metodi vaihtaa esineen equiped-totuusarvon parametrissa annettuun
     * @param equiped Uusi totuusarvo
     */
    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }
}
