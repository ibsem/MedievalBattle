package main;

public class Battle {
	
	public void battle(Player caracter,Player enemy){
		private boolean turn;
		private int buffer;// variavel responsavel por guardar os cauculos
		caracter.life = 100;
		enemy.life = 100;
		do{
			if (caracter.turnAction == "a"){
				
				public int attack(int attack, int life, String turnAction, int defense){//pega o ataque a vida e o que o inimigo escolheu
					if (turn == true){
						 if (enemy.turnAction == "d"){
							 buffer = caracter.attack - enemy.defense;
							 enemy.life -= buffer;
						 }else
							 enemy.life -= caracter.attack;
					}else{
						 if (caracter.turnAction == "d"){
							 buffer = enemy.attack - caracter.defense;
							 caracter.life -= buffer;
						 }else
							 caracter.life -= enemy.attack;	
					}
				}
			}
		}while(caracter.life > 0 && enemy.life > 0)//verifica se alguem ja morreu
	}
}
