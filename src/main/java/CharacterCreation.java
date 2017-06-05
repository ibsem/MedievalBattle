import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Thiago Trennepohl on 14/05/17.
 */

public class CharacterCreation {
//	private SqliteConnection sqliteConnection = new SqliteConnection();
	
    public Player createMainCharacter(String name, String fightStyle) {
      SqliteConnection sqliteConnection = new SqliteConnection();
      Player p1 = new Player();	
      try( Connection conection = sqliteConnection.connect();){
        FightStyle fs = sqliteConnection.getFightStyle("Warrior");
        p1.setAttack(fs.getAttack());
        p1.setDefense(fs.getDefense());
        p1.setLuck(fs.getLuck());
        p1.setSpecial(fs.getSpecial());
        p1.setName(name);
        return p1;
      }
      catch (Exception e) {
			// TODO: handle exception
      }
      return p1;
    }
   




}
