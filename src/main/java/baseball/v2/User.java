package baseball.v2;

import java.util.ArrayList;
import java.util.List;

//문자열 입력
//문자열 변환
//Ball 생성
public class User {
    private List<Ball> userBalls;

    public void createNumberList(String numbers) {
        userBalls = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            userBalls.add(new Ball(i + 1, parseNumber(numbers.charAt(i))));
        }
    }

    private int parseNumber(Character number) {
        return Integer.parseInt(number.toString());
    }

    public List<Ball> getUserBalls() {
        return userBalls;
    }
}
