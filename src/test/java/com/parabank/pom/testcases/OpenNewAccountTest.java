package com.parabank.pom.testcases;

import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.pages.OpenNewAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void OpenNewAccountShouldSucceed() {
        OpenNewAccountPage newAccountPage = new LoginPage(page)
                .doLogin("sqa", "sqa")
                .clickOpenAccountLink()
                .clickOpenAccountBtn();
        Assert.assertTrue(newAccountPage.hasNewAccountId());
    }
}
