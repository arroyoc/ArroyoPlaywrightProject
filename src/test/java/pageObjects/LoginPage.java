package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;
    private final Locator emailField;
    private final Locator passField;
    private final Locator submitBtn;
    private final Locator successTxt;
    private final Locator errorTxt;

    public LoginPage(Page page){
        this.page = page;
        this.emailField = page.getByLabel("Username");
        this.passField = page.getByLabel("Password");
        this.submitBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
        this.successTxt = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Logged In Successfully"));
        this.errorTxt = page.locator("#error");
    }

    public LoginPage enterUsername(String userName){
        emailField.fill(userName);
        return this;
    }

    public LoginPage enterPassword(String pass){
        passField.fill(pass);
        return this;
    }

    public LoginPage clickSubmitBtn(){
        submitBtn.click();
        return this;
    }

    public LoginPage assertSuccessfulLogin(){
        String expectedSuccessfullLoginTxt = "Logged In Successfully";
        assertThat(successTxt).containsText(expectedSuccessfullLoginTxt);
        return this;
    }

    public LoginPage assertInvalidPassword(){
        String expectedInvalidPasswordTxt = "Your password is invalid!";
        assertThat(errorTxt).containsText(expectedInvalidPasswordTxt);
        return this;
    }

}
