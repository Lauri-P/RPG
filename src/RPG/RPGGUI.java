package RPG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

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

    public RPGGUI() {
        kuva = new JLabel();
        kuvapaneeli = new JPanel();
        kuvapaneeli.setPreferredSize(new Dimension(640, 480));
        kompassi = new JLabel();
        kompassipaneeli = new JPanel();
        d6 = new Noppa();
        luotu = false;
        saadetty = false;
        lopetus = false;
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

        JPanel alakerta = new JPanel(new BorderLayout());
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

    private void huoneenValinta(String huoneet) {
        kuvapaneeli.removeAll();
        String polku = missa.getKuva(mista);
        lisaaTekstia("Saatiin polku " + polku);
        kuva = new JLabel(new ImageIcon(polku));
        if (mista != 0) {
            if (huoneet.length() <= 1) {
                kuva = new JLabel(new ImageIcon("Kuvat\\Huone0.png"));
            }
            if (huoneet.length() == 2) {
                if (mista == 1) {
                    if (huoneet.indexOf('2') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('3') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('4') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                    }
                }
                if (mista == 2) {
                    if (huoneet.indexOf('3') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('4') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('1') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                    }
                }
                if (mista == 3 || mista == 0) {
                    if (huoneet.indexOf('4') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('1') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('2') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                    }
                }
                if (mista == 4) {
                    if (huoneet.indexOf('1') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                    }
                    if (huoneet.indexOf('2') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                    }
                    if (huoneet.indexOf('3') > -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                    }
                }
            }

            if (huoneet.length() == 3) {
                if (mista == 1) {
                    if (huoneet.indexOf('2') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('3') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('4') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                    }
                }
                if (mista == 2) {
                    if (huoneet.indexOf('3') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('4') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('1') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                    }
                }
                if (mista == 3) {
                    if (huoneet.indexOf('4') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('1') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('2') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                    }
                }
                if (mista == 4) {
                    if (huoneet.indexOf('1') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                    }
                    if (huoneet.indexOf('2') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                    }
                    if (huoneet.indexOf('3') == -1) {
                        kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                    }
                }
            }
            if (huoneet.length() == 4) {
                kuva = new JLabel(new ImageIcon("Kuvat\\Huone3.png"));
            }
        } else {
            if (huoneet.length() == 1) {
                if (huoneet.indexOf('4') > -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone1v.png"));
                }
                if (huoneet.indexOf('1') > -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone1k.png"));
                }
                if (huoneet.indexOf('2') > -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone1o.png"));
                }
            }
            if (huoneet.length() == 2) {
                if (huoneet.indexOf('4') == -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone2v.png"));
                }
                if (huoneet.indexOf('1') == -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone2k.png"));
                }
                if (huoneet.indexOf('2') == -1) {
                    kuva = new JLabel(new ImageIcon("Kuvat\\Huone2o.png"));
                }
            }
            if (huoneet.length() == 3) {
                kuva = new JLabel(new ImageIcon("Kuvat\\Huone3.png"));
            }
        }
        kuvapaneeli.add(kuva);
        kuva.revalidate();
    }

    private void huoneessaArkku() {
        if (missa.getArkku() != null && missa.getArkku().getEsineet().size() > 0) {
            lisaaTekstia("There is chest in room.");
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
//        taistelu.setTitle("RPG");
//        taistelu.pack();
//        taistelu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        taistelu.setVisible(true);
//        taistelu.taistelu();


    }

    private void taistelunJalkeen(String huoneet) {
        if (pelaaja.getHP() <= 0) {
            gameOver(false);
        } else if (missa.getVihollinen().getHP() <= 0) {
            int expa = missa.getVihollinen().getMaxHP() + missa.getVihollinen().getMaxMP() + missa.getVihollinen().getLck();
            lisaaTekstia("Voitit! +" + expa + "XP");
            int lvl = pelaaja.getLvl();
            pelaaja.addExp(expa);
            odota(500);
            if (pelaaja.getLvl() > lvl) {
                lisaaTekstia("Level up!");
            }
            missa.setVihollinen(null);
            if (missa.getBossi()) {
                gameOver(true);
            }
        } else {
            if (missa.getBossi()) {
                gameOver(true);
            }
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

                RPGGUI gui = new RPGGUI();
                gui.setTitle("RPG");
                gui.pack();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setVisible(true);
                gui.pelaa();
            }
            System.exit(0);
        }
        if (JOptionPane.showConfirmDialog(null, "You died! Retry?") == 0) {
            pelaa();

            RPGGUI gui = new RPGGUI();
            gui.setTitle("RPG");
            gui.pack();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setVisible(true);
            gui.pelaa();
        }
        System.exit(0);
    }

    private void huone() {
        paivitaStatsit();
        kompassinValinta();
        String huoneet = "";
        huoneet = keraaHuoneet(huoneet);
        huoneenValinta(huoneet);
        suunta();
        if (missa.getVihollinen() != null) {
            taistelu();
            taistelunJalkeen(huoneet);
            paivitaStatsit();
        }
        huoneessaArkku();

        attack.setEnabled(false);
        magic.setEnabled(false);
        run.setEnabled(false);
        nuolet(huoneet);
        paivitaStatsit();
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
            huone();
        }
        if (valinta == '2') {
            missa = missa.getIta();
            mista = 4;
            huone();
        }
        if (valinta == '3') {
            missa = missa.getEtela();
            mista = 1;
            huone();
        }
        if (valinta == '4') {
            missa = missa.getLansi();
            mista = 2;
            huone();
        }
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
        huone();
    }

    private void meneVasen() {
        Huone mihin = missa;
        int suunnasta = mista;
        if (mista == 0 || mista == 3) {
            suunnasta = 2;
            mihin = missa.getLansi();
            huone();
        }
        if (mista == 4) {
            suunnasta = 3;
            mihin = missa.getPohjoinen();
            huone();
        }
        if (mista == 1) {
            suunnasta = 4;
            mihin = missa.getIta();
            huone();
        }
        if (mista == 2) {
            suunnasta = 1;
            mihin = missa.getEtela();
            huone();
        }

        setMista(suunnasta);
        setMissa(mihin);
        huone();
    }

    private void meneOikea() {
        Huone mihin = missa;
        int suunnasta = mista;
        if (mista == 0 || mista == 3) {
            suunnasta = 4;
            mihin = missa.getIta();
            huone();
        }
        if (mista == 4) {
            suunnasta = 1;
            mihin = missa.getEtela();
            huone();
        }
        if (mista == 1) {
            suunnasta = 2;
            mihin = missa.getLansi();
            huone();
        }
        if (mista == 2) {
            suunnasta = 3;
            mihin = missa.getPohjoinen();
            huone();
        }

        setMista(suunnasta);
        setMissa(mihin);
        huone();
    }

    private void meneAlas() {
        Huone mihin = missa;
        int suunnasta = mista;
        if (mista == 0 || mista == 3) {
            suunnasta = 1;
            mihin = missa.getEtela();
            huone();
        }
        if (mista == 4) {
            suunnasta = 2;
            mihin = missa.getLansi();
            huone();
        }
        if (mista == 1) {
            suunnasta = 3;
            mihin = missa.getPohjoinen();
            huone();
        }
        if (mista == 2) {
            suunnasta = 4;
            mihin = missa.getIta();
            huone();
        }

        setMista(suunnasta);
        setMissa(mihin);
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
        lisaaTekstia("Hahmon valinta");

        soturi.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        lisaaTekstia("Soturi valittu");
                        luo(false);
                    }
                });

        velho.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        lisaaTekstia("Velho valittu");
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
        lisaaTekstia("Hahmo luotu");
