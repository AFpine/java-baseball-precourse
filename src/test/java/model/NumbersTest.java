package model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    @DisplayName("정상 입력이면 Numbers 생성 성공")
    void create_success() {
        Numbers stringNumbers = new Numbers("123");
        Numbers integerListNumbers = new Numbers(List.of(1, 2, 3));
        assertNotNull(stringNumbers);
        assertNotNull(integerListNumbers);
    }

    @Test
    @DisplayName("길이가 3보다 짧으면 예외")
    void create_fail_short_length() {
        IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> new Numbers("12"));
        assertEquals("3자리여야 합니다.", e.getMessage());
    }

    @Test
    @DisplayName("길이가 3보다 길면 예외")
    void create_fail_long_length() {
        IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> new Numbers("1245"));
        assertEquals("3자리여야 합니다.", e.getMessage());
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    void create_fail_notNumber() {
        IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> new Numbers("1a3"));
        assertEquals("숫자만 입력해야 합니다.", e.getMessage());
    }

    @Test
    @DisplayName("중복된 자릿수가 있으면 예외")
    void create_fail_duplicate() {
        IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> new Numbers("112"));
        assertEquals("중복된 숫자를 다른 자릿수에 사용할 수 없습니다.", e.getMessage());
    }

    @Test
    @DisplayName("countStrike: 같은 위치 같은 숫자 개수")
    void countStrike_success() {
        Numbers a = new Numbers("123");
        Numbers b = new Numbers("103");
        assertEquals(2, a.countStrike(b));
    }

    @Test
    @DisplayName("countBall: 숫자는 같지만 위치가 다른 개수")
    void countBall_success() {
        Numbers a = new Numbers("123");
        Numbers b = new Numbers("312");
        assertEquals(3, a.countBall(b));
    }

    @Test
    @DisplayName("coundStrikeAndBall: 스트라이크와 볼의 개수")
    void countStrikeAndBall_success() {
        Numbers a = new Numbers("456");
        Numbers b = new Numbers("475");
        assertEquals(1, a.countStrike(b));
        assertEquals(1, a.countBall(b));
    }
}

