package battleship;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;

public class Ship {
    public ShipCollection collectionOf;
    public static char safe_symbol = 'O';
    public static char hit_symbol = 'X';
    public int cellSize;
    public String name;
    public String level; //"vertical" or "horizontal"
    public boolean posValid = false;
    public ArrayList<String> inputPos = new ArrayList<>(); //contains all boxes of input position
    public boolean hit = false;

    Ship(String name, int cellSize) {
        this.name = name;
        this.cellSize = cellSize;
    }


    //checks if the input position is valid or not if valid sets it
    //does not return value just changes it
    public void setPosValid(String a, String b) {

        if (level==null) {  //in case of invalid input adjacent lines eg. B3 D4 (neither vertical nor horizontal)
            System.out.println("Error! Wrong ship location! Try again:");
            inputPos.clear(); //clearing input pos if invalid input

        } else if (level.equals("horizontal") ? Math.abs(Integer.parseInt(a.substring(1))-Integer.parseInt(b.substring(1)))+1!= cellSize : Math.abs(a.charAt(0)-b.charAt(0))!= (cellSize-1) ) {
            //checking length of ship using subtraction
            System.out.println(String.format("Error! Wrong length of the %s! Try again:",name));
            inputPos.clear(); //clearing input pos if invalid input

        } else if ( collectionOf.allClosePos != null )  {

            if ( inputPos.stream()
                .filter(collectionOf.allClosePos::contains)
                .collect(Collectors
                        .toList()).isEmpty()) {  //checked if the collectionOf.allClosePos and inputPos given by user have anything in common
                posValid =true;
            } else  {
                System.out.println("Error! You placed it too close to another one. Try again:");
                inputPos.clear(); //clearing input pos if invalid input
            }
        } else {
            posValid =true;
        }
    }

    public void getLevel(String a, String b) {
        if (a.charAt(0)==b.charAt(0)) level = "horizontal";
        else if (a.substring(1).equals(b.substring(1))) level = "vertical";
    }

    public void inputPos(String a, String b, GameField field) {
        if (level!= null) if (level.equals("vertical")) {
            addPos(Integer.parseInt(a.substring(1)), a.charAt(0), b.charAt(0));
        } else if (level.equals("horizontal")) {
            addPos(Integer.parseInt(a.substring(1)), Integer.parseInt(b.substring(1)), a.charAt(0));
        }
    }

    //adding positions to inputPos String[]
    //vertical ship
    private void addPos(int x_pos, char y_pos1, char y_pos2) {
        int y1 = Character.getNumericValue(y_pos1)-9; //getting integer from character code
        int y2 = Character.getNumericValue(y_pos2)-9;

        for (int i= Math.min(y1,y2) ; i < Math.min(y1,y2)+cellSize; i++) inputPos.add((i-1)+""+(x_pos-1));
    }

    //horizontal ship
    private void addPos ( int x_pos1, int x_pos2, char y_pos){
        int y = Character.getNumericValue(y_pos) - 9; //getting integer from character code
        for (int i = Math.min(x_pos1, x_pos2); i < cellSize + Math.min(x_pos1, x_pos2); i++) inputPos.add((y - 1)+""+(i - 1));
    }



}

class ShipCollection {
    public Ship[] ships;
    public int length;
    public ArrayList<String> allPos = new ArrayList<>(); //positions with the ships "rowcol" String
    public ArrayList<String> allClosePos = new ArrayList<>(); //positions surrounding ships + positions with the ships

    ShipCollection(int length, Ship[] ships) {
        this.length = length;
        this.ships = ships;
    }
    
    //setting collection of each set of ships
    public void setCollectionOf() {
        for (Ship x: ships) x.collectionOf = this;
    }

    //positions occupied by ships
    public void occcupied(GameField field) {

        allPos.clear();
        for (int i=0; i< field.contents.length; i++) {
            for (int j=0; j< field.contents[i].length; j++) {
                if (field.contents[i][j] == 'O') allPos.add(i+""+j);
            }
        }
    }


    public void takeAttack(GameField shootingField, GameField placingField, Ship[] ships) {
        Scanner scanner = new Scanner(System.in);

        String attack_pos;
        attack_pos = scanner.nextLine();
        System.out.println();

        int col = Integer.parseInt(attack_pos.substring(1)) - 1;
        int row = (Character.getNumericValue(attack_pos.charAt(0))-9) -1;

        if ((row >= shootingField.dim_size || col >= shootingField.dim_size)) { //ArrayIndexOutOfBounds occur if placed below (some problem with collectionOf.allPos or something else)

            System.out.println("Error! You entered the wrong coordinates! Try again:");
            takeAttack(shootingField, placingField, ships);

        } else if (allPos.contains(row+""+col)) {

            shootingField.construct(Ship.hit_symbol, Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );
            placingField.construct(Ship.hit_symbol, Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );


            int y=0;
            for (Ship ship : ships) {

                if (shootingField.allHitPos().containsAll(ship.inputPos)) {
                    System.out.println("You sank a ship! Specify a new target:");
                    break;
                }
                y += ship.cellSize;
                if (ship == ships[ships.length-1]) {
                    System.out.println("You hit a ship!");
                }
            }

        } else if (!allPos.contains(row+""+col)) {

            shootingField.construct('M', Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );
            placingField.construct('M', Integer.parseInt(attack_pos.substring(1)), attack_pos.charAt(0) );
            System.out.println("You missed!");
        }
    }

    //return true if all ships sank
    public boolean areAllSank(GameField shootingField, GameField placingField) {

        try {
            // placing field has all the x's and the shooting field should have all the x's too
            if (!shootingField.allHitPos().isEmpty() ) {

                // checking if 'O' is there for all position of the field where bombs are placed
                //( placingField also changes 'O' --> 'X' or 'M' (if hit or miss) )
                int counter = 0;
                for (int i=0; i< placingField.dim_size; i++) {
                    for (int j=0; j< placingField.dim_size; j++) {
                        if (placingField.contents[i][j] != 'O') {
                            counter += 1;
                        }
                    }
                }
                //there are no 'O' so counter is at max
                if (counter == placingField.dim_size * placingField.dim_size) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    return true;
                }
            }
        } catch(NullPointerException e) {
            return false;
        } return false;
    }

    //positions closer to ships
    public void inrange(GameField field) {

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