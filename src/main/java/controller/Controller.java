package controller;

import model.Game;
import model.GameResult;
import model.Numbers;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        while (true) {
            int result = play();
            if (result == 2) break;
        }
    }

    private int play() {
        Game game = new Game();
        while (true) {
            try {
                outputView.OutputInputNumber();

                Numbers userNumbers = new Numbers(inputView.InputUserNumbers());

                GameResult result = game.getResult(userNumbers);
                outputView.OutputResult(result);

                if (result.isFinish()) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                outputView.OutputError(e.getMessage());
            }
        }
        outputView.OutputWin();

        while (true) {
            try {
                outputView.OutputInputCommand();
                return game.getCommand(inputView.InputCommand());
            } catch (IllegalArgumentException e) {
                outputView.OutputError(e.getMessage());
            }
        }
    }
}
