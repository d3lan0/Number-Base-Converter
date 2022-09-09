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
        decToHex.put(16, 'g');
        decToHex.put(17, 'h');
        decToHex.put(18, 'i');
        decToHex.put(19, 'j');
        decToHex.put(20, 'k');
        decToHex.put(21, 'l');
        decToHex.put(22, 'm');
        decToHex.put(23, 'n');
        decToHex.put(24, 'o');
        decToHex.put(25, 'p');
        decToHex.put(26, 'q');
        decToHex.put(27, 'r');
        decToHex.put(28, 's');
        decToHex.put(29, 't');
        decToHex.put(30, 'u');
        decToHex.put(31, 'v');
        decToHex.put(32, 'w');
        decToHex.put(33, 'x');
        decToHex.put(34, 'y');
        decToHex.put(35, 'z');
    }

    private static final HashMap<Character, Number> hexToDec = new HashMap<>();
    static {
        hexToDec.put('a', 10);
        hexToDec.put('b', 11);
        hexToDec.put('c', 12);
        hexToDec.put('d', 13);
        hexToDec.put('e', 14);
        hexToDec.put('f', 15);
        hexToDec.put('g', 16);
        hexToDec.put('h', 17);
        hexToDec.put('i', 18);
        hexToDec.put('j', 19);
        hexToDec.put('k', 20);
        hexToDec.put('l', 21);
        hexToDec.put('m', 22);
        hexToDec.put('n', 23);
        hexToDec.put('o', 24);
        hexToDec.put('p', 25);
        hexToDec.put('q', 26);
        hexToDec.put('r', 27);
        hexToDec.put('s', 28);
        hexToDec.put('t', 29);
        hexToDec.put('u', 30);
        hexToDec.put('v', 31);
        hexToDec.put('w', 32);
        hexToDec.put('x', 33);
        hexToDec.put('y', 34);
        hexToDec.put('z', 35);

    }

    public char getChar(int num) {
        return decToHex.get(num);
    }

    public int getInt(char letter) {return (int) hexToDec.get(letter);}

}
