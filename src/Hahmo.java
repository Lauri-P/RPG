
public class Hahmo {

    int strength;
    int vitality;
    int luck;
    int inteligence;
    int maxHP;
    int maxMP;
    int hp;
    int mp;

    public Hahmo() {
        strength = 0;
        vitality = 0;
        luck = 0;
        inteligence = 0;
    }

    public Hahmo(int str) {
        strength = str;
        vitality = 0;
        luck = 0;
        inteligence = 0;
    }

    public Hahmo(int str, int vit) {
        strength = str;
        vitality = vit;
        luck = 0;
        inteligence = 0;
    }

    public Hahmo(int str, int vit, int lck) {
        strength = str;
        vitality = vit;
        luck = lck;
        inteligence = 0;
    }

    public Hahmo(int str, int vit, int lck, int intl) {
        strength = str;
        vitality = vit;
        luck = lck;
        inteligence = intl;
    }

    //Getterit
    public int getStr() {
        return strength;
    }

    public int getVit() {
        return vitality;
    }

    public int getLck() {
        return luck;
    }

    public int getIntl() {
        return inteligence;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getHP() {
        return hp;
    }

    public int getMP() {
        return mp;
    }

    //Setterit
    public void setStr(int str) {
        strength = str;
    }

    public void setVit(int vit) {
        vitality = vit;
    }

    public void setLck(int lck) {
        luck = lck;
    }

    public void setIntl(int intl) {
        inteligence = intl;
    }

    public void setMaxHP(int max) {
        maxHP = max;
    }

    public void setMaxMP(int max) {
        maxMP = max;
    }

    public void setHP(int hp) {
        this.hp = hp;
        if (this.hp > maxHP) {
            this.hp = maxHP;
        }
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

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
    public void addStr(int str) {
        strength += str;
    }

    public void addVit(int vit) {
        vitality += vit;
    }

    public void addLck(int lck) {
        luck += lck;
    }

    public void addIntl(int intl) {
        inteligence += intl;
    }

    public void addMaxHP(int max) {
        maxHP += max;
    }

    public void addMaxMP(int max) {
        maxMP += max;
    }

    public void addHP(int hp) {
        this.hp += hp;
        if (this.hp > maxHP) {
            this.hp = maxHP;
        }
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

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
