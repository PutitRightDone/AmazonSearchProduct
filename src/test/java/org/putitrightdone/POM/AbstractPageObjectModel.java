package org.putitrightdone.POM;

import org.openqa.selenium.WebDriver;

public class AbstractPageObjectModel {
    protected WebDriver webDriver;
    String URL;
    public AbstractPageObjectModel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
