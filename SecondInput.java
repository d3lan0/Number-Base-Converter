package converter;

import java.math.BigInteger;
import java.util.Scanner;

class SecondInput {
    int source;
    int target;

     SecondInput(int source, int target) {
        this.source = source;
        this.target = target;
    }

    public  String levelTwo() {
        boolean validInput;
        String stringInput;

        do {
            stringInput = getLevelTwoInput();
            validInput = checkForValidLevelTwoInput(String.valueOf(stringInput));
        }
        while (!validInput);

        if (checkLeveTwoInputForBack(String.valueOf(stringInput))) {
            return "back";
        }

        return stringInput;
    }

    private String getLevelTwoInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number in base " + source + " to convert to base " + target + " (To go back type /back) ");
        return in.nextLine();
    }

    private boolean checkLeveTwoInputForBack(String input) {
        return input.equalsIgnoreCase("/back");
    }

    private boolean checkBaseInputForValidInput(String input) {
        return checkIfNumberIsHex(input, source) || checkIfNumberIsBigInt(input);
    }

    private boolean checkForValidLevelTwoInput(String input) {
        boolean isBack = checkLeveTwoInputForBack(input);
        boolean containsBigIntAndBase = checkBaseInputForValidInput(input);
        return isBack || containsBigIntAndBase;
    }

    private boolean checkIfNumberIsHex (String number, int radix) {
            try {
                Long value = Long.parseLong(number, radix);
                return true;
            } catch (Exception e) {
                return false;
            }

    }

    private static boolean checkIfNumberIsBigInt(String number) {
        try{
            BigInteger num = new BigInteger(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
