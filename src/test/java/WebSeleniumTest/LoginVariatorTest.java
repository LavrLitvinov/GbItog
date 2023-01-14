package WebSeleniumTest;

import ItogSelenium.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Story("Мучаем логин")
public class LoginVariatorTest extends InitSeleniumTest {

    public LoginPage InputLoginPageAutotest(){
        driver.get(getGetURL());
        new LoginPage(driver)
                .inputUsername(getLoginAutotest())
                .inputPassword(getPasswordAutotest())
                .inputClicButton();
        return new LoginPage(driver);
    }


    @Test
    @Description("Тест инвалидного логина и пароля")
    void testLoginPage_1() throws InterruptedException {
        driver.get(getGetURL());

        new LoginPage(driver)
                .inputUsername(" ")
                .inputPassword(" ")
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")).getText(), is("Invalid credentials."));
    }

    @Test
    @Description("Тест валидного логина и пароля")
    void testLoginPage_2() throws InterruptedException {
        InputLoginPageAutotest();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/nav/a/span")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/nav/a/span")).getText(), is("Home"));

    }
    @Test
    @Description("Корнертест 1 символ")
    void testLoginPage_C1() throws InterruptedException {
        driver.get(getGetURL());

        new LoginPage(driver)
                .inputUsername("autotest")
                .inputPassword("1")
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")).getText(), is("Invalid credentials."));
    }
    @Test
    @Description("Корнертест 21 символ")
    void testLoginPage_C21() throws InterruptedException {
        driver.get(getGetURL());

        new LoginPage(driver)
                .inputUsername("autotest")
                .inputPassword("1111111111111111111")
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")).getText(), is("Invalid credentials."));
    }

    @Test
    @Description("Тест невалидного юзернейма")
    void testLoginPageInvalidUsername() throws InterruptedException {
        driver.get(getGetURL());

        new LoginPage(driver)
                .inputUsername("NoNoUsername")
                .inputPassword(getPasswordAutotest())
                .inputClicButton();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/p[1]")).getText(), is("Invalid credentials."));
    }


    @Test
    @Description("Тест валидного логина и пароля")
    void testLoginPageForFeil() throws InterruptedException {

        //  ответ на какбэ толстый намек, что нужны упавшие тесты

        InputLoginPageAutotest();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/nav/a/span")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/nav/a/span")).getText(), is("Ожидаемый провал теста"));

    }
}
