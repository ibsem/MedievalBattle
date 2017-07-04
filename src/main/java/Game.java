import java.io.BufferedReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.io.InputStreamReader;
import java.util.Scanner;

import org.sqlite.SQLite;


public class Game {
	private static SqliteConnection db = new SqliteConnection();
	private static CharacterCreation charConfig = new CharacterCreation();
	private static Scanner choice;
	
	public static void main(String []args)throws IOException{

	  SqliteConnection conn = new SqliteConnection();
 	  conn.connect();
	  conn.initDatabase();
		
		CharacterCreation player = new CharacterCreation();		
		SqliteConnection sqliteConnection1 = new SqliteConnection();
		Player p1 = new Player("Player", null, 100, 3, 2, 3);
		Player p2 = new Player("Inimigo", null, 100, 1, 2, 1);

		Battle battle = new Battle();
		System.out.println("\n=====================\nAnd the Battle begins!\n=====================\n");
		String winner = battle.startBattle(p1, p2);
		
		System.out.println("O " + winner + " ganhou!");
		ranking();
	}
	
	public static void initGame(Player p1){
		choice = new Scanner(System.in);
		
		System.out.println("======================================");
		System.out.println("Welcome! to the Medieval Battle Game!!");
		System.out.println("======================================");
		System.out.println("\n\nTo start, create your character");
		System.out.println("Name:");
		p1.setName(choice.nextLine());
		System.out.println("\n\nGreat! now, pick a class:");
		System.out.println("Warrior");
		System.out.println("Mage");
		System.out.println("Archer");
		p1.setFightStyleName(choice.nextLine());
	
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