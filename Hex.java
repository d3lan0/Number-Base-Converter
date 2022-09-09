package converter;

import java.util.HashMap;

public class Hex {
    private static final HashMap<Number, Character> decToHex = new HashMap<>();
    static {
        decToHex.put(10, 'a');
        decToHex.put(11, 'b');
        decToHex.put(12, 'c');
        decToHex.put(13, 'd');
        decToHex.put(14, 'e');
        decToHex.put(15, 'f');

    }

    private static final HashMap<Character, Number> hexToDec = new HashMap<>();
    static {
        hexToDec.put('a', 10);
        hexToDec.put('b', 11);
        hexToDec.put('c', 12);
        hexToDec.put('d', 13);
        hexToDec.put('e', 14);
        hexToDec.put('f', 15);

    }

    public char getChar(int num) {
        return decToHex.get(num);
    }

    public int getInt(char letter) {return (int) hexToDec.get(letter);}

}
