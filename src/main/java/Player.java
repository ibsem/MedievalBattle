public class Player {
	private String name;
	private String fightStyleName;
	private String turnAction = null;
	private int life;
	private int attack;
	private int defense;
	private int luck;
	private int special;
	
	
	
	public String getFightStyleName() {
		return fightStyleName;
	}

	public void setFightStyleName(String fightStyleName) {
		this.fightStyleName = fightStyleName;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public String getName() {
		return name;
	}

	public Player(String n, String ta, int lf, int atk, int def, int lk){
		setName(n);
		setTurnAction(ta);
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
	
	public void setTurnAction(String ta){
		turnAction = ta; 
	}
		
	public String getTurnAction(){
		return turnAction;
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
