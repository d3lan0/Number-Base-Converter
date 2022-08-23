package converter;

import java.util.Scanner;

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
        System.out.print("Enter target base: ");
        int base = in.nextInt();
        in.close();
        if(base != 2 && base != 8 && base != 16){
            getTargetBase();
        }
        return base;
    }
}
