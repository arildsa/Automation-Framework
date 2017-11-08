package dbTest;

import com.mysql.cj.jdbc.MysqlDataSource;
import junit.runner.Version;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbTest2 {

    @Test
    public void dbTest2Test(){
        String URL = "customertraining.crcw2iqfkol6.us-east-2.rds.amazonaws.com";
        String PORT = "3306";
        String DATABASE = "CustomerTraining";
        String user = System.getProperty("dbUser");
        String password = System.getProperty("dbPassword");

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setServerName(URL);
        dataSource.setPort(Integer.parseInt(PORT));
        dataSource.setDatabaseName(DATABASE);

        ResultSet result = null;
        Statement statement = null;
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            statement = conn.createStatement();
            result = statement.executeQuery("select * from CustomerTraining.Customer");

            if(result.next())
            {
                System.out.println();
            }

        } catch (SQLException ex){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            try {

                if (result != null) {
                    result.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
