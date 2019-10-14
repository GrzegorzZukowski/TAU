package pl.zukowski.tau.labone;

import org.junit.Test;
import pl.zukowski.tau.labone.domain.Kredki;

import static  org.junit.Assert.*;



public class KredkiTest {

    @Test
    public void classImplementationTest(){
        assertNotNull(new Kredki());
    }

    @Test
    public void isObjectAbleToInstantiate(){
        assertNotNull(new Kredki(1, "Czarny"));
    }
}
