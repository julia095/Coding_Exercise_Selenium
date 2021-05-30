package tests;

import static utils.extentreports.ExtentTestManager.startTest;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class ANZAccountTest extends BaseTest {

    @Test(priority = 0, description = "Ensure I can add ANZ day-to-day account from favorites with valid data")
    public void ensureICanAddANZDayToDayAccountWithValidData(Method method) {
        startTest(method.getName(), "Ensure I can add ANZ day-to-day account from favorites with valid data");
        String testAccountName = homePage.getTestAccountNumber();
        int bankAccountPanelsCountBefore = 0;
        int bankAccountPanelsCountAfter = 0;


        homePage.goToBankAccountsPage();
        bankAccountPanelsCountBefore = homePage.getBankAccountPanelNumber();
        homePage
                .goToAddBankAccountPage()
                .pickAnzBankFromFavorites()
                .fillInBankDetails(testAccountName, "Everyday (day-to-day)", "3456 5676 4533 4455" )
                .clickContinue();
        bankAccountPanelsCountAfter = homePage.getBankAccountPanelNumber();
        homePage
                .verifyStatusInfoMessageContains(testAccountName + " has been added.")
                .verifyNumberOfPanelsIncreasedByNumber(bankAccountPanelsCountBefore, bankAccountPanelsCountAfter, 1);
    }

    @Test(priority = 0, description = "Ensure I can more than one account from favorites")
    public void ensureICanAddMoreThanOneAccountFromFavorites(Method method) {
        startTest(method.getName(), "Ensure I can more than one account from favorites");
        String testAccountName = homePage.getTestAccountNumber();
        int bankAccountTextFieldPanelsCountBefore = 0;
        int bankAccountTextFieldPanelsCountAfter = 0;


        homePage
                .goToBankAccountsPage()
                .goToAddBankAccountPage()
                .pickAnzBankFromFavorites();
        bankAccountTextFieldPanelsCountBefore = homePage.getBankAccountTextFieldPanelNumber();
        homePage
                .clickAddAnotherAnzAccount();
        bankAccountTextFieldPanelsCountAfter = homePage.getBankAccountTextFieldPanelNumber();
        homePage
                .verifyNumberOfPanelsIncreasedByNumber(bankAccountTextFieldPanelsCountBefore, bankAccountTextFieldPanelsCountAfter, 1);
    }

/* These are tests' ideas I couldn't implement due to lack of time.
    @Test(priority = 0, description = "Ensure I can't add ANZ day-to-day account from favorites with account name field empty")
    public void someTestFunction1(Method method) {
        startTest(method.getName(), "test description");

        homePage
                .goToBankAccountsPage()
                .goToAddBankAccountPage()
                .pickAnzBankFromFavorites()
                .fillInBankDetails("", "accountType", "" )
                .verifyWarningMessageContains("Account name required")
                .verifyAccountNameFieldBorderColorIsRed()
    }

    @Test(priority = 0, description = "Ensure I can't add ANZ day-to-day account from favorites with account number field empty")
    public void someTestFunction1(Method method) {
        startTest(method.getName(), "test description");

        homePage
                .goToBankAccountsPage()
                .goToAddBankAccountPage()
                .pickAnzBankFromFavorites()
                .fillInBankDetails("accountName", "accountType", "" )
                .clickContinue()
                .verifyWarningMessageContains("Account NUmber required")
                .verifyAccountNameFieldBorderColorIsRed()
    }

    @Test(priority = 0, description = "Ensure I can add a day-to-day and a loan account with valid data")
    public void someTestFunction1(Method method) {
        startTest(method.getName(), "test description");
       // Test implementation
    }

    @Test(priority = 0, description = "Ensure I can add a Term deposit account with valid data")
    public void someTestFunction1(Method method) {
        startTest(method.getName(), "test description");
       // Test implementation
    }

      @Test(priority = 0, description = "Ensure I can add a Credit card account with valid data")
    public void someTestFunction1(Method method) {
        startTest(method.getName(), "test description");
       // Test implementation
    }
*/
}
