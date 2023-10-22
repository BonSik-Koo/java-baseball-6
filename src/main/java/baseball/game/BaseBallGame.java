package baseball.game;

import static baseball.common.Constant.EXIT_NUMBER;

import baseball.baseball.BaseBall;
import baseball.baseball.BaseBallInputDevice;
import baseball.baseball.BaseBallOutputDevice;
import baseball.baseball.Result;
import java.util.List;

public class BaseBallGame implements Game {

  private final BaseBallInputDevice inputDevice;
  private final BaseBallOutputDevice outputDevice;

  public BaseBallGame() {
    this.inputDevice = new BaseBallInputDevice();
    this.outputDevice = new BaseBallOutputDevice();
  }

  @Override
  public void play() {
    outputDevice.printStartMessage();
    playBaseBallGame();
  }

  private void playBaseBallGame() {
    BaseBall baseBall = new BaseBall();
    playRound(baseBall);

    if (isEndBaseBallGame()) {
      return;
    }
    playBaseBallGame();
  }

  private void playRound(BaseBall baseBall) {
    outputDevice.printStartInputMessage();
    List<Integer> startInput = inputDevice.startInput();
    Result result = baseBall.getPlayResult(startInput);
    outputDevice.printResultMessage(result);

    if (result.isAllStrikes()) {
      outputDevice.printSuccessMessage();
      return;
    }
    playRound(baseBall);
  }

  private Boolean isEndBaseBallGame() {
    outputDevice.printEndInputMessage();
    int endInput = inputDevice.endInput();
    return endInput == EXIT_NUMBER;
  }

}
