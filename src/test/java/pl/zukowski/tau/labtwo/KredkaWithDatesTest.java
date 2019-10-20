package pl.zukowski.tau.labtwo;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;
import org.junit.Test;

import pl.zukowski.tau.labone.domain.Kredka;

public class KredkaWithDatesTest {
    @Test
    //Sprawdzenie czy mozna dodawac daty do nowych pol
    public void isObjectAbleToAddAllDates() {
    	assertNotNull(new Kredka(1,"czrny", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now())));
    }
    
}
