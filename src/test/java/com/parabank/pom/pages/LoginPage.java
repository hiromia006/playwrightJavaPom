package com.parabank.pom.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.parabank.pom.util.General;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public LoginPage fillUsername(String username) {
        page.locator("input[name='username']").first().fill(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        page.locator("input[name='password']").first().fill(password);
        return this;
    }

    public OverviewPage clickLoginBtn() {
        page.locator("//input[@class='button']").click();
//        General.waitForDomStable();
        return new OverviewPage(page);
    }

    public OverviewPage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

}
