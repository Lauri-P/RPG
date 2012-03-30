
import java.util.ArrayList;
import java.util.Scanner;

public class RPG {

    public static Scanner lukija = new Scanner(System.in);

    private static void odota(int millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void odota() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void gameOver(boolean voitto) {
        if (voitto) {
            System.out.println("Onnittelut. Voitit pelin");
        } else {
            System.out.println("Hävisit pelin");
        }
        System.exit(0);
    }

    private static char valintaprosessi() {
        System.out.println("Valitse toiminto: W pohjoiseen, D itään, S etelään, A länteen, I inventory, Q quit");
        String vastaus = lukija.next();
        return vastaus.toUpperCase().charAt(0);
    }

    private static void esine(Pelaaja pelaaja) {
        EsineTulkki tulkki = new EsineTulkki(pelaaja);
        System.out.println("Valitse käytettävä esine, 0 peruuttaa");
        for (int i = 0; i < pelaaja.getInventory().getEsineet().size(); i++) {
            System.out.print((i + 1) + ": " + pelaaja.getInventory().getEsineet().get(i).nimi + ": " + pelaaja.getInventory().getEsineet().get(i).kuvaus);
            if (pelaaja.getInventory().getEsineet().get(i).getEquiped()) {
                System.out.print("(Equiped)");
            }
            System.out.println("");
        }
        int valinta = lukija.nextInt();
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
                System.out.println("You equiped " + esine.getNimi());
            } else if (esine.getEquipable() && esine.getEquiped()) {
                tulkki.unEquip(esine);
                System.out.println("You unequiped " + esine.getNimi());
            }
            pelaaja.paivitaMaximit();
            odota();
        }

    }

    private static void huone(Pelaaja pelaaja, Huone missa, int mista) {
        String[] suunnat={"south", "west", "north", "east"};
        System.out.println("You went to " +suunnat[mista-1]);
        Taistelu taistelu = new Taistelu(pelaaja);
        if (missa.getVihollinen() != null) {
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
                System.out.println("Pakenit");
                ArrayList<Huone> huoneet = new ArrayList<>();
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

                Noppa huonenoppa = new Noppa(huoneet.size());
                Huone mihin = huoneet.get(huonenoppa.heitto()-1);
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
        }
        if (missa.getArkku() != null && missa.getArkku().getEsineet().size() > 0) {
            System.out.println("There is chest in room.");
            for (int i = 0; i < missa.getArkku().getEsineet().size(); i++) {
                pelaaja.getInventory().addEsine(missa.getArkku().getEsineet().get(i));
                System.out.println(missa.getArkku().getEsineet().get(i).getNimi() + " added to inventory");
            }
            missa.getArkku().removeAll();
        }

        String vaihtoehdot = "WASDIQ";
        char valinta;
        while (true) {
            do {
                valinta = valintaprosessi();
            } while (vaihtoehdot.indexOf(valinta) < 0);

            if (valinta == 'W') {
                if (missa.getPohjoinen() == null) {
                    System.out.println("There is no door");
                } else {
                    huone(pelaaja, missa.getPohjoinen(), 3);
                }
            }

            if (valinta == 'D') {
                if (missa.getIta() == null) {
                    System.out.println("There is no door");
                } else {
                    huone(pelaaja, missa.getIta(), 4);
                }
            }

            if (valinta == 'S') {
                if (missa.getEtela() == null) {
                    System.out.println("There is no door");
                } else {
                    huone(pelaaja, missa.getEtela(), 1);
                }
            }

            if (valinta == 'A') {
                if (missa.getLansi() == null) {
                    System.out.println("There is no door");
                } else {
                    huone(pelaaja, missa.getLansi(), 2);
                }
            }

            if (valinta == 'I') {
                esine(pelaaja);
            }

            if (valinta == 'Q') {
                System.exit(0);
            }

        }

    }

    public static void main(String[] args) {

        //Tässä on toistaiseksi vain kaikenlaista testailua


        //Hahmonluonnin vastuuta
        Pelaaja soturi = new Pelaaja(12, 12, 8, 8);
        Taika tulipallo = new Taika("Tulipallo", "Tuli", 2, 8);
        Taika vesipallo = new Taika("Vesipallo", "Vesi", 2, 8);
        ArrayList<String> tyypit = new ArrayList<>();
        tyypit.add("Tuli");
        tyypit.add("Vesi");
        Taika hoyry = new Taika("Höyryä", tyypit, 2, 4);
        soturi.getTaiat().add(tulipallo);
        soturi.getTaiat().add(vesipallo);
        soturi.getTaiat().add(hoyry);

        //Muuta säätöä
        Esine potion1 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        Esine potion2 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine potion3 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        soturi.getInventory().addEsine(potion1);
        soturi.getInventory().addEsine(miekka);
        soturi.getInventory().addEsine(potion1);//Testataan saman esineen laittamista inventoryyn.
        soturi.getInventory().addEsine(potion2);
        soturi.getInventory().addEsine(potion3);

        //kartanluontia
        Vihollinen vihu = new Vihollinen(1, 30, 13);
        vihu.addWeak("Tuli");
        Vihollinen vihu2 = new Vihollinen(12, 20, 6);
        vihu2.addWeak("Vesi");
        Vihollinen vihu3 = new Vihollinen(12, 24, 6);
        vihu3.addWeak("Tuli");
        vihu3.addWeak("Vesi");

        Huone h0 = new Huone();
        Huone h1 = new Huone();
        Huone h2 = new Huone();
        Huone h3 = new Huone();
        Huone h4 = new Huone();
        
        Arkku arkku=new Arkku();
        Arkku arkku2=new Arkku();
        arkku.addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));
        arkku2.addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));
        arkku2.addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));
        arkku2.addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));

        h0.setPohjoinen(h1);
        h1.setPohjoinen(h2);
        h2.setPohjoinen(h3);
        h3.setPohjoinen(h4);
        h4.setEtela(h3);
        h3.setEtela(h2);
        h2.setEtela(h1);
        h1.setEtela(h0);

        h1.setVihollinen(vihu);
        h2.setVihollinen(vihu2);
        h4.setVihollinen(vihu3);

        h1.setArkku(arkku);
        h3.setArkku(arkku2);
        
        h4.setBossi(true);

        huone(soturi, h0, 3);

//        ArrayList<Vihollinen> vihut = new ArrayList<>();
//        vihut.add(vihu);
//        vihut.add(vihu2);
//        vihut.add(vihu3);
//        for (int i = 0; i < vihut.size(); i++) {
//            taistelu.taistele(vihut.get(i));
//            if (soturi.getHP() <= 0) {
//                System.out.println("Hävisit");
//            } else if (vihut.get(i).getHP() <= 0) {
//                System.out.println("Voitit");
//                soturi.addExp(vihut.get(i).getMaxHP() + vihut.get(i).getMaxMP() + vihut.get(i).getLck());
//            } else {
//                System.out.println("Pakenit");
//            }
//        }




    }
}
