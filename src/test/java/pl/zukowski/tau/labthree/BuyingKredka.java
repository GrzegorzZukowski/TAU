package pl.zukowski.tau.labthree;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pl.zukowski.tau.labone.domain.Kredka;
import pl.zukowski.tau.labone.service.KredkaRepository;



public class BuyingKredka {
        public KredkaRepository repo = new KredkaRepository();

        public String selectedColour;
        public String selectedHardness;


        @Given("Customer choses kredka")
        public void customer_chooses_kredka(){
            repo.create(new Kredka(1, "zielony", "2B"));
            repo.create(new Kredka(2, "czerwony", "2H"));
            repo.create(new Kredka(3, "niebieski", "HB"));
        }

        @When("^Customer chose colour \"([^\"]*)\"$")
        public void customer_chose_colour(String kolor) { selectedColour = kolor; }

        @When("^Customer chose hardness \"([\\d][BH])\"")
        public void customer_chose_hardness(String twardosc){
            selectedHardness= twardosc;
        }


        @Then("Kredka has been sold")
        public void kredka_has_been_sold(){
            Kredka chosenKredka= repo.readAll().stream().filter(k->k.getTwardosc()==selectedHardness && k.getNazwaKoloru()==selectedColour).findFirst().get();
            Assert.assertEquals(chosenKredka, repo.read(2));
            Assert.assertEquals(3, repo.kredki.size());
        }
}

