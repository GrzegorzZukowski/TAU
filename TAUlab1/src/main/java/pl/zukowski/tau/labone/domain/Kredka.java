package pl.zukowski.tau.labone.domain;


import java.time.LocalDateTime;

public class Kredka {
    int Id;
    String NazwaKoloru;
    String Twardosc;


    LocalDateTime AddTimeMark;
    LocalDateTime UpdateTimeMark;
    LocalDateTime ReadTimeMark;


    public Kredka() {
    }

    public Kredka(int id, String nazwaKoloru) {
        Id = id;
        NazwaKoloru = nazwaKoloru;
    }

    public Kredka(int id, String nazwaKoloru, String twardosc){
        Id= id;
        NazwaKoloru= nazwaKoloru;
        Twardosc= twardosc;
    }

    public Kredka (int id, String nazwaKoloru, String twardosc, LocalDateTime addTimeMark,
                   LocalDateTime updateTimeMark, LocalDateTime readTimeMark){
        Id= id;
        NazwaKoloru= nazwaKoloru;
        Twardosc= twardosc;
        AddTimeMark = addTimeMark;
        UpdateTimeMark= updateTimeMark;
        ReadTimeMark = readTimeMark;
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
    public LocalDateTime getAddTimeMark() {
        return AddTimeMark;
    }

    public LocalDateTime getUpdateTimeMark() {
        return UpdateTimeMark;
    }

    public LocalDateTime getReadTimeMark() {
        return ReadTimeMark;
    }

    public void setAddTimeMark(LocalDateTime addTimeMark) {
        AddTimeMark = addTimeMark;
    }

    public void setUpdateTimeMark(LocalDateTime updateTimeMark) {
        UpdateTimeMark = updateTimeMark;
    }

    public void setReadTimeMark(LocalDateTime readTimeMark) {
        ReadTimeMark = readTimeMark;
    }

}
