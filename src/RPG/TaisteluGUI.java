
package RPG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class TaisteluGUI extends JFrame{

    RPGGUI gui;
    Noppa d6;
    boolean vuoro;
    Pelaaja pelaaja;
    Vihollinen vihu;
    
    public TaisteluGUI(RPGGUI gui){
        this.gui=gui;
        d6=new Noppa();
        vuoro=true;
        
    }
    
    public void taistelu(){
        vuoro=true;
        vihu=gui.missa.getVihollinen();
        pelaaja=gui.pelaaja;
        while(vihu.getHP()>0&&pelaaja.getHP()>0){
            
            gui.attack.addActionListener(
        new ActionListener() {

                    public void actionPerformed(ActionEvent tapahtuma) {
                        if(vuoro){
                            hyokkaa(pelaaja, vihu);
                        }
                    }
                });
            
            if (!vuoro){
                hyokkaa(vihu, pelaaja);
            }
            
        }
    }
    
    private void hyokkaa(Hahmo kayttaja, Hahmo kohde) {

        int vahinko = kayttaja.getStr();
        gui.lisaaTekstia("Attack!");
        
        if (d6.heitto(3) < kayttaja.getLck()) {
            vahinko = vahinko * 2;
            gui.lisaaTekstia("Critical Hit!");
            
        }
        gui.lisaaTekstia("Caused "+vahinko+"HP damage");
        kohde.addHP(-vahinko);
        vuoro = false;
    }
    
}
