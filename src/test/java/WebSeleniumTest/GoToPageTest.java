package WebSeleniumTest;


import ItogSelenium.LoginPage;
import ItogSelenium.BlogPage;
import ItogSelenium.BlogSecondPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@Story("Херь про ленту и посты")
public class GoToPageTest extends InitSeleniumTest {


    public LoginPage InputLoginPageAutotest(){
        driver.get(getGetURL());
        new LoginPage(driver)
                .inputUsername(getLoginAutotest())
                .inputPassword(getPasswordAutotest())
                .inputClicButton();
        return new LoginPage(driver);
    }

    @Test
    @Description("Тест логина и перехода по страницам ")
    void testPageAssert() throws InterruptedException {

        InputLoginPageAutotest();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new BlogPage(driver);

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/label/span")).getText(), is("Order"));

    }
    @Test
    @Description("Цвета ")
    void testPageAssert_1() throws InterruptedException {

        InputLoginPageAutotest();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new BlogPage(driver)
                .FirstClic()
                .SecondClic();

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[1]/h1"))
                .getCssValue("color"), is("rgba(0, 0, 0, 1)"));


    }
    @Test
    @Description("Переход на следующую страницу")
    void testNextPage() throws InterruptedException {

        InputLoginPageAutotest();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new BlogPage(driver)
                .FirstClic()
                .SecondClic();

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[1]/h1"))
                .getCssValue("color"), is("rgba(0, 0, 0, 1)"));

        new BlogSecondPage(driver);

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[3]/div[1]/a/h2"))
                .getCssValue("color"), is("rgba(64, 179, 255, 1)"));
    }

    @Test
    @Description("Переход на следующую страницу")
    void testPreviousPage() throws InterruptedException {

        InputLoginPageAutotest();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));
        new BlogPage(driver)
                .FirstClic()
                .SecondClic();

        new BlogSecondPage(driver)
                .PreviousClic();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[2]/div[1]/button/i[2]")));

        assertThat(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[3]/div[1]/a[1]/h2"))
                .getCssValue("color"), is("rgba(64, 179, 255, 1)"));
    }

}
