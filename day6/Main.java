package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader input;
        ArrayList<String> inputRows = new ArrayList<>();
        String filename = "resources/day6/" + args[0];
        ArrayList<String[]> problemRows = new ArrayList<>();
        Long grandTotal = 0L;

        try {
            input = new BufferedReader(new FileReader(filename));
            inputRows.add(input.readLine());
            while(inputRows.size() < 5) {
                inputRows.add(input.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error Reading Input File");
            System.out.println(e.toString());
            return;
        }

        StringBuilder row1 = new StringBuilder();
        StringBuilder row2 = new StringBuilder();
        StringBuilder row3 = new StringBuilder();
        StringBuilder row4 = new StringBuilder();
        String[] inputOperations = inputRows.get(4).split("\s+");
        ArrayList<Problem> problemList = new ArrayList<>();

        for(int stringIndex = 0; stringIndex < inputRows.get(0).length(); stringIndex++) {
            char row1Char = inputRows.get(0).charAt(stringIndex);
            char row2Char = inputRows.get(1).charAt(stringIndex);
            char row3Char = inputRows.get(2).charAt(stringIndex);
            char row4Char = inputRows.get(3).charAt(stringIndex);

            if(row1Char == ' ' && row2Char == ' ' && row3Char == ' ' && row4Char == ' ') {
                ArrayList<Long> numbers = translateNumbers(row1, row2, row3, row4);

                problemList.add(new Problem(numbers, inputOperations[problemList.size()]));

                row1.delete(0, row1.length());
                row2.delete(0, row2.length());
                row3.delete(0, row3.length());
                row4.delete(0, row4.length());
            } else {
                row1.append(row1Char);
                row2.append(row2Char);
                row3.append(row3Char);
                row4.append(row4Char);
            }
        }

        ArrayList<Long> numbers = translateNumbers(row1, row2, row3, row4);

        problemList.add(new Problem(numbers, inputOperations[problemList.size()]));

        row1.delete(0, row1.length());
        row2.delete(0, row2.length());
        row3.delete(0, row3.length());
        row4.delete(0, row4.length());

        for(Problem problem: problemList) {
            grandTotal += problem.solveProblem();
        }

        System.out.println("Grand Total: " + grandTotal);
//        int operationRowIndex = problemRows.size() - 1;
//
//        for(int problem = 0; problem < problemRows.get(0).length; problem++) {
//            String operation = problemRows.get(operationRowIndex)[problem];
//            Long answer = Long.valueOf(problemRows.get(0)[problem]);
//
//            for(int rowIndex = 1; rowIndex < problemRows.size() - 1; rowIndex++) {
//                Long number = Long.valueOf(problemRows.get(rowIndex)[problem]);
//                if(operation.equals("+")) {
//                    answer += number;
//                } else {
//                    answer *= number;
//                }
//            }
//
//            grandTotal += answer;
//        }
    }

    private static ArrayList<Long> translateNumbers(StringBuilder row1, StringBuilder row2, StringBuilder row3, StringBuilder row4) {
        ArrayList<Long> numbers = new ArrayList<>();

        for(int translationIndex = row1.length() - 1; translationIndex >= 0; translationIndex--) {
            StringBuilder number = new StringBuilder();
            number.append(row1.toString().charAt(translationIndex));
            number.append(row2.toString().charAt(translationIndex));
            number.append(row3.toString().charAt(translationIndex));
            number.append(row4.toString().charAt(translationIndex));
            numbers.add(Long.valueOf(number.toString().trim()));
        }

        return numbers;
    }
}