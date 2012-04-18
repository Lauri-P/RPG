package RPG;


/**
 * Luokka nopan tavoin toimivalle satunnaislukugeneraattorille
 * @author Lauri
 */
public class Noppa {

    private int sivut;

    /**
     * Konstruktori perinteiselle, kuusisivuiselle nopalle
     */
    public Noppa() {
        sivut = 6;
    }

    /**
     * Konstruktori nopalle, jonka sivujen määrä määritellään paremetrissa
     * @param sivut Nopan sivujen lukumäärä
     */
    public Noppa(int sivut) {
        if (sivut > 0) {
            this.sivut = sivut;
        } else {
            this.sivut = 6;
        }
    }

    /**
     * Heittää noppaa ja palauttaa saadun arvon
     * @return Palauttaa heiton tuloksen
     */
    public int heitto() {
        return (int) (Math.random() * sivut) + 1;
    }

    /**
     * Heittää noppaa parametrina annetun luvun verran ja palauttaa silmälukujen summan. Negatiiviset parametrit palauttaa summan negatiivisenä
     * @param kerrat Montako kertaa noppaa heitetään
     * @return Heittokertojen silmälukujen summa
     */
    public int heitto(int kerrat) {
        int kerroin = 1;
        if (kerrat < 0) {
            kerroin = -1;
        }
        int summa = 0;
        for (int i = 0; i < kerroin * kerrat; i++) {
            summa += heitto();
        }
        return kerroin * summa;
    }

    /**
     * 
     * @return Palauttaa nopan sivujen lukumäärän
     */
    public int getSivut() {
        return sivut;
    }

    /**
     * Asettaa nopan sivujen lukumääräksi annetun parametrin arvon
     * @param sivut Nopan sivujen lukumäärä
     */
    public void setSivut(int sivut) {
        this.sivut = sivut;
    }
}
