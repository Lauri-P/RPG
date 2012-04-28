package RPG;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka generoi hahmoja
 * @author Lauri
 */
public class HahmoGeneraattori {

    public static Scanner lukija = new Scanner(System.in);
    Noppa d6;
    private Scanner teksti;
    ArrayList<String> vihut;

    /**
     * Antaa pelaajalle oletustaiat: Tulipallo, Vesipallo ja Höyryä
     * @param pelaaja Viimeisteltävä pelaaja
     */
    public void pelaajanViimeistely(Pelaaja pelaaja) {
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
     * Konstruktori: Lukee tiedoston Enemy.txt, jonka jokaisella rivillä on kuvattu yksi mahdollinen vihollinen seuraavassa muodossa:
     * Nimi:Kuvatiedosto polkuineen:STR satunnaisosa:STR pohja:VIT satunnaisosa:VIT pohja:LCK satunnaisosa:LCK pohja:INTL satunnaisosa:INTL pohja:Heikkous1:Heikkous2:...
     * Satunnaisosat tarkoittavat montako noppaa heitetään kyseistä statsin kohdalla ja pohja lisätään tähän tulokseen. Heikkouksia voi liittää mielivaltaisen määrän tai ei yhtään
     */
    public HahmoGeneraattori() {
        d6 = new Noppa();
        File tiedosto=new File("Enemy.txt");
        try {
            teksti = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedostoa \"Enemy.txt\" ei löydy, ohjelma keskeytetään");
            System.exit(0);
        }
        vihut=new ArrayList<>();
        while(teksti.hasNextLine()){
            vihut.add(teksti.nextLine());
        }
        
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
     * Lukee satunnaisen rivin tiedostosta Enemy.txt ja luo sen perusteella vihollisen
     * @return Palauttaa jonkin Enemy.txt:ssä kuvatuista vihollisista
     */
    public Vihollinen luoVihu(){
        String[] vihunTiedot=vihut.get((int)(Math.random()*vihut.size())).split(":");
        String nimi=vihunTiedot[0];
        String polku=vihunTiedot[1];
        int str=d6.heitto(Integer.parseInt(vihunTiedot[2]))+Integer.parseInt(vihunTiedot[3]);
        int vit=d6.heitto(Integer.parseInt(vihunTiedot[4]))+Integer.parseInt(vihunTiedot[5]);
        int lck=d6.heitto(Integer.parseInt(vihunTiedot[6]))+Integer.parseInt(vihunTiedot[7]);
        int intl=d6.heitto(Integer.parseInt(vihunTiedot[8]))+Integer.parseInt(vihunTiedot[9]);
        Vihollinen vihu=new Vihollinen(str,vit,lck,intl);
        for(int i=10;i<vihunTiedot.length;i++){
            vihu.addWeak(vihunTiedot[i]);
        }
        vihu.setNimi(nimi);
        vihu.setPolku(polku);
        return vihu;
    }
}
