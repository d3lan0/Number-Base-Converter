package converter;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

class ConvertFromWholeDecNumber {
    private String number;
    private int base;

    private ArrayList<BigInteger> calculateRemainders(BigInteger quotient, BigInteger base) {
        ArrayList<BigInteger> remainders = new ArrayList<>();

        do {
            remainders.add(quotient.mod(base));
            quotient = quotient.divide(base);
        } while (quotient.compareTo(BigInteger.valueOf(1)) >= 0);

        Collections.reverse(remainders);

        return remainders;
    }

    private String replaceCharWithLetter(ArrayList<BigInteger> remainders){
        Hex hex = new Hex();
        StringBuilder output = new StringBuilder();
        for (BigInteger remainder : remainders) {
            int remainderValue = remainder.intValue();
            if (this.base >= 11 && remainderValue > 9) {
                output.append(hex.getChar(remainderValue));
            } else {
                output.append(remainder);
            }
        }

        return output.toString();
    }

    public ConvertFromWholeDecNumber(String number, int base) {
        this.number = number;
        this.base = base;
    }

    public String convert() {
        BigInteger quotient = new BigInteger(this.number);
        BigInteger bigIntBase = BigInteger.valueOf(this.base);
        ArrayList<BigInteger> remainders = calculateRemainders(quotient, bigIntBase);
        return replaceCharWithLetter(remainders);
    }
}
