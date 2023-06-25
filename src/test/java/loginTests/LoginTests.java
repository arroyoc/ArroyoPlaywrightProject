package loginTests;

import org.junit.jupiter.api.*;
import pageObjects.LoginPage;
import testBase.TestBase;

public class LoginTests extends TestBase {

    @BeforeAll
    static void launchBrowser(){
        webSetup();
    }

    @AfterAll
    static void closeBrowser(){
        webTeardown();
    }

    @BeforeEach
    void createContextAndPage(){
        webBeforeEach();
    }

    @AfterEach
    void closeContext(){
        webAfterEach();
    }

    @Test
    void successfulLoginTest(){
        LoginPage lp = new LoginPage(page);

        lp.navigateToLoginPage();

        lp.enterUsername("student")
                .enterPassword("Password123")
                .clickSubmitBtn()
                .assertSuccessfulLogin();
    }

    @Test
    void invalidPasswordTest(){
        LoginPage lp = new LoginPage(page);

        lp.navigateToLoginPage();

        lp.enterUsername("student")
                .enterPassword("password")
                .clickSubmitBtn()
                .assertInvalidPassword();
    }


}
