
public class Game {
	public static void main(String []args){
	  //SqliteConnection conn = new SqliteConnection();
 	  //conn.connect();
	  //conn.initDatabase();
		
		CharacterCreation player = new CharacterCreation();		
		SqliteConnection sqliteConnection1 = new SqliteConnection();
		Player p1 = new Player("Jogador", null, 100, 3, 2, 3);
		Player p2 = new Player("Inimigo", null, 100, 1, 2, 1);
		Battle battle = new Battle();
		String winner = battle.battle(p1, p2);
		
		System.out.println("O " + winner + "ganhou!");		
	}
	
	public void initDatbase(){
		
	}
}
