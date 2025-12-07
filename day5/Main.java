package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader input;
        String inputLine;
        String filename = "resources/day5/" + args[0];
        ArrayList<String> freshRangesInput = new ArrayList<>();
        ArrayList<Long[]> freshRanges = new ArrayList<>();
        ArrayList<Long> ingredients = new ArrayList<>();
        int freshIngredients = 0;

        try {
            input = new BufferedReader(new FileReader(filename));
            inputLine = input.readLine();
            boolean readingRanges = true;
            while(inputLine != null) {
                if(readingRanges) {
                    if(!inputLine.isEmpty()) {
                        freshRangesInput.add(inputLine);
                    } else {
                        readingRanges = false;
                    }
                } else {
                    ingredients.add(Long.valueOf(inputLine));
                }

                inputLine = input.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error Reading Input File");
            System.out.println(e.toString());
            return;
        }

        for(String range: freshRangesInput) {
            String[] splitRange = range.split("-");
            Long[] convertedRange = {Long.valueOf(splitRange[0]), Long.valueOf(splitRange[1])};
            freshRanges.add(convertedRange);
        }

        for(Long ingredient: ingredients) {
            for(Long[] range: freshRanges) {
                if(ingredient >= range[0] && ingredient <= range[1]) {
                    freshIngredients++;
                    break;
                }
            }
        }

        System.out.println("Total Fresh Ingredients: " + freshIngredients);
    }
}
