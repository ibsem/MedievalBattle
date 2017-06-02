import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {
	private boolean turn = true;// 'true' vez do jogador , 'false' vez do inimigo
	private boolean specialCharacter = true;// deixa o especial off apos o uso
		
	public void startBattle(Player character,Player enemy)throws IOException {//comeca a batalha
		character.setLife(100);
		enemy.setLife(100);
		
		do{
			if(turn == true){
				this.pickAction(character);
				int action = this.doAction(character, enemy);
				if(action == 1){
					turn = false;
				}else{
					this.pickAction(character);
				}	
			}else {
				this.pickAction(enemy,3);
				int action2 = this.doAction(enemy, character);
				if(action2 == 1){
					turn = true;
				}else{
					this.pickAction(enemy);
				}
			}	
		}while(character.getLife() > 0 && enemy.getLife() > 0);
	}
	
	public int doAction(Player character, Player enemy)throws IOException {
		switch(character.getTurnAction()){
			case "a":
				this.doAttack(character, enemy);
				return 1;
			case "d":
				return 1;
			case "s":
				if(specialCharacter == true){
					this.doSpecial(character, enemy);
					specialCharacter = false;
				}else{
					System.out.println("Especial bloqueado");
					return 0;
				}
			default:
				return 0;
		}
	}
	
	public void doAttack(Player character, Player enemy){//metodo para atacar
		if (enemy.getTurnAction() == null){
			int damage =(character.getAttack()*10);//calculo dano
			enemy.setLife(enemy.getLife() - damage);
			System.out.println("O "+enemy.getNome()+" perdeu "+ damage + " de sua vida");
			System.out.println(enemy.getNome()+" vida: "+ enemy.getLife());
			System.out.println(character.getNome()+" vida: "+ character.getLife());
		}else{
			if(enemy.getTurnAction().equals("d")){//o proprio metodo ja verifica defesa
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
			System.out.println(character.getNome()+" escolheu ataque");
			break;
		case 2 :
			character.setTurnAction("d");
			System.out.println(character.getNome()+" escolheu defesa");
			break;
		case 3 :
			character.setTurnAction("s");
			System.out.println(character.getNome()+" escolheu especial");
			break;
		default :
			System.out.println("Movimento Invalido");
			return 0;
	}
	return 0;
}
	
	public int pickAction(Player enemy,int randomNumber){		
	
		Random random = new Random();
		int enemyChoice = random.nextInt(randomNumber);//escolhe a acao do inimigo
	
		switch(enemyChoice){ // inimigo escolhe acao
			case 0 :
				enemy.setTurnAction("a");
				System.out.println(enemy.getNome()+" escolheu ataque");
				break;
			case 1 :
				enemy.setTurnAction("d");
				System.out.println(enemy.getNome()+" escolheu defesa");
				break;
			case 2 :
				enemy.setTurnAction("s");
				System.out.println(enemy.getNome()+" escolheu especial");
				break;
			default :
				System.out.println("Movimento Invalido");
				return 0;
		}
		return 0;
	}
}