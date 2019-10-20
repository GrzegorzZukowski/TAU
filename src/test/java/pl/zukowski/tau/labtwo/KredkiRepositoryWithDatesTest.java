package pl.zukowski.tau.labtwo;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.domain.TimeStamp;

import static org.junit.Assert.*;

import java.sql.Date;
//import java.time.LocalDate;


public class KredkiRepositoryWithDatesTest {

	@Mock
	TimeStamp DataDodaniaDoBazy;
	@Mock
	TimeStamp DataOstatniejModyfikacji;
	@Mock
	TimeStamp DataOstatniegoOdczytu;
	
	@Before
	public void initMocs() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test 
	public void testForDateDodanieDoBazy() {
		assertNotNull(DataDodaniaDoBazy);
	}
	@Test 
	public void testForDateOstatniejModyfikacji() {
		assertNotNull(DataDodaniaDoBazy);
	}
	@Test 
	public void testForDateOstatniegoOdczytu() {
		assertNotNull(DataDodaniaDoBazy);
		
	}
	
}
