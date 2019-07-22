package com.stackroute.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleJdbcDemo {

    // method to get employee details
    public void getEmployeeDetails() {

        try {
            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            // catch exceptions
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        try (
                /*Use DriverManager to get Connection*/
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
                // create statements
                Statement statement = connection.createStatement();
                // fetch data from employee
                ResultSet resultSet = statement.executeQuery("Select * from employee");)
            {
            // iterate over all employee data
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }

            // catch exceptions
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {
        try {

            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            // catch driver exceptions
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        try (
                /*Use DriverManager to get Connection*/
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
                // create statement
                Statement statement = connection.createStatement();
                // fetch data from employee table
                ResultSet resultSet = statement.executeQuery("Select * from employee");)
            {

            resultSet.afterLast(); //Moves the curser to the end of the ResultSet object
                // iterate in reverse direction
                while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }

        // catch exceptions
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {

            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                /*Use DriverManager to get Connection*/
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
                // create statement
                Statement statement = connection.createStatement();
                // fetch data from employee table
                ResultSet resultSet = statement.executeQuery("Select * from employee");)
            {
            // set the cursor to last position
            resultSet.afterLast();
                // iterate in reverse direction to the second row
                while (resultSet.previous() && resultSet.getRow()!=1) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
                }
                // catch exceptions
            } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Use PreparedStatement to display by name and gender
    public void getEmployeeDetailsByNameAndGender(String name,String gender) {
        try {

            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            // catch driver exceptions
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        try (
                /*Use DriverManager to get Connection*/
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDb", "root", "Root@123");
                // create prepareStatement
                PreparedStatement statement=connection.prepareStatement("select * from employee where name=? and gender=?");){
                //1 specifies the first parameter in the query
                statement.setString(1,name);
                //2 specifies the first parameter in the query
                statement.setString(2,gender);

                // execute query
                ResultSet resultSet=statement.executeQuery();
                // iterate using resultset
                while (resultSet.next()) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
                }
        // catch exceptions
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}