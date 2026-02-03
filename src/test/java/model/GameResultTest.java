package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameResultTest {

    @Test
    @DisplayName("게임 결과로 2스트라이크 출력")
    void getResultString_correct_onlyStrike() {
        GameResult result = new GameResult(2, 0);
        assertEquals("2스트라이크 ", result.getResultString());
    }

    @Test
    @DisplayName("게임 결과로 2스트라이크 출력")
    void getResultString_correct_onlyBall() {
        GameResult result = new GameResult(0, 1);
        assertEquals("1볼 ", result.getResultString());
    }

    @Test
    @DisplayName("게임 결과로 2스트라이크 출력")
    void getResultString_correct_strikeAndBall() {
        GameResult result = new GameResult(1, 2);
        assertEquals("1스트라이크 2볼 ", result.getResultString());
    }

    @Test
    @DisplayName("게임 결과로 2스트라이크 출력")
    void getResultString_correct_nothing() {
        GameResult result = new GameResult(0, 0);
        assertEquals("낫싱", result.getResultString());
    }

    @Test
    @DisplayName("3스트라이크 이면 게임 종료")
    void isFinish_correct_finish() {
        GameResult result = new GameResult(3, 0);
        assertTrue(result.isFinish());
    }

    @Test
    @DisplayName("3스트라이크가 아니면 게임 진행")
    void isFinish_correct_notFinish() {
        GameResult result = new GameResult(2, 1);
        assertFalse(result.isFinish());
    }
}
