package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader input;
        String filename = "resources/day2/" + args[0];
        String rangeString;
        long answer = 0;
        ArrayList<String> splitId = new ArrayList<>();

        try {
            input = new BufferedReader(new FileReader(filename));
            rangeString = input.readLine();
        } catch (IOException e) {
            System.out.println("Error Reading Input File");
            System.out.println(e.toString());
            return;
        }

        String[] ranges = rangeString.split(",");

        for(String range : ranges) {
            String[] boundsString = range.split("-");
            long[] bounds = {Long.parseLong(boundsString[0]), Long.parseLong(boundsString[1])};

            for(long i = bounds[0]; i <= bounds[1]; i++) {
                String id = Long.toString(i);

                for(int repetitionLength = id.length() / 2; repetitionLength >= 1; repetitionLength--) {
                    if(id.length() % repetitionLength == 0) {
                        for(int splitIndex = 0; splitIndex <= id.length() - repetitionLength; splitIndex += repetitionLength) {
                            splitId.add(id.substring(splitIndex, splitIndex + repetitionLength));
                        }

                        boolean invalidId = true;
                        for(String pattern : splitId) {
                            if(!pattern.equals(splitId.get(0))) {
                                invalidId = false;
                                break;
                            }
                        }

                        if(invalidId) {
                            answer += i;
                            splitId.clear();
                            break;
                        }

                        splitId.clear();
                    }
                }
            }
        }

        System.out.println("The Answer is: " + answer);
    }
}