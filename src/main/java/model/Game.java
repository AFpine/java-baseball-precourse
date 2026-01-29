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
}
