package RPG;


import java.util.ArrayList;

/**
 * Hahmon aliluokka, jossa on viholliseen liittyviä lisämuuttujia
 * @author Lauri
 */
public class Vihollinen extends Hahmo {

    private ArrayList<String> weakness;
    private String nimi;

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä viholliseen liittyvät konstruktiot
     */
    public Vihollinen() {
        super();
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä viholliseen liittyvät konstruktiot
     * @param str Voiman arvo
     */
    public Vihollinen(int str) {
        super(str);
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä viholliseen liittyvät konstruktiot
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     */
    public Vihollinen(int str, int vit) {
        super(str, vit);
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä viholliseen liittyvät konstruktiot
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     * @param lck Onnen arvo
     */
    public Vihollinen(int str, int vit, int lck) {
        super(str, vit, lck);
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä viholliseen liittyvät konstruktiot
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     * @param lck Onnen arvo
     * @param intl Älyn arvo
     */
    public Vihollinen(int str, int vit, int lck, int intl) {
        super(str, vit, lck, intl);
        luo();
    }

    private void luo() {
        maxHP = getStr() + 2 * getVit();
        maxMP = 2 * getIntl();
        hp = maxHP;
        mp = maxMP;
        nimi="Anonymous";
        weakness = new ArrayList<String>();
    }

    /**
     * 
     * @return Palauttaa listan vihollisen heikkouksista
     */
    public ArrayList<String> getWeak() {
        return weakness;
    }

    /**
     * Asettaa vihollisen heikkouksiksi parametrin arvon
     * @param heikkoudet Uudet heikkoudet
     */
    public void setWeak(ArrayList<String> heikkoudet) {
        weakness = heikkoudet;
    }

    /**
     * Lisää vihollisen heikkouksiin annetun parametrin
     * @param heikkous Lisättävä heikkous
     */
    public void addWeak(String heikkous) {
        weakness.add(heikkous);
    }
    
    /**
     * 
     * @return Palautta vihollisen nimen
     */
    public String getNimi(){
        return nimi;
    }
    
    /**
     * Asettaa vihollisen nimeksi paramertin arvon
     * @param nimi Uusi nimi
     */
    public void setNimi(String nimi){
        this.nimi=nimi;
    }
}
