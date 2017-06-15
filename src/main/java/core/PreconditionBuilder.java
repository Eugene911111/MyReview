package core;

import helpers.SqlQueries;
import pages.BasePage;
import pages.LoginPage;
import pages.NoteTabPage;

import java.sql.*;

public class PreconditionBuilder {

    private SqlQueries sqlQueries = new SqlQueries();
    private LoginPage loginPage = new LoginPage();
    private BasePage basePage = new BasePage();
    private NoteTabPage noteTabPage = new NoteTabPage();

    private String login;
    private String sql;
    private int number;

    public PreconditionBuilder loginAs(String userName) throws Exception {
        loginPage.logIn(userName);
        changeStatusOfUserForm(Configuration.getInstance().getInProgress());
        sqlQueries.deleteGoalsCreatedByTestUser();
        return this;
    }

    public PreconditionBuilder sqlPreconditionsForLogIn() throws Exception {
        changeStatusOfUserForm(Configuration.getInstance().getInProgress());
        sqlQueries.deleteGoalsCreatedByTestUser();
        return this;
    }

    public PreconditionBuilder justLogIn(String userName) throws Exception {
        loginPage.logIn(userName);
        return this;
    }

    public PreconditionBuilder insert(int numberOfNotes) throws Exception {
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        Statement statement = connection.createStatement();
        for (int i = 1; i <= numberOfNotes; i++) {
            statement.executeUpdate("INSERT INTO goals (user_id, author_id, user_form_history_id, title, progress, status,created_at, updated_at, deadline, comment_employee, comment_department_manager, comment_irrelevant) " +
                    "VALUES ('" + Configuration.getInstance().getATester1Id() + "', '" + Configuration.getInstance().getATester1Id() + "', NULL, 'autoTestTitle', 'new', 'note', '2017-04-27 09:53:27', '2017-04-27 09:53:27', '2017-07-27', 'comment', NULL, NULL)");
        }
        statement.close();
        connection.close();
        return this;
    }

    public PreconditionBuilder changeStatusOfUserForm(String status) throws Exception {
        String query = " UPDATE user_forms " +
                " SET status = '" + status + "', " +
                " comment_employee = 'comment_created_with_auto_test', " +
                " comment_department_manager = 'comment_created_with_auto_test', " +
                " self_rating = 'Exceeds expectations', " +
                " manager_rating = 'Exceeds expectations' " +
                " WHERE user_id = '" + Configuration.getInstance().getATester1Id() + "'";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        connection.close();
        return this;
    }

    public PreconditionBuilder addEmployeeComment() throws SQLException {
        String query = " UPDATE user_forms " +
                " SET comment_employee = 'comment_created_with_auto_test', " +
                " self_rating = 'Exceeds expectations' " +
                " WHERE user_id = '" + Configuration.getInstance().getATester1Id() + "'";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            basePage.log.error("SQLException." + e.toString());
        }
        return this;
    }

    public PreconditionBuilder addNoteToSettingObjectiveDB(int numberOfNotes, String status) throws Exception {
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        Statement statement = connection.createStatement();
        for (int i = 1; i <= numberOfNotes; i++) {
            statement.executeUpdate(" INSERT INTO goals (user_id, author_id, user_form_history_id, title, progress, status,created_at, updated_at, deadline, comment_employee, comment_department_manager, comment_irrelevant) " +
                    " VALUES ('" + Configuration.getInstance().getATester1Id() + "', '" + Configuration.getInstance().getATester1Id() + "', NULL, '" + basePage.returnCurrentDate() + "', 'started', '" + status + "', '2017-04-27 09:53:27', '2017-04-27 09:53:27', '2017-07-27', 'comment', NULL, NULL)");
        }
        statement.close();
        connection.close();
        return this;
    }

    public PreconditionBuilder delete(String tableName, String columnName, String symbol, String value, String columnName2, String value2) throws Exception {
        String query = "delete from " + tableName + " where " + columnName + " " + symbol + "'" + value + "' AND " + columnName2 + "= '" + value2 + "'";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        statement.close();
        connection.close();
        return this;
    }

    public Precondition build() {
        Precondition precondition = new Precondition();
        precondition.setLogin(login);
        precondition.setSql(sql);
        return precondition;
    }
}