/**
 * Created by Thiago Trennepohl on 14/05/17.
 */

public class CharacterCreation {
    public static void main(String []args){
        CharacterCreation c1 = new CharacterCreation();
        c1.createMainCharacter("Olavo", "Mago");
    }

    public void createMainCharacter(String name, String fightStyle) {
        HSqlConnection conn = new HSqlConnection();
        conn.connect();

    }




}
