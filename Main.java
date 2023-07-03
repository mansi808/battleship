package battleship;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //field for placing bombs
        GameField placingField1 = new GameField(10);
        GameField placingField2 = new GameField(10);

        //field for shooting (ie has hidden bombs, gives hit or miss review)
        GameField shootingField1 = new GameField(10);
        GameField shootingField2 = new GameField(10);


        //player1 ships
        Ship[] ships1 = new Ship[] {new Ship("Aircraft Carrier",5), new Ship("Battleship", 4),new Ship("Submarine", 3), new Ship("Cruiser",3), new Ship("Destroyer",2)};

        //player2 ships
        Ship[] ships2 = new Ship[] {new Ship("Aircraft Carrier",5), new Ship("Battleship", 4),new Ship("Submarine", 3), new Ship("Cruiser",3), new Ship("Destroyer",2)};

        //ship collection for each player
        ShipCollection collection1 = new ShipCollection(5, ships1);

        ShipCollection collection2 = new ShipCollection(5, ships2);
        //telling each ship which collection it belongs to
        collection1.setCollectionOf();
        collection2.setCollectionOf();

        Player player1 = new Player(collection1.ships, placingField1, shootingField1);
        Player player2 = new Player(collection2.ships, placingField2, shootingField2);


        //player 1 placing ships
        System.out.println("Player 1, place your ships on the game field\n");
        player2.placingField.print(); //blank field with '~'
        System.out.println();
        String[] input_pos0;
        for (Ship i : player1.ships) {

            //geting valid position for each of the ship
            System.out.println(String.format("Enter the coordinates of the %s (%d cells):", i.name, i.cellSize));
            System.out.println();

            while (!i.posValid) {
                input_pos0 = scanner.nextLine().trim().split("[\\s]+"); //geting output
                System.out.println();
                i.setLevel(input_pos0[0],input_pos0[1]);//getting level
                i.inputPos(input_pos0[0],input_pos0[1],player1.placingField);
                i.setPosValid(input_pos0[0],input_pos0[1]);
                if (!i.posValid) continue;

                //making ships on placing field
                if (i.level.equals("vertical")) player1.placingField.construct(Ship.safe_symbol, Integer.parseInt(input_pos0[0].substring(1)), input_pos0[0].charAt(0), input_pos0[1].charAt(0), i);
                else if (i.level.equals("horizontal")) player1.placingField.construct(Ship.safe_symbol,Integer.parseInt(input_pos0[0].substring(1)), Integer.parseInt(input_pos0[1].substring(1)), input_pos0[0].charAt(0), i);
            }
            
            player1.placingField.print();
            collection1.occcupied(player1.placingField); collection1.setAllClosePos(player1.placingField);
            System.out.println();
        }

        //clearing screen
        System.out.println("Press Enter and pass the move to another player\n");
        String enter = scanner.nextLine();
        if (enter.equals("")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        //player 2 placing ships (same as above but for second player)
        System.out.println("Player 2, place your ships to the game field");
        player2.placingField.print();
        System.out.println();
        String[] input_pos1;
        for (Ship i : player2.ships) {

            System.out.println(String.format("Enter the coordinates of the %s (%d cells):", i.name, i.cellSize));
            System.out.println();

            while (!i.posValid) {
                input_pos1 = scanner.nextLine().trim().split("[\\s]+");
                System.out.println();
                i.setLevel(input_pos1[0],input_pos1[1]);//getting level
                i.inputPos(input_pos1[0],input_pos1[1],player2.placingField);
                i.setPosValid(input_pos1[0],input_pos1[1]);
                if (!i.posValid) continue;
                if (i.level.equals("vertical")) player2.placingField.construct(Ship.safe_symbol, Integer.parseInt(input_pos1[0].substring(1)), input_pos1[0].charAt(0), input_pos1[1].charAt(0), i);
                else if (i.level.equals("horizontal")) player2.placingField.construct(Ship.safe_symbol,Integer.parseInt(input_pos1[0].substring(1)), Integer.parseInt(input_pos1[1].substring(1)), input_pos1[0].charAt(0), i);
            }

            player2.placingField.print();
            collection2.occcupied(player2.placingField); collection2.setAllClosePos(player2.placingField);
            System.out.println();

        }


        //asking for players to shoot bombs till someone's all ships sink
        //top field is where attackers attacks
        //bottom field is attacker's field
        while (!collection1.areAllSank(player1.shootingField, player1.placingField) || !collection2.areAllSank(player2.shootingField, player2.placingField)) {

            //clearing screen
            System.out.println("Press Enter and pass the move to another player");
            enter = scanner.nextLine();
            if (enter.equals("")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

            //player 1 shooting bomb
            player2.shootingField.print();
            System.out.println("---------------------");
            player1.placingField.print();

            System.out.println("Player 1, it's your turn:\n");
            collection2.takeAttack(player2.shootingField, player2.placingField, player2.ships);

            //clearing screen
            System.out.println("Press Enter and pass the move to another player");
            enter = scanner.nextLine();
            //clearing screen
            if (enter.equals("")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

            //player 2 shooting bombs
            player1.shootingField.print();
            System.out.println("---------------------");
            player2.placingField.print();

            System.out.println("Player 2, it's your turn:\n");
            collection1.takeAttack(player1.shootingField, player1.placingField, player1.ships);

        }
        System.out.println("Congratulations! you won the game!");

    }
}
