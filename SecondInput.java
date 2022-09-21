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

    public  BigInteger levelTwo() {
        String input;
        boolean validInput;

        do{
            input = getLevelTwoInput();
            validInput = checkForValidLevelTwoInput(input);
        }
        while (!validInput);

        if (checkLeveTwoInputForBack(input)){
            return (BigInteger.valueOf(-1));
        }

        if (checkIfNumberIsHex(input, source)) {
            return BigInteger.valueOf(Long.parseLong(input, source));
        }

        return BigInteger.valueOf(Long.parseLong(input));
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
        return checkIfNumberIsHex(input, source) || checkIfNumberIsLong(input);
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

    private static boolean checkIfNumberIsLong(String number) {
        try{
            long value = Long.parseLong(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
