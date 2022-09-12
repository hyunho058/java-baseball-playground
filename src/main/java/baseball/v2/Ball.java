package baseball.v2;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BaseballStatus play(Ball userBall) {
        if (isBall(userBall)) {
            return BaseballStatus.BALL;
        }

        if (isStrike(userBall)) {
            return BaseballStatus.STRIKE;
        }

        return BaseballStatus.NOTHING;
    }

    private boolean isBall(Ball userBall) {
        return this.position != userBall.position && this.number == userBall.number;
    }

    private boolean isStrike(Ball userBall) {
        return this.equals(userBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
