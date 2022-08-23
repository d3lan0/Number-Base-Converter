package converter;

import java.util.ArrayList;
import java.util.Collections;

public class Converter {
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
