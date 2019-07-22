package com.stackroute.jdbc;
import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;


public class RowSetDemo {
    public void getEmployeeDetailsUsingRowSet(){
        try {

            /*Load driver and register with DriverManager*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            // handle driver exceptions
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        try {
            //Creating and Executing RowSet
            JdbcRowSetImpl rowSet=new JdbcRowSetImpl();
            // JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/employeeDb");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            // fetch data from employee
            rowSet.setCommand("select * from employee");
            rowSet.execute();

            while (rowSet.next()) {
                // print data
                System.out.println("Id: " + rowSet.getInt(1));
                System.out.println("Name: " + rowSet.getString(2));
                System.out.println("Age: " + rowSet.getInt(3));
                System.out.println("Gender: " + rowSet.getString(4));
            }
            // catch exceptions
            } catch (
                    SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}
