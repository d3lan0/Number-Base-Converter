package converter;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

import static converter.FirstInput.*;


public class Main {

    public static void main(String[] args) {

        boolean valid = true;
        ArrayList<Integer> levelOneInput = levelOne();
        int sourceBase = levelOneInput.get(0);
        int targetBase = levelOneInput.get(1);


        if (levelOneInput.size() < 2) {
            System.exit(0);
        }

        do {
            SecondInput secondInput = new SecondInput(sourceBase, targetBase);
            BigInteger levelTwoInput = secondInput.levelTwo();

            if(Objects.equals(levelTwoInput, BigInteger.valueOf(-1))) {
                levelOneInput = levelOne();
            }


        }
        while(valid);
    }
}



