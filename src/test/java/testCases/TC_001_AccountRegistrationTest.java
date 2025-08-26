package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test(groups= {"Regression","Master"})
    public void verify_account_registration() {
        logger.info("....TC_001_AccountRegistrationTest.........");
        try {
            // ✅ Pass thread-safe driver
            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();

            logger.info("....Clicked on my account link.........");

            hp.clickRegister();
            logger.info("....Clicked on Register link.........");

            AccountRegistrationPage regpage = new AccountRegistrationPage(getDriver());

            logger.info("....Providing Customer Details.........");

            regpage.setFirstName(randomeString().toUpperCase());
            regpage.setLastName(randomeString().toUpperCase());
            regpage.setEmail(randomeString()+"@gmail.com");

            String password = randomAlphaNumeric();

            regpage.setPassword(password);
            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("....Validating message.........");
            String confmsg = regpage.getConfirmationMsg();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

            logger.info("Test passed");
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            logger.info("***** Finished TC001_AccountRegistrationTest *****");
        }
    }
}
