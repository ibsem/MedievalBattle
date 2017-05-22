public class Player {
	private String name;
	private String action;
	private int life = 100;
	private int attack = 25;
	private int defense = 10;
	private int luck = 100;
	private int teste;
	
	public Player(String n, String a, int lf, int atk, int def, int lk){
		setName(n);
		setAction(a);
		setLife(lf);
		setAttack(atk);
		setDefense(def);
		setLuck(lk);
	}
	
	public Player(){
		
	}
	
	public void setName(String n){
		if(n.isEmpty()){
			name = "Player1";
		}else name = n;
	}
		
	public String getNome(){
		return name;
	}
	
	public void setAction(String a){
		if(a.isEmpty()){
			action = "Attack";
		}else action = a;
	}
		
	public String getAction(){
		return action;
	}
	public void setLife(int lf){
		if(lf < 0){
			life = 0;
		}else life = lf;
	}
		
	public int getLife(){
		return life;
	}
	
	public void setAttack(int atk){
		if(atk < 0){
			attack = 0;
		}else attack = atk;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public void setDefense(int def){
		if(def < 0){
			defense = 0;
		}else defense = def;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public void setLuck(int lk){
		if(lk < 0){
			luck = 0;
		}else luck = lk;
	}
	
	public int getLuck(){
		return luck;
	}
}