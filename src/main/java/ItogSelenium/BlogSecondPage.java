package ItogSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogSecondPage extends BaseAction {

    public BlogSecondPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a[1]")
    public WebElement previousClic;

    public BlogPage PreviousClic() {
        previousClic.click();
        return new BlogPage(driver);
    }

}
