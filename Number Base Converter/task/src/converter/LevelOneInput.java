package converter;

import java.util.ArrayList;
import java.util.Scanner;

public class LevelOneInput {
    private final Scanner scanner;
    private final ArrayList<Integer> bases;

    public LevelOneInput(Scanner scanner) {
        this.scanner = scanner;
        this.bases = new ArrayList<>();
    }

    private Boolean checkForValidBases(String[] bases) {

        if (bases.length < 2) {
            return false;
        }

        try {
            int sourceBase = Integer.parseInt(bases[0]);
            boolean valid = Integer.parseInt(bases[0]) > 0 && Integer.parseInt(bases[0]) <= 36;
        } catch (Exception e) {
            System.out.println("Invalid {target base} try value a from 1-36.");
            return false;
        }

        try {
            int targetBase = Integer.parseInt(bases[1]);
            boolean valid = Integer.parseInt(bases[1]) > 0 && Integer.parseInt(bases[1]) <= 36;
        } catch (Exception e) {
            System.out.println("Invalid {source base} try a value from 1-36.");
            return false;
        }

        return true;

    }

    public ArrayList getBases() {
        return this.bases;
    }

    public void getFirstLevelInput() {

        while (true) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("/exit")) {
                System.exit(0);
            }

            String[] bases = input.split(" ");

            if (!checkForValidBases(bases)) {
                continue;
            }

            this.bases.add(Integer.valueOf(bases[0]));
            this.bases.add(Integer.valueOf(bases[1]));
            break;
        }

    }

}
