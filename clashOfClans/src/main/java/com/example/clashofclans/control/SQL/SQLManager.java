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
    public static void updateMapID(int ID,String Name) throws SQLException {
        String SQL="UPDATE playersinfo SET mapID="+ID+" WHERE name='"+Name+"'";
        Statement sql=connection.prepareStatement(SQL);
        sql.execute(SQL);
    }
    public static String getPlayerPassword(String name) throws SQLException {
        String SQL="Select password FROM playersinfo WHERE name='"+name+"'";
        Statement sql=connection.prepareStatement(SQL);
        ResultSet resultSet=sql.executeQuery(SQL);
        StringBuilder s=new StringBuilder();
        while (resultSet.next()){
            s.append(resultSet.getString(1));
        }
        return s.toString();
    }
    public static ResultSet getPlayerInfo(String name) throws SQLException {
        String SQL="Select level,xp,cup,win,lost,star,mapID FROM playersinfo WHERE name='"+name+"'";
        Statement sql=connection.prepareStatement(SQL);
        return sql.executeQuery(SQL);
    }
    public static ResultSet getAllPlayersAttackInfo() throws SQLException {
        String SQL="Select name,level,mapID,cup FROM playersinfo";
        Statement sql=connection.prepareStatement(SQL);
        return sql.executeQuery(SQL);
    }
    public static ResultSet getAllLeaderBoardInfo()throws SQLException{
        String SQL="Select name,level,win,lost,star,mapID,cup FROM playersinfo";
        Statement sql=connection.prepareStatement(SQL);
        return sql.executeQuery(SQL);
    }
}
