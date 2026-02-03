package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("게임 재시작 커맨드 '1' 입력시 1 반환")
    void getCommand_one_correct() {
        Game game = new Game();
        assertEquals(1, game.getCommand("1"));
    }

    @Test
    @DisplayName("게임 재시작 커맨드 '2' 입력시 2 반환")
    void getCommand_two_correct() {
        Game game = new Game();
        assertEquals(2, game.getCommand("2"));
    }

    @Test
    @DisplayName("길이가 1이 아니면 예외")
    void getCommand_fail_invalid_length() {
        Game game = new Game();
        IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> game.getCommand("12"));
        assertEquals("1 또는 2만 입력해야 합니다.", e.getMessage());
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void create_fail_notNumber() {
        Game game = new Game();
        IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> game.getCommand("a"));
        assertEquals("1 또는 2만 입력해야 합니다.", e.getMessage());
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void create_fail_notOneOrTwo() {
        Game game = new Game();
        IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> game.getCommand("3"));
        assertEquals("1 또는 2만 입력해야 합니다.", e.getMessage());
    }
}

