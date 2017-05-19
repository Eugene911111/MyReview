package helpers;

import org.openqa.selenium.WebDriver;

import java.sql.*;
import java.text.SimpleDateFormat;

import static core.Configuration.*;

public class sqlQueries {

    private WebDriver driver;
    private String currentDate;

    public final static String DELETE_GOALS_BY_ID = "DELETE FROM goals WHERE id >= ?";
    public final static String DELETE_USER_BY_ID = "DELETE FROM goals WHERE id <= ? AND user_id = ?";

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(myReviewDbUrl, myReviewDbUserName, myReviewDbUserPassword);
    }

    private String returnCurrentDate() throws InterruptedException {
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh.mm.ss a");
        currentDate = ft.format(new java.util.Date());
        return currentDate;
    }

    public void insert(int numberOfNotes) throws Exception {
        Connection conn = DriverManager.getConnection(myReviewDbUrl, myReviewDbUserName, myReviewDbUserPassword);
        Statement st = conn.createStatement();
        for (int i = 1; i <= numberOfNotes; i++) {
            st.executeUpdate("INSERT INTO goals (id, user_id, author_id, user_form_history_id, title, progress, status,created_at, updated_at, deadline, comment_employee, comment_department_manager, comment_irrelevant) " +
                    "VALUES (" + i + ",'" + EPTESTER_1_ID + "', '" + EPTESTER_1_ID + "', NULL, 'autoTestTitle', 'new', 'note', '2017-04-27 09:53:27', '2017-04-27 09:53:27', '2017-07-27', 'comment', NULL, NULL)");
        }
        conn.close();
    }

    public void addNoteToSettingObjectiveDB(int numberOfNotes, String status) throws Exception {
        Statement st = getConnection().createStatement();
        for (int i = 1; i <= numberOfNotes; i++) {
            st.executeUpdate("INSERT INTO goals (id, user_id, author_id, user_form_history_id, title, progress, status,created_at, updated_at, deadline, comment_employee, comment_department_manager, comment_irrelevant) " +
                    "VALUES (" + i + ",'" + EPTESTER_1_ID + "', '" + EPTESTER_1_ID + "', NULL, '" + returnCurrentDate() + "', 'new', '" + status + "', '2017-04-27 09:53:27', '2017-04-27 09:53:27', '2017-07-27', 'comment', NULL, NULL)");
        }
        getConnection().close();
    }

    public void changeStatusOfUserForm1(String status) throws Exception {
        Statement st = getConnection().createStatement();
        st.executeUpdate("UPDATE user_forms " +
                "SET status = '" + status + "', " +
                "comment_employee = 'comment_created_with_auto_test', " +
                "comment_department_manager = 'comment_created_with_auto_test'" +
                "WHERE user_id = '" + EPTESTER_1_ID + "'");
        getConnection().close();
    }

    public void addEmployeeComment() throws Exception {
        Statement st = getConnection().createStatement();
        st.executeUpdate("UPDATE user_forms " +
                " SET comment_employee = 'comment_created_with_auto_test', " +
                "self_rating = 'Exceeds expectations'" +
                "WHERE user_id = '" + EPTESTER_1_ID + "'");
        getConnection().close();
    }

    public void changeStatusOfUserForm(String status) throws Exception {
        Statement st = getConnection().createStatement();
        st.executeUpdate("UPDATE user_forms " +
                "SET status = '" + status + "', " +
                "comment_employee = 'comment_created_with_auto_test', " +
                "comment_department_manager = 'comment_created_with_auto_test', " +
                "self_rating = 'Exceeds expectations', " +
                "manager_rating = 'Exceeds expectations' " +
                "WHERE user_id = '" + EPTESTER_1_ID + "'");
        getConnection().close();
    }

    public void delete(String tableName, String columnName, String symbol, String value) throws Exception {
        String query = ("delete from " + tableName + " where " + columnName + " " + symbol + "'" + value + "'");
        PreparedStatement preparedStmt = getConnection().prepareStatement(query);
        preparedStmt.execute();
        getConnection().close();
    }

    public void deleteGoalById(String query) throws Exception {
        final int deleteUserId = 160;
        PreparedStatement preparedStmt = getConnection().prepareStatement(query);
        preparedStmt.setInt(1, deleteUserId);
        preparedStmt.execute();
        getConnection().close();
    }

    public void delete1(String query) throws Exception {
        PreparedStatement preparedStmt = getConnection().prepareStatement(query);
        final int deleteUserIdd = 3;
        preparedStmt.setInt(1, deleteUserIdd);
        preparedStmt.setString(2, EPTESTER_1_ID);
        preparedStmt.execute();
        getConnection().close();
    }

    public void delete(String tableName, String columnName, String symbol, String value, String columnName2, String value2) throws Exception {
        String query = ("delete from " + tableName + " where " + columnName + " " + symbol + "'" + value + "' AND " + columnName2 + "= '" + value2 + "'");
        PreparedStatement preparedStmt = getConnection().prepareStatement(query);
        preparedStmt.execute();
        getConnection().close();
    }

    public String select(String table, String columnName, String value) throws Exception {
        Statement stmt = getConnection().createStatement();
        ResultSet rs;
        String title = null;
        rs = stmt.executeQuery("SELECT * from " + table + " where " + columnName + " " + "=" + " '" + value + "' and author_id = '" + EPTESTER_1_ID + "'");
        while (rs.next()) {
            title = rs.getString(columnName);
        }
        getConnection().close();
        return title;
    }

    public String select(String select, String table, String columnName, String value) throws Exception {
        Statement stmt = getConnection().createStatement();
        ResultSet rs;
        String selectReturn = null;
        rs = stmt.executeQuery("SELECT " + select + " from " + table + " where " + columnName + " " + "=" + " '" + value + "'");
        while (rs.next()) {
            selectReturn = rs.getString(select);
        }
        getConnection().close();
        return selectReturn;
    }
    public String sewewewewlecewrwewewewewewt(String appointment_date) throws Exception {
        Statement stmt = getConnection().createStatement();
        ResultSet rs;
        String selectReturn = null;
        rs = stmt.executeQuery("SELECT "+appointment_date+" from user_form_history where id =(SELECT MAX(id) as MAX_ID from user_form_history where user_id = '644E3D87-E5EC-4274-8B26-EF76C5537E93')");
        while (rs.next()) {
            selectReturn = rs.getString(appointment_date);
        }
        getConnection().close();
        return selectReturn;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
