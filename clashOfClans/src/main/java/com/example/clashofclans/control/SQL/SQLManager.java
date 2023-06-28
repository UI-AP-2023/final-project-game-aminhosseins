package com.example.clashofclans.control.SQL;

import java.sql.*;
import java.util.ArrayList;

public class SQLManager {
    private static final String URL="jdbc:mysql://localhost/clashofclans";
    private static final String Username="root";
    private static final String Password="123456";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(URL,Username,Password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> getNames() throws SQLException {
        String SQL="Select name FROM playersinfo";
        Statement sql=connection.prepareStatement(SQL);
        ResultSet resultSet=sql.executeQuery(SQL);
        ArrayList<String> names=new ArrayList<>();
        while (resultSet.next()){
            names.add(resultSet.getString(1));
        }
        return names;
    }
    public static void setNewPlayer(String playerName,String playerPassword) throws SQLException {
        String SQL="INSERT INTO playersinfo (name,password) VALUES( '"+playerName+"','"+playerPassword+"')";
        Statement sql=connection.prepareStatement(SQL);
        sql.execute(SQL);
    }

}
