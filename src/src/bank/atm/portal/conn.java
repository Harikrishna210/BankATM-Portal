package bank.atm.portal;

import java.sql.*;
public class conn {
    Connection connection;
    Statement statement;

    public conn(){
        try{
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bankrecords","root","Root@123");
            statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
