package com.parabank.pom.pages;

import com.microsoft.playwright.Page;
import com.parabank.pom.util.General;

public class OverviewPage extends BasePage {
    public OverviewPage(Page page) {
        super(page);
    }

    public boolean hasLogoutLink() {
        return page.locator("a[href='/parabank/logout.htm']").all().size() > 0;
    }

    public OpenNewAccountPage clickOpenAccountLink() {
        General.waitForDomStable();
        page.locator("a[href='/parabank/openaccount.htm']").hover();
        page.locator("a[href='/parabank/openaccount.htm']").click();
        return new OpenNewAccountPage(page);
    }
}
