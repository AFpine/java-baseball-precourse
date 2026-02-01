package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Numbers correctNumbers;

    public Game() {
        this.correctNumbers = generateCorrectNumbers();
    }

    private Numbers generateCorrectNumbers() {
        List<Integer> tempNumbers = new ArrayList<Integer>();

        for (int i = 1; i <= 9; ++i) {
            tempNumbers.add(i);
        }
        Collections.shuffle(tempNumbers);

        return new Numbers(tempNumbers.subList(0, 3));
    }

    public GameResult getResult(Numbers userNumbers) {
        int strike = correctNumbers.countStrike(userNumbers);
        int ball = correctNumbers.countBall(userNumbers);

        return new GameResult(strike, ball);
    }

    public int getCommand(String commandString) {
        return validateAndParseInputString(commandString);
    }

    private int validateAndParseInputString(String commandString) {
        if (!validateInputLength(commandString)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
        if (!validateInputIsNumber(commandString)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
        if (!validateInputIsOneOrTwo(commandString)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
        return convertStringToInteger(commandString);
    }

    private boolean validateInputLength(String commandString) {
        return commandString.length() == 1;
    }

    private boolean validateInputIsNumber(String commandString) {
      return commandString.charAt(0) >= '0' && commandString.charAt(0) <= '9';
    }

    private boolean validateInputIsOneOrTwo(String commandString) {
      return commandString.charAt(0) == '1' || commandString.charAt(0) == '2';
    }

    private Integer convertStringToInteger(String commandString) {
        return commandString.charAt(0) - '0';
    }

}
