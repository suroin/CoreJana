package predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static Predicate<WebElement> isBlank = (element -> element.getText().trim().length() == 0);
    private static Predicate<WebElement> hasA = (element -> element.getText().contains("ա"));

    public static List<Predicate<WebElement>> get(){
        List<Predicate<WebElement>> rules = new ArrayList<>();
        rules.add(isBlank);
        rules.add(hasA);
        return rules;
    }

    public static Predicate<WebElement> getIsBlank(){

        return isBlank;
    }

    public static Predicate<WebElement> getHasA(){

        return hasA;
    }
}

