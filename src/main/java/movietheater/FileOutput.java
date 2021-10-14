package movietheater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FileOutput {
    int[][] seats;
    LinkedHashMap<String, ArrayList<String>> arrangements;
    StringBuilder output;
    String path = "/Users/cxy/Desktop/Intern/Theater/MovieTheaterChallenge2/outputTheater";
    String information;

    public FileOutput(int[][] seats, LinkedHashMap<String, ArrayList<String>> arrangements, String informtion) {
        this.seats = seats;
        this.arrangements = arrangements;
        this.output = new StringBuilder();
        this.information = informtion;
        printFile();
    }

    public void printFile() {
        output.append("*************** Seat Map ***************\n\n");
        output.append("                [Screen]                \n");
        for (int i = 0; i < Theater.ROW; i++) {
            for (int j = 0; j < Theater.COLUMN; j++) {
                output.append(seats[i][j] + " ");
            }
            output.append("\n");
        }
        output.append("\n*********** Seat Arrangements ***********\n\n");
        for (String key : arrangements.keySet()) {
            output.append(key + " ");
            for (String seat : arrangements.get(key)){
                output.append(seat + ",");
            }
            output.delete(output.length()-1, output.length());
            output.append("\n\n");
        }
        output.append(information + "\n");
        writeFile();
    }

    public void writeFile() {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(output.toString());
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
