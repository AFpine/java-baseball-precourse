package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String InputUserNumbers() {
        return scanner.nextLine();
    }

    public int InputCommand() {
        String input = scanner.nextLine();

        if (input.equals("1")) return 1;
        if (input.equals("2")) return 2;
        return 3;
    }
}
