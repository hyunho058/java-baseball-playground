package baseball;

import baseball.v2.Ball;
import baseball.v2.Balls;
import baseball.v2.BaseballStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballTest {
    Balls balls;

    @BeforeEach
    void before() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("nothing")
    void nothing() {
        assertEquals(
            BaseballStatus.NOTHING,
            balls.checkBallStatus(
                new Ball(1, 4))
        );
    }

    @Test
    @DisplayName("ball")
    void ball() {
        assertEquals(
            BaseballStatus.BALL,
            balls.checkBallStatus(
                new Ball(1, 2))
        );
    }

    @Test
    @DisplayName("strike")
    void strike() {
        assertEquals(
            BaseballStatus.STRIKE,
            balls.checkBallStatus(
                new Ball(1, 1))
        );
    }
}
