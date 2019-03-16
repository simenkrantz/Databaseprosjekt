import java.sql.*;
import java.util.Properties;

public abstract class DBConn {
    protected Connection conn;

    public DBConn () {
    }
    public void connect() {
    	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Properties p = new Properties();
            p.put("user", "halvorot_db");
            p.put("password", "halvorot");           
            conn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no:3306/halvorot_prosjekt",p);
        } catch (Exception e)
    	{
            throw new RuntimeException("Unable to connect", e);
    	}
    }
}