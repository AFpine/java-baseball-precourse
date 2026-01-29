package model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isValidateNumbers(List<Integer> numbers) {
        if (numbers.size() != 3) return false;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == j) continue;
                if (numbers.get(i).equals(numbers.get(j))) return false;
            }
        }
        return true;
    }

    public int countStrike(Numbers correctNumbers) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            if (this.numbers.get(i).equals(correctNumbers.numbers.get(i))) cnt += 1;
        }
        return cnt;
    }

    public int countBall(Numbers correctNumbers) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == j) continue;
                if (this.numbers.get(i).equals(correctNumbers.numbers.get(j))) cnt += 1;
            }
        }
        return cnt;
    }
}
