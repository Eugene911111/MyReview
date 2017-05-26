package helpers;

import core.Configuration;
import pages.BasePage;

import java.sql.*;

public class SqlQueries {

    private static BasePage basePage = new BasePage();
    public static String DELETE_GOALS_BY_ID = "DELETE FROM goals WHERE id >= ?";
    public static String DELETE_USER_BY_ID = "DELETE FROM goals WHERE id <= ? AND user_id = ?";

    private static Connection getConnectionToDb() throws SQLException {
        return DriverManager.getConnection(Configuration.getInstance().getMyreviewdburl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
    }

    private static void closeConnection() throws SQLException {
        getConnectionToDb().close();
    }

    public static Connection returnCurrentconnection(Connection connection) throws InterruptedException {
        return connection;
    }

    public static void insert(int numberOfNotes) throws Exception {
        Statement st = getConnectionToDb().createStatement();
        for (int i = 1; i <= numberOfNotes; i++) {
            st.executeUpdate("INSERT INTO goals (id, user_id, author_id, user_form_history_id, title, progress, status,created_at, updated_at, deadline, comment_employee, comment_department_manager, comment_irrelevant) " +
                    "VALUES (" + i + ",'" + Configuration.getInstance().getEpTester1Id() + "', '" + Configuration.getInstance().getEpTester1Id() + "', NULL, 'autoTestTitle', 'new', 'note', '2017-04-27 09:53:27', '2017-04-27 09:53:27', '2017-07-27', 'comment', NULL, NULL)");
        }
        getConnectionToDb().close();
    }

    public static void addNoteToSettingObjectiveDB(int numberOfNotes, String status) throws Exception {
        Statement st = getConnectionToDb().createStatement();
        for (int i = 1; i <= numberOfNotes; i++) {
            st.executeUpdate("INSERT INTO goals (id, user_id, author_id, user_form_history_id, title, progress, status,created_at, updated_at, deadline, comment_employee, comment_department_manager, comment_irrelevant) " +
                    "VALUES (" + i + ",'" + "644E3D87-E5EC-4274-8B26-EF76C5537E93" + "', '" + "644E3D87-E5EC-4274-8B26-EF76C5537E93" + "', NULL, '" + basePage.returnCurrentDate() + "', 'new', '" + status + "', '2017-04-27 09:53:27', '2017-04-27 09:53:27', '2017-07-27', 'comment', NULL, NULL)");
        }
        getConnectionToDb().close();
    }

    public static void addEmployeeComment() throws SQLException {
        String query = " UPDATE user_forms " +
                " SET comment_employee = 'comment_created_with_auto_test', " +
                " self_rating = 'Exceeds expectations' " +
                " WHERE user_id = '" + Configuration.getInstance().getEpTester1Id() + "'";

        try (Statement stmt = getConnectionToDb().createStatement()) {
            stmt.executeUpdate(query);
            closeConnection();
        } catch (SQLException e) {
            basePage.log.error("SQLException." + e.toString());
        }
    }

    public static void changeStatusOfUserForm(String status) throws Exception {
        Statement st = getConnectionToDb().createStatement();
        st.executeUpdate("UPDATE user_forms " +
                "SET status = '" + status + "', " +
                "comment_employee = 'comment_created_with_auto_test', " +
                "comment_department_manager = 'comment_created_with_auto_test', " +
                "self_rating = 'Exceeds expectations', " +
                "manager_rating = 'Exceeds expectations' " +
                "WHERE user_id = '" + Configuration.getInstance().getEpTester1Id() + "'");
        getConnectionToDb().close();
    }

    public static void delete(String tableName, String columnName, String symbol, String value) throws Exception {
        String query = ("delete from " + tableName + " where " + columnName + " " + symbol + "'" + value + "'");
        PreparedStatement preparedStmt = getConnectionToDb().prepareStatement(query);
        preparedStmt.execute();
        getConnectionToDb().close();
    }

    public static void deleteGoalById(String query) throws Exception {
        int deleteUserId = 160;
        PreparedStatement preparedStmt = getConnectionToDb().prepareStatement(query);
        preparedStmt.setInt(1, deleteUserId);
        preparedStmt.execute();
        getConnectionToDb().close();
    }

    public static void delete1(String query) throws Exception {
        PreparedStatement preparedStmt = getConnectionToDb().prepareStatement(query);
        int deleteUserIdd = 3;
        preparedStmt.setInt(1, deleteUserIdd);
        preparedStmt.setString(2, Configuration.getInstance().getEpTester1Id());
        preparedStmt.execute();
        getConnectionToDb().close();
    }

    public static void delete(String tableName, String columnName, String symbol, String value, String columnName2, String value2) throws Exception {
        String query = ("delete from " + tableName + " where " + columnName + " " + symbol + "'" + value + "' AND " + columnName2 + "= '" + value2 + "'");
        PreparedStatement preparedStmt = getConnectionToDb().prepareStatement(query);
        preparedStmt.execute();
        getConnectionToDb().close();
    }

    public static String select(String table, String columnName, String value) throws Exception {
        Statement stmt = getConnectionToDb().createStatement();
        ResultSet rs;
        String title = null;
        rs = stmt.executeQuery("SELECT * from " + table + " where " + columnName + " " + "=" + " '" + value + "' and author_id = '" + Configuration.getInstance().getEpTester1Id() + "'");
        while (rs.next()) {
            title = rs.getString(columnName);
        }
        getConnectionToDb().close();
        return title;
    }

    public static String select(String select, String table, String columnName, String value) throws Exception {
        Statement stmt = getConnectionToDb().createStatement();
        String selectReturn = null;
        ResultSet rs = stmt.executeQuery("SELECT " + select + " from " + table + " where " + columnName + " " + "=" + " '" + value + "'");
        while (rs.next()) {
            selectReturn = rs.getString(select);
        }
        getConnectionToDb().close();
        return selectReturn;
    }

    public static String sewewewewlecewrwewewewewewt(String appointment_date) throws Exception {
        Statement stmt = getConnectionToDb().createStatement();
        ResultSet rs;
        String selectReturn = null;
        rs = stmt.executeQuery("SELECT " + appointment_date + " from user_form_history where id =(SELECT MAX(id) as MAX_ID from user_form_history where user_id = '644E3D87-E5EC-4274-8B26-EF76C5537E93')");
        while (rs.next()) {
            selectReturn = rs.getString(appointment_date);
        }
        getConnectionToDb().close();
        return selectReturn;
    }

    public static String selectSelfRating() throws SQLException {
        String query = "SELECT self_rating FROM user_forms where id ='" + Configuration.getInstance().getEpTester1Id() + "'";
        try (Statement stmt = getConnectionToDb().createStatement()) {
            String selectReturn = null;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                selectReturn = rs.toString();
            }
            return selectReturn;
        } catch (SQLException e) {
            throw e;
        }
    }
}