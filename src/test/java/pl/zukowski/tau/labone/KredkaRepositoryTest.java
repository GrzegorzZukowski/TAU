package pl.zukowski.tau.labone;

import org.junit.Test;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.service.KredkaRepository;

import static org.junit.Assert.*;

public class KredkaRepositoryTest {
    @Test
    public void classImplementationTest(){
        assertNotNull(new KredkaRepository());
    }
}
