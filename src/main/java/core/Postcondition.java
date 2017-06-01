package core;

import pages.CommonPage;

public class Postcondition {
    private CommonPage commonPage = new CommonPage();

    public void logout() throws Exception {
        commonPage.logOut();
    }
}