package baseball;

import baseball.v2.Ball;
import baseball.v2.BaseballStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTest {

    Ball ball;

    @BeforeEach
    void createBall() {
        ball = new Ball(1, 2);
    }

    @Test
    @DisplayName("nothing")
    void nothing() {
        BaseballStatus baseballStatus = ball.play(new Ball(2, 3));

        assertEquals(BaseballStatus.NOTHING, baseballStatus);
    }

    @Test
    @DisplayName("ball")
    void ball() {
        BaseballStatus baseballStatus = ball.play(new Ball(2, 2));

        assertEquals(BaseballStatus.BALL, baseballStatus);
    }

    @Test
    @DisplayName("strike")
    void strike() {
        BaseballStatus baseballStatus = ball.play(new Ball(1, 2));

        assertEquals(BaseballStatus.STRIKE, baseballStatus);
    }
}
