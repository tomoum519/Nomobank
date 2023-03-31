package TestCase;

import Pages.HomePage;
import Pages.RentalPropertyFinancePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCase {

    ChromeDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void websiteRunning() throws IOException {
        HomePage homePage = new HomePage(driver);
        driver.navigate().to(homePage.getUrl());
        int responce = homePage.checkUrlStatus();
        Assert.assertEquals(responce,200);
        driver.close();

    }

    @Test
    public void checkFinanceAndMonthlyAmount() throws InterruptedException {
        RentalPropertyFinancePage rentalPropertyFinancePage = new RentalPropertyFinancePage(driver);
        driver.navigate().to(rentalPropertyFinancePage.getUrl());
        rentalPropertyFinancePage.acceptCookies();
        driver.switchTo().frame(0);
        rentalPropertyFinancePage.clearPropertyValueTextbox();
        rentalPropertyFinancePage.enterPropertyValueTextbox("1000000");
        rentalPropertyFinancePage.enterMonthlyRentalIncomeTextbox("1000");
        rentalPropertyFinancePage.enterDownPaymentTextbox("500000");
        rentalPropertyFinancePage.clickDropDownMenu();
        rentalPropertyFinancePage.selectfirstone();
        Assert.assertEquals(rentalPropertyFinancePage.getFinanceAmount(),"92,915 GBP");
        Assert.assertEquals(rentalPropertyFinancePage.getMonthlyCost(),"458 GBP");


    }

    @Test
    public void checkCantbeLessThanThirtyPercent()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RentalPropertyFinancePage rentalPropertyFinancePage = new RentalPropertyFinancePage(driver);
        driver.navigate().to(rentalPropertyFinancePage.getUrl());
        rentalPropertyFinancePage.acceptCookies();
        driver.switchTo().frame(0);
        rentalPropertyFinancePage.clearPropertyValueTextbox();
        rentalPropertyFinancePage.enterPropertyValueTextbox("1000000");
        rentalPropertyFinancePage.enterMonthlyRentalIncomeTextbox("1000");
        rentalPropertyFinancePage.enterDownPaymentTextbox("290000");
        Assert.assertEquals(rentalPropertyFinancePage.getValidationMsgForDownPayment(),"The down payment needs to be higher");
    }

    @Test
    public void checkDownPaymentMoreThanProprtyValue()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RentalPropertyFinancePage rentalPropertyFinancePage = new RentalPropertyFinancePage(driver);
        driver.navigate().to(rentalPropertyFinancePage.getUrl());
        rentalPropertyFinancePage.acceptCookies();
        driver.switchTo().frame(0);
        rentalPropertyFinancePage.clearPropertyValueTextbox();
        rentalPropertyFinancePage.enterPropertyValueTextbox("100000");
        rentalPropertyFinancePage.enterMonthlyRentalIncomeTextbox("1000");
        rentalPropertyFinancePage.enterDownPaymentTextbox("290000");
        Assert.assertEquals(rentalPropertyFinancePage.getValidationMsgForDownPayment(),"The minimum finance amount is 100,000 GBP");
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
