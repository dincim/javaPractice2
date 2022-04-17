package dropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PracticeSelect {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\SeleniumDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Matt");
        Thread.sleep(3000);
        WebElement monthEle = driver.findElement(By.id("month"));
        Select eleMonth = new Select(monthEle);
        eleMonth.selectByValue("3");
        Thread.sleep(3000);
        WebElement dayEle = driver.findElement(By.id("day"));
        Select eleDay = new Select(dayEle);
        eleDay.selectByValue("11");
        Thread.sleep(3000);

        WebElement dayYear = driver.findElement(By.id("year"));
        Select eleYear = new Select(dayYear);
        eleYear.selectByValue("1980");

        driver.findElement(By.xpath("//input[@value='1']")).click();

    }

}
