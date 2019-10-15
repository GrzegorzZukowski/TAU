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
    
    //region create test
    @Test
    public void canCreateObject() {
    KredkaRepository repo = new KredkaRepository();
    assertNotNull(repo.create(new Kredka(1, "szary")));
    }
    
    @Test
    public void isObjectCreatedTestByReadById() {
        KredkaRepository repo = new KredkaRepository();
        Kredka kredka = new Kredka(1, "szary");

        repo.create(kredka);

        assertNotNull(repo.read(1));
        assertEquals("Objects are not equal", kredka, kredka);
    }
    

    @Test
     public void creationOfObjectChangeTheListSize() {
         KredkaRepository repo = new KredkaRepository();

         assertEquals(true, repo.kredki.isEmpty());

         repo.create(new Kredka(1, "szary"));

         assertEquals("List size is correct", 1, repo.kredki.size());

     }
    
    @Test
    public void createObjectWithSameIdAsPresentInListShouldThrowException(){
        KredkaRepository repo = new KredkaRepository();

        repo.create(new Kredka(1, "szary"));
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Kredka juz istnieje");

        assertNotNull(repo.create(new Kredka(1, "szary")));
    }

    //endregion
    
  //region update test
    @Test
    public void canUpdateObject(){
        KredkaRepository repo = new KredkaRepository();
        Kredka kredkaZielona= new Kredka(1, "zielony");
        repo.create(kredkaZielona);
        assertNotNull(repo.update(1,new Kredka(1, "szary")));
    }
    
    @Test
    public void actuallyUpdatesObjectShouldReturnTrue(){
        KredkaRepository repo = new KredkaRepository();
        Kredka nowaCzerwona = new Kredka(1, "szary");
        Kredka szara = new Kredka(1, "szary");
        repo.create(szara);
        repo.update(1, nowaCzerwona);
        assertEquals(nowaCzerwona, repo.read(1));

    }
    
    @Test
    public void updateElementNotPresentInDatabaseShouldThrowAnException(){
        KredkaRepository repo = new KredkaRepository();

        exception.expect(NoSuchElementException.class);
        exception.expectMessage("Nie ma takiej kredki w bazie");
        repo.update(1, new Kredka(1, "pomaranczowy"));
    }
    //endregion
    
    //region delete test
    @Test
    public void canRemoveObject(){
        KredkaRepository repo = new KredkaRepository();
        repo.create(new Kredka(1, "zielony"));
        assertNotNull(repo.remove(1));
    }
    
    @Test
    public void removeOfObjectTatDoesNotExistInDatabaseShouldThrowException(){
        KredkaRepository repo = new KredkaRepository();
        repo.create(new Kredka(1, "zielony"));
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("Nie ma takiej kredki w bazie");
        repo.remove(2);
    }
    
    @Test
    public void afterRemoveCheckHowManyObjectsInList(){
        KredkaRepository repo = new KredkaRepository();
        repo.create(new Kredka(1, "zielony"));
        repo.remove(1);
        int expectedCountInList= repo.kredki.size();
        assertEquals(0, expectedCountInList);
    }
    //endregion
}
