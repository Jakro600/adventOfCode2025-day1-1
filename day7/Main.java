package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        BufferedReader input;
        String inputLine;
        String filename = "resources/day7/" + args[0];
        ArrayList<String> rows = new ArrayList<>();
        int numSplits = 0;

        try {
            input = new BufferedReader(new FileReader(filename));
            inputLine = input.readLine();
            while(inputLine != null) {
                rows.add(inputLine);
                inputLine = input.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error Reading Input File");
            System.out.println(e.toString());
            return;
        }

        HashSet<Integer> beamIndexes = new HashSet<>();
        beamIndexes.add(rows.get(0).indexOf('S'));

        for(int rowIndex = 1; rowIndex < rows.size(); rowIndex++) {
            HashSet<Integer> currentBeamIndexes = new HashSet<>(beamIndexes);

            for(Integer beamIndex: currentBeamIndexes) {
                if(rows.get(rowIndex).charAt(beamIndex) == '^') {
                    beamIndexes.remove(beamIndex);
                    beamIndexes.add(beamIndex - 1);
                    beamIndexes.add(beamIndex + 1);
                    numSplits++;
                }
            }
        }

        System.out.println("Number of Splits: " + numSplits);
    }
}