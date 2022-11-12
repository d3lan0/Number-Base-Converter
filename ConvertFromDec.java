package converter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

class ConvertFromDec {
    String number;
    int base;

    ConvertFromDec(String number, int base){
        this.number = number;
        this.base = base;
    }

    public StringBuilder convertFromDec () {
        BigInteger bigNumber = new BigInteger(number);
        Hex hex = new Hex();
        BigInteger bigIntBase = BigInteger.valueOf(base);
        StringBuilder output = new StringBuilder();
        ArrayList<BigInteger> remainders = new ArrayList<>();
        BigInteger quotient = bigNumber;

        do{
            remainders.add(quotient.mod(bigIntBase));
            quotient = quotient.divide(bigIntBase);
        }while (quotient.compareTo(BigInteger.valueOf(1)) >= 0);

        Collections.reverse(remainders);

        for (BigInteger o : remainders) {
            int oValue = o.intValue();
            if (base >= 11 && oValue  > 9){
                output.append(hex.getChar(oValue));
            } else {output.append(o);}
        }
        return output;
    }
}
