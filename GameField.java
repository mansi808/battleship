package battleship;

import java.util.ArrayList;

public class GameField {
    public int dim_size;

    public char[][] contents; //table with dimension size specified

    public GameField(int dim_size) {
        this.dim_size = dim_size;
        this.contents = construct();
    }

    //return a field with only '~' character
    public char[][] construct() {

        char[][] field_placeholder = new char[dim_size][dim_size];
        for (int x = 0; x < dim_size; x++) {
            for (int y = 0; y < dim_size; y++) { field_placeholder [x][y] = '~';  }
        } return field_placeholder;
    }

    //other construct method only changes the existing arraylist return vois
    //A=10-J=20 are character code
    //vertical ship
    public void construct(char element, int x_pos, char y_pos1, char y_pos2,Ship ship) {

        int y1 = Character.getNumericValue(y_pos1)-9; //getting integer from character code
        int y2 = Character.getNumericValue(y_pos2)-9;
        for (int i= Math.min(y1,y2) ; i <= (ship.cellSize-1)+Math.min(y1,y2); i++) contents[i-1][x_pos-1] = element;
    }

    //horizontal ship
    public void construct(char element, int x_pos1, int x_pos2, char y_pos, Ship ship) {

        int y = Character.getNumericValue(y_pos)-9; //getting integer from character code
        for (int i= Math.min(x_pos1,x_pos2); i< ship.cellSize+Math.min(x_pos1,x_pos2); i++) contents[y-1][i-1] = element;
    }

    //making change to contents for attack position
    public void construct(char element, int x_pos, char y_pos) {

        int y = Character.getNumericValue(y_pos)-9;
        contents[y-1][x_pos-1] = element;
    }

    public void print() {

        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for (int x = 0; x < dim_size; x++) {
            System.out.print((char)(65+x) +" "); //ascii code of A=65
            for (int y = 0; y < dim_size; y++) {
                System.out.print(contents[x][y]+" ");
            }
            System.out.println();
        }
    }

    //has all positions with "row"+"col" with 'X'
    public ArrayList<String> allHitPos() {

        ArrayList<String> arr = new ArrayList<>();

        for (int x = 0; x < dim_size; x++) {
            for (int y = 0; y < dim_size; y++) {
                if (contents[x][y]=='X') arr.add(x+""+y);
            }
        } return arr;
    }


}//class "GameField" ends
