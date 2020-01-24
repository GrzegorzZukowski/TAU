package pl.zukowski.tau.labthree;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.service.KredkaRepository;

import static org.junit.Assert.assertEquals;

public class NewKredka {

    private Kredka kredka;
    private KredkaRepository repo= new KredkaRepository();

    @Given("Create new Kredka")
    public void create_kredka(){
        kredka = new Kredka(1, "szara");
    }

    @When("When Kredka has been created")
    public void kredka_created(){
        repo.create(kredka);
    }

    @Then("Then kredka has been added to database")
    public void kredka_added(){
        assertEquals(kredka, repo.read(1));
    }

}
