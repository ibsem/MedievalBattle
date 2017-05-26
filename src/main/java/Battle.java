import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {
	private boolean turn = true;// 'true' vez do jogador , 'false' vez do inimigo
	private boolean specialCharacter = true;
	private boolean specialEnemy = true;
		
	public void startBattle(Player character,Player enemy)throws IOException {//comeca a batalha
		character.setLife(100);
		enemy.setLife(100);
		
		do{
			if(turn = true){
				this.pickAction(character);
				if(character.getTurnAction().equals("a")){
					this.doAttack(character, enemy);
					turn = false;
				}else{
					if(character.getTurnAction().equals("s") && specialCharacter == true){
						this.doSpecial(character, enemy);
						specialCharacter = false;
						turn = false;
					}else{
						if(character.getTurnAction().equals("s")){
							System.out.println("Escolha indisponivel");
							this.pickAction(character);
						}else{
							if(character.getTurnAction().equals("d")){
								turn = false;
							}
						}
					}
				}
			}else{//comeca o turno do inimigo
				this.pickAction(enemy,3);
				if(enemy.getTurnAction().equals("a")){
					this.doAttack(enemy, character);
					turn = true;
				}else{
					if(enemy.getTurnAction().equals("s") && specialEnemy == true){
						this.doSpecial(enemy, character);
						specialEnemy = false;
						turn = true;
					}else{
						if(enemy.getTurnAction().equals("s")){
							System.out.println("Escolha indisponivel");
							this.pickAction(enemy);
						}else{
							if(enemy.getTurnAction().equals("d")){
								turn = true;
							}
						}
					}
				}
			}
		}while(character.getLife() > 0 || enemy.getLife() > 0);
	}
	
	public void doAttack(Player character, Player enemy){//metodo para atacar
		if (enemy.getTurnAction().equals(null)){
			int damage = enemy.getLife() - (character.getAttack()*10);//calculo dano
			enemy.setLife(damage);
			System.out.println("the Enemy has lost "+ damage + " of his life");
			System.out.println(enemy.getNome()+"'s life: "+ enemy.getLife());
			System.out.println(character.getNome()+"'s life: "+ character.getLife());
		}else{
			if(enemy.getTurnAction().equals("d")){//o proprio metodo ja verifica defesa
				int damage = character.getAttack()*10 - enemy.getDefense()*10;
				if(damage> 0){
					enemy.setLife(enemy.getLife() - damage);
					System.out.println("the Enemy has lost "+ damage + " of his life");
					System.out.println(enemy.getNome()+"'s life: "+ enemy.getLife());
					System.out.println(character.getNome()+"'s life: "+ character.getLife());
				}else{
					System.out.println(enemy.getNome()+"'s life: "+ enemy.getLife());
					System.out.println(character.getNome()+"'s life: "+ character.getLife());
				}
			}
		}
	}
	
	public void doSpecial(Player character, Player enemy){
		int damage = enemy.getLife() - (character.getAttack()*20);//calcula o special sem chance de defesa
		enemy.setLife(damage);
		System.out.println("the "+enemy.getNome()+" has lost "+ damage + " of his life");
		System.out.println(enemy.getNome()+"'s life: "+ enemy.getLife());
		System.out.println(character.getNome()+"'s life: "+ character.getLife());
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
	
	public void pickAction(Player enemy,int randomNumber){		
	
		Random random = new Random();
		int enemyChoice = random.nextInt(randomNumber);//escolhe a acao do inimigo
	
		switch(enemyChoice){ // inimigo escolhe acao
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