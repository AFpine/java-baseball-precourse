package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String InputUserNumbers() {
        return scanner.nextLine();
    }

    public String InputCommand() {
        return scanner.nextLine();
    }
}
