package lotto;

import java.util.List;

public interface NumberBag {

    Score matchScore(WinningLottoBallBag winningLottoBallBag);

    List<Number> getNumbers();
}
