package pl.zukowski.tau.labone;

import org.junit.Test;
import pl.zukowski.tau.labone.domain.Kredka;

import static  org.junit.Assert.*;



public class KredkaTest {

    @Test
    public void classImplementationTest(){
        assertNotNull(new Kredka());
    }

    @Test
    public void isObjectAbleToInstantiate(){
        assertNotNull(new Kredka(1, "Czarny"));
    }
}
