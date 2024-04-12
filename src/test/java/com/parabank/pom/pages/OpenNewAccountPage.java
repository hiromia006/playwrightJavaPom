package com.parabank.pom.pages;

import com.microsoft.playwright.Page;
import com.parabank.pom.util.General;

public class OpenNewAccountPage extends BasePage {
    public OpenNewAccountPage(Page page) {
        super(page);
    }

    public OpenNewAccountPage clickOpenAccountBtn() {
        General.waitForDomStable();
        page.locator("input[value='Open New Account']").hover();
        page.locator("input[value='Open New Account']").click();
        return this;
    }

    public boolean hasNewAccountId() {
        General.waitForDomStable();
        return page.locator("//a[@id='newAccountId']").all().size() > 0;
    }
}
