package converter;

import java.util.*;
import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int number = getDecimalNumber();
        int base = getTargetBase();
        String result = convert(number, base).toString();
        System.out.println("Conversion result: " + result);
    }

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


    public static StringBuilder convert (int number, int base) {
        Hex hex = new Hex();

        StringBuilder output = new StringBuilder();
        ArrayList<Object> remainders = new ArrayList<>();
        double quotient = number;
       // double remainder = Math.floor(quotient % base);
        do{
            remainders.add((int)Math.floor(quotient % base));
            quotient = Math.floor(quotient / base);
           // remainder = Math.floor(quotient % base);
        }while (quotient >= 1);

        Collections.reverse(remainders);

        for (Object o : remainders) {
            if (base == 16 && (int)o  > 9){
                output.append(hex.get((int)o));
            } else {output.append(o);}

        }

        return output;
    }
}




