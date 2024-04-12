package com.parabank.pom.pages;

import com.microsoft.playwright.Page;

public class OverviewPage extends BasePage {
    public OverviewPage(Page page) {
        super(page);
    }

    public boolean hasLogoutLink() {
        return page.locator("a[href='/parabank/logout.htm']").all().size() > 0;
    }
}
