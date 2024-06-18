package Post_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class registration {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void startBrowser() {

//        WebDriver driver = new ChromeDriver();

        driver.get("https://carshare.yomafleet.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test(enabled = true)
    public void SignUp() throws InterruptedException, AWTException {

        //Home page - Sign Up
        driver.findElement(By.cssSelector("div[class='flex flex-1 justify-end items-center'] a:nth-child(2)")).click();
        Thread.sleep(2000);
        //Sign up individually
        driver.findElement(By.xpath("(//button[@type='button'][text()='Join Now'])[1]")).click();
        Thread.sleep(2000);

        //Enter User credential
        driver.findElement(By.id("fullName")).sendKeys("ThandarTest");

        driver.findElement(By.id("username")).sendKeys("maythandaroo720@gmail.com");

        WebElement p1 = driver.findElement(By.id("password"));
        p1.sendKeys("Thandar@test2");
        driver.findElement(By.xpath("(//div[@class='cursor-pointer'])[1]")).click();

        WebElement p2 = driver.findElement(By.id("confirmPassword"));
        p2.sendKeys("Thandartest2");
        driver.findElement(By.xpath("(//div[@class='cursor-pointer'])[2]")).click();
        Thread.sleep(1500);

//        Assert.assertEquals(p2.getText(),p1.getText());

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);

        //Input OTP from email manually//
        driver.findElement(By.id("verifying")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("swal-button swal-button--confirm")).click(); //click alert mesg OK button
        Thread.sleep(2000);

    }

    @Test(enabled = true)
    public void Login() throws InterruptedException, AWTException {

        driver.get("https://carshare.yomafleet.com/account/signin");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("maythandaroo720@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Thandar@test2");
        driver.findElement(By.xpath("(//div[@class='cursor-pointer'])[1]")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);


    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
        System.out.println("The driver closed the browser entirely.");
    }
}