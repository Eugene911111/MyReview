package core;

import pages.CommonPage;
import pages.LoginPage;

import static helpers.SqlQueries.*;

public class Preconditions {
    private LoginPage loginPage = new LoginPage();
    private CommonPage commonPage = new CommonPage();

    public void logInAs(String userName) throws Exception {
        changeStatusOfUserForm(Configuration.getInstance().getInProgress());
        delete1(DELETE_USER_BY_ID);
        deleteGoalById(DELETE_GOALS_BY_ID);
        loginPage.logIn(userName);
    }

    public void postcondition() throws Exception {
        commonPage.logOut();
    }
}

