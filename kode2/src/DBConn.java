import java.sql.*;
import java.util.Properties;

public abstract class DBConn {
    protected Connection conn;

    public DBConn () {
    }
    public void connect() {
    	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Properties for user and password. Here the user and password are both 'paulr'
            Properties p = new Properties();
            p.put("user", "root");
            p.put("password", "root");           
	    //            conn = DriverManager.getConnection("jdbc:mysql://mysql.ansatt.ntnu.no/sveinbra_ektdb?autoReconnect=true&useSSL=false",p);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",p);
        } catch (Exception e)
    	{
            throw new RuntimeException("Unable to connect", e);
    	}
    }
}