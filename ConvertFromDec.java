package converter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

class ConvertFromDec {
    BigInteger number;
    int base;

    ConvertFromDec(BigInteger number, int base){
        this.number = number;
        this.base = base;
    }

    public StringBuilder convertFromDec () {
        Hex hex = new Hex();
        BigInteger bigIntBase = BigInteger.valueOf(base);
        StringBuilder output = new StringBuilder();
        ArrayList<BigInteger> remainders = new ArrayList<>();
        BigInteger quotient = number;

        do{
            remainders.add(quotient.mod(bigIntBase));
            quotient = quotient.divide(bigIntBase);
        }while (quotient.compareTo(BigInteger.valueOf(1)) > 0);

        Collections.reverse(remainders);

        for (BigInteger o : remainders) {
            int oValue = o.intValue();
            if (base >= 16 && oValue  > 9){
                output.append(hex.getChar(oValue));
            } else {output.append(o);}
        }
        return output;
    }
}
