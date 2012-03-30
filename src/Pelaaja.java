
import java.util.ArrayList;

public class Pelaaja extends Hahmo {

    int exp;
    int lvl;
    boolean maagi;
    Noppa d6;
    Arkku inventory;
    ArrayList<Taika> taiat;

    public Pelaaja() {
        super();
        luo();
    }

    public Pelaaja(int str) {
        super(str);
        luo();
    }

    public Pelaaja(int str, int vit) {
        super(str, vit);
        luo();
    }

    public Pelaaja(int str, int vit, int lck) {
        super(str, vit, lck);
        luo();
    }

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

    public int getExp() {
        return exp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setExp(int xp) {
        exp = xp;
    }

    public void setLvl(int levu) {
        lvl = levu;
    }

    public void addExp(int xp) {
        exp += xp;
        if (exp < 0) {
            exp = 0;
        }
        if (exp >= 100 * lvl) {
            levelUp();
        }
    }

    public void addLvl(int levu) {
        lvl += levu;
    }

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

    public Arkku getInventory() {
        return inventory;
    }

    public ArrayList<Taika> getTaiat() {
        return taiat;
    }
}
