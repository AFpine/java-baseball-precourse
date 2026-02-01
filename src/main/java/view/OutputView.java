package view;

import model.Game;
import model.GameResult;
import model.Numbers;

public class OutputView {
    public void OutputInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void OutputResult(GameResult result) {
        System.out.println(result.getResultString());
    }

    public void OutputWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void OutputInputCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

