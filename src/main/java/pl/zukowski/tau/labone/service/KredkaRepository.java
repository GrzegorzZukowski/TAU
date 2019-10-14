package pl.zukowski.tau.labone.service;

import pl.zukowski.tau.labone.domain.Kredka;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class KredkaRepository implements IKredkaRepositoryManager{
    public ArrayList<Kredka> kredki = new ArrayList();

    @Override
    public Kredka create(Kredka kredka) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Kredka read(int id) throws NoSuchElementException {
        for (Kredka _kredka : kredki)
            if (_kredka.getId() == id)
                return _kredka;
        throw new NoSuchElementException("Nie ma takiej kredki w bazie");
    }

    @Override
    public ArrayList<Kredka> readAll() {
        return kredki;
    }

    @Override
    public Kredka update(int id, Kredka kredka) throws NoSuchElementException {
        return null;
    }

    @Override
    public Kredka remove(int id) {
        return null;
    }
}
