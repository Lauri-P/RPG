package RPG;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RPGGUI extends JFrame {

    private static void odota(int millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    JPanel kuvapaneeli;
    JPanel kompassipaneeli;
    JLabel kuva;
    JLabel kompassi;
    JButton vasen = new JButton("<");
    JButton oikea = new JButton(">");
    JButton ylos = new JButton("^");
    JButton alas = new JButton("v");
    JButton attack = new JButton("Attack");
    JButton item = new JButton("Item");
    JButton magic = new JButton("Magic");
    JButton run = new JButton("Run");
    JTextArea teksti;
    JScrollPane rullaus;
    JTextArea statsit;
    JTextArea vihuStatsit;
    JLayeredPane kerrokset;
    Huone missa;
    int mista;
    Pelaaja pelaaja;
    private JButton velho = new JButton("Wizard");
    private JButton soturi = new JButton("Warrior");
    Noppa d6;
    boolean luotu;
    boolean saadetty;
    boolean lopetus;
    private JButton strUp = new JButton("+");
    private JButton strDown = new JButton("-");
    JTextField str2;
    JButton lopetusNappi = new JButton("Quit");
    String huoneet;
    JList esineList;
    JList taikaList;
    JPanel alakerta;
    boolean esineet;
    boolean taiat;
    JScrollPane esineListScroller;
    JScrollPane taikaListScroller;
    JButton useEsine = new JButton("Use");
    JPanel esineValikko;
    JPanel taikaValikko;
    JButton useTaika = new JButton("Use");
    ImageIcon huoneKuva;
    String polku;
    BufferedImage background;
    JLabel vihulla;
    JLabel arkulla;

    public RPGGUI() throws IOException {
        kuva = new JLabel();
        kuvapaneeli = new JPanel();
        kuvapaneeli.setPreferredSize(new Dimension(640, 480));
        kompassi = new JLabel();
        kompassipaneeli = new JPanel();
        d6 = new Noppa();
        luotu = false;

        saadetty = false;
        lopetus = false;
        taiat = false;
        esineet = false;
        JPanel toiminnot = new JPanel(new GridLayout(3, 3));

        toiminnot.add(attack);
        toiminnot.add(ylos);
        toiminnot.add(item);
        toiminnot.add(vasen);
        toiminnot.add(kompassipaneeli);
        toiminnot.add(oikea);
        toiminnot.add(magic);
        toiminnot.add(alas);
        toiminnot.add(run);

        teksti = new JTextArea("", 8, 20);
        teksti.setLineWrap(true);
        teksti.setEditable(false);
        rullaus = new JScrollPane(teksti);
        rullaus.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        statsit = new JTextArea("Jee Tänne statsit!", 10, 15);
        vihuStatsit = new JTextArea("Jee Tänne vihun statsit!", 10, 15);
        vihuStatsit.setLineWrap(true);
        statsit.setEditable(false);
        vihuStatsit.setEditable(false);

        JPanel statsiruudut = new JPanel(new BorderLayout());
        statsiruudut.add("West", statsit);
        statsiruudut.add("East", vihuStatsit);

        alakerta = new JPanel(new BorderLayout());
        alakerta.add("West", toiminnot);
        alakerta.add("Center", rullaus);
        alakerta.add("East", statsiruudut);


        this.setLayout(new BorderLayout());
        this.add("Center", kuvapaneeli);
        this.add("South", alakerta);

    }

    public void lisaaTekstia(String teksti) {
        this.teksti.setText(this.teksti.getText() + "\n\n" + teksti);
        rullaus.getHorizontalScrollBar().setValue(0);
    }

    private void huoneenValinta(String huoneet) throws IOException {
        kuvapaneeli.removeAll();
        polku = missa.getKuva(mista);
//        lisaaTekstia("Saatiin polku " + polku);
        kuva = new JLabel(new ImageIcon(polku));
        if (mista != 0) {
            if (huoneet.length() <= 1) {
                kuva = new JLabel(new ImageIcon("Kuvat\\Huone0.png"));
                background = ImageIO.read(new File("Kuvat\\Huone0.png"));
            }
            if (huoneet.length() == 2) {
                if (mista == 1) {
                    if (huoneet.indexOf('2') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('3') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('4') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1o.png"));
                    }
                }
                if (mista == 2) {
                    if (huoneet.indexOf('3') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('4') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('1') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1o.png"));
                    }
                }
                if (mista == 3 || mista == 0) {
                    if (huoneet.indexOf('4') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('1') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('2') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1o.png"));
                    }
                }
                if (mista == 4) {
                    if (huoneet.indexOf('1') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('2') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('3') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone1o.png"));
                    }
                }
            }

            if (huoneet.length() == 3) {
                if (mista == 1) {
                    if (huoneet.indexOf('2') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('3') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('4') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2o.png"));
                    }
                }
                if (mista == 2) {
                    if (huoneet.indexOf('3') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('4') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('1') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2o.png"));
                    }
                }
                if (mista == 3) {
                    if (huoneet.indexOf('4') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('1') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('2') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2o.png"));
                    }
                }
                if (mista == 4) {
                    if (huoneet.indexOf('1') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('2') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('3') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                        background = ImageIO.read(new File("Kuvat\\Huone2o.png"));
                    }
                }
            }
            if (huoneet.length() == 4) {
                kuva = new JLabel(new ImageIcon("Kuvat\\Huone3.png"));
                background = ImageIO.read(new File("Kuvat\\Huone3.png"));
            }
        } else {
            if (huoneet.length() == 1) {
                if (huoneet.indexOf('4') > -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                    background = ImageIO.read(new File("Kuvat\\Huone1v.png"));
                }
                if (huoneet.indexOf('1') > -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                    background = ImageIO.read(new File("Kuvat\\Huone1k.png"));
                }
                if (huoneet.indexOf('2') > -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                    background = ImageIO.read(new File("Kuvat\\Huone1o.png"));
                }
            }
            if (huoneet.length() == 2) {
                if (huoneet.indexOf('4') == -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                    background = ImageIO.read(new File("Kuvat\\Huone2v.png"));
                }
                if (huoneet.indexOf('1') == -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                    background = ImageIO.read(new File("Kuvat\\Huone2k.png"));
                }
                if (huoneet.indexOf('2') == -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                    background = ImageIO.read(new File("Kuvat\\Huone2o.png"));
                }
            }
            if (huoneet.length() == 3) {
                kuva = new JLabel(new ImageIcon("Kuvat\\Huone3.png"));
                background = ImageIO.read(new File("Kuvat\\Huone3.png"));
            }
        }
        kuvapaneeli.add(kuva);
        kuva.revalidate();
    }

    private void huoneessaArkku() {
        if (missa.getArkku() != null && missa.getArkku().getEsineet().size() > 0) {
            lisaaTekstia("There is chest in room.");

//            try {
//                arkkuYhdiste();
//            } catch (Exception e) {
//                lisaaTekstia("KuvaFail");
//            }
//            arkulla = new JLabel(new ImageIcon("arkkuYhdiste.png"));
//            kuvapaneeli.remove(kuva);
//            kuvapaneeli.add(arkulla);
//            this.pack();
//            this.repaint();

            for (int i = 0; i < missa.getArkku().getEsineet().size(); i++) {
                pelaaja.getInventory().addEsine(missa.getArkku().getEsineet().get(i));
                lisaaTekstia(missa.getArkku().getEsineet().get(i).getNimi() + " added to inventory");
            }
            missa.getArkku().removeAll();
        }
    }

    private String keraaHuoneet(String huoneet) {
        if (missa.getPohjoinen() != null) {
            huoneet = huoneet + "1";
        }
        if (missa.getIta() != null) {
            huoneet = huoneet + "2";
        }
        if (missa.getEtela() != null) {
            huoneet = huoneet + "3";
        }
        if (missa.getLansi() != null) {
            huoneet = huoneet + "4";
        }
        return huoneet;
    }

    private void kompassinValinta() {
        kompassipaneeli.removeAll();
        if (mista == 0 || mista == 3) {
            kompassi = new JLabel(new ImageIcon("Kuvat\\Kompassi1.png"));
        }

        if (mista == 4) {
            kompassi = new JLabel(new ImageIcon("Kuvat\\Kompassi4.png"));
        }

        if (mista == 1) {
            kompassi = new JLabel(new ImageIcon("Kuvat\\Kompassi3.png"));
        }

        if (mista == 2) {
            kompassi = new JLabel(new ImageIcon("Kuvat\\Kompassi2.png"));
        }
        kompassipaneeli.add(kompassi);
        kompassi.revalidate();
    }

    private void vihuYhdiste() throws IOException {

        WritableRaster raster = background.getRaster();
        BufferedImage layer = ImageIO.read(new File(missa.getVihollinen().getPolku()));
        int width = layer.getWidth();
        int height = layer.getHeight();
        // We will shift the overlay image over the background this amount.
        int shiftX = 360 - layer.getWidth() / 2;
        int shiftY = 360 - layer.getHeight() / 2;
        // Slow method: scan all input (layer) image pixels, plotting only those which are not green.
        int lPixel, red, green, blue;
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                lPixel = layer.getRGB(w, h);
                if ((lPixel & 0x00FFFFFF) != 0x00FF00) // Not pure green!
                {
                    red = (int) ((lPixel & 0x00FF0000) >>> 16); // Red level
                    green = (int) ((lPixel & 0x0000FF00) >>> 8);  // Green level
                    blue = (int) (lPixel & 0x000000FF);       // Blue level
                    // Set the pixel on the output image's raster.
                    raster.setPixel(w + shiftX, h + shiftY, new int[]{red, green, blue, 255});
                }
            } // end for
        }       // Save the image as a PNG via ImageIO.
        ImageIO.write(background, "PNG", new File("vihuYhdiste.png"));
    }

    private void arkkuYhdiste() throws IOException {

        WritableRaster raster = background.getRaster();
        BufferedImage layer = ImageIO.read(new File("Kuvat\\Arkku.png"));
        int width = layer.getWidth();
        int height = layer.getHeight();
        // We will shift the overlay image over the background this amount.
        int shiftX = 360 - layer.getWidth() / 2;
        int shiftY = 360 - layer.getHeight() / 2;
        // Slow method: scan all input (layer) image pixels, plotting only those which are not green.
        int lPixel, red, green, blue;
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                lPixel = layer.getRGB(w, h);
                if ((lPixel & 0x00FFFFFF) != 0x00FF00) // Not pure green!
                {
                    red = (int) ((lPixel & 0x00FF0000) >>> 16); // Red level
                    green = (int) ((lPixel & 0x0000FF00) >>> 8);  // Green level
                    blue = (int) (lPixel & 0x000000FF);       // Blue level
                    // Set the pixel on the output image's raster.
                    raster.setPixel(w + shiftX, h + shiftY, new int[]{red, green, blue, 255});
                }
            } // end for
        }       // Save the image as a PNG via ImageIO.
        ImageIO.write(background, "PNG", new File("arkkuYhdiste.png"));
    }

    private void nuolet(String huoneet) {
        if (mista == 3 || mista == 0) {
            if (huoneet.indexOf('1') >= 0) {
                ylos.setEnabled(true);
            } else {
                ylos.setEnabled(false);
            }
            if (huoneet.indexOf('2') >= 0) {
                oikea.setEnabled(true);
            } else {
                oikea.setEnabled(false);
            }
            if (huoneet.indexOf('3') >= 0) {
                alas.setEnabled(true);
            } else {
                alas.setEnabled(false);
            }
            if (huoneet.indexOf('4') >= 0) {
                vasen.setEnabled(true);
            } else {
                vasen.setEnabled(false);
            }
        }
        if (mista == 4) {
            if (huoneet.indexOf('2') >= 0) {
                ylos.setEnabled(true);
            } else {
                ylos.setEnabled(false);
            }
            if (huoneet.indexOf('3') >= 0) {
                oikea.setEnabled(true);
            } else {
                oikea.setEnabled(false);
            }
            if (huoneet.indexOf('4') >= 0) {
                alas.setEnabled(true);
            } else {
                alas.setEnabled(false);
            }
            if (huoneet.indexOf('1') >= 0) {
                vasen.setEnabled(true);
            } else {
                vasen.setEnabled(false);
            }
        }
        if (mista == 1) {
            if (huoneet.indexOf('3') >= 0) {
                ylos.setEnabled(true);
            } else {
                ylos.setEnabled(false);
            }
            if (huoneet.indexOf('4') >= 0) {
                oikea.setEnabled(true);
            } else {
                oikea.setEnabled(false);
            }
            if (huoneet.indexOf('1') >= 0) {
                alas.setEnabled(true);
            } else {
                alas.setEnabled(false);
            }
            if (huoneet.indexOf('2') >= 0) {
                vasen.setEnabled(true);
            } else {
                vasen.setEnabled(false);
            }
        }
        if (mista == 2) {
            if (huoneet.indexOf('4') >= 0) {
                ylos.setEnabled(true);
            } else {
                ylos.setEnabled(false);
            }
            if (huoneet.indexOf('1') >= 0) {
                oikea.setEnabled(true);
            } else {
                oikea.setEnabled(false);
            }
            if (huoneet.indexOf('2') >= 0) {
                alas.setEnabled(true);
            } else {
                alas.setEnabled(false);
            }
            if (huoneet.indexOf('3') >= 0) {
                vasen.setEnabled(true);
            } else {
                vasen.setEnabled(false);
            }
        }
    }

    private void suunta() {
        if (mista == 1) {
            lisaaTekstia("You went to south.");
        }
        if (mista == 2) {
            lisaaTekstia("You went to west.");
        }
        if (mista == 3) {
            lisaaTekstia("You went to north.");
        }
        if (mista == 4) {
            lisaaTekstia("You went to east.");
        }
    }

    private void taistelu() {
        ylos.setEnabled(false);
        oikea.setEnabled(false);
        vasen.setEnabled(false);
        alas.setEnabled(false);
        attack.setEnabled(true);
        magic.setEnabled(true);
        run.setEnabled(true);

//        TaisteluGUI taistelu = new TaisteluGUI(this);
////        taistelu.setTitle("RPG");
////        taistelu.pack();
////        taistelu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        taistelu.setVisible(true);
//while (missa.getVihollinen().getHP()>0){
//
//        taistelu.taistelu();
//}

    }

    private void taistelunJalkeen(String huoneet) {
        if (pelaaja.getHP() <= 0) {
            gameOver(false);
        } else if (missa.getVihollinen().getHP() <= 0) {
            if (missa.getBossi()) {
                gameOver(true);
            }
        } else {
//            pako(huoneet);
        }
    }

    private void vaihdaKuvaa(String polku) {
        kuva = new JLabel(new ImageIcon(polku));

    }

    private void gameOver(boolean voitto) {
        if (voitto) {
            if (JOptionPane.showConfirmDialog(null, "You won! Retry?") == 0) {
                pelaa();

//                RPGGUI gui = new RPGGUI();
//                gui.setTitle("RPG");
//                gui.pack();
//                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                gui.setVisible(true);
//                gui.pelaa();
            }
            System.exit(0);
        }
        if (JOptionPane.showConfirmDialog(null, "You died! Retry?") == 0) {
            pelaa();

//            RPGGUI gui = new RPGGUI();
//            gui.setTitle("RPG");
//            gui.pack();
//            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            gui.setVisible(true);
//            gui.pelaa();
        }
        System.exit(0);
    }

    private void huone() {
        paivitaStatsit();
        kompassinValinta();
        huoneet = "";
        huoneet = keraaHuoneet(huoneet);

        try {
            huoneenValinta(huoneet);
        } catch (Exception e) {
            lisaaTekstia("KuvaFail");
        }


        if (missa.getVihollinen() != null) {

            try {
                vihuYhdiste();
            } catch (Exception e) {
                lisaaTekstia("KuvaFail");
            }
            vihulla = new JLabel(new ImageIcon("vihuYhdiste.png"));
            kuvapaneeli.removeAll();
            kuvapaneeli.add(vihulla);
            this.repaint();
            this.pack();

            taistelu();
            taistelunJalkeen(huoneet);
            paivitaStatsit();
        } else {
            huoneessaArkku();



            attack.setEnabled(false);
            magic.setEnabled(false);
            run.setEnabled(false);
            nuolet(huoneet);
            paivitaStatsit();
        }
    }

    public void setMista(int mista) {
        this.mista = mista;
    }

    public void setMissa(Huone missa) {
        this.missa = missa;
    }

    private void pako(String huoneet) {
        Noppa huoneNoppa = new Noppa(huoneet.length());
        char valinta = huoneet.charAt(huoneNoppa.heitto() - 1);
        if (valinta == '1') {
            missa = missa.getPohjoinen();
            mista = 3;
//            huone();
        }
        if (valinta == '2') {
            missa = missa.getIta();
            mista = 4;
//            huone();
        }
        if (valinta == '3') {
            missa = missa.getEtela();
            mista = 1;
//            huone();
        }
        if (valinta == '4') {
            missa = missa.getLansi();
            mista = 2;
//            huone();
        }
        suunta();
        huone();
    }

    private void meneYlos() {
        Huone mihin = missa;
        int suunnasta = mista;
        if (mista == 0 || mista == 3) {
            suunnasta = 3;
            mihin = missa.getPohjoinen();
        }
        if (mista == 4) {
            suunnasta = 4;
            mihin = missa.getIta();
        }
        if (mista == 1) {
            suunnasta = 1;
            mihin = missa.getEtela();
        }
        if (mista == 2) {
            suunnasta = 2;
            mihin = missa.getLansi();
        }
        setMista(suunnasta);
        setMissa(mihin);
        suunta();
        huone();
    }

    private void meneVasen() {
        Huone mihin = missa;
        int suunnasta = mista;
        if (mista == 0 || mista == 3) {
            suunnasta = 2;
            mihin = missa.getLansi();
//            huone();
        }
        if (mista == 4) {
            suunnasta = 3;
            mihin = missa.getPohjoinen();
//            huone();
        }
        if (mista == 1) {
            suunnasta = 4;
            mihin = missa.getIta();
//            huone();
        }
        if (mista == 2) {
            suunnasta = 1;
            mihin = missa.getEtela();
//            huone();
        }

        setMista(suunnasta);
        setMissa(mihin);
        suunta();
        huone();
    }

    private void meneOikea() {
        Huone mihin = missa;
        int suunnasta = mista;
        if (mista == 0 || mista == 3) {
            suunnasta = 4;
            mihin = missa.getIta();
//            huone();
        }
        if (mista == 4) {
            suunnasta = 1;
            mihin = missa.getEtela();
//            huone();
        }
        if (mista == 1) {
            suunnasta = 2;
            mihin = missa.getLansi();
//            huone();
        }
        if (mista == 2) {
            suunnasta = 3;
            mihin = missa.getPohjoinen();
//            huone();
        }

        setMista(suunnasta);
        setMissa(mihin);
        suunta();
        huone();
    }

    private void meneAlas() {
        Huone mihin = missa;
        int suunnasta = mista;
        if (mista == 0 || mista == 3) {
            suunnasta = 1;
            mihin = missa.getEtela();
//            huone();
        }
        if (mista == 4) {
            suunnasta = 2;
            mihin = missa.getLansi();
//            huone();
        }
        if (mista == 1) {
            suunnasta = 3;
            mihin = missa.getPohjoinen();
//            huone();
        }
        if (mista == 2) {
            suunnasta = 4;
            mihin = missa.getIta();
//            huone();
        }

        setMista(suunnasta);
        setMissa(mihin);
        suunta();
        huone();
    }

    private void paivitaStatsit() {
        statsit.setText("Your stats"
                + "\nHP:\t" + pelaaja.getHP() + "/" + pelaaja.getMaxHP()
                + "\nMP:\t" + pelaaja.getMP() + "/" + pelaaja.getMaxMP()
                + "\nSTR:\t" + pelaaja.getStr()
                + "\nVIT:\t" + pelaaja.getVit()
                + "\nLCK:\t" + pelaaja.getLck()
                + "\nINTL:\t" + pelaaja.getIntl()
                + "\nLVL:\t" + pelaaja.getLvl()
                + "\nXP:\t" + pelaaja.getExp() + "/" + (pelaaja.getLvl() * 100));

        if (missa.getVihollinen() != null) {
            Vihollinen vihu = missa.getVihollinen();
            vihuStatsit.setText("Enemy stats"
                    + "\nHP:\t" + vihu.getHP() + "/" + vihu.getMaxHP()
                    + "\nMP:\t" + vihu.getMP() + "/" + vihu.getMaxMP()
                    + "\nSTR:\t" + vihu.getStr()
                    + "\nVIT:\t" + vihu.getVit()
                    + "\nLCK:\t" + vihu.getLck()
                    + "\nINTL:\t" + vihu.getIntl()
                    + "\nName:\t" + vihu.getNimi());
        } else {
            vihuStatsit.setText("No enemy around");
        }
    }

    private void luoPelaaja() {
        JTextField kuvateksti = new JTextField("Choose your character");
        kuvateksti.setEditable(false);
        JPanel kyssari = new JPanel(new BorderLayout());
        JPanel vastaukset = new JPanel(new BorderLayout());
        vastaukset.add("East", velho);
        vastaukset.add("West", soturi);
        kyssari.add("North", kuvateksti);
        kyssari.add("South", vastaukset);
        JPanel ylaosa = new JPanel();
        ylaosa.setPreferredSize(new Dimension(640, 240));
        kuvapaneeli.removeAll();
        kuvapaneeli.add("North", ylaosa);
        kuvapaneeli.add("South", kyssari);
//        lisaaTekstia("Hahmon valinta");

        soturi.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
//                        lisaaTekstia("Soturi valittu");
                        luo(false);
                    }
                });

        velho.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
