package converter;

import java.math.BigInteger;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private LevelOneInput levelOneInput;
    private ConvertToWholeDecNumber dec;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    private boolean checkIfNumberIsHex(String number, int radix) {
        try {
            Long value = Long.parseLong(number, radix);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private boolean checkIfNumberIsBigInt(String number) {
        try {
            BigInteger num = new BigInteger(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkForValidLevelTwoInput(String input, int radix) {
        return checkIfNumberIsBigInt(input) || checkIfNumberIsHex(input, radix);
    }

    public void start() {

        this.levelOneInput = new LevelOneInput(scanner);
        levelOneInput.getFirstLevelInput();

        int sourceBase = (int) levelOneInput.getBases().get(0);
        int targetBase = (int) levelOneInput.getBases().get(1);

        while (true) {
            System.out.println("Enter number in base " + sourceBase + " to convert to base " + targetBase + " (To go back type /back)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("/back")) {
                this.start();
            }

            //split the input into an array
            // for each input do validity check, convert.
            // join  and print
            if (!checkForValidLevelTwoInput(input, sourceBase)) {
                continue;
            }

            if (sourceBase == targetBase) {
                System.out.println("Conversion result: " + input);
            }

            if (targetBase == 10) {
                this.dec = new ConvertToWholeDecNumber(input, sourceBase);
                System.out.println("Conversion result: " + dec.convert());
                continue;
            }

            this.dec = new ConvertToWholeDecNumber(input, sourceBase);
            ConvertFromWholeDecNumber value = new ConvertFromWholeDecNumber(dec.convert().toString(), targetBase);
            System.out.println("Conversion result: " + value.convert());

        }

    }

}
