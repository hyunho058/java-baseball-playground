package baseball.v2;

import java.util.List;

public class BaseballGame {

    private final User user;
    private final Balls commBalls;

    public BaseballGame(User user, Balls commBalls) {
        this.user = user;
        this.commBalls = commBalls;
    }

    public String gameResults(String inputUserNumbers) {
        StringBuilder sb = new StringBuilder();
        user.createNumberList(inputUserNumbers);

        int ballCount = checkForBallCount(user.getUserBalls());
        if (ballCount > 0) sb.append(combinationOfResults(sb, ballCount, BaseballStatus.BALL));

        int strikeCount = checkForStrikeCount(user.getUserBalls());
        if (strikeCount > 0) sb.append(combinationOfResults(sb, strikeCount, BaseballStatus.STRIKE));

        if (ballCount == 0 && strikeCount == 0) sb.append(BaseballStatus.NOTHING);

        return sb.toString();
    }

    private int checkForBallCount(List<Ball> userBalls) {
        int ballCount = 0;
        for (Ball ball : userBalls) {
            if (commBalls.checkBallStatus(ball).equals(BaseballStatus.BALL)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int checkForStrikeCount(List<Ball> userBalls) {
        int strikeCount = 0;
        for (Ball ball : userBalls) {
            if (commBalls.checkBallStatus(ball).equals(BaseballStatus.STRIKE)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private String combinationOfResults(StringBuilder sb,
                                        int count,
                                        BaseballStatus baseballStatus) {
        if (sb.toString().contains(BaseballStatus.BALL.toString())) {
            sb.append(" ");
        }

        return count + baseballStatus.toString();
    }
}
