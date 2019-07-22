package com.stackroute.jdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        // run for Simple jdbc demo
//        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
//        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Shubhi","female");
//
//        // run for resultset meta data demo
//        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
//        resultSetMetadataDemo.getResultSetMetaDeta();
//
//        // run for database meta data demo
//        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
//        databaseMetadataDemo.getDatabaseMetaDeta();

        // run for rowset meta data demo
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.getEmployeeDetailsUsingRowSet();
//
//        // run for jdbc batch demo
//        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
//        jdbcBatchDemo.addEmployeeUsingBatch();

        // run for transaction demo
//        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
//        jdbcTransactionDemo.transactionDemo("insert into employee values(10,'a',21,'female')",
//                "insert into employee values(11,'abc',21,'aaaaaaaaaaaaaaaaaaa')");
    }
}
