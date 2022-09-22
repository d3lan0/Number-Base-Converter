package converter;


import java.util.ArrayList;

import static converter.FirstInput.*;


public class Main {

    public static void main(String[] args) {

         ArrayList<Integer> levelOneInput = levelOne();

        if (levelOneInput.size() == 1) {
            System.exit(0);
        }

        do {
            int sourceBase = levelOneInput.get(0);
            int targetBase = levelOneInput.get(1);
            SecondInput secondInput = new SecondInput(sourceBase, targetBase);
            String levelTwoInput = secondInput.levelTwo();

            if(levelTwoInput.equals("back")) {
                levelOneInput = levelOne();
                continue;
            }

            if(sourceBase == targetBase){
                System.out.println("Conversion result: " + levelTwoInput);
                continue;
            }

            ConvertToDec decimalConversion = new ConvertToDec(levelTwoInput, sourceBase);
            String decimalValue = String.valueOf(decimalConversion.convertToDec());

            if (targetBase == 10) {
                output(decimalValue);
                continue;
            }

            if (sourceBase == 10) {
                ConvertFromDec fromDecConversion = new ConvertFromDec(levelTwoInput, targetBase);
                String convertedValue = String.valueOf(fromDecConversion.convertFromDec());
                output(convertedValue);
                continue;
            }

            ConvertFromDec fromDecConversion = new ConvertFromDec(decimalValue, targetBase);
            String convertedValue = String.valueOf(fromDecConversion.convertFromDec());
            output(convertedValue);
        }
        while(levelOneInput.size() != 1);
    }

    public static void output(Object o) {
        System.out.println("Conversion result: " + o);
    }
}



