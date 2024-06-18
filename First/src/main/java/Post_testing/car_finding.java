package Post_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class car_finding {

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
    public void FindACar() throws InterruptedException, AWTException {

/*        driver.get("https://carshare.yomafleet.com/account/signin");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("maythandaroo720@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Thandar@test2");
        driver.findElement(By.xpath("(//div[@class='cursor-pointer'])[1]")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);*/

        driver.findElement(By.xpath("//a[contains(@class,'text-textBlack hover:text-primary p-2 rounded-md text-sm font-medium font-source-serif uppercase dark:text-dOnSurface dark:hover:text-secondary')][text()='Find A Car']")).click();
        Thread.sleep(1000);

//        driver.findElement(By.xpath("//div[@class='select__value-container css-hlgwow']")).sendKeys("yangon");
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='select__indicators css-1wy0on6']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", dropdown);
        dropdown.sendKeys("Yangon Airport (Coach Parking) , Mingalardon Township");
//        Select city = new Select(dropdown);
//        city.selectByVisibleText("Yangon Airport (Coach Parking) , Mingalardon Township");
        Thread.sleep(3000);


    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
        System.out.println("The driver closed the browser entirely.");
    }
}
