
public class Noppa {

    private int sivut;

    public Noppa() {
        sivut = 6;
    }

    public Noppa(int sivut) {
        if (sivut > 0) {
            this.sivut = sivut;
        } else {
            this.sivut = 6;
        }
    }

    public int heitto() {
        return (int) (Math.random() * sivut) + 1;
    }

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

    public int getSivut() {
        return sivut;
    }

    public void setSivut(int sivut) {
        this.sivut = sivut;
    }
}
