## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```


## TEST TODO
* 하나 숫자와 자리만 비교 (random : position number / user : position number)
  ~~* NOTHING : 1 2 / 3 4~~
  ~~* BALL : 1 2 / 2 2~~
  ~~* STRIKE : 1 2 / 1 2~~
* 3개의 숫자를 받아 유저가 입력한 하나의 숫자와 자리만 비교 (random : numbers / user : position number)
  ~~* NOTHING : 123 / 1 4~~
  ~~* BALL : 123 / 1 2~~
  ~~* STRIKE : 123 / 1 1~~
~~* 랜덤으로 3자리 숫자 생성 (ex - 123)~~
* 한개도 맞추지 못하면 NOTHING (ex - 123 : 789)
* 숫자만 맞고 자리는 맞추지 못한 경우 BALL (ex - 123 : 810)
* 숫자와 자리가 맞는 경우 STRIKE (ex - 123 : 189)
* 3개 숫자와 자리를 맞추면 게임 종료 (ex -1 123 : 123)



```java
package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls() {
        this.balls = createBall(Arrays.asList(1, 2, 3));
    }

    private static List<Ball> createBall(List<Integer> numbers) {
        List<Ball> resultBalls = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            resultBalls.add(new Ball(i + 1, numbers.get(i)));
        }
        return resultBalls;
    }

    public BaseballStatus checkBallStatus(Ball userBall) {

        for (Ball ball : balls) {
            BaseballStatus status = ball.play(userBall);
            if (!status.equals(BaseballStatus.NOTHING)) {
                return status;
            }
        }
        return BaseballStatus.NOTHING;
    }
}

package baseball;

        import java.util.ArrayList;
        import java.util.List;

public class Balls {

  public List<Ball> createBall(List<Integer> numbers) {
    List<Ball> resultBalls = new ArrayList<>();
    for (int i = 0; i < numbers.size(); i++) {
      resultBalls.add(new Ball(i + 1, numbers.get(i)));
    }
    return resultBalls;
  }

  public BaseballStatus checkBallStatus(List<Ball> balls, Ball userBall) {
    return balls.stream()
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


```


```java
package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public List<Ball> createBall(List<Integer> numbers) {
        List<Ball> resultBalls = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            resultBalls.add(new Ball(i + 1, numbers.get(i)));
        }
        return resultBalls;
    }

    public BaseballStatus checkBallStatus(List<Ball> balls, Ball userBall) {
        return balls.stream()
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

```