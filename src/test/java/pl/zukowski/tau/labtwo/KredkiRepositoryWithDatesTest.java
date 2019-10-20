package pl.zukowski.tau.labtwo;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.zukowski.tau.labone.domain.Kredka;

import static org.junit.Assert.*;

import java.sql.Date;
//import java.time.LocalDate;


public class KredkiRepositoryWithDatesTest {

	@Mock
	Date DataDodaniaDoBazy;
	@Mock
	Date DataOstatniejModyfikacji;
	@Mock
	Date DataOstatniegoOdczytu;
	
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
