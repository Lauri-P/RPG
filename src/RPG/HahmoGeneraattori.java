package RPG;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka generoi hahmoja
 * @author Lauri
 */
public class HahmoGeneraattori {

    public static Scanner lukija = new Scanner(System.in);
    Noppa d6;

    private void pelaajanViimeistely(Pelaaja pelaaja) {
        Taika tulipallo = new Taika("Tulipallo", "Tuli", 2, 8);
        Taika vesipallo = new Taika("Vesipallo", "Vesi", 2, 8);
        ArrayList<String> tyypit = new ArrayList<>();
        tyypit.add("Tuli");
        tyypit.add("Vesi");
        Taika hoyry = new Taika("Höyryä", tyypit, 3, 6);
        pelaaja.getTaiat().add(tulipallo);
        pelaaja.getTaiat().add(vesipallo);
        pelaaja.getTaiat().add(hoyry);
        pelaaja.setHP(pelaaja.getMaxHP());
        pelaaja.setMP(pelaaja.getMaxMP());
    }

    private char valintaprosessi() {
        String vastaus = lukija.next();
        return vastaus.toUpperCase().charAt(0);
    }

    private void hienosaato(Pelaaja pelaaja, int pisteet) {
        int alkuStr = pelaaja.getStr();
        int alkuVit = pelaaja.getVit();
        int alkuLck = pelaaja.getLck();
        int alkuIntl = pelaaja.getIntl();
        while (true) {
            System.out.println("Str: " + pelaaja.getStr() + ", Vit: " + pelaaja.getVit() + ", Lck: " + pelaaja.getLck() + ", Intl: " + pelaaja.getIntl() + ", HP: " + pelaaja.getMaxHP() + ", MP: " + pelaaja.getMaxMP());
            System.out.println("Sinulla on " + pisteet + " irtopistettä. Mitä haluat muuttaa? S = Str, V = Vit, L = Lck, I = Intl, Q lopettaa hahmonmuokkauksen.");
            char valinta = valintaprosessi();

            if (valinta == 'S') {
                System.out.println("Str: " + pelaaja.getStr() + ", josta " + (pelaaja.getStr() - alkuStr) + " irtopisteinä. Sinulla on " + pisteet + " irtopistettä jäljellä. Paljonko lisätään? (Miinus vähentää)");
                int muutos = lukija.nextInt();
                if (muutos > pisteet) {
                    muutos = pisteet;
                }
                if (muutos < -(pelaaja.getStr() - alkuStr)) {
                    muutos = -(pelaaja.getStr() - alkuStr);
                }
                pelaaja.addStr(muutos);
                pisteet = pisteet - muutos;
                pelaaja.paivitaMaximit();
            }

            if (valinta == 'V') {
                System.out.println("Vit: " + pelaaja.getVit() + ", josta " + (pelaaja.getVit() - alkuVit) + " irtopisteinä. Sinulla on " + pisteet + " irtopistettä jäljellä. Paljonko lisätään? (Miinus vähentää)");
                int muutos = lukija.nextInt();
                if (muutos > pisteet) {
                    muutos = pisteet;
                }
                if (muutos < -(pelaaja.getVit() - alkuVit)) {
                    muutos = -(pelaaja.getVit() - alkuVit);
                }
                pelaaja.addVit(muutos);
                pisteet = pisteet - muutos;
                pelaaja.paivitaMaximit();
            }

            if (valinta == 'L') {
                System.out.println("Lck: " + pelaaja.getLck() + ", josta " + (pelaaja.getLck() - alkuLck) + " irtopisteinä. Sinulla on " + pisteet + " irtopistettä jäljellä. Paljonko lisätään? (Miinus vähentää)");
                int muutos = lukija.nextInt();
                if (muutos > pisteet) {
                    muutos = pisteet;
                }
                if (muutos < -(pelaaja.getLck() - alkuLck)) {
                    muutos = -(pelaaja.getLck() - alkuLck);
                }
                pelaaja.addLck(muutos);
                pisteet = pisteet - muutos;
                pelaaja.paivitaMaximit();
            }

            if (valinta == 'I') {
                System.out.println("Intl: " + pelaaja.getIntl() + ", josta " + (pelaaja.getIntl() - alkuIntl) + " irtopisteinä. Sinulla on " + pisteet + " irtopistettä jäljellä. Paljonko lisätään? (Miinus vähentää)");
                int muutos = lukija.nextInt();
                if (muutos > pisteet) {
                    muutos = pisteet;
                }
                if (muutos < -(pelaaja.getIntl() - alkuIntl)) {
                    muutos = -(pelaaja.getIntl() - alkuIntl);
                }
                pelaaja.addIntl(muutos);
                pisteet = pisteet - muutos;
                pelaaja.paivitaMaximit();
            }

            if (valinta == 'Q') {
                if (pisteet > 0) {
                    System.out.println("Sinulla on vielä käyttämättömiä irtopisteitä. Oletko varma että haluat lopettaa hahmonmuokkauksen? Y = Kyllä");
                    if (valintaprosessi() == 'Y') {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Konstruktori
     */
    public HahmoGeneraattori() {
        d6 = new Noppa();
    }

    /**
     * Metodi luo Pelaaja-luokan hahmon, jolle arvotaan statsit. Lopuksi statseja voi vielä muokata rajatusti
     * @return Palauttaa valmiin pelaaja
     */
    public Pelaaja luoPelaaja() {
        Pelaaja pelaaja;
        char valinta;
        while (true) {
            System.out.println("Valitse hahmosi tyyppi: S = soturi, V = velho");
            valinta = valintaprosessi();
            if (valinta == 'S') {
                pelaaja = new Pelaaja(d6.heitto(3), d6.heitto(3), d6.heitto(2));
                break;
            }

            if (valinta == 'V') {
                pelaaja = new Pelaaja(d6.heitto(2), d6.heitto(2), d6.heitto(2), d6.heitto(2));
                break;
            }
        }
        hienosaato(pelaaja, d6.heitto());
        pelaajanViimeistely(pelaaja);
        return pelaaja;
    }
    
    /**
     * Luo toistaiseksi testivihollisen jonka nimi sisältää tiedon hahmon heikkouksista. Statsit on arvottu
     * @return Palauttaa satunnaisgeneroidun vihollisen
     */
    public Vihollinen luoVihu(){
        Vihollinen vihu=new Vihollinen(d6.heitto(3),d6.heitto(3),d6.heitto(2),d6.heitto(2));
        int heikkoudet=d6.heitto();
        if(heikkoudet>2){
            vihu.addWeak("Tuli");
            vihu.setNimi(vihu.getNimi()+"T");
        }
        
        if(heikkoudet<5){
            vihu.addWeak("Vesi");
            vihu.setNimi(vihu.getNimi()+"V");
        }
        return vihu;
    }
}
