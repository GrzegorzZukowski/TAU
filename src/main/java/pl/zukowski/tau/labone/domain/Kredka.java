package pl.zukowski.tau.labone.domain;


public class Kredka {

	int Id;
	String NazwaKoloru;
	TimeStamp DataDodaniaDoBazy;
	TimeStamp DataOstatniejModyfikacji;
	TimeStamp DataOstatniegoOdczytu;

	public Kredka() {
		
	}

	public Kredka(int id, String nazwaKoloru, TimeStamp dataDodaniaDoBazy, TimeStamp dataOstatniejModyfikacji, TimeStamp dataOstatniegoOdczytu) {
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

	public TimeStamp getDataDodaniaDoBazy() {
		return DataDodaniaDoBazy;
	}

	public void setDataDodaniaDoBazy(TimeStamp dataDodaniaDoBazy) {
		DataDodaniaDoBazy = dataDodaniaDoBazy;
	}

	public TimeStamp getDataOstatniejModyfikacji() {
		return DataOstatniejModyfikacji;
	}

	public void setDataOstatniejModyfikacji(TimeStamp dataOstatniejModyfikacji) {
		DataOstatniejModyfikacji = dataOstatniejModyfikacji;
	}

	public TimeStamp getDataOstatniegoOdczytu() {
		return DataOstatniegoOdczytu;
	}

	public void setDataOstatniegoOdczytu(TimeStamp dataOstatniegoOdczytu) {
		DataOstatniegoOdczytu = dataOstatniegoOdczytu;
	}

}
