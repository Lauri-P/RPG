
import java.util.ArrayList;

public class Arkku {

    ArrayList<Esine> sisalto;

    public Arkku() {
        sisalto = new ArrayList<>();
    }

    public void addEsine(Esine uusi) {
        sisalto.add(uusi);
    }

    public void setEsineet(ArrayList<Esine> esineet) {
        sisalto = esineet;
    }

    public ArrayList<Esine> getEsineet() {
        return sisalto;
    }

    public void removeEsine(Esine poistettava) {
        sisalto.remove(poistettava);
    }

    public void removeAll() {
        sisalto.clear();
    }
}
