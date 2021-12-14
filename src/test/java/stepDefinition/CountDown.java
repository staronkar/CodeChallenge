package stepDefinition;

import implementations.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CountDown extends BaseClass {


    @Given("the user is on eggtimer website")
    public void the_user_is_on_eggtimer_website() {
        setDriver("https://e.ggtimer.com/");
    }
    @Given("the user waits for page to load")
    public void the_user_waits_for_page_to_load() {
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
    }
    @When("the user enters {int} seconds as the timer")
    public void the_user_enters_seconds_as_the_timer(Integer interval) {
        driver.findElement(By.xpath("//*[@id=\"EggTimer-start-time-input-text\"]")).sendKeys(interval.toString());
    }
    @When("the user clicks on Go Button")
    public void the_user_clicks_on_go_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/main/div[1]/button")).click();

    }
    @Then("verify the counter starts")
    public void verify_the_counter_starts() {
        Assertions.assertEquals("00:00:05",driver.getTitle());

    }
    @Then("countdown happens every second")
    public void countdown_happens_every_second() throws InterruptedException {
        for(int i=0;i<=5;i=i++)
        {
            Thread.sleep(1000);
            int expectedTime = 5-i;
            String titleValue = driver.getTitle();
            Assertions.assertEquals("00:00:0"+String.valueOf(expectedTime),titleValue);

        }


    }
    @Then("verify that remaining time decreases every second.")
    public void verify_that_remaining_time_decreases_every_second() {
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        System.out.println(driver.switchTo().window(iterator.next()).getTitle());
        quitDriver(driver);
    }
}
