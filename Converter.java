package converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Converter {
    public static StringBuilder convertFromDec (int number, int base) {
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
                output.append(hex.getChar((int)o));
            } else {output.append(o);}

        }

        return output;
    }

    public static int convertToDec (String value, int base) {
        Hex hex = new Hex();
        int counter = 0;
        int number = 0;
        ArrayList<Integer> charArray = new ArrayList<>();
        for (int i = 0; i<= value.length()-1; i++){
            char digit = value.charAt(i);

            if( digit >= 'A' && digit <= 'F' || digit >= 'a' && digit <= 'f'){
                charArray.add(hex.getInt(Character.toLowerCase(digit)));
            } else {
                charArray.add(Character.getNumericValue(value.charAt(i)));
            }
        }

        for (int i = charArray.size()-1; i >= 0; i--) {
            number += (int) (charArray.get(i) * Math.floor(Math.pow(base, counter)));
            counter++;
        }




        return number;
    }
}
