package lotto;

import com.sun.tools.javac.util.List;

public class WinningNumberFixture {
    public static WinningNumber 당첨번호123456() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.addAll(List.of(new Lotto(1), new Lotto(2), new Lotto(3), new Lotto(4), new Lotto(5), new Lotto(6)));
        return winningNumber;
    }
}
