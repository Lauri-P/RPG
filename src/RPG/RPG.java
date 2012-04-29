package RPG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Peliä pyörittävä luokka
 * @author Lauri
 */
public class RPG {

    /**
     * Perus skanneri tekstisyötteiden lukemiseen
     */
    public static Scanner lukija = new Scanner(System.in);

    private static void guilla() {
        RPGGUI gui = new RPGGUI();
        gui.setTitle("RPG");
        gui.pack();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setResizable(false);
        gui.setVisible(true);
        gui.pelaa();
    }

    private static void guiton() {
        HahmoGeneraattori gener = new HahmoGeneraattori();
        KarttaGeneraattori kartta = new KarttaGeneraattori();
        Huone h0 = kartta.luoLuolasto();
//        System.out.println("Luolaston kokoluokka: " + kartta.kokoluokka + "x" + kartta.kokoluokka + ", Huoneita: " + kartta.maara + "\nVihollisia: " + kartta.vihut + ", Bossi: (" + kartta.vikaVihuX + "," + kartta.vikaVihuY + ")");//Tietoja luolastosta testausta varten
        Pelaaja soturi = gener.luoPelaaja();
        Esine potion1 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        Esine potion2 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine potion3 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        soturi.getInventory().addEsine(potion1);
        soturi.getInventory().addEsine(miekka);
        soturi.getInventory().addEsine(potion2);
        soturi.getInventory().addEsine(potion3);
        huone(soturi, h0, 0);
    }

    private static void huoneListaus(Huone missa, ArrayList<Huone> huoneet) {
        if (missa.getPohjoinen() != null) {
            huoneet.add(missa.getPohjoinen());
        }
        if (missa.getIta() != null) {
            huoneet.add(missa.getIta());
        }
        if (missa.getEtela() != null) {
            huoneet.add(missa.getEtela());
        }
        if (missa.getLansi() != null) {
            huoneet.add(missa.getLansi());
        }
    }

    private static void huoneessaArkku(Huone missa, Pelaaja pelaaja) {
        if (missa.getArkku() != null && missa.getArkku().getEsineet().size() > 0) {
            System.out.println("There is chest in room.");
            for (int i = 0; i < missa.getArkku().getEsineet().size(); i++) {
                pelaaja.getInventory().addEsine(missa.getArkku().getEsineet().get(i));
                System.out.println(missa.getArkku().getEsineet().get(i).getNimi() + " added to inventory");
            }
            missa.getArkku().removeAll();
        }
    }

    private static void siirry(Pelaaja pelaaja, Huone missa, Huone mihin, int mista) {
        if (mihin == null) {
            System.out.println("There is no door");
        } else {
            huone(pelaaja, mihin, mista);
        }
    }

    private static void kaytaEsinetta(int valinta, Pelaaja pelaaja, EsineTulkki tulkki) {
        if (valinta > 0 && valinta <= pelaaja.getInventory().getEsineet().size()) {
            Esine esine = pelaaja.getInventory().getEsineet().get(valinta - 1);
            if (esine.getConsumable() && !esine.getConsumed()) {
                tulkki.consume(esine);
                System.out.println("Player consumed " + esine.getNimi());
                if (esine.getConsumed()) {
                    while (pelaaja.getInventory().getEsineet().contains(esine)) {
                        pelaaja.getInventory().getEsineet().remove(esine);
                    }
                }
            } else if (esine.getEquipable() && !esine.getEquiped()) {
                tulkki.equip(esine);
                System.out.println("You equipped " + esine.getNimi());
            } else if (esine.getEquipable() && esine.getEquiped()) {
                tulkki.unEquip(esine);
                System.out.println("You unequipped " + esine.getNimi());
            }
            pelaaja.paivitaMaximit();
            odota();
        }
    }

