package RPG;

import javax.swing.ImageIcon;


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

    /**
     * Palauttaa polun kuvaan, joka vastaa huoneen näkymää tulosuunnasta katsottuna
     * @param mista Suuntaa, josta huoneeseen saavutaan, vastaava numero. Pohjoinen=1, Itä=2; Etelä=3 ja Länsi=4. Pelin aloitushuoneeseen ei saavuta mistään ja tätä vastaa luku 0. Pelaaja katsoo tällöin pohjoiseen
     * @return Polku näkymää vastaavaan kuvaan
     */
    public String getKuva(int mista){
        String polku="";
        String huoneet="";
        huoneet=etsiOvet(mista, huoneet);
        if (huoneet.length()==3){
            polku="Kuvat\\Huone3.png";
        }
        if(huoneet.length()==0){
            polku="Kuvat\\Huone0.png;";
        }
        if(huoneet.length()==2){
            if(huoneet.indexOf('1')<0){
                polku="Kuvat\\Huone2v.png;";
            }
            else if(huoneet.indexOf('2')<0){
                polku="Kuvat\\Huone2k.png;";
            }
            else{
                polku="Kuvat\\Huone2o.png;";
            }
        }
        if(huoneet.length()==1){
            if(huoneet.indexOf('1')>-1){
                polku="Kuvat\\Huone1v.png;";
            }
            else if(huoneet.indexOf('2')>-1){
                polku="Kuvat\\Huone1k.png;";
            }
            else{
                polku="Kuvat\\Huone1o.png;";
            }
        }
        return polku;
    }

    private String etsiOvet(int mista, String huoneet) {
        if(mista==3||mista==0){
            if(getLansi()!=null){
                huoneet=huoneet+"1";
            }
            if(getPohjoinen()!=null){
                huoneet=huoneet+"2";
            }
            if(getIta()!=null){
                huoneet=huoneet+"3";
            }
        }
        if(mista==4){
            if(getPohjoinen()!=null){
                huoneet=huoneet+"1";
            }
            if(getIta()!=null){
                huoneet=huoneet+"2";
            }
            if(getEtela()!=null){
                huoneet=huoneet+"3";
            }
        }
        if(mista==1){
            if(getIta()!=null){
                huoneet=huoneet+"1";
            }
            if(getEtela()!=null){
                huoneet=huoneet+"2";
            }
            if(getLansi()!=null){
                huoneet=huoneet+"3";
            }
        }
        if(mista==2){
            if(getEtela()!=null){
                huoneet=huoneet+"1";
            }
            if(getLansi()!=null){
                huoneet=huoneet+"2";
            }
            if(getPohjoinen()!=null){
                huoneet=huoneet+"3";
            }
        }
        return huoneet;
    }

}
