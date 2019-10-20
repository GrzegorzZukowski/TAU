package pl.zukowski.tau.labone.domain;

import java.time.LocalDate;
import java.util.Date;

public class Kredka {

	int Id;
	String NazwaKoloru;
	LocalDate DataDodaniaDoBazy;
	LocalDate DataOstatniejModyfikacji;
	LocalDate DataOstatniegoOdczytu;

	public Kredka() {
		
	}

	public Kredka(int id, String nazwaKoloru, LocalDate dataDodaniaDoBazy, LocalDate dataOstatniejModyfikacji, LocalDate dataOstatniegoOdczytu) {
		Id = id;
		NazwaKoloru = nazwaKoloru;
		DataDodaniaDoBazy = dataDodaniaDoBazy;
		DataOstatniejModyfikacji = dataOstatniejModyfikacji;
		DataOstatniegoOdczytu = dataOstatniegoOdczytu;
	}

	public Kredka(int id, String nazwaKoloru) {
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

	public LocalDate getDataDodaniaDoBazy() {
		return DataDodaniaDoBazy;
	}

	public void setDataDodaniaDoBazy(LocalDate dataDodaniaDoBazy) {
		DataDodaniaDoBazy = dataDodaniaDoBazy;
	}

	public LocalDate getDataOstatniejModyfikacji() {
		return DataOstatniejModyfikacji;
	}

	public void setDataOstatniejModyfikacji(LocalDate dataOstatniejModyfikacji) {
		DataOstatniejModyfikacji = dataOstatniejModyfikacji;
	}

	public LocalDate getDataOstatniegoOdczytu() {
		return DataOstatniegoOdczytu;
	}

	public void setDataOstatniegoOdczytu(LocalDate dataOstatniegoOdczytu) {
		DataOstatniegoOdczytu = dataOstatniegoOdczytu;
	}

}
