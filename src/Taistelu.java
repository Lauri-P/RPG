
import java.util.Scanner;

public class Taistelu {

    Noppa d6 = new Noppa();
    EsineTulkki tulkki;
    public static Scanner lukija = new Scanner(System.in);
    Pelaaja pelaaja;
    boolean vuoro;

    public Taistelu(Pelaaja pelaaja) {
        tulkki = new EsineTulkki(pelaaja);
        this.pelaaja = pelaaja;
    }

    private void odota(int millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void odota() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char valintaprosessi() {
        System.out.println("Määrittele taistelutoiminto: A Hyökkää, M Käytä taikaa, I Käytä esine, R Koita paeta");
        String vastaus = lukija.next();
        return vastaus.toUpperCase().charAt(0);
    }

    private boolean pakene() {
        System.out.println("Player tries to run");

        odota();

        if (d6.heitto(2) < pelaaja.getLck()) {
            System.out.println("Success");
            return true;
        }
        System.out.println("But it failed");
        vuoro = false;
        return false;
    }

    private void esine() {
        System.out.println("Valitse käytettävä esine, 0 peruuttaa");
        for (int i = 0; i < pelaaja.getInventory().getEsineet().size(); i++) {
            System.out.println((i + 1) + ": " + pelaaja.getInventory().getEsineet().get(i).nimi + ": " + pelaaja.getInventory().getEsineet().get(i).kuvaus);
        }
        int valinta = lukija.nextInt();
        if (valinta > 0 && valinta <= pelaaja.getInventory().getEsineet().size()) {
            Esine esine = pelaaja.getInventory().getEsineet().get(valinta - 1);
            if (esine.getConsumable() && !esine.getConsumed()) {
                tulkki.consume(esine);
                System.out.println("Player consumed " + esine.getNimi());
                odota();
                pelaaja.paivitaMaximit();
                if (esine.getConsumed()) {
                    while (pelaaja.getInventory().getEsineet().contains(esine)) {
                        pelaaja.getInventory().getEsineet().remove(esine);
                    }
                }
                vuoro = false;
            }
        }

    }

    private void taika(Hahmo kayttaja, Hahmo kohde) {
        //Toteutetaan myöhemmin
        System.out.println("BUY DLC");
        odota();
    }

    private void hyokkaa(Hahmo kayttaja, Hahmo kohde) {

        int vahinko = kayttaja.getStr();
        System.out.println("Attack!");
        odota();
        if (d6.heitto(3) < kayttaja.getLck()) {
            vahinko = vahinko * 2;
            System.out.println("Critical Hit!");
            odota();
        }
        kohde.addHP(-vahinko);
        vuoro = false;
    }

    public void taistele(Vihollinen vihu) {
        while (pelaaja.getHP() > 0 && vihu.getHP() > 0) {
            System.out.println("Player: HP " + pelaaja.getHP() + "/" + pelaaja.getMaxHP() + "   MP " + pelaaja.getMP() + "/" + pelaaja.getMaxMP() + "\n"
                    + "Enemy: HP " + vihu.getHP() + "/" + vihu.getMaxHP() + "   MP " + vihu.getMP() + "/" + vihu.getMaxMP());
            char valinta;
            vuoro = true;
            String vaihtoehdot = "RIMA";
            while (vuoro) {
                do {
                    valinta = valintaprosessi();
                } while (vaihtoehdot.indexOf(valinta) < 0);
                if (valinta == 'R') {
                    if (pakene()) {
                        return;
                    }
                }
                if (valinta == 'I') {
                    esine();
                }
                if (valinta == 'M') {
                    taika(pelaaja, vihu);
                }
                if (valinta == 'A') {
                    hyokkaa(pelaaja, vihu);
                }
            }
            System.out.println("Player: HP " + pelaaja.getHP() + "/" + pelaaja.getMaxHP() + "   MP " + pelaaja.getMP() + "/" + pelaaja.getMaxMP() + "\n"
                    + "Enemy: HP " + vihu.getHP() + "/" + vihu.getMaxHP() + "   MP " + vihu.getMP() + "/" + vihu.getMaxMP());
            odota();
            if (pelaaja.getHP() > 0 && vihu.getHP() > 0) {
                hyokkaa(vihu, pelaaja);
            }
        }
    }
}
