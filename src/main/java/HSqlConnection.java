import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import org.


/**
 * Created by thiago on 14/05/17.
 */

public class HSqlConnection {


    public void connect() {

        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver" );
            String url = "jdbc:hsqldb:file:/home/thiago/MedievalBattleDB/MedievalBattle";
            conn = DriverManager.getConnection(url,"SA","");
            System.out.println("Connection to HSQL has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void select(String sql){

    }
}
