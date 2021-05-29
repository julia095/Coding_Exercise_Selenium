import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BankAccountsDetailsPage;
import pages.BankAccountsPage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class UserCanAddAnzAccountTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private BankAccountsPage bankAccountsPage;
    private BankAccountsDetailsPage bankAccountsDetailsPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp()  {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        bankAccountsPage = new BankAccountsPage(driver);
        bankAccountsDetailsPage = new BankAccountsDetailsPage((driver));
        loginPage.open();
        loginPage.login("julia095+test@gmail.com", "password1");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldDisplayCorrectMessageAfterAddingEveryDayANZAccount() {
        bankAccountsPage.open();
        bankAccountsPage.isLoaded();
        bankAccountsPage.addANZBankAccountFromPopularBankLists();
        assertTrue("Bank accounts details page header is not loaded", bankAccountsDetailsPage.isLoaded());
        bankAccountsDetailsPage.fillAccountDetails();
        assertTrue("Bank accounts page is not loaded", bankAccountsPage.isLoaded());
        Assert.assertEquals("Bank account name is not equal to expected", bankAccountsDetailsPage.uniqueAccountName +" has been added.", bankAccountsPage.getAddAccountStatusMessage());
    }


}
