package pl.zukowski.tau.labone;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.service.KredkaRepository;


import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Rule;

public class KredkaRepositoryTest  {
    //region List tests
    @Test
    public void classImplementationTest(){
        assertNotNull(new KredkaRepository());
    }
    @Test
    public void testList() {
        KredkaRepository repo = new KredkaRepository();
        assertNotNull(repo.kredki);
    }
    @Test
    public void isListFilledWithObjects() {
        Kredka kredkaZielona = new Kredka(1, "zielony");

        KredkaRepository repo = new KredkaRepository();
        repo.kredki.add(kredkaZielona);

        assertTrue(repo.kredki.contains(kredkaZielona));
    }
    @Test
    public void listShouldContainExactNumberOfObjects() {
        Kredka kredkaZielona = new Kredka(1, "zielony");
        Kredka kredkaNiebieska = new Kredka(2, "niebieski");

        KredkaRepository repo = new KredkaRepository();

        repo.kredki.add(kredkaZielona);
        repo.kredki.add(kredkaNiebieska);

        assertEquals(2, repo.kredki.size());
    }
    //endregion

    //region ReadAll tests
    @Test
    public void readAllTest(){
        KredkaRepository repo = new KredkaRepository();
        Kredka kredkaZielona = new Kredka(1, "zielony");
        Kredka kredkaNiebieska = new Kredka(2, "niebieski");
        repo.kredki.add(kredkaZielona);
        repo.kredki.add(kredkaNiebieska);

        assertEquals(2, repo.readAll().size());
    }

    //endregion

    //region Read tests
    @Test
    public void readShouldReturnObjectById() {
        Kredka kredkaZielona = new Kredka(1, "zielony");

        KredkaRepository repo = new KredkaRepository();
        repo.kredki.add(kredkaZielona);

        assertEquals("Objects are not equal", kredkaZielona, repo.read(1));
    }
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void readShouldNotReturnObjectButThrowNoSuchElementException() throws NoSuchElementException {

        Kredka kredkaZielona = new Kredka(1, "zielony");
        KredkaRepository repo = new KredkaRepository();

        repo.kredki.add(kredkaZielona);

        exception.expect(NoSuchElementException.class);
        exception.expectMessage("Nie ma takiej kredki w bazie");

        assertNotNull(repo.read(2));
    }
    //endregion
}
