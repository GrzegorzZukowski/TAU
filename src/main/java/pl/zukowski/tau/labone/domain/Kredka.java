package pl.zukowski.tau.labone.domain;

import java.util.Date;

public class Kredka {

	int Id;
	String NazwaKoloru;
	Date DataDodaniaDoBazy;
	Date DataOstatniejModyfikacji;
	Date DataOstatniegoOdczytu;

	public Kredka() {
		
	}

	public Kredka(int id, String nazwaKoloru, Date dataDodaniaDoBazy, Date dataOstatniejModyfikacji, Date dataOstatniegoOdczytu) {
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

	public Date getDataDodaniaDoBazy() {
		return DataDodaniaDoBazy;
	}

	public void setDataDodaniaDoBazy(Date dataDodaniaDoBazy) {
		DataDodaniaDoBazy = dataDodaniaDoBazy;
	}

	public Date getDataOstatniejModyfikacji() {
		return DataOstatniejModyfikacji;
	}

	public void setDataOstatniejModyfikacji(Date dataOstatniejModyfikacji) {
		DataOstatniejModyfikacji = dataOstatniejModyfikacji;
	}

	public Date getDataOstatniegoOdczytu() {
		return DataOstatniegoOdczytu;
	}

	public void setDataOstatniegoOdczytu(Date dataOstatniegoOdczytu) {
		DataOstatniegoOdczytu = dataOstatniegoOdczytu;
	}

}
