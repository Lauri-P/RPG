package RPG;


/**
 * Pelin luolasto koostuu huoneista, joissa voi olla vihollisia ja arkkuja, sekä ovia viereisiin huoneisiin
 * @author Lauri
 */
public class Huone {

    boolean bossi;
    boolean kauppa;
    Arkku arkku;
    Vihollinen vihollinen;
    Huone pohjoinen;
    Huone ita;
    Huone etela;
    Huone lansi;

    /**
     * Konstruktori tyhjälle, ovettomalle huoneelle
     */
    public Huone() {
        bossi = false;
        kauppa = false;
        arkku = null;
        vihollinen = null;
        pohjoinen = null;
        ita = null;
        lansi = null;
        etela = null;
    }

    /**
     *
     * @return Palauttaa totuusarvon siitä, että onko huone bossivihollisen olinpaikka
     */
    public boolean getBossi() {
        return bossi;
    }

    /**
     * 
     * @return Palauttaa totuusarvon siitä, että onko huone kauppa
     */
    public boolean getKauppa() {
        return kauppa;
    }

    /**
     * 
     * @return Palauttaa huoneen arkun
     */
    public Arkku getArkku() {
        return arkku;
    }

    /**
     * 
     * @return Palauttaa huoneen vihollisen
     */
    public Vihollinen getVihollinen() {
        return vihollinen;
    }

    /**
     * 
     * @return Palauttaa huoneen pohjoisoven takaisen huoneen
     */
    public Huone getPohjoinen() {
        return pohjoinen;
    }

    /**
     * 
     * @return Palauttaa huoneen itäoven takaisen huoneen
     */
    public Huone getIta() {
        return ita;
    }

    /**
     * 
     * @return Palauttaa huoneen eteläoven takaisen huoneen
     */
    public Huone getEtela() {
        return etela;
    }

    /**
     * 
     * @return Palauttaa huoneen länsioven takaisen huoneen
     */
    public Huone getLansi() {
        return lansi;
    }

    /**
     * Asettaa parametrina annetun totuusarvon huoneen bossipitoisuuden arvoksi
     * @param onko Totuusarvo siitä, onko huoneessa bossi
     */
    public void setBossi(boolean onko) {
        bossi = onko;
    }

    /**
     * Asettaa parametrina annetun totuusarvon huoneen kauppaominaisuuden arvoksi
     * @param onko Totuusarvo siitä, onko huone kauppa
     */
    public void setKauppa(boolean onko) {
        kauppa = onko;
    }

    /**
     * Asettaa parametrin vihollisen huoneen viholliseksi
     * @param vihu Huoneeseen asetettava vihollinen
     */
    public void setVihollinen(Vihollinen vihu) {
        vihollinen = vihu;
    }

    /**
     * Asettaa parametrin arkun huoneen arkuksi
     * @param loota Huoneeseen asetettava arkku
     */
    public void setArkku(Arkku loota) {
        arkku = loota;
    }

    /**
     * Asettaa parametrin huoneen löytymään tämän huoneen pohjoisoven takaa
     * @param huone Pohjoisesta löytyvä huone
     */
    public void setPohjoinen(Huone huone) {
        pohjoinen = huone;
    }

    /**
     * Asettaa parametrin huoneen löytymään tämän huoneen itäoven takaa
     * @param huone Idästä löytyvä huone
     */
    public void setIta(Huone huone) {
        ita = huone;
    }

    /**
     * Asettaa parametrin huoneen löytymään tämän huoneen eteläoven takaa
     * @param huone Etelästä löytyvä huone
     */
    public void setEtela(Huone huone) {
        etela = huone;
    }

    /**
     * Asettaa parametrin huoneen löytymään tämän huoneen länsioven takaa
     * @param huone Lännestä löytyvä huone
     */
    public void setLansi(Huone huone) {
        lansi = huone;
    }
}
