package battleship;

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
