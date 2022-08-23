package converter;


import static converter.Converter.convert;
import static converter.Input.getDecimalNumber;
import static converter.Input.getTargetBase;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int number = getDecimalNumber();
        int base = getTargetBase();
        String result = convert(number, base).toString();
        System.out.println("Conversion result: " + result);
    }
}




