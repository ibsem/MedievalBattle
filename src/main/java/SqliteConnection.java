import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Object;


/**
 * Created by Thiago Trennepohl on 14/05/17.
 */

public class SqliteConnection {
	private static String url = "jdbc:sqlite:MedievalBattle.db";


    public void connect() {

        Connection conn = null;
        try {
        	//connects to the sqlite database MedievalBattle
        	Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

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
    
    public void initDatabase(){
    	
    }

    public void select(String sql){
    	

    }
    
    public void insert(String sql){
    	
    }
    
    public static void initFightStyles(){
    	String sql = "INSERT INTO fight_style(name,attack,defense,luck) VALUES(?,?,?,?)";
        
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
        	
            //stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    }
    
    public static void createFightStylesTable() {
    	//ceates Fight_Style Table(containes character classes)
        String sql = "CREATE TABLE IF NOT EXISTS fight_style  (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	attack int NOT NULL,\n"
                + " defense int NOT NULL,\n"
                + " luck int NOT NULL,\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
