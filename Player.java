package battleship;

//each player has ship collection
//placing field where user places his/her ships as 'O'
//shooting field is the one displayed during attack time
public class Player {
    public Ship[] ships;
    public GameField placingField;
    public GameField shootingField;

    Player(Ship[] ships, GameField placingField, GameField shootingField) {
        this.ships = ships;
        this.placingField = placingField;
        this.shootingField = shootingField;
    }
}
