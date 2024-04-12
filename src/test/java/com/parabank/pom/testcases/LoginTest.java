package com.parabank.pom.testcases;

import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.pages.OverviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;


    @Test
    public void checkLoginTittle() {
        loginPage = new LoginPage(page);
        Assert.assertTrue(loginPage.getPageTittle().contains("ParaBank"));
    }

    @Test
    public void checkUrl() {
        loginPage = new LoginPage(page);
        Assert.assertTrue(loginPage.getPageUrl().contains("parabank.parasoft.com"));
    }

    @Test
    public void loginShouldSucceed() {
        OverviewPage overviewPage = new LoginPage(page)
                .doLogin("sqa", "sqa");
        Assert.assertTrue(overviewPage.hasLogoutLink());
    }

}
