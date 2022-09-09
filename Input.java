package converter;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {


    public static int getDecimalNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number in decimal system: ");
        int input = 0;
        try {
            input = in.nextInt();
            in.close();
        } catch (Exception e) {
            getDecimalNumber();
        }
        return input;
    }

    public static int getTargetBase(){
        Scanner in = new Scanner(System.in);
        int base = 0;
        boolean validator;
        do {
            System.out.print("Enter target base: ");
            try{
                base = in.nextInt();
            }catch (Exception e){
                getTargetBase();
            }
            validator = base == 2 || base == 8 || base == 16;
        }
        while (!validator);
        in.close();
        return base;
    }

    public static String getSource(){
        Scanner in = new Scanner(System.in);
        Pattern validPattern = Pattern.compile("^[0-9A-Fa-f]+$");
        boolean valid;
        String input;
        do{
            System.out.println("Enter source number:");
            input = in.next();
            Matcher m = validPattern.matcher(input);
            valid = m.find();
        }
        while (!valid);

        return input;
    }

    public static int getSourceBase(){
        Scanner in = new Scanner(System.in);
        int base = 0;
        boolean validator;
        do {
            System.out.print("Enter source base: ");
            try{
                base = in.nextInt();
            }catch (Exception e){
                getSourceBase();
            }
            validator = base == 2 || base == 8 || base == 16;
        }
        while (!validator);
        in.close();
        return base;
    }

}
