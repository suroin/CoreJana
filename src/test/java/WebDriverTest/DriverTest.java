package WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import predicate.Rules;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static DriverSupplier.DriverFactory.getDriver;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = getDriver(browser);
    }

    @DataProvider(name="gender")
    public Object[] testData(){
        return new Object[]{
                "male",
                "female"
        };
    }


    @Test
    public void webTestConsumer() {
        driver.get("https://google.com");
        driver.findElements(By.tagName("a")).forEach((element) -> System.out.println(element.getText()));
    }

    @Test
    public void webTestPredicate() {
        driver.get("https://google.com");
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        Predicate<WebElement> isBlank = (element -> element.getText().trim().length() == 0);
        Predicate<WebElement> hasA = (element -> element.getText().contains("ա"));
        System.out.println("Before Elements size: " + elements.size());

        elements.removeIf(isBlank.or(hasA));

        System.out.println("After Elements size: " + elements.size());

    }

    @Test
    public void webTestPredicate2() {
        driver.get("https://google.com");
        List<WebElement> elements = driver.findElements(By.tagName("a"));

        System.out.println("Before Elements size: " + elements.size());

//        predicate.Rules.get().forEach((rule) -> elements.removeIf(rule));
        Rules.get().forEach(elements::removeIf);

        System.out.println("After Elements size: " + elements.size());

    }

    @Test
    public void webTestPredicate3() {
        driver.get("https://google.com");
        driver.findElements(By.tagName("a"))
                .stream()
                .filter(Rules.getHasA())
               // .filter(Rules.getIsBlank())
                .map(e -> e.getText().toUpperCase())
                .forEach(System.out::println);

    }

    @Test(dataProvider="gender")
    public void checkBoxTest(String gender) {
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter((elementList) -> elementList.get(1).getText().equalsIgnoreCase(gender))
                .map((elementList) -> elementList.get(3))
                .map(element -> element.findElement(By.tagName("input")))
                .forEach(WebElement::click);

    }


    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
