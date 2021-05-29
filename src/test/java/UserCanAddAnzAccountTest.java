import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ucaa.pages.BankAccountsDetailsPage;
import ucaa.pages.BankAccountsPage;
import ucaa.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class UserCanAddAnzAccountTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp()  {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldCreateEveryDayANZAccount() {
        LoginPage loginPage = new LoginPage(driver);
        BankAccountsPage bankAccountsPage = new BankAccountsPage(driver);
        BankAccountsDetailsPage bankAccountsDetailsPage = new BankAccountsDetailsPage((driver));
        loginPage.open();
        loginPage.login("julia095+test@gmail.com", "password1");
        bankAccountsPage.open();
        bankAccountsPage.isLoaded();
        bankAccountsPage.addANZBankAccountFromPopularBankLists();
        assertTrue("Bank accounts details page header is not loaded", bankAccountsDetailsPage.isLoaded());
        bankAccountsDetailsPage.fillAccountDetails();
        assertTrue("Bank accounts page is not loaded", bankAccountsPage.isLoaded());
        Assert.assertEquals("Bank account name is not equal to expected", bankAccountsDetailsPage.uniqueAccountName +" has been added.", bankAccountsPage.getAddAccountStatusMessage());
    }


}
