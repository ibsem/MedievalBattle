import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

public class Game {
	public static void main(String []args)throws IOException{
	  SqliteConnection conn = new SqliteConnection();
 	  conn.connect();
	  conn.initDatabase();
		
		CharacterCreation player = new CharacterCreation();		
		SqliteConnection sqliteConnection1 = new SqliteConnection();
		Player p1 = new Player("Player", null, 100, 3, 2, 3);
		Player p2 = new Player("Inimigo", null, 100, 1, 2, 1);
		Battle battle = new Battle();
		String winner = battle.startBattle(p1, p2);
		
		System.out.println("O " + winner + " ganhou!");
		ranking();
	}
	
	public void initDatbase(){
		
	}
	
	public static void ranking(){
		SqliteConnection sqlite = new SqliteConnection();
		String sql = "SELECT * FROM ranking ORDER BY score DESC LIMIT 10;";
		System.out.println("O Ranking dos 10 Melhores");
		try (Connection conn = sqlite.connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			while (rs.next()){
				String name = rs.getObject(2).toString();
				String score =  rs.getObject(3).toString();
				String data = rs.getObject(4).toString();
				System.out.println("Jogador: " + name + " com " + score + " pontos, na data: " + data);
			}
		}catch (SQLException e) {
			System.out.println("Erro ->"+e);
		}
		
	}
}