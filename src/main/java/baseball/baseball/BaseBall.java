package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;
import static baseball.common.Constant.MAX_BALL_NUMBER;
import static baseball.common.Constant.MIN_BALL_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBall {

  private final List<Integer> ballNumbers;

  public BaseBall() {
    this.ballNumbers = generatedRandomBallNumbers();
  }

  public List<Integer> getBallNumbers() {
    return this.ballNumbers;
  }

  public int getStrikeCount(List<Integer> targetBallNumbers) {
    int strikeCount = 0;
    int ballCount = 0;

    for (int i = 0; i < BALL_AMOUNT; i++) {
      Integer ballNumber = this.ballNumbers.get(i);
      Integer targetBallNumber = targetBallNumbers.get(i);

      if (ballNumber.equals(targetBallNumber)) { // 스트라이크 인경우
        strikeCount++;
        continue;
      }

      if (this.ballNumbers.contains(targetBallNumber)) { // 볼 인경우
        ballCount++;
      }
    }

    printResult(ballCount, strikeCount);

    return strikeCount;
  }

  public Boolean isSucceed(int strikeCount) {
    if (strikeCount == BALL_AMOUNT) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      return true;
    }
    return false;
  }

  private void printResult(int ballCount, int strikeCount) {
    if (ballCount == 0 && strikeCount == 0) {
      System.out.println("낫싱");
    } else if (ballCount == 0) {
      System.out.println(strikeCount + "스트라이크");
    } else if (strikeCount == 0) {
      System.out.println(ballCount + "볼");
    } else {
      System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
  }

  private List<Integer> generatedRandomBallNumbers() {
    List<Integer> ballNumbers = new ArrayList<>();

    while (ballNumbers.size() < BALL_AMOUNT) {
      int randomNumber = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
      addBallNumber(ballNumbers, randomNumber);
    }

    return ballNumbers;
  }

  private void addBallNumber(List<Integer> ballNumbers, int randomNumber) {
    if (!ballNumbers.contains(randomNumber)) {
      ballNumbers.add(randomNumber);
    }
  }

}
