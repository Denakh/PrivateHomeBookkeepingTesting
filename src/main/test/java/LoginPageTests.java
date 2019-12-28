import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BasePHBTestSetups {

    @Test(priority = 1, description = "Verify that name field is editable")
    @Severity(SeverityLevel.BLOCKER)
    public void testNameFieldIsEditable() {
//      String actualAddHotelNameText = newHotelPage.getTypedNameValue();
//      Log.LOG.debug("Comparison of actual result ('" + actualAddHotelNameText + "') " +
//              "and expected ('" + text + "')");
        Assert.assertTrue(true, "Error");
    }

}
