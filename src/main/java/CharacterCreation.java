import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Thiago Trennepohl on 14/05/17.
 */

public class CharacterCreation {
    public static void main(String []args){
    	SqliteConnection s = new SqliteConnection();
    	s.initDatabase();
        CharacterCreation c1 = new CharacterCreation(); 
        Player mainPlayer = c1.createMainCharacter("Olavo", "Warrior");
        
        System.out.println(mainPlayer.getNome());
        
    }

    public Player createMainCharacter(String name, String fightStyle) {

    	SqliteConnection sqliteConnection = new SqliteConnection();
        try( Connection conection = sqliteConnection.connect();){
        	ResultSet rs = sqliteConnection.getFightStyle("warrior");
        	Player mainCharacter = new Player();
        	while(rs.next()){
        		mainCharacter.setAttack(rs.getInt("attack"));
        		mainCharacter.setDefense(rs.getInt("defense"));
        		mainCharacter.setLuck(rs.getInt("luck"));
        		mainCharacter.setName(name);
        	}
        	return mainCharacter;
        }
        catch (Exception e) {
			// TODO: handle exception
		}
		return null;
    }
   




}
