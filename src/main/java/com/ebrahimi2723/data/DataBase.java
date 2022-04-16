package com.ebrahimi2723.data;
import java.sql.*;
public class DataBase {

 public void sql(String sqlCommand){
    String connectionUrl = "jdbc:mysql://localhost:3306/student";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/student", "root", "");
        Statement statement = connection.createStatement();
        statement.execute(sqlCommand);
        connection.close();
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
 }

}
