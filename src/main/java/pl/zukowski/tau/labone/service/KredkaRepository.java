package pl.zukowski.tau.labone.service;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.domain.TimeStamp;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class KredkaRepository implements IKredkaRepositoryManager{
	
    public ArrayList<Kredka> kredki = new ArrayList();

    @Override
    public Kredka create(Kredka kredka) throws IllegalArgumentException {
        for (Kredka _kredka : kredki)
        	if(_kredka.getId()==kredka.getId())
        		throw new IllegalArgumentException("Kredka juz istnieje");
        kredka.setDodanieDoBazy(new TimeStamp(LocalDate.now()));
        kredki.add(kredka);
        return kredka;
    }

    @Override
    public Kredka read(int id) throws NoSuchElementException {
        for (Kredka _kredka : kredki)
            if (_kredka.getId() == id){
                _kredka.setOstatniOdczyt(new TimeStamp(LocalDate.now()));
                return _kredka;
            }
        throw new NoSuchElementException("Nie ma takiej kredki w bazie");
    }

    @Override
    public ArrayList<Kredka> readAll() {
        return kredki;
    }

    @Override
    public Kredka update(int id, Kredka kredka) throws NoSuchElementException {
    	for (Kredka _kredka : kredki)
			if (_kredka.getId() == id && id <= kredki.size()) {
			    kredka.setOstatniaModyfikacja(new TimeStamp(LocalDate.now()));
				kredki.set(id - 1, kredka);
				return kredka;
			}
		throw new NoSuchElementException("Nie ma takiej kredki w bazie");
    }

    @Override
    public Kredka remove(int id) {
        Kredka kredka = null;
        if((kredka= read(id))!=null) {
        	kredki.remove(kredka);
        	return kredka;
        }
        return null;
    }
}
