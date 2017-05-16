
public class Game {
	public static void main(String []args){
		SqliteConnection conn = new SqliteConnection();
		conn.connect();
		conn.createFightStylesTable();
		
	}
	
	public void initDatbase(){
		
	}
	
	

}
