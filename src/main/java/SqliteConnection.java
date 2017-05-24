import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;



/**
 * Created by Thiago Trennepohl on 14/05/17.
 */

public class SqliteConnection {
	private static String url = "jdbc:sqlite:MedievalBattle.db";
	private static final Logger LOGGER = Logger.getLogger( Class.class.getName() );
	

    public Connection connect() {

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
           return conn;
        }
    }
    
    
    public void initDatabase(){
      if(!this.isDatabaseCreated()){
    	try (Connection conn = this.connect()){
    	  ScriptUtils.executeSqlScript(conn, new FileSystemResource("src/main/java/resources/initialData.sql"));
    	  conn.close();
    	}
    	catch (Exception e) {
    	  System.out.println("deu pau");
		}
      }else {
    	  
    	  LOGGER.log( Level.INFO, "Database already exists... moving on...");
    	  
      }
      
    }
    
    public FightStyle getFightStyle(String style){
      String sql = "SELECT * FROM fight_style WHERE name='"+ style+"';";
      FightStyle fightStyle = new FightStyle();
      try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
        while(rs.next()){
          fightStyle.setAttack(rs.getInt("attack"));
          fightStyle.setDefense(rs.getInt("defese"));
          fightStyle.setLuck(rs.getInt("luc"));
          fightStyle.setSpecial(rs.getInt("special"));
          return fightStyle;
        }
       }catch (SQLException e) {
           System.out.println(e.getMessage());
       }
	return null;
    }
  
    public boolean isDatabaseCreated(){
    	File f = new File("MedievalBattle.db");
    	if(f.exists()) { 
    	    return true;
    	}
    	return false;
    }
    	
    }
