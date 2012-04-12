
/**
 * Luokka sisältää pelin hahmojen perusstatseihin liittyviä metodeja
 * @author Lauri
 */
public class Hahmo {

    int strength;
    int vitality;
    int luck;
    int inteligence;
    int maxHP;
    int maxMP;
    int hp;
    int mp;

    /**
     * Konstruktori hahmolle, jonka kaikki statsit ovat nollilla
     */
    public Hahmo() {
        strength = 0;
        vitality = 0;
        luck = 0;
        inteligence = 0;
    }

    /**
     * Konstruktori joka asettaa hahmon voiman parametrin mukaiseksi. Muut arvot ovat nollia
     * @param str Voiman arvo
     */
    public Hahmo(int str) {
        strength = str;
        vitality = 0;
        luck = 0;
        inteligence = 0;
    }

    /**
     * Konstruktori joka asettaa hahmon statsit parametrien mukaisiksi. Muut arvot ovat nollia
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     */
    public Hahmo(int str, int vit) {
        strength = str;
        vitality = vit;
        luck = 0;
        inteligence = 0;
    }

    /**
     * Konstruktori joka asettaa hahmon statsit parametrien mukaisiksi. Muut arvot ovat nollia
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     * @param lck Onnen arvo
     */
    public Hahmo(int str, int vit, int lck) {
        strength = str;
        vitality = vit;
        luck = lck;
        inteligence = 0;
    }

    /**
     * Konstruktori joka asettaa hahmon statsit parametrien mukaisiksi. Muut arvot ovat nollia
     * @param str Voiman arvo
     * @param vit Elinvoiman arvo
     * @param lck Onnen arvo
     * @param intl Älyn arvo
     */
    public Hahmo(int str, int vit, int lck, int intl) {
        strength = str;
        vitality = vit;
        luck = lck;
        inteligence = intl;
    }

    //Getterit
    /**
     * 
     * @return Palauttaa hahmon voiman
     */
    public int getStr() {
        return strength;
    }

    /**
     * 
     * @return Palauttaa hahmon elinvoiman
     */
    public int getVit() {
        return vitality;
    }

    /**
     * 
     * @return Palauttaa hahmon onnen
     */
    public int getLck() {
        return luck;
    }

    /**
     * 
     * @return Palauttaa hahmon älyn
     */
    public int getIntl() {
        return inteligence;
    }

    /**
     * 
     * @return Palauttaa hahmon maksimi HP-tason
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * 
     * @return Palauttaa hahmon maksimi MP-tason
     */
    public int getMaxMP() {
        return maxMP;
    }

    /**
     * 
     * @return Palauttaa hahmon HP-tason
     */
    public int getHP() {
        return hp;
    }

    /**
     * 
     * @return Palauttaa hahmon MP-tason
     */
    public int getMP() {
        return mp;
    }

    //Setterit
    /**
     * Asettaa hahmon voimaksi parametrin arvon
     * @param str Uusi voiman arvo
     */
    public void setStr(int str) {
        strength = str;
    }

    /**
     * Asettaa hahmon elinvoimaksi parametrin arvon
     * @param vit Uusi elinvoiman arvo
     */
    public void setVit(int vit) {
        vitality = vit;
    }

    /**
     * Asettaa hahmon onneksi parametrin arvon
     * @param lck Uusi onnen arvo
     */
    public void setLck(int lck) {
        luck = lck;
    }

    /**
     * Asettaa hahmon älyksi parametrin arvon
     * @param intl Uusi älyn arvo
     */
    public void setIntl(int intl) {
        inteligence = intl;
    }

    /**
     * Asettaa hahmon maksimi HP-tasoksi parametrin arvon
     * @param max Uusi maksimi HP-taso
     */
    public void setMaxHP(int max) {
        maxHP = max;
    }

    /**
     * Asettaa hahmon maksimi MP-tasoksi parametrin arvon
     * @param max Uusi maksimi HP-taso
     */
    public void setMaxMP(int max) {
        maxMP = max;
    }

    /**
     * Asettaa hahmon HP-tasoksi parametrin arvon. Arvo ei ylitä hahmon maksimi HP-tasoa, mutta on vähintään nolla
     * @param hp Uusi HP-taso
     */
    public void setHP(int hp) {
        this.hp = hp;
        if (this.hp > maxHP) {
            this.hp = maxHP;
        }
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    /**
     * Asettaa hahmon MP-tasoksi parametrin arvon. Arvo ei ylitä hahmon maksimi MP-tasoa, mutta on vähintään nolla
     * @param mp Uusi MP-taso
     */
    public void setMP(int mp) {
        this.mp = mp;
        if (this.mp > maxMP) {
            this.mp = maxMP;
        }
        if (this.mp < 0) {
            this.mp = 0;
        }
    }

    //Adderit
    /**
     * Lisää hahmon voimaa parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa
     * @param str Voiman muutos
     */
    public void addStr(int str) {
        strength += str;
    }

    /**
     * Lisää hahmon elinvoimaa parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa
     * @param vit Elinvoiman muutos
     */
    public void addVit(int vit) {
        vitality += vit;
    }

    /**
     * Lisää hahmon onnea parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa
     * @param lck Onnen muutos
     */
    public void addLck(int lck) {
        luck += lck;
    }

    /**
     * Lisää hahmon älyä parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa
     * @param intl Älyn muutos
     */
    public void addIntl(int intl) {
        inteligence += intl;
    }

    /**
     * Lisää hahmon maksimi HP-tasoa parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa
     * @param max Maksimi HP-tasom muutos
     */
    public void addMaxHP(int max) {
        maxHP += max;
    }

    /**
     * Lisää hahmon maksimi MP-tasoa parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa
     * @param max Maksimi MP-tasom muutos
     */
    public void addMaxMP(int max) {
        maxMP += max;
    }

    /**
     * Lisää hahmon HP-tasoa parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa. Ei ylitä hahmon maksimi HP-tasoa, mutta on vähintään nolla
     * @param hp HP-tason muutos
     */
    public void addHP(int hp) {
        this.hp += hp;
        if (this.hp > maxHP) {
            this.hp = maxHP;
        }
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    /**
     * Lisää hahmon MP-tasoa parametrina annetun arvon verran. Negatiivinen luku vähentää arvoa. Ei ylitä hahmon maksimi MP-tasoa, mutta on vähintään nolla
     * @param mp MP-tason muutos
     */
    public void addMP(int mp) {
        this.mp += mp;
        if (this.mp > maxMP) {
            this.mp = maxMP;
        }
        if (this.mp < 0) {
            this.mp = 0;
        }
    }
}