//                        lisaaTekstia("Velho valittu");
                        luo(true);
                    }
                });


        while (!luotu) {
        }
    }

    private void luo(boolean velho) {
        if (velho) {
            pelaaja = new Pelaaja(d6.heitto(2), d6.heitto(2), d6.heitto(2), d6.heitto(2));
        } else {
            pelaaja = new Pelaaja(d6.heitto(3), d6.heitto(3), d6.heitto(2));
        }
//        lisaaTekstia("Hahmo luotu");
        hienosaato();
//        lisaaTekstia("Hienosaato loppui");
//        while(!saadetty){
//            
//        }
        luotu = true;


    }

    public void hienosaato() {
//        lisaaTekstia("Hienosaato alkoi");
        int pisteet = d6.heitto();
        int alkuStr = pelaaja.getStr();
        int alkuVit = pelaaja.getVit();
        int alkuLck = pelaaja.getLck();
        int alkuIntl = pelaaja.getIntl();

        JPanel strSaadot = new JPanel(new BorderLayout());
        strSaadot.add("North", strUp);
        strSaadot.add("South", strDown);
        JTextField str1 = new JTextField("STR:");
        str2 = new JTextField(String.valueOf(pelaaja.getStr()));
        JPanel str = new JPanel(new BorderLayout());
        str.add("West", str1);
        str.add("Center", str2);
        str.add("East", strSaadot);


        JPanel ylaosa = new JPanel();
        ylaosa.setPreferredSize(new Dimension(640, 120));
        kuvapaneeli.removeAll();
        kuvapaneeli.add("North", ylaosa);
        kuvapaneeli.add("Center", str);
        kuvapaneeli.add("South", lopetusNappi);

        strUp.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        pelaaja.addStr(1);
                        str2.setText(String.valueOf(pelaaja.getStr()));
                    }
                });

        lopetusNappi.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        setLopetus(true);
                    }
                });

