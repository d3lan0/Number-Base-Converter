package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class ConvertFractionFromDec {
    private String value;
    private BigDecimal base;


    public ConvertFractionFromDec(String value, String base) {
        this.value = value;
        this.base = new BigDecimal(base);
    }

    public String convert() {
        Hex hex = new Hex();
        BigDecimal product = new BigDecimal(value);
        ArrayList<BigInteger> remainders = new ArrayList<>();
        return "string";
    }

}
