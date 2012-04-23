
package RPG;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HahmoGUI extends JFrame{
    
    private RPGGUI gui;
    private JButton velho=new JButton("Wizard");
    private JButton soturi=new JButton("Warrior");
    private JButton strUp=new JButton("+");
    private JButton strDown=new JButton("-");
    private JButton vitUp=new JButton("+");
    private JButton vitDown=new JButton("-");
    private JButton lckUp=new JButton("+");
    private JButton lckDown=new JButton("-");
    private JButton intlUp=new JButton("+");
    private JButton intlDown=new JButton("-");
    JTextField str2;
    Pelaaja pelaaja;
    Noppa d6;
    boolean luotu;
    boolean saadetty;
    boolean lopetus;
    
    public HahmoGUI(RPGGUI gui){
        d6=new Noppa();
        this.gui=gui;
        luotu=false;
        saadetty=false;
        lopetus=false;
    }
    
    private void luo(boolean velho){
        if(velho){
            pelaaja = new Pelaaja(d6.heitto(2), d6.heitto(2), d6.heitto(2), d6.heitto(2));
        }else{
            pelaaja = new Pelaaja(d6.heitto(3), d6.heitto(3), d6.heitto(2));
        }
//        hienosaato();
//        while(!saadetty){
//            
//        }
        luotu=true;
    }
    
    private void hienosaato(){
        int pisteet=d6.heitto();
        int alkuStr=pelaaja.getStr();
        int alkuVit=pelaaja.getVit();
        int alkuLck=pelaaja.getLck();
        int alkuIntl=pelaaja.getIntl();
        
        JPanel strSaadot=new JPanel(new BorderLayout());
        strSaadot.add("North", strUp);
        strSaadot.add("South", strDown);
        JTextField str1=new JTextField("STR:");
        str2=new JTextField(pelaaja.getStr());
        JPanel str=new JPanel(new BorderLayout());
        str.add("West", str1);
        str.add("Center", str2);
        str.add("East", strSaadot);
        
        
        JPanel ylaosa=new JPanel();
        ylaosa.setPreferredSize(new Dimension(640, 120));
        gui.kuvapaneeli.removeAll();
        gui.kuvapaneeli.add("North", ylaosa);
        gui.kuvapaneeli.add("Center", str);
        
        strUp.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        pelaaja.addStr(1);
                        str2.setText(""+pelaaja.getStr());
                    }
                });
        
        while(!lopetus){
            
        }
    }
    
    public Pelaaja getPelaaja(){
        return pelaaja;
    }
    
    public Pelaaja luoPelaaja(){
        JTextField teksti=new JTextField("Choose your character");
        teksti.setEditable(false);
        JPanel kyssari=new JPanel(new BorderLayout());
        JPanel vastaukset=new JPanel(new BorderLayout());
        vastaukset.add("East", velho);
        vastaukset.add("West", soturi);
        kyssari.add("North", teksti);
        kyssari.add("South", vastaukset);
        JPanel ylaosa=new JPanel();
        ylaosa.setPreferredSize(new Dimension(640, 240));
        gui.kuvapaneeli.removeAll();
        gui.kuvapaneeli.add("North", ylaosa);
        gui.kuvapaneeli.add("South", kyssari);
        
        soturi.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        luo(false);
                    }
                });
        
        velho.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        luo(true);
                    }
                });
        
        
        while(!luotu){
            
        }
        return pelaaja;
    }
    
}
