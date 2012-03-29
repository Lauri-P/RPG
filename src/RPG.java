
import java.util.ArrayList;

public class RPG {

    public static void main(String[] args) {

        //Tässä on toistaiseksi vain kaikenlaista testailua
        Taistelu taistelu;
        Pelaaja soturi = new Pelaaja(12, 12, 8);
        taistelu = new Taistelu(soturi);
        Esine potion1 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        Esine potion2 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine potion3 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        soturi.getInventory().addEsine(potion1);
        soturi.getInventory().addEsine(miekka);
        soturi.getInventory().addEsine(potion1);//Testataan saman esineen laittamista inventoryyn.
        soturi.getInventory().addEsine(potion2);
        soturi.getInventory().addEsine(potion3);
        Vihollinen vihu = new Vihollinen(1, 30, 13);
        Vihollinen vihu2 = new Vihollinen(12, 20, 6);
        Vihollinen vihu3 = new Vihollinen(12, 24, 6);
        ArrayList<Vihollinen> vihut = new ArrayList<>();
        vihut.add(vihu);
        vihut.add(vihu2);
        vihut.add(vihu3);
        for (int i = 0; i < vihut.size(); i++) {
            taistelu.taistele(vihut.get(i));
            if (soturi.getHP() <= 0) {
                System.out.println("Hävisit");
            } else if (vihut.get(i).getHP() <= 0) {
                System.out.println("Voitit");
                soturi.addExp(vihut.get(i).getMaxHP() + vihut.get(i).getMaxMP() + vihut.get(i).getLck());
            } else {
                System.out.println("Pakenit");
            }
        }


    }
}
