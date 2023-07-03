package battleship;

import java.util.ArrayList;
import java.util.Scanner;

//collection of ships for players
public class ShipCollection {
    public Ship[] ships;
    public int length;
    public ArrayList<String> allPos = new ArrayList<>(); //positions with the ships "rowcol" String
    public ArrayList<String> allClosePos = new ArrayList<>(); //positions surrounding ships + positions with the ships
    ArrayList<Integer> sankShipIndex = new ArrayList<>(); //index of the ships sank for 'ships' array from ShipCollection

    ShipCollection(int length, Ship[] ships) {
        this.length = length;
        this.ships = ships;
    }

    //setting collectionOf variable for each set of ships as the object itself
    public void setCollectionOf() {
        for (Ship x: ships) x.collectionOf = this;
    }

    //positions occupied by ships on placing field
    public void occcupied(GameField field) {

        allPos.clear();
        for (int i=0; i< field.contents.length; i++) {
            for (int j=0; j< field.contents[i].length; j++) {
                if (field.contents[i][j] == 'O') allPos.add(i+""+j);
            }
        }
    }


    //
    public void takeAttack(GameField shootingField, GameField placingField, Ship[] ships) {
        Scanner scanner = new Scanner(System.in);

        String attack_pos;
        attack_pos = scanner.nextLine();
        System.out.println();

        int col = Integer.parseInt(attack_pos.substring(1)) - 1;
        int row = (Character.getNumericValue(attack_pos.charAt(0))-9) -1;

        //invalid coordinates warning message
        if ((row >= shootingField.dim_size || col >= shootingField.dim_size)) {

            System.out.println("Error! You entered the wrong coordinates! Try again:");
            takeAttack(shootingField, placingField, ships);

        } else if (shootingField.contents[row][col]!='~') { //checking if the position was already tried

            System.out.println("Error! You already tried there! Try again:");
            takeAttack(shootingField, placingField, ships);

        }else if (allPos.contains(row+""+col)) {   //checking if a ship was hit

            shootingField.construct(Ship.hit_symbol, Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );
            placingField.construct(Ship.hit_symbol, Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );


            int y=0;
            for (int i=0; i < ships.length; i++) {

                if (shootingField.allHitPos().containsAll(ships[i].inputPos) && !sankShipIndex.contains(i)) {
                    sankShipIndex.add(i);
                    System.out.println("You sank a ship!");
                    break;
                }
                y += ships[i].cellSize;
                if (ships[i] == ships[ships.length-1]) {
                    System.out.println("You hit a ship!");
                }
            }

        } else if (!allPos.contains(row+""+col)) { //checking if it was missed

            shootingField.construct('M', Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );
            placingField.construct('M', Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );
            System.out.println("You missed!");
        }
    }

    //return true if all ships sank
    public boolean areAllSank(GameField shootingField, GameField placingField) {

        try {
            // placing field has all the x's and the shooting field should have all the x's too
            if (!shootingField.allHitPos().isEmpty() && !allPos.isEmpty()) {

                if (shootingField.allHitPos().size() == this.allPos.size()) {
                    return true;
                }
            }
        } catch(NullPointerException e) {
            return false;
        } return false;
    }

    //positions closer to ships sets 'allClosePos' variable
    public void setAllClosePos(GameField field) {

        allClosePos.clear();
        for (String x: allPos) {
            int i = Integer.parseInt(String.valueOf(x.charAt(0))); //row
            int j = Integer.parseInt(x.substring(1)); //col

            for (int row = i-1; row < (i-1)+3; row++) {
                for (int col = j-1; col < (j-1)+3; col++) {
                    if (row< field.dim_size && col <field.dim_size && row >=0 && col >=0) { allClosePos.add(row+""+col); }
                }
            }
        }
    }
}