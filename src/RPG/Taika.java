package RPG;


import java.util.ArrayList;

/**
 * Taiat vahingoittavat vihollisia ja niitten tyyppi voi tuoda lisätehoa joitakin vihollisia vastaan. Tait kuluttavat MP:tä
 * @author Lauri
 */
public class Taika {

    private String nimi;
    private ArrayList<String> tyyppi;
    private int hinta;
    private int teho;

    /**
     * Konstruktori taialle jolla on annetut parametrit
     * @param nimi Taian nimi
     * @param tyyppi Lista taian tyypeistä
     * @param hinta Taian hinta
     * @param teho Taian teho
     */
    public Taika(String nimi, ArrayList<String> tyyppi, int hinta, int teho) {
        this.nimi = nimi;
        this.tyyppi = tyyppi;
        this.hinta = hinta;
        this.teho = teho;
    }

    /**
     * Konstruktori taialle jolla on annetut parametrit
     * @param nimi Taian nimi
     * @param tyyppi Taian tyyppi
     * @param hinta Taian hinta
     * @param teho Taian teho
     */
    public Taika(String nimi, String tyyppi, int hinta, int teho) {
        this.nimi = nimi;
        this.tyyppi = new ArrayList<>();
        this.tyyppi.add(tyyppi);
        this.hinta = hinta;
        this.teho = teho;
    }

    /**
     * 
     * @return Palauttaa taian nimen
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * 
     * @return Palauttaa listan taian tyypeistä
     */
    public ArrayList<String> getTyyppi() {
        return tyyppi;
    }

    /**
     * 
     * @return Palauttaa taian hinnan
     */
    public int getHinta() {
        return hinta;
    }

    /**
     * 
     * @return Palauttaa taian tehon
     */
    public int getTeho() {
        return teho;
    }

    /**
     * Asettaa taian nimeksi parametrina annetun arvon
     * @param nimi Uusi taian nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Asettaa taian tyypeiksi annetun parametrin tyypit
     * @param tyyppi Uusi lista taian tyypeistä
     */
    public void setTyyppi(ArrayList<String> tyyppi) {
        this.tyyppi = tyyppi;
    }

    /**
     * Asettaa taian hinnaksi parametrina annetun arvon
     * @param hinta Uusi taian hinta
     */
    public void setHinta(int hinta) {
        this.hinta = hinta;
    }

    /**
     * Asettaa taian tehoksi parametrina annetun arvon
     * @param teho Uusi Taian teho
     */
    public void setTeho(int teho) {
        this.teho = teho;
    }

    /**
     * Lisää taian tyyppeihin parametrinä annetun arvon
     * @param tyyppi Lisättävä tyyppi
     */
    public void addTyyppi(String tyyppi) {
        this.tyyppi.add(tyyppi);
    }
}
