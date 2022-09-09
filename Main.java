package converter;


import java.util.Scanner;

import static converter.Converter.convertFromDec;
import static converter.Converter.convertToDec;
import static converter.Input.*;

public class Main {

    public static void main(String[] args) {

       boolean terminate = true;
        do{
            String choice = getChoice();
            if (choice.equals("/exit")){
                terminate= false;
                System.exit(0);
            }
            if (choice.equals("/to")) {
                String input = getSource();
                int base = getSourceBase();
                System.out.println("Conversion to decimal result: " + convertToDec(input, base));
            }

            if (choice.equals("/from")) {
                int input = getDecimalNumber();
                int base = getTargetBase();
                System.out.println("Conversion result: " + convertFromDec(input, base));
            }


        }
        while (terminate);

    }

    public static String getChoice() {
        boolean validator;
        String choice;
        do {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            Scanner in = new Scanner(System.in);
            choice = in.next();
            validator = "/from".equalsIgnoreCase(choice) || "/to".equalsIgnoreCase(choice) || "/exit".equalsIgnoreCase(choice);
        }
        while (!validator);

        return choice;

    }
}



