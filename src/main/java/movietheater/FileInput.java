package movietheater;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FileInput {
    private String filename;
    private StringBuilder input;
    public LinkedHashMap<String, Integer> reservations;

    public FileInput(String filename) {
        this.filename = filename;
        this.input = new StringBuilder();
        this.reservations = new LinkedHashMap<>();
        loadFile();
    }
    public void loadFile() {
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                input.append(sc.nextLine()+"\n");
            }
            String[] rows = input.toString().split("\n");
            for (String row : rows) {
                String[] arr =row.split("\\s+");
                reservations.put(arr[0], Integer.parseInt(arr[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
