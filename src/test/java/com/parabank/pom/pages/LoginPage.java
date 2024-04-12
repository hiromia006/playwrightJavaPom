package com.parabank.pom.pages;

import com.microsoft.playwright.Page;

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

}
