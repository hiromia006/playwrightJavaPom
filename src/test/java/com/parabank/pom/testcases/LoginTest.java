package com.parabank.pom.testcases;

import com.parabank.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;


    @Test(priority = 0)
    public void checkLoginTittle() {
        loginPage = new LoginPage(page);
        Assert.assertTrue(loginPage.getPageTittle().contains("ParaBank"));
    }

    @Test(priority = 1)
    public void checkUrl() {
        loginPage = new LoginPage(page);
        Assert.assertTrue(loginPage.getPageUrl().contains("parabank.parasoft.com"));
    }

}
