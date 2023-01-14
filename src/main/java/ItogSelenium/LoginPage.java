package ItogSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseAction{

    public static final String INTRANSBUTTON = "//*[@id=\"login\"]/div[3]/button";
    public static final String USERNAME = "//*[@id=\"login\"]/div[1]/label/input";
    public static final String PASSWORD = "//*[@id=\"login\"]/div[2]/label";
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = USERNAME)
    public WebElement usernameInput;

    @FindBy(xpath = PASSWORD)
    public  WebElement passwordInput;

    @FindBy(xpath = INTRANSBUTTON)
    public WebElement clickButton;

    @Step("Заполнение username")
    public LoginPage inputUsername (String username){
        usernameInput.click();
        usernameInput.sendKeys(username);
        return this;
    }
    @Step("Заполнение password")
    public LoginPage inputPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Kликаем на вход")
    public void  inputClicButton(){
        clickButton.click();
    }
}


