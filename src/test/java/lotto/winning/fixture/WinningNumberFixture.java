package lotto.winning.fixture;

import lotto.winning.domain.WinningNumber;

public class WinningNumberFixture {
    public static WinningNumber 당첨번호123456() {
        return new WinningNumber(new String[]{"1", "2", "3", "4", "5", "6"});
    }

    public static WinningNumber 당첨번호45691011() {
        return new WinningNumber(new String[]{"4", "5", "6", "9", "10", "11"});
    }
}
