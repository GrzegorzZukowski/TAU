package pl.zukowski.tau.labtwo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.domain.TimeStamp;
import pl.zukowski.tau.labone.service.KredkaRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.*;

public class KredkiRepositoryWithDatesTest {

	@Mock
	Kredka kredka = new Kredka(0, "Szara");

	@Mock
	TimeStamp dodanieDoBazy;

	@Mock
	TimeStamp ostatniaModyfikacja;

	@Mock
	TimeStamp ostatniOdczyt;

	@Mock
	KredkaRepository mockedRepo = new KredkaRepository();

	@Before
	public void initMocs() {
		MockitoAnnotations.initMocks(this);
	}

	//region Mockito tryouts
	@Test
	public void testofmock() {
		mockedRepo.read(1);
		mockedRepo.remove(1);

		verify(mockedRepo).read(1);
		verify(mockedRepo).remove(1);
	}

	@Test
	public void  someTest2(){
		mockedRepo.create(kredka);

		verify(mockedRepo).create(kredka);
		verify(mockedRepo, times(1)).create(kredka);
	}

	@Test
	public void givenFixedLocalDateTimeTestTheReadMethod(){
		mockedRepo.create(kredka);
		when(mockedRepo.read(1)).thenReturn(kredka);
	}
	//endregion

	//region tests for mocking date
	@Test
	public void testOfOstatniOdczytOnReadMethod(){
		Kredka kredka = new Kredka(0,"szara");
		KredkaRepository repo= new KredkaRepository();

		repo.kredki.add(kredka);
		repo.read(0);

		when(ostatniOdczyt.getTimeStamp()).thenReturn(LocalDate.now());
		Mockito.mockingDetails(ostatniOdczyt).isMock();

		assertEquals(repo.read(0).getOstatniOdczyt().getTimeStamp(), ostatniOdczyt.getTimeStamp());
	}

	@Test
	public void testOfDodanieDoBazyOnCreatMethod(){
		Kredka kredka = new Kredka(0,"szara");
		KredkaRepository repo= new KredkaRepository();

		repo.create(kredka);

		when(dodanieDoBazy.getTimeStamp()).thenReturn(LocalDate.now());
		Mockito.mockingDetails(dodanieDoBazy).isMock();

		assertEquals(repo.read(0).getDodanieDoBazy().getTimeStamp(), dodanieDoBazy.getTimeStamp());
	}

	@Test
	public void testOfOstatniaModyfikacjaOnUpdateMethod(){
		Kredka kredka = new Kredka(1,"szara");
		Kredka czarna = new Kredka(1, "czarna");

		KredkaRepository repo= new KredkaRepository();
		repo.create(kredka);
		repo.update(1, czarna);

		when(ostatniaModyfikacja.getTimeStamp()).thenReturn(LocalDate.now());
		Mockito.mockingDetails(ostatniaModyfikacja).isMock();

		assertEquals(repo.read(1).getOstatniaModyfikacja().getTimeStamp(), ostatniaModyfikacja.getTimeStamp());
	}
	//endregion

	//region test for toggling Timestamps
	@Test
	public void testForToggleOstatniOdczytTimeStamp(){
		Kredka kredka = new Kredka(1,"szara");
		KredkaRepository repo= new KredkaRepository();

		repo.toggleOstatniOdczytTimeStamo();
		repo.create(kredka);

		assertNull(repo.read(1).getOstatniOdczyt());
	}

	@Test
	public void testForToggleDodanieDoBazyMethod(){
		Kredka kredka = new Kredka(1,"szara");
		KredkaRepository repo= new KredkaRepository();

		repo.toggleDodajTimeStamp();
		repo.create(kredka);

		assertNull(repo.read(1).getDodanieDoBazy());
	}

	@Test
	public void testForToggleOstatniaModyfikacjaTimeStamp(){
		Kredka kredka = new Kredka(1,"szara");
		Kredka czarna = new Kredka(1, "czarna");
		KredkaRepository repo= new KredkaRepository();

		repo.create(kredka);
		repo.toggleOstatniaModyfikacjaTimeStamp();
		repo.update(1, czarna);

		assertNull(repo.read(1).getOstatniaModyfikacja());
	}
	//endregion
}
