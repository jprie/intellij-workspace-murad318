package com.example.logindatabasegx;

import com.example.logindatabasegx.Controller.User;
import com.example.logindatabasegx.Model.Order;
import com.example.logindatabasegx.Model.OrderModel;
import com.example.logindatabasegx.Model.UserModel;

import java.sql.*;

public class DatabaseUtility {

    private static final String dbPrefix = "jdbc:mariadb:";
    //location = IP-Adresse + Port + / Datenbank-Name
    private static final String location = "//172.16.171.3:3306/318";
    private static final String dbUser = "root";
    private static final String dbPw = "";

    private static Connection connection;

    public static void connectDatabase() throws SQLException {

        try {
            connection = DriverManager.getConnection(dbPrefix + location, dbUser, dbPw);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static Boolean checkUsernamePw(String username, String password) throws SQLException {

        String query = "select * from login_user where username=? AND password=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    UserModel.username = resultSet.getString("username");
                    UserModel.userid = resultSet.getString("id");
                    UserModel.fName = resultSet.getString("firstname");
                    UserModel.lName = resultSet.getString("lastname");
                    return true;
                }
            }
        }

        return false;
    }

    public static Boolean insertUser(User user) {

        String query = "INSERT INTO login_user (username, firstname, lastname, email, password, gender) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.userName());
            statement.setString(2, user.firstName());
            statement.setString(3, user.lastName());
            statement.setString(4, user.email());
            statement.setString(5, user.password());
            statement.setString(6, user.gender());

            try (ResultSet keys = statement.executeQuery()){

                keys.next();
                long id = keys.getLong("id");
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean readOrders() {

        String query = "SELECT * FROM `buylando_orders` " +
                "JOIN product on buylando_orders.productid=product.productid " +
                "JOIN login_user on buylando_orders.userid=login_user.id " +
                "WHERE buylando_orders.userid="+ UserModel.userid +";";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String fName = resultSet.getString("firstname");
                String lName = resultSet.getString("firstname");
                String product = resultSet.getString("description");
                String label = resultSet.getString("label");
                String date = resultSet.getString("date");
                String price = resultSet.getString("price");
                Order order = new Order(fName, lName,product,label,date,price);
                OrderModel.list.add(order);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
