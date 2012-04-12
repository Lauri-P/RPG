
/**
 * Tulkki esineiden ominaisuuksien toteuttamiseen
 * @author Lauri
 */
public class EsineTulkki {

    Hahmo kohde;

    /**
     * Metodi toteuttaa parametrinä annetun ominaisuuden kohdehahmolle
     * @param ominaisuus Toteutettava ominaisuus
     */
    private void toteuta(String ominaisuus) {
        String[] toteutettava = ominaisuus.split(":");

        if (toteutettava[0].equalsIgnoreCase("STR")) {
            kohde.addStr(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("VIT")) {
            kohde.addVit(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("LCK")) {
            kohde.addLck(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("INTL")) {
            kohde.addIntl(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("HP")) {
            kohde.addHP(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("MP")) {
            kohde.addMP(Integer.parseInt(toteutettava[1]));
        }

        //Maksimien muutos ei seuraa helposti pelaajan metodin paivitaMaximit() mukana
//        else if (toteutettava[0].equalsIgnoreCase("MAXHP")) {
//            kohde.addMaxHP(Integer.parseInt(toteutettava[1]));
//        } else if (toteutettava[0].equalsIgnoreCase("MAXMP")) {
//            kohde.addMaxMP(Integer.parseInt(toteutettava[1]));
//        }
    }

    /**
     * Vaihtaa parametrin ominaisuuden vaikutuksen käänteiseksi ja lähettää sen metodille toteuta
     * @param ominaisuus Peruttava ominaisuus
     */
    private void peru(String ominaisuus) {
        String[] peruttava = ominaisuus.split(":");
        toteuta(peruttava[0] + ":" + (-(Integer.parseInt(peruttava[1]))));
    }

    /**
     * Konstruktorille annetaan kohteeksi hahmo, johon esineiden ominaisuuksien halutaan vaikuttavan
     * @param kohde Esineitten omiaisuuksien kohde
     */
    public EsineTulkki(Hahmo kohde) {
        this.kohde = kohde;
    }

    /**
     * Asettaa parametrina annetun hahmon EsineTulkin uudeksi kohteeksi
     * @param kohde Uusi kohde
     */
    public void setHahmo(Hahmo kohde) {
        this.kohde = kohde;
    }

    /**
     * Palauttaa EsineTulkin kohteena olevan hahmon
     * @return Kohteena oleva hahmo
     */
    public Hahmo getHahmo() {
        return kohde;
    }

    /**
     * Lukee esineen ominaisuudet ja toteuttaa ne kohteelle. Esineen tulee olla nautittava ja nauttimaton. Muuttaa esineen consumed totuusarvoksi true
     * @param esine Nautittava esine
     */
    public void consume(Esine esine) {
        if (esine.getConsumable() && !esine.getConsumed()) {
            String[] ominaisuudet = esine.getOminaisuudet().split(",");
            for (int i = 0; i < ominaisuudet.length; i++) {
                toteuta(ominaisuudet[i]);
            }
            esine.setConsumed(true);
        }
    }

    /**
     * Lukee esineen ominaisuudet ja toteuttaa ne kohteelle. Esineen tulee olla varustettava ja varustamaton. Muuttaa esineen equiped totuusarvoksi true 
     * @param esine Varustettava esine
     */
    public void equip(Esine esine) {
        if (esine.getEquipable() && !esine.getEquiped()) {
            String[] ominaisuudet = esine.getOminaisuudet().split(",");
            for (int i = 0; i < ominaisuudet.length; i++) {
                toteuta(ominaisuudet[i]);
            }
            esine.setEquiped(true);
        }
    }

    /**
     * Poistaa parametrin esineen käytöstä. Lukee esineen ominaisuudet ja kumoaa ne. Esineen tulee olla varustettava ja varustettu. Muuttaa esineen equiped totuusarvoksi false 
     * @param esine käytöstä poistettava esine
     */
    public void unEquip(Esine esine) {
        if (esine.getEquipable() && esine.getEquiped()) {
            String[] ominaisuudet = esine.getOminaisuudet().split(",");
            for (int i = 0; i < ominaisuudet.length; i++) {
                peru(ominaisuudet[i]);
            }
            esine.setEquiped(false);
        }
    }
}
