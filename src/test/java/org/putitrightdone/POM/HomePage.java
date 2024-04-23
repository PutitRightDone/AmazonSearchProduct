package org.putitrightdone.POM;
import java.lang.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPageObjectModel {
    private String loginUrl;

    public HomePage(WebDriver webDriver, String loginUrl) {
        super(webDriver);
        this.loginUrl = loginUrl;
    }
    public void launchURL(String loginURL){
        webDriver.get(loginUrl);
    }
    public void login(String username, String password) throws InterruptedException {
        webDriver.get(loginUrl);
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
        webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        webDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Ceiling Fan");
        webDriver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    public void SearchProducts(String searchProducttext){

    }
    /*public void Logout() {
        CaptureScreenshots cpScreenshots = new CaptureScreenshots(webDriver);
        try {

            cpScreenshots.takeScreenShot(webDriver,"Logout");
            webDriver.findElement(By.xpath("//a[@title='Logout']")).click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            cpScreenshots.takeScreenShot(webDriver,"LogoutException");
        }
    }*/
}