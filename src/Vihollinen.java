
import java.util.ArrayList;

public class Vihollinen extends Hahmo {

    private ArrayList<String> weakness;
    private String nimi;

    public Vihollinen() {
        super();
        luo();
    }

    public Vihollinen(int str) {
        super(str);
        luo();
    }

    public Vihollinen(int str, int vit) {
        super(str, vit);
        luo();
    }

    public Vihollinen(int str, int vit, int lck) {
        super(str, vit, lck);
        luo();
    }

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

    public ArrayList<String> getWeak() {
        return weakness;
    }

    public void setWeak(ArrayList<String> heikkoudet) {
        weakness = heikkoudet;
    }

    public void addWeak(String heikkous) {
        weakness.add(heikkous);
    }
    
    public String getNimi(){
        return nimi;
    }
    
    public void setNimi(String nimi){
        this.nimi=nimi;
    }
}
