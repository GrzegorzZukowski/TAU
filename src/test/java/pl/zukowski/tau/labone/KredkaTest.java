package pl.zukowski.tau.labone;

import org.junit.Test;
import pl.zukowski.tau.labone.domain.Kredka;

import static  org.junit.Assert.*;

import java.time.LocalDate;



public class KredkaTest {

    @Test
    public void classImplementationTest(){
        assertNotNull(new Kredka());
    }

    @Test
    public void isObjectAbleToInstantiate(){
        assertNotNull(new Kredka(1, "Czarny"));
    }
    
    @Test
    //Sprawdzenie czy mozna dodawac daty do nowych pol
    public void isObjectAbleToAddAllDates() {
    	assertNotNull(new Kredka(1,"czrny",LocalDate.now(), LocalDate.now(),LocalDate.now()));
    }
    
}
