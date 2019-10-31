package pl.zukowski.tau.labtwo;


import org.junit.Assert;
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


import java.sql.Time;
import java.time.*;

import java.util.NoSuchElementException;


public class KredkiRepositoryWithDatesTest {



	@Mock
	Kredka kredka = new Kredka(0, "Szara");
	@Mock
	//TimeStamp ts = new TimeStamp(LocalDateTime.now());
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



}
