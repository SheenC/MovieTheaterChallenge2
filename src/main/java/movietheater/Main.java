package movietheater;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //file input, seat reservations
        FileInput fileInput = new FileInput("input.txt");
        //arrange for seats
        Theater theater = new Theater();
        theater.arrange(fileInput.reservations);
        //file output, the seats arrangement
        FileOutput fileOutput = new FileOutput(theater.getSeats(), theater.getArrangements());
    }
}

