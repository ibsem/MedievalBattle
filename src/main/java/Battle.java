import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Battle {
	private boolean turn = true;// 'true' vez do jogador , 'false' vez do inimigo
	private Player p1;
	private Player p2;
	
	public void Battle(Player p1,Player p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void startBattle(Player character,Player enemy)throws IOException {
		character.setLife(100);
		enemy.setLife(100);
		do{
			this.pickAction(character);
			if(turn = true){
				if(character.getTurnAction().equals("a")){
					this.doAttack(character, enemy);
				}
			}else{
				if(enemy.getTurnAction().equals("a")){
					this.doAttack(enemy, character);
				}
			}
		}while(character.getLife() > 0 || enemy.getLife() > 0);
	}
	
	public void doAttack(Player character, Player enemy){
		if (enemy.getTurnAction().equals(null)){
			int damage = enemy.getLife() - (character.getAttack()*10);
			enemy.setLife(damage);
			System.out.println("the Enemy has lost "+ damage + " of his life");
			System.out.println("Enemy's life: "+ enemy.getLife());
			System.out.println("Player's life: "+ character.getLife());
			turn = false;
		}else{
			if(enemy.getTurnAction().equals("d")){
				int damage = character.getAttack()*10 - enemy.getDefense()*10;
				if(damage> 0){
					enemy.setLife(enemy.getLife() - damage);
					System.out.println("the Enemy has lost "+ damage + " of his life");
					System.out.println("Enemy's life: "+ enemy.getLife());
					System.out.println("Player's life: "+ character.getLife());
					turn = false;
				}else{
					System.out.println("Enemy's life: "+ enemy.getLife());
					System.out.println("Player's life: "+ character.getLife());
					turn = false;
				}
			}
		}
	}
	
	public void pickAction(Player character)throws IOException {

		System.out.println("Escolha sua Acao ");//permite a escolha da acao
		System.out.println("1 - Attack");
		System.out.println("2 - Defense");
		System.out.println("3 - Special");
		BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
		int playerChoice = Integer.parseInt(choice.readLine());				
	
	switch(playerChoice){ // permite ao usuario escolher a acao
		case 1 :
			character.setTurnAction("a");
			break;
		case 2 :
			character.setTurnAction("d");
			break;
		case 3 :
			character.setTurnAction("s");
			break;
		default :
			System.out.println("Invalid Moviment");
	}
	}
	public void pickAction(boolean turn){		
	
		Random random = new Random();
		int enemyChoice = random.nextInt(randomNumber);//escolhe a acao do inimigo
	
		switch(enemyChoice){ // permite ao usuario escolher a acao
			case 1 :
				enemy.setTurnAction("a");
				break;
			case 2 :
				enemy.setTurnAction("d");
				break;
			case 3 :
				enemy.setTurnAction("s");
				break;
			default :
				System.out.println("Invalid Moviment");
		}
	}
}