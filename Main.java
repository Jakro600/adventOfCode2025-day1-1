import java.io.BufferedReader;
import java.io.FileReader;

class Main {
    static BufferedReader document;
    static String instruction;
    static int change;
    static int pointer = 50;
    static int passCount = 0;

    public static void main(String[] args) {
        String fileName = "resources/" + args[0];

        try {
            document = new BufferedReader(new FileReader(fileName));
            instruction = document.readLine();
            while(instruction != null) {
                change = parse(instruction);
                pointer = turnPointer(pointer, change);
                if(pointer == 0) {
                    passCount++;
                }
                instruction = document.readLine();
            }
            System.out.println("The Passcode is: " + passCount);
        } catch(java.io.FileNotFoundException e) {
            System.out.println("Error Opening File");
            System.out.println(e.toString());
        } catch(java.io.IOException e) {
            System.out.println("Error Reading File");
            System.out.println(e.toString());
        }
    }

    private static int parse(String instruction) {
        char operation = instruction.charAt(0);
        int magnitude = Integer.parseInt(instruction.substring(1));

        if(operation == 'L') {
            magnitude -= magnitude*2;
        }

        return magnitude;
    }

    private static int turnPointer(int pointer, int change) {
        pointer += change;

        while(pointer > 99) {
            pointer -= 100;
        }
        while(pointer < 0) {
            pointer += 100;
        }

        return pointer;
    }
}