//        while (!lopetus) {
//        }
//        saadetty=true;
    }

    private void setLopetus(boolean loppu) {
        lopetus = loppu;
    }

    private void hyokkaa(Hahmo kayttaja, Hahmo kohde) {

        int vahinko = kayttaja.getStr();
        lisaaTekstia("Attack!");

        if (d6.heitto(3) < kayttaja.getLck()) {
            vahinko = vahinko * 2;
            lisaaTekstia("Critical Hit!");

        }
        lisaaTekstia("Caused " + vahinko + "HP damage");
        kohde.addHP(-vahinko);
        paivitaStatsit();
    }

    private void vihunVuoro() {
        if (missa.getVihollinen().getHP() > 0) {
            hyokkaa(missa.getVihollinen(), pelaaja);
        }
    }

    private void vuoronJalkeen() {
        if (missa.getVihollinen().getHP() > 0) {
            vihunVuoro();
        } else if (pelaaja.getHP() > 0) {
            int expa = missa.getVihollinen().getMaxHP() + missa.getVihollinen().getMaxMP() + missa.getVihollinen().getLck();
            lisaaTekstia("You won! +" + expa + "XP");
            int lvl = pelaaja.getLvl();
            pelaaja.addExp(expa);
//            odota(500);
            if (pelaaja.getLvl() > lvl) {
                lisaaTekstia("Level up!");
            }
            missa.setVihollinen(null);
            if (missa.getBossi()) {
                gameOver(true);
            }
            huone();
        } else {
            gameOver(false);
        }
        if (pelaaja.getHP() <= 0) {
            gameOver(false);
        }
    }

    public void hyokkaysAnimaatio() {
//        lisaaTekstia("hyökkäysanimaatiota");
        for (int i = 0; i < 5; i++) {
            odota(50);
            kuvapaneeli.remove(vihulla);
            kuvapaneeli.add(kuva);
            kuvapaneeli.repaint();
            kuvapaneeli.revalidate();
//            this.pack();
            odota(50);
            kuvapaneeli.remove(kuva);
            kuvapaneeli.add(vihulla);
            kuvapaneeli.repaint();
            kuvapaneeli.revalidate();
//            this.pack();
        }
    }

    public void pelaa() {
//        HahmoGUI gener = new HahmoGUI(this);
//        pelaaja = gener.luoPelaaja();
        luoPelaaja();
        kuvapaneeli.removeAll();
        KarttaGeneraattori kartta = new KarttaGeneraattori();
        missa = kartta.luoLuolasto();

        mista = 0;

        Esine potion1 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine miekka = new Esine("Miekka", "STR:3", "Voima +3", true, false);
        Esine potion2 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        Esine potion3 = new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true);
        pelaaja.getInventory().addEsine(potion1);
        pelaaja.getInventory().addEsine(miekka);
        pelaaja.getInventory().addEsine(potion2);
        pelaaja.getInventory().addEsine(potion3);
        pelaaja.getInventory().addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));
        pelaaja.getInventory().addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));
        pelaaja.getInventory().addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));
        pelaaja.getInventory().addEsine(new Esine("Potion", "HP:20", "Palauttaa 20HP", false, true));

        Taika tulipallo = new Taika("Tulipallo", "Tuli", 2, 8);
        Taika vesipallo = new Taika("Vesipallo", "Vesi", 2, 8);
        ArrayList<String> tyypit = new ArrayList<>();
        tyypit.add("Tuli");
        tyypit.add("Vesi");
        Taika hoyry = new Taika("Höyryä", tyypit, 3, 6);
        pelaaja.getTaiat().add(tulipallo);
        pelaaja.getTaiat().add(vesipallo);
        pelaaja.getTaiat().add(hoyry);


