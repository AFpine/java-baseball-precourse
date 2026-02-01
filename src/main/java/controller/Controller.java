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
            play();
            outputView.OutputInputCommand();

            int inputCommand = inputView.InputCommand();
            if(inputCommand == 1) continue;
            if(inputCommand == 2) break;
        }
    }

    private void play() {
        Game game = new Game();
        while (true) {
            outputView.OutputInputNumber();

            Numbers userNumbers = new Numbers(inputView.InputUserNumbers());

            GameResult result = game.getResult(userNumbers);
            outputView.OutputResult(result);

            if(result.isFinish()) break;
        }
        outputView.OutputWin();
    }
}
