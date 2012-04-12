
import java.util.ArrayList;

/**
 * Esineiden säilömiseen tarkoitettu luokka
 * @author Lauri
 */
public class Arkku {
    
    /**
     * Lista arkun esineistä
     */
    ArrayList<Esine> sisalto;

    /**
     * Konstruktori luo listan arkun esineistä
     */
    public Arkku() {
        sisalto = new ArrayList<>();
    }

    
    /**
     * Metodi lisää parametrina annetun esineen arkkuun
     * 
     * @param uusi Käyttäjän antama esine   
     */
    public void addEsine(Esine uusi) {
        sisalto.add(uusi);
    }

    /**
     * Korvaa nykyisen esinelistan parametrin listalla
     * 
     * @param esineet Lista esineistä, joilla arkun sisältö korvataan
     */
    public void setEsineet(ArrayList<Esine> esineet) {
        sisalto = esineet;
    }

    /**
     * @return Palauttaa listan arkun sisällöstä
     */
    public ArrayList<Esine> getEsineet() {
        return sisalto;
    }

    /**
     * Poistaa parametrina annetun esineen arkusta
     * @param poistettava Poistettava esine
     */
    public void removeEsine(Esine poistettava) {
        sisalto.remove(poistettava);
    }

    /**
     * Tyhjentää arkun
     */
    public void removeAll() {
        sisalto.clear();
    }
}
