package baseball.v2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {

    private final List<Ball> comBalls;

    public Balls(List<Integer> numbers) {
        this.comBalls = createBall(numbers);
    }

    private static List<Ball> createBall(List<Integer> numbers) {
        return IntStream
            .range(0, numbers.size())
            .mapToObj(idx -> new Ball(idx + 1, numbers.get(idx)))
            .collect(Collectors.toList());
    }

    public BaseballStatus checkBallStatus(Ball userBall) {
        return this.comBalls.stream()
            .filter(
                ball -> !ball.play(userBall)
                    .equals(BaseballStatus.NOTHING)
            )
            .map(
                ball -> ball.play(userBall)
            )
            .findFirst()
            .orElse(BaseballStatus.NOTHING);
    }
}
