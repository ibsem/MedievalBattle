import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

package default;

public class Battle {
	
	public void battle(Player caracter,Player enemy)throws IOException {
		private boolean turn;// 'true' vez do jogador , 'false' vez do inimigo
		private int buffer;// variavel responsavel por guardar os cauculos
		private int special;
		caracter.setLife = 100;
		enemy.setLife = 100;
		do{
			
			public int choseAction(Player caracter,Player enemy){

				System.out.println("Escolha sua Acao ");//permite a escolha da acao
				System.out.println("1 - Attack");
				System.out.println("2 - Defense");
				System.out.println("3 - Special");
				BufferedReader chose = new BufferedReader(new InputStreamReader(System.in));
				int chosePlayer = chose.readLine();				
				
				Random random = new Random();
				int choseEnemy = ran.nextInt(3);//escolhe a acao do inimigo
				
				switch(chosePlayer){ // permite ao usuario escolher a acao
					case 1 :
						caracter.setTurnAction = 'a';
						break;
					case 2 :
						caracter.setTurnAction = 'd';
						break;
					case 3 :
						caracter.setTurnAction = 's';
						break;
					default :
						System.out.println("Invalid Moviment");
				}
				
				switch(choseEnemy){ // marca a acao do inimigo 
					case 0 :
						enemy.setTurnAction = 'a';
						break;
					case 1 :
						enemy.setTurnAction = 'd';
						break;
					case 2 :
						enemy.setTurnAction = 's';
						break;
					default :
						System.out.println("Invalid Moviment");
				}
				
				public int attack(Player caracter, Player enemy){
					if (caracter.getTurnAction == 'a'){
						if(enemy.getTurnAction == 'd'){// caso o inimigo defenda
							buffer = caracter.getAttack*10 - enemy.getDefense*10;
							if (buffer > 0){//verifica se a defesa foi efetiva
								enemy.setLife -= buffer;
								turn = false;// troca pra vez do inimigo
								return enemy.getLife;
							}else{
								turn = false;
								return enemy.getLife;
							}
						}else{
							enemy.setLife -= caracter.getAttack*10;// inimigo nao defendeu
							turn = false;
							return enemy.getLife;
						}
					}else{
						if (enemy.getTurnAction == 'a'){
							if(caracter.getTurnAction == 'd'){// caso o inimigo defenda
								buffer = enemy.getAttack*10 - caracter.getDefense*10;
								if (buffer > 0){//verifica se a defesa foi efetiva
									caracter.setLife -= buffer;
									turn = false;// troca pra vez do inimigo
									return caracter.getLife;
								}else{
									turn = false;
									return caracter.getLife;
								}
							}else{
								caracter.setLife -= enemy.getAttack*10;// inimigo nao defendeu
								turn = false;
								return caracter.getLife;
							}
						}
					}
					return 0;
				}

			}
		}while(caracter.getLife > 0 && enemy.getLife > 0)//verifica se alguem ja morreu
	}
}