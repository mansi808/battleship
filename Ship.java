package battleship;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;

//ships have a name and cell size
//ship may be part of a collection of ships in game
//placed ships = '0'
//hit ships = 'X'
//miss ships = 'M'

public class Ship {
    public ShipCollection collectionOf;
    public static char safe_symbol = 'O';
    public static char hit_symbol = 'X';
    public int cellSize;
    public String name;
    public String level; //"vertical" or "horizontal"
    public boolean posValid = false;
    public ArrayList<String> inputPos = new ArrayList<>(); //contains all boxes of input position

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
            inputPos.clear();    //clearing input pos if invalid input

        } else if ( collectionOf.allClosePos != null )  {

            if ( inputPos.stream()
                .filter(collectionOf.allClosePos::contains)
                .collect(Collectors
                        .toList()).isEmpty()) {  //checked if the collectionOf.allClosePos and inputPos given by user have anything in common
                posValid =true;
            } else  {
                System.out.println("Error! You placed it too close to another one. Try again:");
                inputPos.clear();    //clearing input pos if invalid input
            }
        } else {
            posValid =true;
        }
    }
    
    //sets the value of level as 'horizontal' or 'vertical'
    public void setLevel(String a, String b) {
        if (a.charAt(0)==b.charAt(0)) level = "horizontal";
        else if (a.substring(1).equals(b.substring(1))) level = "vertical";
    }

    //adds all the positions for each ship according to level
    public void inputPos(String a, String b, GameField field) {
        if (level!= null) if (level.equals("vertical")) {

            int x_pos = Integer.parseInt(a.substring(1));
            int y1 = Character.getNumericValue(a.charAt(0))-9; //getting integer from character code
            int y2 = Character.getNumericValue(b.charAt(0))-9;

            for (int i= Math.min(y1,y2) ; i < Math.min(y1,y2)+cellSize; i++) inputPos.add((i-1)+""+(x_pos-1));

        } else if (level.equals("horizontal")) {
            int x_pos1 = Integer.parseInt(a.substring(1));
            int x_pos2 = Integer.parseInt(b.substring(1));
            int y = Character.getNumericValue(a.charAt(0)) - 9; //getting integer from character code

            for (int i = Math.min(x_pos1, x_pos2); i < cellSize + Math.min(x_pos1, x_pos2); i++) inputPos.add((y - 1)+""+(i - 1));
        }
    }

}

