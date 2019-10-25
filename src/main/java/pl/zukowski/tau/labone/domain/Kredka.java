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
}
