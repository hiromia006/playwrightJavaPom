package com.parabank.pom.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public String getPageTittle() {
        return page.title().trim();
    }

    public String getPageUrl() {
        return page.url().trim();
    }
}
