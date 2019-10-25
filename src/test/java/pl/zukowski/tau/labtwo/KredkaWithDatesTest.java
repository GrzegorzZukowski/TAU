package pl.zukowski.tau.labtwo;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;
import org.junit.Test;

import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.domain.TimeStamp;

public class KredkaWithDatesTest {
    @Test
    //Sprawdzenie czy mozna dodawac daty do nowych pol
    public void isObjectAbleToAddAllDates() {
    	TimeStamp ts = new TimeStamp(LocalDate.now());
    	assertNotNull(new Kredka(1,"czarny",ts,ts,ts));
    }
    
}
