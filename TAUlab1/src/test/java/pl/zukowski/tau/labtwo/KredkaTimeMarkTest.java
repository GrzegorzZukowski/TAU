package pl.zukowski.tau.labtwo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.domain.TimeProvider;
import pl.zukowski.tau.labone.service.KredkaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KredkaTimeMarkTest {

    @Mock
    TimeProvider timeMark;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    private Kredka kredka = new Kredka(1,"brązowa", "2h");

    @InjectMocks
    private KredkaRepository testRepo = new KredkaRepository();

    @Test
    public void addTimeMarkOnCreate(){
        LocalDateTime localDateTime= LocalDateTime.parse("2010-01-01T15:15:15");
        when(timeMark.getTime()).thenReturn(localDateTime);
        testRepo.create(kredka);
        verify(timeMark).getTime();
        assertEquals(testRepo.kredki.get(0).getAddTimeMark(), localDateTime);
    }

    @Test
    public void readTimeMarkOnRead(){
        LocalDateTime localDateTime= LocalDateTime.parse("2010-01-01T15:15:15");
        when(timeMark.getTime()).thenReturn(localDateTime);
        testRepo.kredki.add(kredka);
        testRepo.read(1);
        verify(timeMark).getTime();
        assertEquals(testRepo.kredki.get(0).getReadTimeMark(), localDateTime);
    }

    @Test
    public void updateTimeMarkOnUpdate(){
        LocalDateTime localDateTime= LocalDateTime.parse("2010-01-01T15:15:15");
        when(timeMark.getTime()).thenReturn(localDateTime);
        Kredka kredkaUpdate= new Kredka(1, "zielony", "B");
        testRepo.kredki.add(kredka);
        testRepo.update(1,kredkaUpdate);
        verify(timeMark).getTime();
        assertEquals(testRepo.kredki.get(0).getUpdateTimeMark(), localDateTime);
    }

    @Test
    public void readTimeMarkOnReadAll(){
        LocalDateTime localDateTime= LocalDateTime.parse("2010-01-01T15:15:15");
        when(timeMark.getTime()).thenReturn(localDateTime);
        Kredka nowaKredka= new Kredka(1, "zielony", "B");
        testRepo.kredki.add(kredka);
        testRepo.kredki.add(nowaKredka);
        testRepo.readAll();
        assertEquals(testRepo.kredki.get(0).getReadTimeMark(), localDateTime);
        assertEquals(testRepo.kredki.get(1).getReadTimeMark(), localDateTime);
    }

    @Rule
    public final ExpectedException ex = ExpectedException.none();

    @Test
    public void toggleUpdateTimeMark(){
        Kredka kredkaUpdate= new Kredka(1, "zielony", "B");
        testRepo.kredki.add(kredka);
        testRepo.toggleUpdateTimemark();
        testRepo.update(1,kredkaUpdate);
        assertNull(testRepo.kredki.get(0).getUpdateTimeMark());
    }

    @Test
    public void toggleReadTimeMark(){
        testRepo.kredki.add(kredka);
        testRepo.toggleReadTimemark();
        testRepo.read(1);
        assertNull(testRepo.kredki.get(0).getReadTimeMark());
    }

    @Test
    public void toggleAddTimeMark(){
        testRepo.toggleAddTimemark();
        testRepo.create(kredka);
        assertNull(testRepo.kredki.get(0).getAddTimeMark());
    }


}
