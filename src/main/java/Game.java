import java.sql.Connection;

public class Game {
	
	
	public static void main(String []args){
	  SqliteConnection sqliteConnection = new SqliteConnection();
	  try(Connection conection = sqliteConnection.connect()){
		  sqliteConnection.initDatabase();
		  // TODO: Create characters and start game	  
		  
		  
		  
	  }catch (Exception e) {
		// TODO: handle exception
	  }
	  
	}
	

}
