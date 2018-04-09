package Connection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CreateConnectionClass {

    public static void main(String[] args) throws SQLException {
        CreateConnectionClass dataBaseClass = new CreateConnectionClass();
        // dataBaseClass.insertRecordIntoDatabse();
        //dataBaseClass.updateRecordFromDatabase();
        //dataBaseClass.deleteRecordFromDatabase();
        dataBaseClass.selectRecordFromDatabase();


    }

    void insertRecordIntoDatabse() throws SQLException {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest",
                    "root", "admin");
            if (connection == null) {
                System.out.println("Connection not established!");
                System.exit(0);
            }

            System.out.println("Database connection success!");
            Statement statement = connection.createStatement();
            try {
                statement.executeUpdate("INSERT INTO users(id,name, age, email)\n" +
                        "VALUES (18, 'Oleksandr', 43, 'oleksandr@gmail.com')");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    void updateRecordFromDatabase() throws SQLException {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest",
                    "root", "admin");
            if (connection == null) {
                System.out.println("Connection not established!");
                System.exit(0);
            }
            System.out.println("Database connection success!");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE users SET name = 'Vasya', age = 30, email ='vasyua@gmail.com' " +
                    "WHERE id = 4 ");

        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    void deleteRecordFromDatabase() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest",
                    "root", "admin");
            if (connection == null) {
                System.out.println("Connection not established!");
                System.exit(0);
            }
            System.out.println("Database connection success!");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM users WHERE name LIKE '%ndr%'");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }

        }

    }

    void selectRecordFromDatabase() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest",
                    "root", "admin");
            if (connection == null) {
                System.out.println("Connection not established!");
                System.exit(0);
            }
            System.out.println("Database connection success!");
            Map<Integer, String>  map  = new HashMap();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM users ");
            while (resultSet.next()) {
                map.put((resultSet.getInt("id")),
                        resultSet.getString("name"));
            }
            map.forEach((Integer key, String value) -> {
                System.out.println(  key + " " + value);
            });
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }

        }

    }
}