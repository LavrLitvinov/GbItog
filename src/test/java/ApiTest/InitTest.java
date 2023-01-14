package ApiTest;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class InitTest {
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String noValidLogin;
    private static String validLogin;
    private static String endUrlOne;
    private static String noValidPassword ;

    public static Properties getProp() {
        return prop;
    }

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/Resourses/my.properties");
        prop.load(configFile);

        noValidLogin = prop.getProperty("autotesLogin");
        endUrlOne = prop.getProperty("urlOne");
        validLogin = prop.getProperty("noValidLogin");
        noValidPassword = prop.getProperty("4956318935");

    }

    public static String getNoValidLogin() {
        return noValidLogin;
    }

    public static String getEndUrlOne() {
        return endUrlOne;
    }

    public static String getValidLogin() {
        return validLogin;
    }

    public static String getNoValidPassword() {
        return noValidPassword;
    }

}