    /**
     * Metodi luo parametrina annetun ajan mittaisen tauon
     * 
     * @param millis Tauon pituus millisekunteina 
     */
    private static void odota(int millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sekunnin mittainen tauko
     */
    private static void odota() {
        odota(1000);
    }

    /**
     * Kertoo pelin loppumisen syyn parametrina annetun totuusarvon mukaan ja päättää ohjelman ajon
     * 
     * @param voitto True jos pelin voittoehto on täyttynyt, muuten false 
     */
    private static void gameOver(boolean voitto) {
        if (voitto) {
            System.out.println("Onnittelut. Voitit pelin");
        } else {
            System.out.println("Hävisit pelin");
        }
        System.exit(0);
    }

    private static void pako(Huone missa, Pelaaja pelaaja) {
        System.out.println("Pakenit");
        ArrayList<Huone> huoneet = new ArrayList<>();
        huoneListaus(missa, huoneet);
        Noppa huonenoppa = new Noppa(huoneet.size());
        Huone mihin = huoneet.get(huonenoppa.heitto() - 1);
        if (mihin == missa.getPohjoinen()) {
            huone(pelaaja, mihin, 3);
        }
        if (mihin == missa.getIta()) {
            huone(pelaaja, mihin, 4);
        }
        if (mihin == missa.getEtela()) {
            huone(pelaaja, mihin, 1);
        }
        if (mihin == missa.getLansi()) {
            huone(pelaaja, mihin, 2);
        }
    }

    private static void suunnanNayttaja(int mista) {
        String[] suunnat = {"south", "west", "north", "east"};
        if (mista > 0) {
            System.out.println("You went to " + suunnat[mista - 1]);
        }
    }

    private static void huoneessaVihollinen(Huone missa, Pelaaja pelaaja) {
        if (missa.getVihollinen() != null) {
            Taistelu taistelu = new Taistelu(pelaaja);
            taistelu.taistele(missa.getVihollinen());
            if (pelaaja.getHP() <= 0) {
                System.out.println("Hävisit");
                gameOver(false);
            } else if (missa.getVihollinen().getHP() <= 0) {
                int expa = missa.getVihollinen().getMaxHP() + missa.getVihollinen().getMaxMP() + missa.getVihollinen().getLck();
                System.out.println("Voitit! +" + expa + "XP");
                pelaaja.addExp(expa);
                missa.setVihollinen(null);
                if (missa.getBossi()) {
                    gameOver(true);
                }
            } else {
                pako(missa, pelaaja);
            }
        }
    }

    private static void tulostaEsineet(Pelaaja pelaaja) {
        for (int i = 0; i < pelaaja.getInventory().getEsineet().size(); i++) {
            System.out.print((i + 1) + ": " + pelaaja.getInventory().getEsineet().get(i).nimi + ": " + pelaaja.getInventory().getEsineet().get(i).kuvaus);
            if (pelaaja.getInventory().getEsineet().get(i).getEquiped()) {
                System.out.print("(Equipped)");
            }
            System.out.println("");
        }
    }

    /**
     * Metodi kysyy seuraavaa toimintoa ja palauttaa toimintoa vastaavan merkin
     * 
     * @return Käyttäjän antaman syötteen ensimmäinen merkki
     */
    private static char valintaprosessi() {
        System.out.println("Valitse toiminto: W pohjoiseen, D itään, S etelään, A länteen, I inventory, Q quit");
        String vastaus = lukija.next();
        return vastaus.toUpperCase().charAt(0);
    }

    /**
     * Metodi esittää pelaajan hallussa olevat esineet ja toteuttaa valitun esineen ominaisuudet
     * Lisäksi esine poistetaan inventorystä jos sen consumed-arvoksi tulee true
     * 
     * @param pelaaja Määrittelee toiminnon kohteen
     */
    private static void esine(Pelaaja pelaaja) {
        EsineTulkki tulkki = new EsineTulkki(pelaaja);
        System.out.println("Valitse käytettävä esine, 0 peruuttaa");
        tulostaEsineet(pelaaja);
        int valinta = lukija.nextInt();
        kaytaEsinetta(valinta, pelaaja, tulkki);

    }

    /**
     * Metodi vastaa isosta osasta pelin kulkua. Se seuraa pelaajaa ja toteuttaa huonekohtaiset toiminnot
     * Jos huoneessa on vihollinen, seuraa taistelu, jos pelaaja kuolee, peli päättyy, jos pelaaja pakenee, metodi arpoo pakosuunnan, jos pelaaja voittaa, pelaaja saa expaa ja voittaa pelin jos vihollinen on bossi
     * Jos huoneessa on arkku, sen sisältö lisätään pelaajan inventoryyn, olettaen että huoneessa ei ole (enää) vihollista
     * 
     * @param pelaaja Pelin pelaaja
     * @param missa Huone johon siirryttiin
     * @param mista luku joka kertoo mistä suunnasta huoneeseen saavuttiin: 1=pohjoinen, 2=itä, 3=etelä ja 4=länsi
     */
    private static void huone(Pelaaja pelaaja, Huone missa, int mista) {
        suunnanNayttaja(mista);
        huoneessaVihollinen(missa, pelaaja);
        huoneessaArkku(missa, pelaaja);
        char valinta;
        while (true) {
            valinta = valintaprosessi();
            Huone mihin;
            if (valinta == 'W') {
                mihin = missa.getPohjoinen();
                siirry(pelaaja, missa, mihin, 3);
            }
            if (valinta == 'D') {
                mihin = missa.getIta();
                siirry(pelaaja, missa, mihin, 4);
            }
            if (valinta == 'S') {
                mihin = missa.getEtela();
                siirry(pelaaja, missa, mihin, 1);
            }
            if (valinta == 'A') {
                mihin = missa.getLansi();
                siirry(pelaaja, missa, mihin, 2);
            }
            if (valinta == 'I') {
                esine(pelaaja);
            }
            if (valinta == 'Q') {
                System.exit(0);
            }

        }

    }

    private static int kysyInt(String kysymys) {
        String tarjokas = "";
        int arvo = 0;
        boolean kunnossa = false;
        do {
            try {
                tarjokas = JOptionPane.showInputDialog(kysymys);
                arvo = Integer.parseInt(tarjokas);
                kunnossa = true;
            } catch (Exception e) {
                if (tarjokas == null) {
                    JOptionPane.showMessageDialog(null, "Cancel is not an integer!", "", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, tarjokas + " is not an integer!", "", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } while (!kunnossa);

        return arvo;
    }

    /**
     * Aloittaa pelin. Pelaaja voi valita ponnahdusikkunasta GUI-version tai tekstiversion
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        guilla();
//        guiton();
    }
}
