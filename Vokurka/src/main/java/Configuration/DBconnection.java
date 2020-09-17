package Configuration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnection {

    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://packeta-db-dev-2.westeurope.cloudapp.azure.com/zasilkovna?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // Constant for Database Username
    public static String DB_USER = "zasilkovnadev";
    // Constant for Database Password
    public static String DB_PASSWORD = "pingdingbing";

    @Before
    public void setUp() throws Exception {
        try{
            // Make the database connection
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            // Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try{
            String query = "SELECT * FROM tmp_bexport";
            // Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
            // Print the result untill all the records are printed
            // res.next() returns true if there is any next record else returns false
            while (res.next())
            {
                System.out.print(res.getString(1));

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        // Close DB connection
        if (con != null) {
            con.close();
        }
    }

}
