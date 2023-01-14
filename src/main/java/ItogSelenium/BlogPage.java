package ItogSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogPage extends BaseAction{
    public BlogPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")
    public WebElement firstClic;
    public BlogPage FirstClic(){
        firstClic.click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[1]")));
        return this;
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[1]")
    public WebElement secondClic;
    public BlogPage SecondClic() {
        secondClic.click();
        return this;
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a[2]")
    public  WebElement nextPage;
    public BlogSecondPage NextPageClic(){
        nextPage.click();
        return new BlogSecondPage(driver);
    }


}
