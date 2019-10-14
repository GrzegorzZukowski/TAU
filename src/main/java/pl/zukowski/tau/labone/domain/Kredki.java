package pl.zukowski.tau.labone.domain;

public class Kredki {
    int Id;
    String NazwaKoloru;

    public Kredki() {
    }

    public Kredki(int id, String nazwaKoloru) {
        Id = id;
        NazwaKoloru = nazwaKoloru;
    }

    public int getId() {
        return Id;
    }

    public String getNazwaKoloru() {
        return NazwaKoloru;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNazwaKoloru(String nazwaKoloru) {
        NazwaKoloru = nazwaKoloru;
    }
}
