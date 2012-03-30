
import java.util.ArrayList;

public class Taika {

    private String nimi;
    private ArrayList<String> tyyppi;
    private int hinta;
    private int teho;

    public Taika(String nimi, ArrayList<String> tyyppi, int hinta, int teho) {
        this.nimi = nimi;
        this.tyyppi = tyyppi;
        this.hinta = hinta;
        this.teho = teho;
    }

    public Taika(String nimi, String tyyppi, int hinta, int teho) {
        this.nimi = nimi;
        this.tyyppi=new ArrayList<>();
        this.tyyppi.add(tyyppi);
        this.hinta = hinta;
        this.teho = teho;
    }

    public String getNimi() {
        return nimi;
    }

    public ArrayList<String> getTyyppi() {
        return tyyppi;
    }

    public int getHinta() {
        return hinta;
    }

    public int getTeho() {
        return teho;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setTyyppi(ArrayList<String> tyyppi) {
        this.tyyppi = tyyppi;
    }

    public void setHinta(int hinta) {
        this.hinta = hinta;
    }

    public void setTeho(int teho) {
        this.teho = teho;
    }

    public void addTyyppi(String tyyppi) {
        this.tyyppi.add(tyyppi);
    }
}
