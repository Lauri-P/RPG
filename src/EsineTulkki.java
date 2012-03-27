
public class EsineTulkki {

    Hahmo kohde;

    private void toteuta(String ominaisuus) {
        String[] toteutettava = ominaisuus.split(":");

        if (toteutettava[0].equalsIgnoreCase("STR")) {
            kohde.addStr(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("VIT")) {
            kohde.addVit(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("LCK")) {
            kohde.addLck(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("INTL")) {
            kohde.addIntl(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("HP")) {
            kohde.addHP(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("MP")) {
            kohde.addMP(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("MAXHP")) {
            kohde.addMaxHP(Integer.parseInt(toteutettava[1]));
        } else if (toteutettava[0].equalsIgnoreCase("MAXMP")) {
            kohde.addMaxMP(Integer.parseInt(toteutettava[1]));
        }
    }

    private void peru(String ominaisuus) {
        String[] peruttava = ominaisuus.split(":");
        toteuta(peruttava[0] + (-(Integer.parseInt(peruttava[1]))));
    }

    public EsineTulkki(Hahmo kohde) {
        this.kohde = kohde;
    }

    public void consume(Esine esine) {
        if (esine.getConsumable() && !esine.getConsumed()) {
            String[] ominaisuudet = esine.getOminaisuudet().split(",");
            for (int i = 0; i < ominaisuudet.length; i++) {
                toteuta(ominaisuudet[i]);
            }
            esine.setConsumed(true);
        }
    }

    public void equip(Esine esine) {
        if (esine.getEquipable() && !esine.getEquiped()) {
            String[] ominaisuudet = esine.getOminaisuudet().split(",");
            for (int i = 0; i < ominaisuudet.length; i++) {
                toteuta(ominaisuudet[i]);
            }
            esine.setEquiped(true);
        }
    }

    public void unEquip(Esine esine) {
        if (esine.getEquipable() && esine.getEquiped()) {
            String[] ominaisuudet = esine.getOminaisuudet().split(",");
            for (int i = 0; i < ominaisuudet.length; i++) {
                peru(ominaisuudet[i]);
            }
            esine.setEquiped(false);
        }
    }
}
