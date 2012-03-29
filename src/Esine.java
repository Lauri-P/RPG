
public class Esine {

    boolean equipable;
    boolean equiped;
    boolean consumable;
    boolean consumed;
    String nimi;
    String ominaisuudet;
    String kuvaus;

    public Esine() {

        equipable = false;
        equiped = false;
        consumable = false;
        consumed = false;
        nimi = "EI NIMEÄ";
        ominaisuudet = "";
        kuvaus = "EI KUVAUSTA";

    }

    public Esine(String nimi, String ominaisuudet, boolean equipable, boolean consumable) {

        this.equipable = equipable;
        equiped = false;
        this.consumable = consumable;
        consumed = false;
        this.nimi = nimi;
        this.ominaisuudet = ominaisuudet;
        kuvaus = "EI KUVAUSTA";
    }

    public Esine(String nimi, String ominaisuudet, String kuvaus, boolean equipable, boolean consumable) {
        this.equipable = equipable;
        equiped = false;
        this.consumable = consumable;
        consumed = false;
        this.nimi = nimi;
        this.ominaisuudet = ominaisuudet;
        this.kuvaus = kuvaus;
    }

    public String getNimi() {
        return nimi;
    }

    public String getOminaisuudet() {
        return ominaisuudet;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public boolean getConsumable() {
        return consumable;
    }

    public boolean getConsumed() {
        return consumed;
    }

    public boolean getEquipable() {
        return equipable;
    }

    public boolean getEquiped() {
        return equiped;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setOminaisuudet(String ominaisuudet) {//Ominaisuudet kirjataan muodossa "STA1:INT1,STA2:INT2,...,STAi:INTi", jossa STAi on status, johon halutaan vaikuttaa ja INTi on vaikutuksen suuruus. Esim "STR:3,HP:-6" lisää voimaa kolmella ja vähentä HP:itä kuudella
        this.ominaisuudet = ominaisuudet;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public void setEquipable(boolean equipable) {
        this.equipable = equipable;
    }

    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }
}