//        hienosaato();
        luotu = true;


    }

    public void hienosaato() {
        lisaaTekstia("Hienosaato alkoi");
        int pisteet = d6.heitto();
        int alkuStr = pelaaja.getStr();
        int alkuVit = pelaaja.getVit();
        int alkuLck = pelaaja.getLck();
        int alkuIntl = pelaaja.getIntl();

        JPanel strSaadot = new JPanel(new BorderLayout());
        strSaadot.add("North", strUp);
        strSaadot.add("South", strDown);
        JTextField str1 = new JTextField("STR:");
        str2 = new JTextField(pelaaja.getStr());
        JPanel str = new JPanel(new BorderLayout());
        str.add("West", str1);
        str.add("Center", str2);
        str.add("East", strSaadot);


        JPanel ylaosa = new JPanel();
        ylaosa.setPreferredSize(new Dimension(640, 120));
        kuvapaneeli.removeAll();
        kuvapaneeli.add("North", ylaosa);
        kuvapaneeli.add("Center", str);

        strUp.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        pelaaja.addStr(1);
                        str2.setText("" + pelaaja.getStr());
                    }
                });

        while (!lopetus) {
        }
    }

    public void pelaa() {
//        HahmoGUI gener = new HahmoGUI(this);
//        pelaaja = gener.luoPelaaja();
        luoPelaaja();

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


        lisaaTekstia("Testitekstiä");

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

        huone();
    }
}
