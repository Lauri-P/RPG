
public class Huone {

    boolean bossi;
    boolean kauppa;
    Arkku arkku;
    Vihollinen vihollinen;
    Huone pohjoinen;
    Huone ita;
    Huone etela;
    Huone lansi;

    public Huone() {
        bossi = false;
        kauppa = false;
        arkku = null;
        vihollinen = null;
        pohjoinen = null;
        ita = null;
        lansi = null;
        etela = null;
    }
    
    public boolean getBossi(){
        return bossi;
    }
    
    public boolean getKauppa(){
        return kauppa;
    }
    
    public Arkku getArkku(){
        return arkku;
    }
    
    public Vihollinen getVihollinen(){
        return vihollinen;
    }
    
    public Huone getPohjoinen(){
        return pohjoinen;
    }
    
    public Huone getIta(){
        return ita;
    }
    
    public Huone getEtela(){
        return etela;
    }
    
    public Huone getLansi(){
        return lansi;
    }
    
    public void setBossi(boolean onko){
        bossi=onko;
    }
    
    public void setKauppa(boolean onko){
        kauppa=onko;
    }
    
    public void setVihollinen(Vihollinen vihu){
        vihollinen=vihu;
    }
    
    public void setArkku(Arkku loota){
        arkku=loota;
    }
    
    public void setPohjoinen(Huone huone){
        pohjoinen=huone;
    }
    
    public void setIta(Huone huone){
        ita=huone;
    }
    
    public void setEtela(Huone huone){
        etela=huone;
    }
    
    public void setLansi(Huone huone){
        lansi=huone;
    }
}
