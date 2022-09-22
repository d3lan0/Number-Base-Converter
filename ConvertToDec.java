package converter;

import java.math.BigInteger;
import java.util.ArrayList;

 class ConvertToDec {
     String value;
     int base;

     ConvertToDec(String value, int base) {
         this.value = value;
         this.base = base;
     }


     public BigInteger convertToDec() {
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