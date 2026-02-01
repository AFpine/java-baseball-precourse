package model;

public class GameResult {
    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getResultString() {
        String ret = "";
        if (strike > 0) ret += strike + "스트라이크 ";
        if (ball > 0) ret += ball + "볼 ";
        if (strike == 0 && ball == 0) ret += "낫싱";
        return ret;
    }

    public boolean isFinish() {
      return strike == 3;
    }
}
