import java.io.IOException;

public class Game {
	public static void main(String []args)throws IOException {
	  //SqliteConnection conn = new SqliteConnection();
	  //conn.connect();
	 // conn.initDatabase();
	  Player p1 = new Player("jogador",null,100,3,3,3);
	  Player p2 = new Player("inimigo",null,100,1,1,1);
	  Battle batlle = new Battle();
	  batlle.startBattle(p1,p2);
	}
	
	public void initDatbase(){
		
	}
	
	

}
