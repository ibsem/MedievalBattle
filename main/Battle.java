import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

package main;

public class Battle {
	
	public void battle(Player caracter,Player enemy)throws IOException {
		private boolean turn;// 'true' vez do jogador , 'false' vez do inimigo
		private int buffer;// variavel responsavel por guardar os cauculos
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
				
			}
		}while(caracter.life > 0 && enemy.life > 0)//verifica se alguem ja morreu
	}
}
