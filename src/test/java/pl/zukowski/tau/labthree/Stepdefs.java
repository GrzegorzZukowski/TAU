package pl.zukowski.tau.labthree;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;


class CheckKredkaColour {

    static String checkKredkaColour(String colour) {
        if (colour.equals("czerwony"))
            return "Tak";
        return "Nie";
    }
}

public class Stepdefs {

    private String colourName;
    private String actualAnswer;

    @Given("^This is \"([^\"]*)\"$")
    public void this_is(String kolor){
        this.colourName=kolor;
    }

    @When("^Are you sure its czerwony$")
    public void are_you_sure_its_czerwony(){
        this.actualAnswer= CheckKredkaColour.checkKredkaColour(colourName);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer){
        assertEquals(expectedAnswer, actualAnswer);
    }


}
