package pl.zukowski.tau.labone;

import org.junit.Test;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.service.KredkaRepository;

import static org.junit.Assert.*;

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
        Kredka kredkaMiebieska = new Kredka(2, "niebieski");

        KredkaRepository repo = new KredkaRepository();

        repo.kredki.add(kredkaZielona);
        repo.kredki.add(kredkaMiebieska);

        assertEquals(2, repo.kredki.size());
    }
    //endregion

    //region ReadAll tests


    //endregion
}
