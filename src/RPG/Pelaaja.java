package RPG;


import java.util.ArrayList;

/**
 * Hahmon aliluokka, jossa on pelaajaan liittyviä lisämuuttujia
 * @author Lauri
 */
public class Pelaaja extends Hahmo {

    int exp;
    int lvl;
    boolean maagi;
    Noppa d6;
    Arkku inventory;
    ArrayList<Taika> taiat;

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä pelaajaan liittyvät konstruktiot
     */
    public Pelaaja() {
        super();
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä pelaajaan liittyvät konstruktiot
     * @param str Voiman arvo
     */
    public Pelaaja(int str) {
        super(str);
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä pelaajaan liittyvät konstruktiot
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     */
    public Pelaaja(int str, int vit) {
        super(str, vit);
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä pelaajaan liittyvät konstruktiot
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     * @param lck Onnen arvo
     */
    public Pelaaja(int str, int vit, int lck) {
        super(str, vit, lck);
        luo();
    }

    /**
     * Kuten Hahmolla, mutta lopuksi suorittaa vielä pelaajaan liittyvät konstruktiot
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     * @param lck Onnen arvo
     * @param intl Älyn arvo
     */
    public Pelaaja(int str, int vit, int lck, int intl) {
        super(str, vit, lck, intl);
        luo();
    }

    private void luo() {
        inventory = new Arkku();
        paivitaMaximit();
        hp = maxHP;
        mp = maxMP;
        exp = 0;
        lvl = 1;
        maagi = getIntl() > 0;
        d6 = new Noppa();
        taiat = new ArrayList<>();

    }

    /**
     * 
     * @return Palauttaa pelaajalle kertyneen expan
     */
    public int getExp() {
        return exp;
    }

    /**
     * 
     * @return Palauttaa pelaajan levelin
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Asettaa pelaajan expaksi parametrin arvon
     * @param xp uusi expa
     */
    public void setExp(int xp) {
        exp = xp;
    }

    /**
     * Asettaa pelaajan leveliksi parametrin arvon
     * @param levu uusi level
     */
    public void setLvl(int levu) {
        lvl = levu;
    }

    /**
     * Lisää expaa parametrin arvon verran. Jos expa saavuttaa seuraavan levelin tason, toteutetaan metodi levelUp
     * @param xp Lisättävä expa
     */
    public void addExp(int xp) {
        exp += xp;
        if (exp < 0) {
            exp = 0;
        }
        if (exp >= 100 * lvl) {
            levelUp();
        }
    }

    /**
     * Kasvattaa leveliä annetun parametrin verran
     * @param levu lisättävät levelit
     */
    public void addLvl(int levu) {
        lvl += levu;
    }

    /**
     * Kasvattaa pelaajan statseja kunnes expa ei enää riitä seuraavaan leveliin. Palauttaa HP:n Ja MP:n maksimiinsa
     */
    public void levelUp() {
        while (exp >= 100 * lvl) {
            exp -= 100 * lvl;
            addLvl(1);
            if (maagi) {
                addStr(1);
                addVit(1);
                addIntl(1);
            } else {
                addStr(2);
                addVit(2);
            }

            if (d6.heitto(4) < getLck()) {
                addLck(1);
            }

        }
        paivitaMaximit();
        hp = maxHP;
        mp = maxMP;
        System.out.println("LEVEL UP!\nSTR: " + getStr() + "  VIT: " + getVit() + "  LCK: " + getLck() + "  INTL: " + getIntl() + "\nHP: " + getHP() + "/" + getMaxHP() + "  MP: " + getMP() + "/" + getMaxMP());

    }

    /**
     * Päivittää maxHP:n ja maxMP:n vastaamaan senhetkistä statstitilannetta
     */
    public void paivitaMaximit() {
        maxHP = getStr() + 2 * getVit();
        maxMP = 2 * getIntl();
        if (hp > maxHP) {
            hp = maxHP;
        }
        if (mp > maxMP) {
            mp = maxMP;
        }
    }

    /**
     * 
     * @return Palauttaa pelaajan inventoryn
     */
    public Arkku getInventory() {
        return inventory;
    }

    /**
     * 
     * @return Palauttaa pelaajan taiat
     */
    public ArrayList<Taika> getTaiat() {
        return taiat;
    }
}
