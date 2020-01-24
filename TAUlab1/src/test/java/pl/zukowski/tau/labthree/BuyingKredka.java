package pl.zukowski.tau.labthree;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.service.KredkaRepository;

public class BuyingKredka {
    private Kredka kredka;
    private KredkaRepository repo;

    private String selectedColour;


    @Given("Customer choses a phone")
    public void customer_chooses_kredka(){
        repo.kredki.add(new Kredka(1, "zielony", "2H"));
        repo.kredki.add(new Kredka(2, "czerwony", "2B"));
        repo.kredki.add(new Kredka(3, "zielony", "2B"));
    }

    @When("^Customer choses colour \"([^\"]*)\"$")
    public void customer_choses_colour(String kolor){

    }

}
