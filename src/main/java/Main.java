import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    /*
    Domaći:
Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, prisisnuti dugme.
Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje.
Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.
Kod na git, screen recording puštanja i izvršavanja testa na Drive./
     */
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.stealmylogin.com/demo.html");
            URL currentUrl = new URL(driver.getCurrentUrl());
            driver.findElement(By.name("username")).sendKeys("randomUsername");
            WebElement inputPassword = driver.findElement(By.name("password"));
            inputPassword.sendKeys("randomPass");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException ex){
            }
            inputPassword.sendKeys(Keys.ENTER);
            if (driver.getCurrentUrl().equals(currentUrl)) {
                System.out.println("Not nice!");
            } else {
                System.out.println("Nice!");
            }
            try {
                Thread.sleep(5000);
            }catch (InterruptedException ex){
            }
            driver.close();
        }catch (MalformedURLException mue){
        }
    }
}
