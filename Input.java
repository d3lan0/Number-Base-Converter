package converter;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {


    public static ArrayList<Integer> levelOne() {
        String input;
        ArrayList<Integer> output = new ArrayList<Integer>();

        do {
            input = getBaseInput();

            if (checkBaseInputForExit(input)){
                output.add(-1);;
            }

            String[] strArry = input.split("\\s+");
            output.add(Integer.parseInt(strArry[0]));
            output.add(Integer.parseInt(strArry[1]));

        }
        while(!checkForValidInput(input));
        return output;
    }

    public static String getBaseInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
        return in.nextLine();
    }

    public static Boolean checkBaseInputForExit(String input) {
        return input.equalsIgnoreCase("/exit");
    }

    public static Boolean checkBaseInputForNumbers(String input) {
        String[] strArry = input.split("\\s+");
        if (strArry.length != 2) {
            return false;
        }
        try {
            int sourceBase = Integer.parseInt(strArry[0]);
            int targetBase = Integer.parseInt(strArry[1]);
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    public static Boolean checkForValidInput(String input) {
        Boolean isExit = checkBaseInputForExit(input);
        Boolean containsTwoValidNumbers = checkBaseInputForNumbers(input);

        return isExit && containsTwoValidNumbers;

    }

}
