package converter;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstInput {


    public static ArrayList<Integer> levelOne() {
        String input;
        boolean validInput;
        ArrayList<Integer> output = new ArrayList<>();

        do {
            input = getBaseInput();
            validInput = checkForValidInput(input);
        }
        while(!validInput);

        if (checkBaseInputForExit(input)){
            output.add(-1);
            return output;
        }

        String[] strArry = input.split("\\s+");
        output.add(Integer.parseInt(strArry[0]));
        output.add(Integer.parseInt(strArry[1]));

        return output;
    }

    private static String getBaseInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
        return in.nextLine();
    }

    private static boolean checkBaseInputForExit(String input) {
        return input.equalsIgnoreCase("/exit");
    }

    private static boolean checkBaseInputForValidNumbers(String input) {
        String[] strArray = input.split("\\s+");
        int sourceBase;
        int targetBase;
        if (strArray.length != 2) {
            return false;
        }
        try {
            sourceBase = Integer.parseInt(strArray[0]);
            targetBase = Integer.parseInt(strArray[1]);
        }
        catch (Exception e) {
            return false;
        }

        if (sourceBase < 2 || sourceBase > 36) {
            return false;
        }

        if (targetBase < 2 || targetBase > 36) {
            return false;
        }

        return true;
    }

    private static boolean checkForValidInput(String input) {
        Boolean isExit = checkBaseInputForExit(input);
        Boolean containsTwoValidNumbers = checkBaseInputForValidNumbers(input);

        return isExit || containsTwoValidNumbers;

    }

}
