import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 * Created by Thiago Trennepohl on 14/05/17.
 */

public class CharacterCreation {
	private String[] fightStyles = {"Warrior","Mage","Archer"};
	private String[] enemyNames = {"Brutus", "Judas", "Donald Trump", "Sauron", "Saruman", "Darth Vader"}; 
	private static final Logger LOGGER = Logger.getLogger( Class.class.getName() );
	private Random randomNumber = new Random();
	
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
    
    public Player createEnemy() {
        Player p1 = new Player();	
          FightStyle fs = this.getFightStyle(fightStyles[randomNumber.nextInt(4)]);
          p1.setAttack(fs.getAttack());
          p1.setDefense(fs.getDefense());
          p1.setLuck(fs.getLuck());
          p1.setSpecial(fs.getSpecial());
          p1.setName(enemyNames[randomNumber.nextInt(enemyNames.length + 1)]);          
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
