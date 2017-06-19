import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.sqlite.SQLite;

public class Game {
	private static SqliteConnection db = new SqliteConnection();
	private static CharacterCreation charConfig = new CharacterCreation();
	private static Scanner choice;
	
	public static void main(String []args)throws IOException{
		Player p1 = new Player();
		Player p2 = new Player();
		db.initDatabase();
		
		Game.initGame(p1);
		
		
		p1 = charConfig.createMainCharacter(p1.getName(),p1.getFightStyleName());
		p2 = charConfig.createEnemy();
		
		
	
		Battle battle = new Battle();
		System.out.println("\n=====================\nAnd the Battle begins!\n=====================\n");
		String winner = battle.startBattle(p1, p2);
		
		System.out.println("O " + winner + " ganhou!");		
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

}