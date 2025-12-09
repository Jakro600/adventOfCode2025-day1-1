package day6;

import java.util.ArrayList;

public class Problem {
    ArrayList<Long> numbers;
    String operation;
    Long answer;

    Problem(ArrayList<Long> numbers, String operation) {
        this.numbers = numbers;
        this.operation = operation;
        answer = 0L;
    }

    public Long solveProblem() {
        if(operation.equals("+")) {
            for(Long num: numbers) {
                answer += num;
            }
        } else {
            answer = 1L;
            for(Long num: numbers) {
                answer *= num;
            }
        }
        return answer;
    }
}
