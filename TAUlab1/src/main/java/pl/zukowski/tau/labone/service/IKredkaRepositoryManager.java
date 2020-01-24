package pl.zukowski.tau.labone.service;

import pl.zukowski.tau.labone.domain.Kredka;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public interface IKredkaRepositoryManager {
    public Kredka create(Kredka kredka)  throws IllegalArgumentException;
    public Kredka read(int id)  throws NoSuchElementException;
    public ArrayList<Kredka> readAll();
    public Kredka update(int id, Kredka kredka)  throws NoSuchElementException;
    public Kredka remove(int id);
}
