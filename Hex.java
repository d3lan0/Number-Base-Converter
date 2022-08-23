package converter;

import java.util.HashMap;

public class Hex {
    private static final HashMap<Number, Character> hex = new HashMap<>();
    static {
        hex.put(10, 'A');
        hex.put(11, 'B');
        hex.put(12, 'C');
        hex.put(13, 'D');
        hex.put(14, 'E');
        hex.put(15, 'F');
    }

    public char get(int num) {
        return hex.get(num);
    }
}
