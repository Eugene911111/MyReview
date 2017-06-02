package helpers;

import core.Configuration;

import java.sql.*;

public class SqlQueries {

//    public static Connection getConnectionToDb() throws SQLException {
//        return DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
//    }

    public void delete(String tableName, String columnName, String symbol, String value) throws Exception {
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        String query = ("delete from " + tableName + " where " + columnName + " " + symbol + "'" + value + "'");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        statement.close();
        connection.close();
    }

    public void deleteGoalById() throws Exception {
        String query = "DELETE FROM goals WHERE id > ? AND user_id  = '" + Configuration.getInstance().getEpTester1Id() + "'";
        int deleteUserId = 160;
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, deleteUserId);
        statement.execute();
        statement.close();
        connection.close();
    }

    public void delete1() throws Exception {
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());

        String query = "DELETE FROM goals WHERE id <= ? AND user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        int deleteUserIdd = 3;
        statement.setInt(1, deleteUserIdd + 1);
        statement.setString(2, Configuration.getInstance().getEpTester1Id());
        statement.execute();
        statement.close();
        connection.close();
    }

    public void delete(String tableName, String columnName, String symbol, String value, String columnName2, String value2) throws Exception {
        String query = "delete from " + tableName + " where " + columnName + " " + symbol + "'" + value + "' AND " + columnName2 + "= '" + value2 + "'";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        statement.close();
        connection.close();
    }

    public String select(String select, String table, String columnName, String value) throws Exception {
        String query = " SELECT " + select + " from " + table + " where " + columnName + " " + "=" + " '" + value + "'";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        Statement statement = connection.createStatement();
        String selectReturn = null;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            selectReturn = rs.getString(select);
        }
        statement.close();
        connection.close();
        return selectReturn;
    }

    public String select(String appointment_date) throws Exception {
        String query = " SELECT " + appointment_date + " from user_form_history where id =(SELECT MAX(id) as MAX_ID from user_form_history where user_id = '644E3D87-E5EC-4274-8B26-EF76C5537E93')";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        Statement statement = connection.createStatement();
        String select = null;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            select = rs.getString(appointment_date);
        }
        statement.close();
        return select;
    }

    public String select(String table, String columnName, String value) throws Exception {
        String query = "SELECT * from " + table + " where " + columnName + " " + "=" + " '" + value + "' and author_id = '" + Configuration.getInstance().getEpTester1Id() + "'";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());
        Statement statement = connection.createStatement();
        String title = null;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            title = rs.getString(columnName);
        }
        statement.close();
        connection.close();
        return title;
    }

    public String selectSelfRating() throws Exception {
        String query = " SELECT self_rating FROM user_forms where id ='" + Configuration.getInstance().getEpTester1Id() + "'";
        Connection connection = DriverManager.getConnection(Configuration.getInstance().getMyreviewDbUrl(), Configuration.getInstance().getMyReviewDbUserName(), Configuration.getInstance().getMyReviewDbUserPassword());

        try (Statement statement = connection.createStatement()) {
            String select = null;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                select = rs.toString();
            }
            statement.close();
            connection.close();
            return select;
        } catch (Exception e) {
            throw e;
        }
    }
}