//        lisaaTekstia("Testitekstiä");

        ylos.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        meneYlos();
                    }
                });

        vasen.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        meneVasen();
                    }
                });

        oikea.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        meneOikea();
                    }
                });

        alas.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        meneAlas();
                    }
                });

        attack.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        hyokkaa(pelaaja, missa.getVihollinen());
//                        hyokkaysAnimaatio();
                        vuoronJalkeen();

                    }
                });

        run.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent tapahtuma) {
                pako(huoneet);
            }
        });

        item.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent tapahtuma) {
                if (!esineet) {
                    String[] data = new String[pelaaja.getInventory().getEsineet().size()];
                    for (int i = 0; i < data.length; i++) {
                        data[i] = pelaaja.getInventory().getEsineet().get(i).nimi + ": " + pelaaja.getInventory().getEsineet().get(i).getKuvaus();
                        if (pelaaja.getInventory().getEsineet().get(i).getEquiped()) {
                            data[i] = data[i] + " (equipped)";
                        }
                    }

                    esineList = new JList(data); //data has type Object[]
                    esineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    esineList.setLayoutOrientation(JList.VERTICAL);
                    esineList.setVisibleRowCount(-1);
                    esineListScroller = new JScrollPane(esineList);
                    esineListScroller.setPreferredSize(new Dimension(180, 80));
                    esineValikko = new JPanel(new BorderLayout());
                    esineValikko.add("West", esineListScroller);
                    esineValikko.add("East", useEsine);
                    if (taiat) {
                        alakerta.remove(taikaValikko);
                    } else {
                        alakerta.remove(rullaus);
                    }
                    alakerta.add("Center", esineValikko);
                    alakerta.updateUI();
                    taiat = false;
                    esineet = true;
                    esineList.addListSelectionListener(new ListSelectionListener() {

                        public void valueChanged(ListSelectionEvent e) {
                            if (e.getValueIsAdjusting() == false) {

                                if (esineList.getSelectedIndex() == -1) {
                                    //No selection, disable fire button.
                                    useEsine.setEnabled(false);

                                } else {
                                    //Selection, enable the fire button.
                                    useEsine.setEnabled(true);
                                }
                            }
                        }
                    });
                } else {
                    alakerta.remove(esineValikko);
                    alakerta.add("Center", rullaus);
                    alakerta.updateUI();
                    esineet = false;
                }
            }
        });

        useEsine.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent tapahtuma) {
                if (esineList.getSelectedIndex() > -1) {
                    EsineTulkki tulkki = new EsineTulkki(pelaaja);
                    Esine valittu = pelaaja.getInventory().getEsineet().get(esineList.getSelectedIndex());
                    if (valittu.getConsumable() && !valittu.getConsumed()) {
                        tulkki.consume(valittu);
                        lisaaTekstia("You consumed " + valittu.getNimi());
                        pelaaja.getInventory().getEsineet().remove(valittu);
                    }
                    if (valittu.getEquipable()) {
                        if (!valittu.getEquiped()) {
                            tulkki.equip(valittu);
                            lisaaTekstia("You equipped " + valittu.getNimi());
                        } else {
                            tulkki.unEquip(valittu);
                            lisaaTekstia("You unequipped " + valittu.getNimi());
                        }
                    }
                    alakerta.remove(esineValikko);
                    alakerta.add("Center", rullaus);
                    alakerta.updateUI();
                    esineet = false;
                    paivitaStatsit();
                    if (attack.isEnabled()) {
                        vihunVuoro();
                    }
                }
            }
        });

        magic.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent tapahtuma) {
                if (!taiat) {
//                    lisaaTekstia("Data alkaa");
                    String[] data = new String[pelaaja.getTaiat().size()];
                    for (int i = 0; i < data.length; i++) {
//                        lisaaTekstia("Data" + i);
                        data[i] = pelaaja.getTaiat().get(i).getNimi() + ": " + pelaaja.getTaiat().get(i).getHinta() + " MP";

                    }
//                    lisaaTekstia("Data luotu");

                    taikaList = new JList(data); //data has type Object[]
                    taikaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    taikaList.setLayoutOrientation(JList.VERTICAL);
                    taikaList.setVisibleRowCount(-1);
                    taikaListScroller = new JScrollPane(taikaList);
                    taikaListScroller.setPreferredSize(new Dimension(180, 80));
                    taikaValikko = new JPanel(new BorderLayout());
                    taikaValikko.add("West", taikaListScroller);
                    taikaValikko.add("East", useTaika);

                    if (esineet) {
                        alakerta.remove(esineValikko);
                    } else {
                        alakerta.remove(rullaus);
                    }
                    alakerta.add("Center", taikaValikko);
                    alakerta.updateUI();
                    taiat = true;
                    esineet = false;
                    taikaList.addListSelectionListener(new ListSelectionListener() {

                        public void valueChanged(ListSelectionEvent e) {
                            if (e.getValueIsAdjusting() == false) {

                                if (taikaList.getSelectedIndex() == -1) {
                                    //No selection, disable fire button.
                                    useTaika.setEnabled(false);

                                } else {
                                    //Selection, enable the fire button.
                                    useTaika.setEnabled(true);
                                }
                            }
                        }
                    });
                } else {
                    alakerta.remove(taikaValikko);
                    alakerta.add("Center", rullaus);
                    alakerta.updateUI();
                    taiat = false;
                }
            }
        });

        useTaika.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent tapahtuma) {
                if (taikaList.getSelectedIndex() > -1) {
                    Taika taika = pelaaja.getTaiat().get(taikaList.getSelectedIndex());
                    alakerta.remove(taikaValikko);
                    alakerta.add("Center", rullaus);
                    alakerta.updateUI();
                    taiat = false;
                    if (pelaaja.getMP() >= taika.getHinta()) {
                        pelaaja.addMP(-taika.getHinta());
                        int vahinko = taika.getTeho();
                        ArrayList<String> weakness = missa.getVihollinen().getWeak();
                        for (int i = 0; i < weakness.size(); i++) {
                            if (taika.getTyyppi().contains(weakness.get(i))) {
                                vahinko = vahinko * 2;
                            }
                        }
                        lisaaTekstia("Player used " + taika.getNimi());
//                    odota(500);
                        if (d6.heitto(3) < pelaaja.getLck()) {
                            vahinko = vahinko * 2;
                            lisaaTekstia("Critical Hit!");
//                        odota(500);
                        }
                        missa.getVihollinen().addHP(-vahinko);
                        lisaaTekstia("Caused " + vahinko + "HP damage");
//                        hyokkaysAnimaatio();
                        vuoronJalkeen();
                    } else {
                        lisaaTekstia("Not enough MP!");
                    }
                    paivitaStatsit();
                }
            }
        });


        huone();
    }
}
