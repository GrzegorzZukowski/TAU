package pl.zukowski.tau.labthree;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.service.KredkaRepository;

public class BuyingKredka {

    private KredkaRepository repo = new KredkaRepository();

    private String selectedColour;
    private String selectedHardness;
    private String badHardness;

    @Given("Customer choses kredka")
    public void customer_chooses_kredka() {
        repo.create(new Kredka(1, "zielony", "2B"));
        repo.create(new Kredka(2, "czerwony", "2B"));
        repo.create(new Kredka(3, "niebieski", "HB"));
        repo.create(new Kredka(4, "czerwony", "2H"));
    }

    @When("^Customer chose colour \"([^\"]*)\"$")
    public void customer_chose_colour(String kolor) {
        selectedColour = kolor;
    }

    @When("^Customer chose hardness \"([\\d][BH])\"")
    public void customer_chose_hardness(String twardosc) {
        selectedHardness = twardosc;
    }

    @When("^Customer dont want \"([\\d][BH])\"$")
    public void customer_dont_want(String zlaTwardosc) {
        badHardness = zlaTwardosc;
    }


    @Then("Kredka has been sold")
    public void kredka_has_been_sold() {
        Kredka chosenKredka = repo.readAll().stream().filter(k -> k.getTwardosc().equals(selectedHardness) && k.getNazwaKoloru().equals(selectedColour)).findFirst().get();
        Assert.assertEquals(chosenKredka, repo.read(2));
        Assert.assertNotEquals(chosenKredka, repo.read(4));
        Assert.assertEquals(4, repo.kredki.size());
    }
}

