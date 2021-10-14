package movietheater;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Theater {
    public static final int ROW = 10;
    public static final int COLUMN = 20;
    public static final int BUFFER = 3;
    public static final int MIDROW = ROW/2;
    public static final int MIDCOL = COLUMN/2;
    private int curRow;
    private int curCol;
    private int[][] seats;
    private int seatsAvailable;
    private LinkedHashMap<String, ArrayList<String>> arrangements;
    private boolean enoughSeats;

    public Theater() {
        seats = new int[ROW][COLUMN];
        // A is row 0, ..., F is row 5, ..., J is row 9
        curRow = MIDROW;
        curCol = MIDCOL;
        arrangements = new LinkedHashMap<>();
        //consider safety buffer
        seatsAvailable = ROW * COLUMN - BUFFER;
        enoughSeats = true;
    }

    public void arrange(LinkedHashMap<String, Integer> reservations) {
        for (String key : reservations.keySet()) {
            int seatsNeed = reservations.get(key);
            if (seatsAvailable < seatsNeed) {
                enoughSeats = false;
                break;
            }
            else {
                seatsAvailable -= seatsNeed;
                allocate(key, seatsNeed);
            }
        }
    }

    void allocate(String customerId, int seatsNeed) {
        while (seatsNeed > 0) {
            //this seat marked as visited
            seats[curRow][curCol] = 1;
            //locate the seat
            char rowChar  = (char) (curRow + 'A');
            String rowStr= String.valueOf(rowChar);
            String position = rowStr + "" + curCol;
            //add the seat into seatList in arrangements
            ArrayList seatList = arrangements.getOrDefault(customerId, new ArrayList<>());
            seatList.add(position);
            arrangements.put(customerId, seatList);
            //update curRow, curCol
            updateCurPos();
            seatsNeed--;
        }
    }

    //return false if if no more seats available
    public boolean updateCurPos() {
        //right part, do not change row
        if (curCol >= MIDCOL && curCol < (COLUMN - 1)) {
            curCol++;
        }
        //right part, change to the left part
        else if (curCol == (COLUMN - 1)) {
            //set column
            curCol = MIDCOL - 1;
        }
        //left part, do not change row
        else if (curCol > 0 && curCol <= MIDCOL - 1) {
            curCol--;
        }
        //left part, change row
        else if (curCol == 0) {
            curCol = MIDCOL;
            //from middle to end
            if (curRow >= MIDROW && curRow < ROW - 1)
                curRow++;
            //after the last row, jump to the MIDROW-1 row
            else if (curRow == ROW - 1)
                curRow = MIDROW - 1;
            //from middle to front
            else if (curRow < MIDROW && curRow > 0)
                curRow--;
            //no more seats available
            else if (curRow == MIDROW - 1)
                return false;
        }
        return true;
    }

    public int[][] getSeats() {
        return this.seats;
    }

    public LinkedHashMap<String, ArrayList<String>> getArrangements() {
        return this.arrangements;
    }

    public String getInformation() {
        if (enoughSeats) {
            return "The theater has enough seats.";
        }
        else {
            return "The rest reservations cannot be made because of the insufficient seats.";
        }
    }

    //methods used for test
    public int getSeatsAvailable() {
        return this.seatsAvailable;
    }
    public boolean getEnoughSeats() {
        return this.enoughSeats;
    }
    public int getCurRow() {
        return this.curRow;
    }
    public int getCurCol() {
        return this.curCol;
    }
}
