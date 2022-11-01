package lotto;

import java.util.List;

public interface NumberBag {

    double matchScore(WinningLottoBallBag winningLottoBallBag);

    List<Number> getNumbers();
}
