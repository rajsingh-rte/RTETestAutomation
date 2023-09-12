package DataBaseConnection;

import java.sql.*;
//import com.mysql.jdbc.Statement;

public class DBConnection {

    public static void main(String[] args) throws SQLException {
        String host="3.126.158.182";
        String port= "1521";
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@3.126.158.182:1521:STOC","User","pwd");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from abc where ID = '70776'");
        while (rs.next()) {
            System.out.println(rs.getString("FIRST_NAME"));
        }
    }
}



