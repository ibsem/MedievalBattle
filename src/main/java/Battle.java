import java.util.Random;
import java.util.logging.Level;
import org.springframework.expression.spel.ast.Selection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Battle {
	private boolean turn = true;// 'true' vez do jogador , 'false' vez do inimigo
	private boolean specialC = true;// deixa o especial off apos o uso
	private boolean specialE = true;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	Date date = new Date(); 
	
	public String startBattle(Player character,Player enemy)throws IOException {//comeca a batalha
		character.setLife(100);
		enemy.setLife(100);
		
		do{
			if(turn == true){
				this.pickAction(character);
				boolean action = this.doAction(character, enemy);
				if(action == true){//verifica se a acao foi bem sucedida
					turn = false;//troca o turno
				}else{
					this.pickAction(character);//escolhe denovo
				}	
			}else {
				this.pickAction(enemy,3);//faz a escolha do inimigo com 3 opcoes disponiveis
				boolean action2 = this.doAction(enemy, character);
				if(action2 == true){
					turn = true;
				}else{
					this.pickAction(enemy);
				}
			}	
		}while(character.getLife() > 0 && enemy.getLife() > 0);
		if (enemy.getLife() <= 0){
			this.insertScore(character);
			return character.getNome();
		}else{
			return enemy.getNome();
		}
	}
	
	public void insertScore(Player character){
		SqliteConnection sqlite = new SqliteConnection();
       	String sql = "INSERT INTO ranking(name,score,datescore) values ('"+ character.getName()+"','"+character.getLife()+"','"+dateFormat.format(date)+"')";        
       	try (Connection conn = sqlite.connect();
       			Statement stmt  = conn.createStatement();){
       			stmt.executeUpdate(sql);
       	}
       	catch (SQLException e) {
       		System.out.println("Erro -> "+ e);
       	}
	}
	
	public boolean doAction(Player character, Player enemy)throws IOException {
		switch(character.getTurnAction()){
			case "a":
				this.doAttack(character, enemy);
				return true;
			case "d":
				return true;
			case "s":
				if (turn == true){
					if(specialC == true){
						this.doSpecial(character, enemy);
						specialC = false;
						return true;
					}else{
							System.out.println("Especial bloqueado");
							return false;
					}
				}else{
					if(specialE == true){
						this.doSpecial(character, enemy);
						specialE = false;
						System.out.println(enemy.getNome()+" usou seu especial");
						return true;
					}else{
						this.doAttack(character, enemy);
						System.out.println(enemy.getNome()+" atacou");
						return true;
					}
				}
			default:
				return false;
		}
	}
	
	public void doAttack(Player character, Player enemy){//metodo para atacar
		if (enemy.getTurnAction() != "d" ){
			int damage =(character.getAttack()*10);//calculo dano
			enemy.setLife(enemy.getLife() - damage);
			System.out.println("O "+enemy.getNome()+" perdeu "+ damage + " de sua vida");
			System.out.println(enemy.getNome()+" vida: "+ enemy.getLife());
			System.out.println(character.getNome()+" vida: "+ character.getLife());
		}else{
			int damage = character.getAttack()*10 - enemy.getDefense()*10;
			if(damage> 0){
				enemy.setLife(enemy.getLife() - damage);
				System.out.println("O "+enemy.getNome()+" perdeu "+ damage + " de sua vida");
				System.out.println(enemy.getNome()+" vida: "+ enemy.getLife());
				System.out.println(character.getNome()+" vida: "+ character.getLife());
			}else{
				System.out.println(enemy.getNome()+" vida: "+ enemy.getLife());
				System.out.println(character.getNome()+" vida: "+ character.getLife());
			}
		}
	}
	
	public void doSpecial(Player character, Player enemy){
		int damage =(character.getAttack()*20);//calcula o special sem chance de defesa
		enemy.setLife(enemy.getLife() - damage);
		System.out.println("O "+enemy.getNome()+" perdeu "+ damage + " de sua vida");
		System.out.println(enemy.getNome()+" vida: "+ enemy.getLife());
		System.out.println(character.getNome()+" vida: "+ character.getLife());
	}
	
	public int pickAction(Player character)throws IOException {

		System.out.println("Escolha sua Acao ");//permite a escolha da acao
		System.out.println("1 - Attack");
		System.out.println("2 - Defense");
		System.out.println("3 - Special");
		BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
		int playerChoice = Integer.parseInt(choice.readLine());	
	
	switch(playerChoice){ // permite ao usuario escolher a acao
		case 1 :
			character.setTurnAction("a");
			System.out.println(character.getNome()+" atacou");
			break;
		case 2 :
			character.setTurnAction("d");
			System.out.println(character.getNome()+" defendeu");
			break;
		case 3 :
			character.setTurnAction("s");
			System.out.println(character.getNome()+" usou seu especial");
			break;
		default :
			System.out.println("Movimento Invalido");
			return 0;
	}
	return 0;
}
	
	public void pickAction(Player enemy,int randomNumber){		
	
		Random random = new Random();
		int enemyChoice = random.nextInt(randomNumber);//escolhe a acao do inimigo
	
		switch(enemyChoice){ // inimigo escolhe acao
			case 0 :
				enemy.setTurnAction("a");
				System.out.println(enemy.getNome()+" atacou");
				break;
			case 1 :
				enemy.setTurnAction("d");
				System.out.println(enemy.getNome()+" defendeu");
				break;
			case 2 :
				enemy.setTurnAction("s");
				break;
			default :
				break;
		}
	}
}