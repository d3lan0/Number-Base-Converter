package converter;

import java.math.BigInteger;
import java.util.ArrayList;

class ConvertToWholeDecNumber {
    String value;
    int base;

    ConvertToWholeDecNumber(String value, int sourceBase) {
        this.value = value;
        this.base = sourceBase;
    }

    public BigInteger convert() {
        Hex hex = new Hex();
        int counter = 0;
        long number = 0;
        ArrayList<Integer> charArray = new ArrayList<>();
        for (int i = 0; i <= value.length() - 1; i++) {
            char digit = value.charAt(i);

            if (digit >= 'A' && digit <= 'F' || digit >= 'a' && digit <= 'f') {
                charArray.add(hex.getInt(Character.toLowerCase(digit)));
            } else {
                charArray.add(Character.getNumericValue(value.charAt(i)));
            }
        }

        for (int i = charArray.size() - 1; i >= 0; i--) {
            number += (charArray.get(i) * Math.pow(base, counter));
            counter++;
        }
        return BigInteger.valueOf(number);
    }
}