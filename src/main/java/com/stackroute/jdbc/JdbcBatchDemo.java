package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {

    public void addEmployeeUsingBatch() {
        try {
            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            // catch exceptions
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (
                /*Use DriverManager to get Connection*/
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
                // create statement
                Statement statement = connection.createStatement();) {
                // set auto commit to false
                connection.setAutoCommit(false);

                // add two statements to batch
                statement.addBatch("insert into employee values(9,'pragya',21,'female')");
                statement.addBatch("insert into employee values(10,'himanshu',22,'male')");

                // execute batch
                statement.executeBatch();

                // commit
                connection.commit();

                // fetch data from employee
                ResultSet resultSet = statement.executeQuery("select * from employee");

                // print result using resultset
                while (resultSet.next()) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
                }
                // catch exceptions
                } catch (
                    SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }}
