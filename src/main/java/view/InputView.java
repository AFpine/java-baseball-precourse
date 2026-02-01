package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<Integer> InputUserNumbers() {
        String input = scanner.nextLine();
        return numberToIntegerList(input);
    }

    private List<Integer> numberToIntegerList(String input) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 3; ++i) {
            ret.add(input.charAt(i) - '0');
        }
        return ret;
    }

    public int InputCommand() {
        String input = scanner.nextLine();

        if (input.equals("1")) return 1;
        if (input.equals("2")) return 2;
        return 3;
    }
}
