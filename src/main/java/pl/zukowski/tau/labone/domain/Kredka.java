package pl.zukowski.tau.labone.domain;


public class Kredka {
    int Id;
    String NazwaKoloru;

    TimeStamp DodanieDoBazy;
    TimeStamp OstatniaModyfikacja;
    TimeStamp OstatniOdczyt;

    public Kredka() {
    }

    public Kredka(int id, String nazwaKoloru) {
        Id = id;
        NazwaKoloru = nazwaKoloru;
    }

    public Kredka(int id, String nazwaKoloru, TimeStamp dodanieDoBazy, TimeStamp ostatniaModyfikacja, TimeStamp ostatniOdczyt){
    	Id = id;
    	NazwaKoloru = nazwaKoloru;
    	DodanieDoBazy = dodanieDoBazy;
    	OstatniaModyfikacja = ostatniaModyfikacja;
    	OstatniOdczyt = ostatniOdczyt;
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

    public void setDodanieDoBazy(TimeStamp dodanieDoBazy) {
        DodanieDoBazy = dodanieDoBazy;
    }

    public void setOstatniaModyfikacja(TimeStamp ostatniaModyfikacja) {
        OstatniaModyfikacja = ostatniaModyfikacja;
    }

    public void setOstatniOdczyt(TimeStamp ostatniOdczyt) {
        OstatniOdczyt = ostatniOdczyt;
    }

    public TimeStamp getDodanieDoBazy() {
        return DodanieDoBazy;
    }

    public TimeStamp getOstatniaModyfikacja() {
        return OstatniaModyfikacja;
    }

    public TimeStamp getOstatniOdczyt() {
        return OstatniOdczyt;
    }


}
