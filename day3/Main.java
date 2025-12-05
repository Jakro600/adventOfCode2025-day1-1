package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader input;
        String filename = "resources/day3/" + args[0];
        String notedBank;
        ArrayList<String> powerBanks = new ArrayList<>();
        int totalVoltage = 0;

        try {
            input = new BufferedReader(new FileReader(filename));
            notedBank = input.readLine();
            while(notedBank != null) {
                powerBanks.add(notedBank);
                notedBank = input.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error Reading Input File");
            System.out.println(e.toString());
            return;
        }

        for(String bank: powerBanks) {
            int tensVoltage = 1;
            int onesVoltage = 1;
            int tensVoltageIndex = 0;
            char[] batteryVoltages = bank.toCharArray();

            for(int battery = 0; battery < batteryVoltages.length - 1; battery++) {
                int batteryVoltage = Character.getNumericValue(batteryVoltages[battery]);
                if(tensVoltage < batteryVoltage) {
                    tensVoltage = batteryVoltage;
                    tensVoltageIndex = battery;
                }
            }
            for(int battery = tensVoltageIndex + 1; battery < batteryVoltages.length; battery++) {
                int batteryVoltage = Character.getNumericValue(batteryVoltages[battery]);
                if(onesVoltage < batteryVoltage) {
                    onesVoltage = batteryVoltage;
                }
            }

            int bankVoltage = Integer.parseInt(String.valueOf(tensVoltage) + String.valueOf(onesVoltage));
            totalVoltage += bankVoltage;
        }

        System.out.println("Total Voltage: " + totalVoltage);
    }
}