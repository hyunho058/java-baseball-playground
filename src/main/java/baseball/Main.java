package baseball;

import baseball.v1.BaseBallGame;
import baseball.v2.Balls;
import baseball.v2.BaseballGame;
import baseball.v2.NumberGenerator;
import baseball.v2.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
//        startGameV1(br);
        startGameV2(br);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (br.readLine().equals("1")) {
//            startGameV1(br);
            startGameV2(br);
        }
    }

    public static void startGameV1(BufferedReader br) throws IOException {
        BaseBallGame baseBallGame = new BaseBallGame();
        String answerNumber = baseBallGame.createNumber(3);
        boolean gameStatus = true;

        while (gameStatus) {
            System.out.print("숫자를 입력해 주세요 : ");
            String inputNumbers = br.readLine();
            String result = baseBallGame.gameResults(answerNumber, inputNumbers);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("개의 숫자르 ㄹ모두 맞히셨습니다! 게임 종료");
                gameStatus = false;
            }
        }
    }

    public static void startGameV2(BufferedReader br) throws IOException {
        NumberGenerator numberGenerator = new NumberGenerator();
        BaseballGame baseballGame = new BaseballGame(
            new User(),
            new Balls(numberGenerator.generateNumberList(3))
        );
        boolean gameStatus = true;

        while (gameStatus) {
            System.out.print("숫자를 입력해 주세요 : ");
            String inputNumbers = br.readLine();
            String result = baseballGame.gameResults(inputNumbers);
            System.out.println(result);
            if (result.equals("3STRIKE")) {
                System.out.println("개의 숫자르 ㄹ모두 맞히셨습니다! 게임 종료");
                gameStatus = false;
            }
        }
    }
}
