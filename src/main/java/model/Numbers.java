package model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(String inputNumbersString) {
        this.numbers = validateAndParseInputString(inputNumbersString);
    }

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private List<Integer> validateAndParseInputString(String inputNumbersString) {
        if (!validateInputLength(inputNumbersString)) {
            throw new IllegalArgumentException("3자리여야 합니다.");
        }
        if (!validateInputIsNumbers(inputNumbersString)) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
        if (!validateInputHasDistinctDigits(inputNumbersString)) {
            throw new IllegalArgumentException("중복된 숫자를 다른 자릿수에 사용할 수 없습니다.");
        }
        return convertStringToIntegerList(inputNumbersString);
    }

    private boolean validateInputLength(String inputNumbersString) {
        return inputNumbersString.length() == 3;
    }

    private boolean validateInputIsNumbers(String inputNumbersString) {
        for (int i = 0; i < 3; ++i) {
            if (inputNumbersString.charAt(i) < '0' || inputNumbersString.charAt(i) > '9') return false;
        }
        return true;
    }

    private boolean validateInputHasDistinctDigits(String inputNumbersString) {
        boolean[] digitsArray = new boolean[13];
        for (int i = 0; i < 3; ++i) {
            int digit = inputNumbersString.charAt(i) - '0';
            if (digitsArray[digit]) return false;
            digitsArray[digit] = true;
        }
        return true;
    }

    private List<Integer> convertStringToIntegerList(String inputNumbersString) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 3; ++i) {
            ret.add(inputNumbersString.charAt(i) - '0');
        }
        return ret;
    }


    public int countStrike(Numbers otherNumbers) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            if (this.numbers.get(i).equals(otherNumbers.numbers.get(i))) cnt += 1;
        }
        return cnt;
    }

    public int countBall(Numbers otherNumbers) {
        boolean[] ballCountArray = new boolean[13];
        int cnt = 0;

        for (int i = 0; i < 3; ++i) {
            ballCountArray[this.numbers.get(i)] = true;
        }
        for (int i = 0; i < 3; ++i) {
            if (ballCountArray[otherNumbers.numbers.get(i)]) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
