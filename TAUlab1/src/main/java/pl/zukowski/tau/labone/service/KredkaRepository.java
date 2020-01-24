package pl.zukowski.tau.labone.service;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.domain.TimeProvider;


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class KredkaRepository implements IKredkaRepositoryManager{

    public ArrayList<Kredka> kredki = new ArrayList();
    private TimeProvider timemark = new TimeProvider();
    private boolean addToggle = true;
    private boolean readToggle = true;
    private boolean updateToggle= true;



    @Override
    public Kredka create(Kredka kredka) throws IllegalArgumentException {
        for (Kredka _kredka : kredki)
        	if(_kredka.getId()==kredka.getId())
        		throw new IllegalArgumentException("Kredka juz istnieje");
        if(addToggle){
            kredka.setAddTimeMark(timemark.getTime());
        }
        kredki.add(kredka);
        return kredka;
    }

    @Override
    public Kredka read(int id) throws NoSuchElementException {
        for (Kredka _kredka : kredki)
            if (_kredka.getId() == id){
                if(readToggle){
                    _kredka.setReadTimeMark(timemark.getTime());
                }
                return _kredka;
            }
        throw new NoSuchElementException("Nie ma takiej kredki w bazie");
    }

    @Override
    public ArrayList<Kredka> readAll() {
        if(readToggle){
            for(Kredka kredka:kredki){
                kredka.setReadTimeMark(timemark.getTime());
            }
        }
        return kredki;
    }

    @Override
    public Kredka update(int id, Kredka kredka) throws NoSuchElementException {
    	for (Kredka _kredka : kredki)
			if (_kredka.getId() == id && id <= kredki.size()) {

				kredki.set(id - 1, kredka);
				if(updateToggle){
				    kredka.setUpdateTimeMark(timemark.getTime());
                }
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

    public void toggleAddTimemark(){
        addToggle = false;
    }

    public void toggleReadTimemark(){
        readToggle = false;
    }

    public void toggleUpdateTimemark(){
        updateToggle = false;
    }
}
