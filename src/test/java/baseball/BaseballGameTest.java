package baseball;

import baseball.v2.Balls;
import baseball.v2.BaseballGame;
import baseball.v2.BaseballStatus;
import baseball.v2.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballGameTest {
    @Test
    @DisplayName("nothing")
    void nothing() {
        BaseballGame baseballGame = new BaseballGame(
            new User(),
            new Balls(Arrays.asList(1, 2, 3))
        );
        String result = baseballGame.gameResults("890");

        assertEquals(BaseballStatus.NOTHING.toString(), result);
    }

    @Test
    @DisplayName("ball")
    void ball() {
        BaseballGame baseballGame = new BaseballGame(
            new User(),
            new Balls(Arrays.asList(1, 2, 3))
        );
        assertAll(
            () -> assertEquals("1BALL", baseballGame.gameResults("891")),
            () -> assertEquals("2BALL", baseballGame.gameResults("219")),
            () -> assertEquals("3BALL", baseballGame.gameResults("312"))
        );
    }

    @Test
    @DisplayName("strike")
    void strike(){
        BaseballGame baseballGame = new BaseballGame(
            new User(),
            new Balls(Arrays.asList(1, 2, 3))
        );
        assertAll(
            () -> assertEquals("1STRIKE", baseballGame.gameResults("189")),
            () -> assertEquals("2STRIKE", baseballGame.gameResults("183")),
            () -> assertEquals("3STRIKE", baseballGame.gameResults("123"))
        );
    }

    @Test
    @DisplayName("ball_and_strike")
    void ball_and_strike(){
        BaseballGame baseballGame = new BaseballGame(
            new User(),
            new Balls(Arrays.asList(1, 2, 3))
        );
        assertAll(
            () -> assertEquals("1BALL 1STRIKE", baseballGame.gameResults("182")),
            () -> assertEquals("2BALL 1STRIKE", baseballGame.gameResults("321"))
        );
    }
}
