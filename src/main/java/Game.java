import java.sql.Connection;

public class Game {
	private static Player p1;
	private Player p2;
	
	
	public static void main(String []args){
	  SqliteConnection sqliteConnection = new SqliteConnection();
	  CharacterCreation character = null;
	  
	  try(Connection conection = sqliteConnection.connect()){
		  sqliteConnection.initDatabase();
		  p1 = character.createMainCharacter("Olavo", "warrior");
		  //TODO: Create enemy and start battle
		  
	  }catch (Exception e) {
		// TODO: handle exception
	  }
	  
	}
	

}
