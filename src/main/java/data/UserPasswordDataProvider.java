package data;

import org.testng.annotations.DataProvider;

public class UserPasswordDataProvider {

    @DataProvider
    public Object[][] addWrongUserPasswordPair() {
        return new Object[][]{
                {"non-existent user", "some password"},
                {"", "test password"},
                {"test user", ""}
        };

    }

}
