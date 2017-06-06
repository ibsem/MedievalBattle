import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Thiago Trennepohl on 14/05/17.
 */

public class CharacterCreation {
	private static final Logger LOGGER = Logger.getLogger( Class.class.getName() );
	
    public Player createMainCharacter(String name, String fightStyle) {
      Player p1 = new Player();	
        FightStyle fs = this.getFightStyle("Warrior");
        p1.setAttack(fs.getAttack());
        p1.setDefense(fs.getDefense());
        p1.setLuck(fs.getLuck());
        p1.setSpecial(fs.getSpecial());
        p1.setName(name);
        
        return p1;
        
    }
    
    
    public FightStyle getFightStyle(String style){
    	SqliteConnection sqlite = new SqliteConnection();
        String sql = "SELECT * FROM fight_style WHERE name='"+ style+"';";
        FightStyle fightStyle = new FightStyle();
        
        try (Connection conn = sqlite.connect();
          Statement stmt  = conn.createStatement();
          ResultSet rs    = stmt.executeQuery(sql)){
      	  
          while(rs.next()){
            fightStyle.setAttack(rs.getInt("attack"));
            fightStyle.setDefense(rs.getInt("defense"));
            fightStyle.setLuck(rs.getInt("luck"));
          }
          return fightStyle;
          
        }catch (SQLException e) {
             LOGGER.log(Level.SEVERE, "Problems ahead" + e.getStackTrace());
         }
        return null;
      }
   




}
