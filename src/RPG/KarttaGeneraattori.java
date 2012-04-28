package RPG;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka generoi huoneista koostuvia karttoja
 * @author Lauri
 */
public class KarttaGeneraattori {

    Noppa d4;
    Noppa d3;
    int kokoluokka;
    double pArkku;
    double pVihu;
    Huone[][] huoneet;
    HahmoGeneraattori gener;
    int maara;
    int vikaVihuX;
    int vikaVihuY;
    int vihut;
    private Scanner teksti;
    ArrayList<String> esineet;

    /**
     * Konstruktori 5x5 alueelle mahtuvalle kartalle
     */
    public KarttaGeneraattori() {

        kokoluokka = 5;
        d4 = new Noppa(4);
        d3 = new Noppa(3);
        pArkku = 0.5;
        pVihu = 0.5;
        gener = new HahmoGeneraattori();

        File tiedosto = new File("Item.txt");
        try {
            teksti = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedostoa \"Item.txt\" ei löydy, ohjelma keskeytetään");
            System.exit(0);
        }
        esineet = new ArrayList<>();
        while (teksti.hasNextLine()) {
            esineet.add(teksti.nextLine());
        }
    }

    /**
     * Konstruktori kartalle, joka mahtuu neliönmuotoiselle alueelle, jonka sivun pituus on parametrina annettu arvo
     * @param koko Kartan sivun pituus
     */
    public KarttaGeneraattori(int koko) {
        kokoluokka = koko;
        d4 = new Noppa(4);
        d3 = new Noppa(3);
        pArkku = 0.5;
        pVihu = 0.5;
    }

//    private char arvoJaPoista(String arvottavat){
//        int valinta=(int)(Math.random()*arvottavat.length());
//        char vastaus=arvottavat.charAt(valinta);
//        arvottavat=arvottavat.substring(0, valinta)+arvottavat.substring(valinta+1);
//        return vastaus;
//    }
    private void luoHuone(int x, int y, int mista) {
        if (x >= 0 && x < huoneet.length && y >= 0 && y < huoneet[0].length) {

            if (huoneet[x][y] == null) {
                huoneet[x][y] = new Huone();
                maara++;
                if (Math.random() <= pVihu) {
                    huoneet[x][y].setVihollinen(gener.luoVihu());
                    vikaVihuX = x;
                    vikaVihuY = y;
                    vihut++;
                }
                if (Math.random() <= pArkku) {//Toistaiseksi arkuissa vain potioneja
                    Arkku arkku = new Arkku();
                    int esineita=d3.heitto();
                    for (int i=0;i<esineita;i++){
                    String[] esineenTiedot = esineet.get((int) (Math.random() * esineet.size())).split(";");
                    String nimi = esineenTiedot[0];
                    String ominaisuudet = esineenTiedot[1];
                    String kuvaus = esineenTiedot[2];
                    boolean equipable=esineenTiedot[3].equals("1");
                    boolean consumable=esineenTiedot[4].equals("1");
                    arkku.addEsine(new Esine(nimi, ominaisuudet, kuvaus, equipable, consumable));
                    }
                    huoneet[x][y].setArkku(arkku);
                }

                int ovet = d4.heitto();
                String suunnat = "1234";

                while (ovet > 1) {
                    int valinta = (int) (Math.random() * suunnat.length());
                    char ovi = suunnat.charAt(valinta);
                    suunnat = suunnat.substring(0, valinta) + suunnat.substring(valinta + 1);
                    ovet--;

                    if (ovi == '1') {
                        luoHuone(x, y + 1, 3);
                    }
                    if (ovi == '2') {
                        luoHuone(x + 1, y, 4);
                    }
                    if (ovi == '3') {
                        luoHuone(x, y - 1, 1);
                    }
                    if (ovi == '4') {
                        luoHuone(x - 1, y, 2);
                    }
                }

            }

            if (mista == 1) {
                huoneet[x][y].setPohjoinen(huoneet[x][y + 1]);
                huoneet[x][y + 1].setEtela(huoneet[x][y]);
            }

            if (mista == 2) {
                huoneet[x][y].setIta(huoneet[x + 1][y]);
                huoneet[x + 1][y].setLansi(huoneet[x][y]);
            }

            if (mista == 3) {
                huoneet[x][y].setEtela(huoneet[x][y - 1]);
                huoneet[x][y - 1].setPohjoinen(huoneet[x][y]);
            }

            if (mista == 4) {
                huoneet[x][y].setLansi(huoneet[x - 1][y]);
                huoneet[x - 1][y].setIta(huoneet[x][y]);
            }

        }
    }

    /**
     * Metodi luo luolaston ja siihen viholliset ja arkut ja nimeää yhden vihollisen bossiksi
     * @return Palauttaa huoneen, josta seikkailu alkaa
     */
    public Huone luoLuolasto() {
        vihut = 0;
        maara = 1;
        huoneet = new Huone[kokoluokka][kokoluokka];
        Huone alku = new Huone();
        int x = huoneet.length / 2;
        int y = 0;
        huoneet[x][y] = alku;
        int ovet = d3.heitto();
        String suunnat = "124";

        while (ovet > 0) {
            int valinta = (int) (Math.random() * suunnat.length());
            char ovi = suunnat.charAt(valinta);
            suunnat = suunnat.substring(0, valinta) + suunnat.substring(valinta + 1);
            ovet--;
            if (ovi == '1') {
                luoHuone(x, y + 1, 3);
            }
            if (ovi == '2') {
                luoHuone(x + 1, y, 4);
            }
            if (ovi == '4') {
                luoHuone(x - 1, y, 2);
            }

        }
        if (vihut > kokoluokka) {
            huoneet[vikaVihuX][vikaVihuY].setBossi(true);
            huoneet[vikaVihuX][vikaVihuY].getVihollinen().setNimi(huoneet[vikaVihuX][vikaVihuY].getVihollinen().getNimi() + "Bossi");
            return alku;
        } else {
            return luoLuolasto();
        }
    }
}
